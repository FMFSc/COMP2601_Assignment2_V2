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
    private Date born;
    private Date died;
    private Name name;


    /**
     * Getter method for the date of birth of the person object.
     *
     * @return Date of birth.
     */
    public final Date getBorn()
    {

        return born;
    }


    /**
     * Getter method for the date of death of the person object.
     *
     * @return Date of death.
     */
    public final Date getDied()
    {

        return died;
    }


    /**
     * Getter method for the name of the person object.
     *
     * @return Name of the person object.
     */
    public final Name getName()
    {

        return name;
    }


    public final void setBorn(Date born)
    {

        this.born = born;
    }


    public final void setDied(Date died)
    {

        this.died = died;
    }


    public final void setName(Name name)
    {

        this.name = name;
    }


    // /**
    //  * The constructor will test if the person has a valid name, and date of birth and death.
    //  *
    //  * @param born represents the date of birth of the Person object
    //  * @param died represents the date of death of the Person object
    //  * @param name represents the full name of the person.
    //  */
    // public Person(Date born, Date died, Name name)
    // {
    //
    //     if(name == null)
    //     {
    //         throw new IllegalPersonException("invalid name");
    //     }
    //     else if(born == null)
    //     {
    //         throw new IllegalPersonException("invalid date of birth");
    //     }
    //     else if(died )
    //     {
    //         throw new IllegalPersonException("invalid date of death");
    //     }
    //     else
    //     {
    //         this.born = born;
    //         this.died = died;
    //         this.name = name;
    //     }
    // }


    /**
     * The constructor will test if the person has a valid name, and date of birth.
     *
     * @param born represents the date of birth of the Person object
     * @param name represents the full name of the person.
     */
    public Person(Date born, Name name)
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
            this.name = name;
        }
    }


    /**
     * This method sets the died instance variable to the dateOfDeath provided.
     *
     * @param dateOfDeath represents the Person object's date of death
     */
    public final void die(Date dateOfDeath)
    {

        if(dateOfDeath == null)
        {
            throw new IllegalArgumentException("invalid date of death");
        }
        setDied(dateOfDeath);
    }


    /**
     * This method returns true if the Person is alive; otherwise returns false. This method will determine the living
     * status of the Person object, by checking the existence of a date of death for said Person. A person is considered
     * alive when the died attribute is null or that it has not been set. If there is a died attribute, the person is
     * considered deceased.
     *
     * @return the state of life of the Person object, being true for alive, false for deceased.
     */
    public final boolean isAlive()
    {

        return died == null;

    }


}
