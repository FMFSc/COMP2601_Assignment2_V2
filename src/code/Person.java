/**
 * COMP2601 - Assignment 01
 * The class will be used to create Person objects throughout the programm.
 * Each person will have its own variables as date of birth, death and name.
 * This class will implement the comparable interface.
 *
 * @version 2.0
 * @Author Fellipe Matheus Fumagali Scirea
 */


public class Person implements Comparable<Person>
{
    private final Date born;
    private final Date died;
    private final Name name;


    /**
     * Getter method for the date of birth of the person object.
     *
     * @return Date of birth.
     */
    public Date getBorn()
    {

        return born;
    }


    /**
     * Getter method for the date of death of the person object.
     *
     * @return Date of death.
     */
    public Date getDied()
    {

        return died;
    }


    /**
     * Getter method for the name of the person object.
     *
     * @return Name of the person object.
     */
    public Name getName()
    {

        return name;
    }


    /**
     * The constructor will test if the person has a valid name, and date of birth and death.
     * @param born
     * @param died
     * @param name
     */
    public Person(Date born, Date died, Name name)
    {

        if(name == null)
        {
            throw new IllegalPersonException("invalid name");
        }
        else if(born == null)
        {
            throw new IllegalPersonException("invalid date of birth");
        }
        else
        {
            this.born = born;
            this.died = died;
            this.name = name;
        }
    }
}
