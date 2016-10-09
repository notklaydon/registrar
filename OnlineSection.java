package registrar;

import javax.swing.JOptionPane;

/**
 * A Online Section is a subclass of Section
 * A Hybrid Section has one meeting time online
 * 
 * @author Klaydon Balicanta
 * @version 07/05/2015
 *
 */

public class OnlineSection extends Section
{
	/**
	 * overridden constructor
	 * @param course
	 * @param faculty
	 */
	public OnlineSection(Course course, Faculty faculty)
	{
		super(course, faculty);
		schedule = "Online";
	}

	/**
	 * prompts the user to validate their choice in selecting a hybrid course
	 * @return boolean value of their yes/no choice
	 */
	protected boolean validateChoice()
	{
		int choice = JOptionPane.showConfirmDialog(null, 
				"Remote classes require online connectivity and good time management skills."
						+ "Are you sure you want to register for this class?", 
						"Online Registration Verification",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
		if (choice == 0)
			return true;
		else
			return false;
	}
}