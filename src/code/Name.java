/**
 * This class implements a name structure for the data to be inputted. It has final instance variables, constructor
 * arguments, and accessor methods for String first and String last.
 *
 * @version 2.0
 * @Author Fellipe Matheus Fumagali Scirea
 */


public class Name
{
    private final String first;
    private final String last;


    /**
     * This constructor method will initialize and validate the Name data, as it can´t be blank, contain only whitespace
     * or be null.
     *
     * @param first String representing the first name of a person
     * @param last  String representing the last name of a person
     */
    public Name(String first, String last)
    {

        if(first == null || first.isBlank())
        {
            throw new IllegalArgumentException("invalid first name");
        }

        else if(last == null || last.isBlank())
        {
            throw new IllegalArgumentException("invalid last name");
        }

        this.first = first;
        this.last  = last;
    }


}
