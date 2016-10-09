package registrar;

/**
 * A Course represents a type of class that can be taken at a University
 * Courses have a title, a course number, and a department
 * 
 * @author Klaydon Balicanta
 * @version 07/05/2015
 * 
 */

public class Course
{
	/**
	 * course identification number
	 */
	private String courseNumber;
	/**
	 * course title
	 */
	private String title;
	/**
	 * department to which the course belongs under
	 */
	private Department department;
	
	/**
	 * constructor
	 * @param courseNumber course identification number
	 * @param className course title
	 * @param dept department to which the course belongs under
	 */
	public Course(String courseNumber, String className, Department dept) {
		this.courseNumber = courseNumber;
		this.title = className;
		this.department = dept;
	}
	
	/*Getters and Setters*/
	
	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
