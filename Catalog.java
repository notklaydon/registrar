package registrar;

/**
 * A collection of Courses that can add more Courses
 * 
 * @author Klaydon Balicanta
 * @version 07/05/2015
 * 
 */

import java.util.ArrayList;

public class Catalog
{
	/**
	 * ArrayList collection of Courses
	 */
	ArrayList<Course> catalog;
	
	/**
	 * Constructor
	 */
	public Catalog()
	{
		catalog = new ArrayList<Course>();
	}
	
	/**
	 * adds a Course to the collection
	 * @param course Course to be added
	 */
	public void addCourse(Course course)
	{
		catalog.add(course);
	}
	
	/**
	 * returns the course at the specified index
	 * @param index location of Course in the collection
	 * @return Course at specified index
	 */
	public Course getCourse(int index)
	{
		return catalog.get(index);
	}
	
	/**
	 * gets the size of the collection
	 * @return size of the collection
	 */
	public int size() {
		return catalog.size();
	}
}
