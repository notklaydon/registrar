package registrar;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * A Traditional Section is a subclass of Section
 * A Traditional Section has two meeting times in person
 * 
 * @author Klaydon Balicanta
 * @version 07/05/2015
 *
 */
public class TraditionalSection extends Section
{
	DayOfWeek weekday_second;
	LocalTime startTime_second, endTime_second;
	
	/**
	 * overridden constructor
	 * @param course
	 * @param faculty
	 */
	public TraditionalSection(Course course, Faculty faculty)
	{
		super(course, faculty);
		generateSchedule();
	}

	/**
	 * creates the schedule for the section of the course
	 */
	protected void generateSchedule()
	{
		int timeSlotOne = rand.nextInt(timeslots.size());
		int timeSlotTwo = rand.nextInt(timeslots.size());
		while(timeSlotOne == timeSlotTwo)
			timeSlotTwo = rand.nextInt(timeslots.size());
		schedule = timeslots.get(timeSlotOne).toString() + ", " + timeslots.get(timeSlotTwo).toString();
	}
}