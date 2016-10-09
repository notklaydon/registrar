package registrar;

/**
 * An Instructor is a subclass of Person
 * An Instructor has a department
 *
 * @author Klaydon Balicanta
 * 
 * Modification: made usable for the Registrar package
 * new constructor created to include id parameter
 * @version 07/05/2015
 */

//import java.util.Scanner;

public class Instructor extends Person
{
    Department department;

    /**
     * Instructor constructor
     * Overrides the Person super constructor to include the major
     * 
     * @param first first name
     * @param middle middle name
     * @param last last name
     * @param email email address [format: whatever@domain.com]
     * @param ssn social security number [format: ###-##-####]
     * @param age age [at least 17 years old]
     * @param scan Scanner object passed from Driver
     * @param department area of work at the university
     */
    //public Instructor(String first, String middle, String last, String email,
    //        String ssn, Integer age, Scanner scan, String department) {
    //    super(first, middle, last, email, ssn, age, scan);
    //    setDepartment(department);
    //}

    /**
     * constructor
     * @param id id
     * @param lastName last name
     */
    public Instructor(int id, String lastName)
    {
    	super(id, lastName);
    }    
    
    /**
     * sets or changes the instructors department
     * modification: changed department type to Department
     * @param department area of work at the university
     */
    public void setDepartment(Department department)
    {
        this.department = department;
    }

    /**
     * returns the instructors department
     * modification: changed department type to Department
     * @return department area of work at the university
     */
    public Department getDepartment()
    {
        return this.department;
    }

    /* *
     * overridden
     * returns string format of the instructor
     * 
     * @return String string format of the instructor including department
     * /
    protected String personString()
    {
        String returnString = super.personString();
        returnString += "\n" + getDepartment();
        return returnString;
    }*/
}