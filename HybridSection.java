package registrar;

import javax.swing.JOptionPane;

/**
 * A Hybrid Section is a subclass of Section
 * A Hybrid Section has one meeting time in person 
 * and one meeting time online
 * 
 * @author Klaydon Balicanta
 *
 */
public class HybridSection extends Section
{
	/**
	 * overridden constructor
	 * @param course
	 * @param faculty
	 */
	public HybridSection(Course course, Faculty faculty)
	{
		super(course, faculty);
		generateSchedule();
	}
	
	/**
	 * prompts the user to validate their choice in selecting a hybrid course
	 * @return boolean value of their yes/no choice
	 */
	protected boolean validateChoice()
	{
		int choice = JOptionPane.showConfirmDialog(null, 
				"Hybrid classes require online connectivity." +
						"Are you sure you want to register for this class?", 
						"Hybrid Registration Verification",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
		if (choice == 0)
			return true;
		else
			return false;
	}

	/**
	 * creates the schedule for the section of the course
	 */
	protected void generateSchedule()
	{
		int timeSlotOne = rand.nextInt(timeslots.size());
		schedule = timeslots.get(timeSlotOne).toString();
	}
}