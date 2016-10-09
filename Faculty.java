package registrar;

/**
 * A collection of Instructors that can add more Instructors
 * 
 * @author Klaydon Balicanta
 * @version 07/05/2015
 * 
 */

import java.util.ArrayList;

public class Faculty
{
	/**
	 * ArrayList collection of Instructors
	 */
	ArrayList<Instructor> faculty = new ArrayList<>();

	/**
	 * constructor
	 * @param instructor instructor
	 */
	public void addInstructor(Instructor instructor)
	{
		faculty.add(instructor);
	}

	/**
	 * returns the Instructor at the specified index
	 * @param index location of Instructor in the collection
	 * @return Instructor at specified index
	 */
	public Instructor getInstructor(int index) {
		return faculty.get(index);
	}
	
	/**
	 * gets the size of the collection
	 * @return size of the collection
	 */
	public int size() {
		return faculty.size();
	}
}