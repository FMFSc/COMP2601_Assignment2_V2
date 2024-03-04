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
    private Date dateOfBirth;
    private Date dateOfDeath;
    private Name name;


    /**
     * Getter method for the date of birth of the person object.
     *
     * @return Date of birth.
     */
    public final Date getDateOfBirth()
    {

        return dateOfBirth;
    }


    /**
     * Getter method for the date of death of the person object.
     *
     * @return Date of death.
     */
    public final Date getDateOfDeath()
    {

        return dateOfDeath;
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


    public final void setDateOfBirth(Date dateOfBirth)
    {

        this.dateOfBirth = dateOfBirth;
    }


    public final void setDateOfDeath(Date dateOfDeath)
    {

        this.dateOfDeath = dateOfDeath;
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
     * @param dateOfBirth represents the date of birth of the Person object
     * @param name represents the full name of the person.
     */
    public Person(Date dateOfBirth, Name name)
    {

        if(name == null)
        {
            throw new IllegalPersonException("invalid name");
        }
        else if(dateOfBirth == null)
        {
            throw new IllegalPersonException("invalid date of birth");
        }
        else
        {
            this.dateOfBirth = dateOfBirth;
            this.name        = name;
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
        setDateOfDeath(dateOfDeath);
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

        return dateOfDeath == null;

    }


    /**
     *The override compareTo method will evaluate the date of birth of this Person object against another specified
     * Person.
     *
     * It will throw a NullPointerException in case any of the dates of birth is null.
     * A younger person is considered greater, following the Date class compareTo method determination that a later date
     * is greater.
     *
     * @param p the Person to be compared.
     * @return a negative integers, zero or a positive integer, as this Person is older, same age, or younger
     * respectively than the specified Person it is being compared against
     * @throws NullPointerException if the date of birth of either this person or the specified person (p) is null.
     */
    @Override
    public final int compareTo(Person p)
    {

        if(this.getDateOfBirth() == null || p.getDateOfBirth() == null)
        {
            throw new NullPointerException("invalid date of birth");
        }
        return this.getDateOfBirth().compareTo(p.getDateOfBirth());
    }


    /**
     * The method will return a statement in form of a String as the following examples:
     * a) Alive people example: "Tiger Woods was born 1975-12-30 and is still alive"
     * b) Dead people example: "Albert Einstein was born 1879-03-14 and died 1955-04-18"
     *
     * @return String with the person's information, as name and dates of birth and death.
     */
    @Override
    public final String toString()
    {

        if(this.isAlive())
        {
            return String.format("%s was born on %s and is still alive.", name.getPrettyName(),
                                 dateOfBirth.getYyyyMmDd());
        }
        return String.format("%s was born on %s and died on %s.", name.getPrettyName(), dateOfBirth.getYyyyMmDd(),
                             dateOfDeath.getYyyyMmDd());
    }
}
