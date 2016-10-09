package registrar;

/**
 * A Registrar GUI
 * The Registrar has panels to select the department,
 * panel to list sections and section information for
 * the selected department, and feedback panel to show
 * how many matches there are for a department
 * 
 * @author Klaydon Balicanta
 * @version 07/05/2015
 * 
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Registrar extends JFrame
{
	final int MIN_FRAME_WIDTH = 1500;		//minimum frame pixel width
	final int MIN_FRAME_HEIGHT = 300;		//minimum frame pixel height
	private final String defaultFeedbackLabel = "Matching Sections";	//default message when no Department is selected
	private JFrame frame;					//main container
	private JPanel departmentPanel;			//contains department combo box
	private JPanel sectionPanel;			//contains sections labels
	private JPanel feedbackPanel;			//contains feedback on combo box selection
	private final JLabel promptDepartmentSelection = new JLabel("Select A Department ");	//label prompting user to make Department selection
	//private final JLabel crnLabel = new JLabel("Click CRN to add or drop course");//column title for CRN
	private final JLabel crnLabel = new JLabel("CRN");								//column title for CRN
	private final JLabel courseLabel = new JLabel("Course Number");					//column title for course
	private final JLabel titleText = new JLabel("Title");							//column title for title
	private final JLabel instructorLabel = new JLabel("Instructor");				//column title for instructor
	private final JLabel scheduleLabel = new JLabel("Schedule");					//column title for schedule
	private JLabel feedbackLabel = new JLabel(defaultFeedbackLabel);				//label, updated upon Department selection change, to contain how many sections match Department selection
	private JComboBox departments;			//combo box containing Department selections

	/**
	 * 
	 * @param catalog
	 * @param faculty
	 * @param student
	 * @param term
	 */
	public Registrar(Catalog catalog, Faculty faculty, Student student, Term term)
	{
		for(int i = 0; i < catalog.size(); i++)											//creates the three different sections for
		{																				//the course in catalog. a new section is
			term.addSection(new TraditionalSection(catalog.getCourse(i), faculty));		//made for each course as well as instructor
			term.addSection(new HybridSection(catalog.getCourse(i), faculty));			//assignment to each section (this assignment
			term.addSection(new OnlineSection(catalog.getCourse(i), faculty));			//is random to each course section
		}
		
		frame = new JFrame("Banner Self Service For " + student.getLastName());			//puts students last name in window title
		frame.setLayout(new BorderLayout());
		
		departmentPanel = new JPanel(new FlowLayout());									//setting up the panel that contains the
		departments = new JComboBox(Department.departmentsString());					//combo box of Departments and 
		departmentPanel.add(promptDepartmentSelection);									//prompt label for Department selection
		departmentPanel.add(departments);

		sectionPanel = new JPanel();													//setting up the panel that contains the section
		sectionPanel.setBackground(Color.WHITE);										//information for sections for a Department

		feedbackPanel = new JPanel(new FlowLayout());									//setting up the panel that contains the label to
		feedbackPanel.add(feedbackLabel);												//display information about their Department selection

		frame.add(departmentPanel, BorderLayout.NORTH);									//adding the panels to the BorderLayout
		frame.add(sectionPanel, BorderLayout.CENTER);
		frame.add(feedbackPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);							//what to do when the user presses "X"
		frame.setMinimumSize(new Dimension(MIN_FRAME_WIDTH, MIN_FRAME_HEIGHT));			//sets a minimum dimension user can minimize to
		frame.setVisible(true);															//make visible

		departments.addItemListener(new ItemListener()				//JComboBox Listener
		{
			public void itemStateChanged(ItemEvent e)
			{
				resetSectionPanel();								//clear out contents of section panel
				int numSections = 0;								//variable to keep track of how many sections that match the Department selection
				if(e.getStateChange() == ItemEvent.SELECTED) {
					Object item = e.getItem();						//the user selection from the Department combo box
					Department currentSelectDept = null;			//variable to hold Department selection (if any made)

					if(item != "") {				//if the user made a selection (that is, not the blank selection)
						for(Department dept : Department.values())	//assigns Department selection variable to the user selection	
						{
							if(item.toString() == dept.toString())
								currentSelectDept = dept;
						}

						for(Section section : term.sections)		//determines how many sections match the Department selection and
						{											//adds new rows of section information to the appropriate panel
							if(section.course.getDepartment().equals(currentSelectDept))
							{
								sectionPanel.add(new JLabel(section.getCRNString()));		//old CRN Column components
								/*
								JButton CRNButton = new JButton(section.getCRNString());	//creates new button(s) instead of jlabel(s)
								CRNButton.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										boolean added = false;
										if(!added)
										student.add(section);
										else
											student.drop(section);
										
										String sectionsFeedback = "";
										for(Integer CRN : student.currentSections.keySet()) {
											sectionsFeedback += student.currentSections.get(CRN).toString() + ", ";
										}
										feedbackLabel.setText((student.currentSections.get(section).CRN.toString()));
									}
								});
								sectionPanel.add(CRNButton);
								*/
								sectionPanel.add(new JLabel(section.getCourseNumber()));
								sectionPanel.add(new JLabel(section.getCourseTitle()));
								sectionPanel.add(new JLabel(section.getInstructor().getLastName()));
								sectionPanel.add(new JLabel(section.schedule));
								numSections++;
							}
						}

						feedbackLabel.setText(numSections + " sections of " + currentSelectDept.toString() + " found.");	//update feedbackPanel
						sectionPanel.setLayout(new GridLayout(numSections+1,5));	//make space for sections of selected department
					} else {						//if the user did not make a selection (that is, they chose the blank selection)
						feedbackLabel.setText(defaultFeedbackLabel);//reset feedback to default message label
						clearSectionPanel();						//clear out contents of section panel completely
					}
				}
			}
		});
		//System.exit(0);	//upon opening the GUI, this closes it immediately
	}
	
	/**
	 * removes all components from the section panel and replaces
	 * the column titles
	 */
	public void resetSectionPanel()
	{
		frame.remove(sectionPanel);
		sectionPanel = new JPanel(new GridLayout(1,5));
		
		crnLabel.setForeground(Color.BLUE);
		courseLabel.setForeground(Color.BLUE);
		titleText.setForeground(Color.BLUE);
		instructorLabel.setForeground(Color.BLUE);
		scheduleLabel.setForeground(Color.BLUE);
		
		sectionPanel.setBackground(Color.WHITE);
		
		sectionPanel.add(crnLabel);
		sectionPanel.add(courseLabel);
		sectionPanel.add(titleText);
		sectionPanel.add(instructorLabel);
		sectionPanel.add(scheduleLabel);
		
		frame.add(sectionPanel, BorderLayout.CENTER);
	}
	
	/**
	 * removes all components from the section panel including column titles
	 */
	public void clearSectionPanel()
	{
		frame.remove(sectionPanel);
		sectionPanel = new JPanel();
		sectionPanel.setBackground(Color.WHITE);
		frame.add(sectionPanel, BorderLayout.CENTER);
	}
}
