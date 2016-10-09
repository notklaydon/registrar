package registrar;

/**
 * Term is a collection of Sections that can add
 * more to the collection and contains a field for the
 * term
 * 
 * @author Klaydon Balicanta
 * @version 07/05/2015
 * 
 */
import java.util.ArrayList;

public class Term
{
	ArrayList<Section> sections;
	String term;
	
	/**
	 * constructor
	 * @param term term
	 */
	public Term(String term)
	{
		sections = new ArrayList<>();
		this.term = term;
	}
	
	/**
	 * adds a new Section to the collection
	 * @param section new Section to add
	 */
	public void addSection(Section section)
	{
		sections.add(section);
	}
}
