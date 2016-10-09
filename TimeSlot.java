package registrar;

/**
 * Timeslot represents a Section objects availability
 * and contains fields for the start and end of a section,
 * and day a section occurs
 * 
 * @author Klaydon Balicanta
 * @version 07/05/2015
 * 
 */
import java.time.LocalTime;
import java.time.DayOfWeek;

public class TimeSlot
{
	LocalTime startTime, endTime;
	DayOfWeek weekday;

	/**
	 * constructor
	 * @param startTime
	 * @param endTime
	 * @param weekday
	 */
	public TimeSlot(LocalTime startTime, LocalTime endTime, DayOfWeek weekday)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		this.weekday = weekday;
	}

	/**
	 * returns start time of the section
	 * @return start time of the section
	 */
	public LocalTime getStartTime()
	{
		return startTime;
	}

	/**
	 * sets the start time of a section
	 * @param startTime start time of a section
	 */
	public void setStartTime(LocalTime startTime)
	{
		this.startTime = startTime;
	}

	/**
	 * returns the end time of a section
	 * @return end time of a section
	 */
	public LocalTime getEndTime()
	{
		return endTime;
	}

	/**
	 * sets the end time of a section
	 * @param endTime end time of a section
	 */
	public void setEndTime(LocalTime endTime)
	{
		this.endTime = endTime;
	}

	/**
	 * returns the weekday a section may occur on
	 * @return weekday a section may occur on
	 */
	public DayOfWeek getWeekday()
	{
		return weekday;
	}

	/**
	 * sets the weekday a section may occur on
	 * @param weekday weekday a section will occur on
	 */
	public void setWeekday(DayOfWeek weekday)
	{
		this.weekday = weekday;
	}

	/**
	 * creates a String representation of a timeslot
	 * @return String representation of a timeslot
	 */
	public String toString()
	{
		return dayOfWeekToString(weekday) + ": " + startTime.toString() + "-" + endTime.toString();
	}

	/**
	 * converts a DayOfWeek object to the String of the Day
	 * @param DoW DayOfWeek to convert
	 * @return String version of the DayOfWeek
	 */
	public String dayOfWeekToString(DayOfWeek DoW)
	{
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
}