package registrar;

/**
 * Students are a subclass of a Person
 * Students have a major.
 *
 * @author Klaydon Balicanta
 * 
 * Modifications: made usable for Registrar
 * a student now has a collection of Sections
 * and new functionality to add and drop Sections
 * from the collection
 * A new constructor has been added to accommodate
 * the Registrar
 * Fields unrelated to the Registrar have been
 * commented out
 * @version 07/05/2015
 * 
 */
//import java.util.Scanner;
import java.util.HashMap;

public class Student extends Person
{
    //String major;
    HashMap<Integer, Section> currentSections;
    
    /*
    /**
     * Student constructor
     * Overrides the Person super constructor to include the major
     * 
     * @param first first name
     * @param middle middle name
     * @param last last name
     * @param email email address [format: whatever@domain.com]
     * @param ssn social security number [format: ###-##-####]
     * @param age age [at least 17 years old]
     * @param scan Scanner object passed from Driver
     * @param major area of study at the university
     * /
    public Student(String first, String middle, String last, String email, 
            String ssn, Integer age, Scanner scan, String major) {
        super(first, middle, last, email, ssn, age, scan);
        setMajor(major);
    }
    */
    
    public Student(int id, String lastName)
    {
    	super(id, lastName);
    	currentSections = new HashMap<>();
    }

    /* *
     * sets or changes the students major
     * 
     * @param major area of study at the university
     * /
    public void setMajor(String major) {
        this.major = major;
    }*/

    /* *
     * returns the students major
     * 
     * @return major area of study at the university
     * /
    public String getMajor() {
        return this.major;
    }*/
    
    /* *
    * overridden
    * returns string format of the student
    * 
    * @return String string format of the student including major
    * /
    protected String personString() {
        String returnString = super.personString();
        returnString += "\n" + getMajor();
        return returnString;
    }*/
    
    /**
     * adds a Course-Section to the students collection of 
     * Course-Sections
     * @param section Section to add the Course collection
     */
    public void add(Section section)
    {
    	currentSections.put(section.CRN, section);
    }
    
    
    /**
     * removes the specified Course-Section from the students
     * collection of Course-Sections
     * @param section Section to add the Course collection
     */
    public void drop(Section section)
    {
    	currentSections.remove(section);
    }
}