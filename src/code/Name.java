/**
 * COMP2601 - Assignment 01
 * This class implements a name structure for the data to be inputted. It has final instance variables, constructor
 * arguments, and accessor methods for String first and String last.
 *
 * @version 2.0
 * @author Fellipe Matheus Fumagali Scirea
 */


public class Name
{
    private final String first;
    private final String last;


    /**
     * Accessor Getter method for the first name Variable
     *
     * @return first name of a person
     */
    public final String getFirst()
    {

        return first;
    }


    /**
     * Accessor Getter method for the last name Variable
     *
     * @return last name of a person
     */
    public final String getLast()
    {

        return last;
    }


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


    /**
     * the GetPrettyName method will format any given name, in any given format condition, and return with the first
     * letter as upper case for both first and last name, and the other letters as lower case.
     *
     * @return the formatted version of the name variable, with proper formatting(first letter is upper case, the others
     *         are lower case)
     */
    public final String getPrettyName()
    {

        return first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase() + " " +
               last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
    }


    /**
     * The getInitials method will be used to extract the firs letter of the first and last names, in capital letters.
     * Each letter will be followed by a dot and no spaces.
     *
     * @return First letter of the first name, and last name, in upper case.
     */
    public final String getInitials()
    {

        return first.substring(0, 1).toUpperCase() + "." +
               last.substring(0, 1).toUpperCase() + ".";
    }

}
