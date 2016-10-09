package registrar;

/**
 * Deparments of the University
 * 
 * @author Klaydon Balicanta
 * @version 07/05/2015
 * 
 */

public enum Department
{
	/**
	 * enumerated Department values
	 */
	Art, Biology, Chemistry, Computer_Science, Economics, 
	History, Music, Philosophy, Physics, Psychology;

	/**
	 * creates a string array of departments
	 * with one offset at the beginning of the array
	 * allowing a blank selection to be available
	 * @return a string array of Department values
	 */
	public static String[] departmentsString()
	{
		Department[] departments = values();
		String[] departmentStrings = new String[departments.length + 1];
		departmentStrings[0] = "";
		for(int i = 1; i < departments.length + 1; i++)
			departmentStrings[i] = departments[i-1].name();
		return departmentStrings;
	}
}