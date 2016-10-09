package registrar;

/**
 * Section is a Course with more specific details regarding
 * availability and scheduling.
 * Sections of a Course have the Course, a CRN, an instructor
 * which is randomly assigned, a schedule consisting of the 
 * available timeslots, which are day(s) and time(s) between
 * 08:00 and 18:00 between Monday and Friday, and a Random
 * object to randomly assign the instructors and schedules
 * 
 * @author Klaydon Balicanta
 * @version 07/05/2015
 * 
 */

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Random;
import java.util.ArrayList;

public abstract class Section
{
	/**
	 * CRN to continue assigning from
	 */
	protected static Integer lastCRN = 40000;

	protected Integer CRN;
	protected Course course;
	protected Instructor instructor;
	protected String schedule;
	//protected DayOfWeek weekday;
	//protected LocalTime startTime, endTime;
	protected ArrayList<TimeSlot> timeslots;
	final protected LocalTime FIRST_TIMESLOT_TIME = LocalTime.parse("08:00");
	final protected LocalTime LAST_TIMESLOT_TIME = LocalTime.parse("18:00");
	
	protected Random rand = new Random();
	
	/**
	 * constructor 
	 * @param course
	 * @param faculty
	 */
	public Section(Course course, Faculty faculty)
	{
		this.CRN = ++lastCRN;		//	assigns CRN number
		this.course = course;		//	assigns course
		setInstructor(faculty);		//	assigns instructor
		createTimeslots();			//	assigns schedule - random assignment of the day and time
	}

	/**
	 * returns the CRN as a String
	 * @return CRN as a String
	 */
	protected String getCRNString()
	{
		return CRN.toString();
	}
	
	/**
	 * returns the CRN
	 * @return CRN
	 */
	protected Integer getCRN() {
		return CRN;
	}
	
	/**
	 * returns the course number as a String
	 * @return course number String
	 */
	protected String getCourseNumber()
	{
		return course.getCourseNumber();
	}
	
	/**
	 * returns the course title
	 * @return course title
	 */
	protected String getCourseTitle()
	{
		return course.getTitle();
	}
	
	/**
	 * returns the Instructor of the Course
	 * @return Instructor
	 */
	protected Instructor getInstructor()
	{
		return instructor;
	}
	
	/**
	 * sets the Instructor of the Course
	 * @param faculty Instructor for the Course
	 */
	protected void setInstructor(Faculty faculty) {
		int choice = rand.nextInt(faculty.size());
		this.instructor = faculty.getInstructor(choice);
	}
	
	/**
	 * returns the schedule
	 * @return schedule
	 */
	protected String getSchedule()
	{
		return schedule;
	}
	
	/**
	 * creates a collection of available timeslots taking place
	 * between 08:00 and 18:00 between Monday and Friday
	 */
	protected void createTimeslots()
	{
		timeslots = new ArrayList<>();
		for(int i = 0; i < 5; i++)
		{
			LocalTime currentWorkingTime = FIRST_TIMESLOT_TIME;
			while(currentWorkingTime != LAST_TIMESLOT_TIME)
			{
				timeslots.add(new TimeSlot(currentWorkingTime, currentWorkingTime.plusMinutes(50), dayIndexToDayOfWeek(i+1)));
				currentWorkingTime = currentWorkingTime.plusHours(1);
			}
		}
	}
	
	/**
	 * converts a DayOfWeek object to the String of the Day
	 * @param DoW DayOfWeek to convert
	 * @return String version of the DayOfWeek
	 */
	protected String dayOfWeekToString(DayOfWeek DoW) {
		if(DoW == DayOfWeek.MONDAY)
			return "MONDAY";
		else if(DoW == DayOfWeek.TUESDAY)
			return "TUESDAY";
		else if(DoW == DayOfWeek.WEDNESDAY)
			return "WEDNESDAY";
		else if(DoW == DayOfWeek.THURSDAY)
			return "THURSDAY";
		else
			return "FRIDAY";
	}
	
	/**
	 * converts an index of the week to a DayOfWeek equivalent
	 * eg Monday = 1 ... Friday = 5
	 * @param dayIndex index in a week
	 * @return DayOfWeek equivalent of week index
	 */
	protected DayOfWeek dayIndexToDayOfWeek(int dayIndex) {
		switch(dayIndex)
		{
			case 1:	return DayOfWeek.MONDAY;
			case 2:	return DayOfWeek.TUESDAY;
			case 3: return DayOfWeek.WEDNESDAY;
			case 4: return DayOfWeek.THURSDAY;
			case 5: return DayOfWeek.FRIDAY;
			default: return null;
		}
	}
}