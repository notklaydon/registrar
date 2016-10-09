package registrar;

/**
 * Represents a person that has an id, components to make up a full name,
 * (such as a first, middle, and last name) an email address, social 
 * security number and an age
 * 
 * This object validates certain attributes during instantiation such as age,
 * social security number and email address for correct format and
 * restrictions
 * 
 * This object also contains an attribute to keep track of the oldest person
 * created is.
 * 
 * @author Klaydon Balicanta
 * 
 * Modification: made usable for the Registrar package
 * new constructor created to include id parameter
 * many methods of the Person are not used for Registrar
 * and are therefore commented out
 * @version 07/05/2015
 * 
 */

//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class Person
{
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    //private String email;
    //private String ssn;
    //private Integer age;
    //static private Person oldestPerson = null;	//instantiated to null until first entry of person
    //static private int lastUsedID = 4815162342;//int too large to be used. took out first integer
    //static private int lastUsedID = 815162342;	//Hurley's lucky/unlucky number from Lost
    //^^not used
    
    //private Pattern pattern = Pattern.compile(EMAIL_PATTERN);	//
    //private Matcher matcher;
    
    //private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	//	+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    //the following three constructors are commented out as they don't follow the registrar person format
 
    /* *
     * constructor
     * 
     * sets mostly everything to null except for id
     * /
    public Person(/*pass scanner to no param constructor?* /) {
        //may want to instantiate person attributes with something
        //other than null so then when driver calls to see the person
        //instantiated without params, they won't get errors up the ass
        this.firstName = null;
        this.middleName = null;
        this.lastName = null;
        this.email = null;
        this.ssn = null;
        this.age = null;
        this.id = ++lastUsedID; //shouldn't be null. id will be instantiated no matter what
    }*/
    

    /* *
     * constructor
     * 
     * does not prompt user to enter information, instead takes parameters
     * from instantiate in driver
     * 
     * @param first first name
     * @param middle middle name
     * @param last last name
     * @param email email address (only one '@' followed by a '.')
     * @param ssn social security number (formatted like ###-##-####)
     * @param age age (above 16)
     * @param scan Scanner
     * /
    public Person(String first, String middle, String last,
            String email, String ssn, Integer age, Scanner scan) {
        setFirstName(first);
        setMiddleName(middle);
        setLastName(last);
        setEmail(email, scan);
        setSSN(ssn, scan);
        setAge(age, scan);
        this.id = ++lastUsedID;
    }*/
    
    /* *
     * constructor
     * 
     * prompts user for Person information
     * 
     * @param scan 
     * /
    public Person(Scanner scan) {
        System.out.println("Please enter person's first name: ");
        setFirstName(scan.next());
        System.out.println("Please enter person's middle name: ");
        setMiddleName(scan.next());
        System.out.println("Please enter person's last name: ");
        setLastName(scan.next());
        System.out.println("Please enter person's email address: ");
        setEmail(scan.next(), scan);
        System.out.println("Please enter person's SSN in ###-##-#### format: ");
        setSSN(scan.next(), scan);
        System.out.println("Please enter person's age: ");
        setAge(scan.nextInt(), scan);
        this.id = ++lastUsedID;
    }
    */
    
    /**
     * 
     * @param id id
     * @param lastName last name
     */
    public Person(int id, String lastName)
    {
    	this.id = id;
    	this.lastName = lastName;
    }

    /* *
     * 
     * @param hex
     * @return
     * /
    public boolean validate(String hex)
    {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }*/
    
    /* *
     * returs a persons id
     * 
     * @return a persons id
     */
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
    	this.id = id;
    }

    /**
     * returns a person first name
     * 
     * @return a person first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * sets the persons first name
     * 
     * @param firstName a persons first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * returns a person middle name
     * 
     * @return a persons middle name
     */
    public String getMiddleName()
    {
        return middleName;
    }

    /**
     * sets the persons middle name
     * 
     * @param middleName a persons middle name
     */
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    /**
     * returns a person last name
     * 
     * @return a persons last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * sets the persons last name
     * 
     * @param lastName a persons last name
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    /**
     * returns a persons full name
     * 
     * @return persons first, middle, and last name concatenated together
     */
    public String getFullName()
    {
        return (firstName + " " + middleName + " " + lastName);
    }

    /* *
     * returns a persons email
     * 
     * @return a persons email
     * /
    public String getEmail()
    {
        return email;
    }*/
    
    /* *
     * returns domain portion of a persons email (after the @)
     * 
     * @return domain portion of a persons email
     * /
    public String getEmailDomain()
    {
        String domain;
        int atPosition = 0;
        for(int i = 0; i < email.length(); i++)
        {
            if(email.charAt(i) != '@')
                domain = email.substring(i, email.length()-1);
            else
                atPosition = i;
        }
        domain = email.substring(atPosition+1, email.length());
        return domain;
    }*/

    /* *
     * sets a persons email
     * email must contain only one '@' and must be followed by '.'
     * 
     * @param emailIn a persons email
     * @param scan Scanner object
     * /
    public /*static* / void setEmail(String emailIn, Scanner scan)
    {
        String email = emailIn;
        if(validate(email))
        {
            this.email = email;
            return;
        }
        else
        {
            while (!validate(email))
            {
                System.out.println("Invalid email. Please enter again: ");
                email = scan.nextLine();
            }
        }
        this.email = email;
    }*/

    /* *
     * returns a persons SSN
     * 
     * @return a persons SSN
     * /
    private String getSSN()
    {
        return ssn;
    }*/

    /* *
     * returns the last four digits of a persons SSN
     * 
     * @return last four digits of a persons SSN
     * /
    public String getLast4SSN()
    {
        return ssn.substring(7, 11);
    }*/

    /* *
     * sets a persons SSN
     * format must be ###-##-#### of only digits
     * 
     * @param ssn a persons SSN
     * @param scan Scanner object
     * /
    public /*static* / void setSSN(String ssn, Scanner scan)
    {

    	//there is an error here.
        while (ssn.length() != 11)
        {
            System.out.println("SSN missing a number or '-'. Enter again: ");
            ssn = scan.nextLine();
            while (!(ssn.charAt(3) == '-') || !(ssn.charAt(6) == '-'))
            {
                System.out.println("Format not compatible. Enter again: ");
                ssn = scan.nextLine();
            }
        }
        this.ssn = ssn;
    }*/

    /* *
     * returns a persons age
     * 
     * @return a persons age
     * /
    public Integer getAge()
    {
        return age;
    }*/

    /* *
     * sets a persons age
     * must be above 16 years old
     * 
     * @param age a persons age
     * @param scan Scanner object
     * /
    public /*static* / void setAge(Integer age, Scanner scan)
    {
        while (age <= 16)
        {
            System.out.println("Must be older than 16 years old."
                    + " Enter correct age: ");
            age = scan.nextInt();
        }
        if(oldestPerson == null)
            oldestPerson = this;
        else if (age > oldestPerson.getAge())
            oldestPerson = this;

        this.age = age;
    }*/
    
    /* *
     * String representation of a person
     * can be overridden in extending subclasses
     * 
     * @return String representation of a person
     * /
    protected String personString()
    {
        String returnString = "\n" + this.getFullName()
                + "\n" + this.getEmailDomain()
                + "\n" + this.getLast4SSN()
                + "\n" + getOldest();
        return returnString;
    }*/
    
    /* *
     * returns the oldest Person object
     * 
     * @return oldest Person object
     * /
    protected String getOldest()
    {
        if(this.equals(oldestPerson))
            return "oldest";
        else
            return "not oldest";
    }*/
}