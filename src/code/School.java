import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * COMP2601 - Assignment 01
 * This class is used to generate a list of Person references, and export it into a txt file.
 *
 * @version 2.0
 * @author Fellipe Matheus Fumagali Scirea
 */


public class School
{
    public List<Person> listOfPerson;

    private static final int currentYear;

    static
    {
        currentYear = 2022;
    }


    /**
     * Instance initializer block for the class.
     * Initializes the 'listOfPerson' with an empty ArrayList. This block runs before any constructor  whenever an
     * instance of the class is created. It ensures that 'listOfPerson' is ready to store* 'Person'
     * objects/references as soon as the class instance is created.
     */
    {
        listOfPerson = new ArrayList<>();
    }


    /**
     * The getter method returns the list of persons.
     * This method gives access to the current list of Person objects.
     *
     * @return The current list of Person objects.
     */
    public List<Person> getListOfPerson()
    {

        return listOfPerson;
    }


    /**
     * This method will be used to add People references to the listOfPeople ArrayList, in case they pass the validation
     * for null values.
     *
     * @param p Person object to be added to the listOfPerson
     */
    public final void register(Person p)
    {

        if(p == null)
        {
            throw new IllegalPersonException("cannot register a non-person");
        }
        listOfPerson.add(p);

    }


    /**
     * This method uses a method reference to print out all the people (i.e. triggering a call to their respective
     * toString() methods).
     */
    public final void printRoster()
    {

        listOfPerson.forEach(System.out::println);
    }


    /**
     * Prints the ages and corresponding years for each person in the list.
     *
     * This method iterates over the list of Person objects and prints their full name, birth year, and age
     * for each year until the current year or the year of death (if applicable).
     */
    public final void printAgesAndYears()
    {

        Writeable w = (String fullName, int yearBorn, int maxYear) ->
        {
            for(int year = yearBorn; year <= maxYear; year++)
            {
                int age = year - yearBorn;
                System.out.printf("%s: %d (age %d)\n", fullName, year, age);
            }
        };

        for(Person person : listOfPerson)
        {
            final String fullName = person.getName().getPrettyName();
            final int    yearBorn = person.getDateOfBirth().getYear();
            final int    maxYear;
            if(person.isAlive())
            {
                maxYear = currentYear;
            }
            else
            {
                maxYear = person.getDateOfDeath().getYear();
            }

            w.printData(fullName, yearBorn, maxYear);
        }
    }

    /**
     * Saves details of each Person object to a text file named "people.txt".
     *
     * This method iterates over the list of Person objects and writes their details, including name, initials,
     * birthdate, and, if deceased, death date, to a text file. The file format is as follows:
     * - For living persons: "<FullName> (<Initials>) was born on <Weekday Birth> <Birth Date>."
     * - For deceased persons: "<Full Name> (<Initials>) was born on <Weekday Birth> <Birth Date> and died on
     * <Weekday Death> <Death Date>." The text file is saved in the current directory.
     */
    public void saveDetails()
    {
        try (FileWriter writer = new FileWriter("people.txt"))
        {
            for(Person person : listOfPerson)
            {
                String name      = person.getName().getPrettyName();
                String initials  = person.getName().getInitials();
                String birthDate = person.getDateOfBirth().getYyyyMmDd();

                String weekDayBirth = person.getDateOfBirth().getDayOfTheWeek();


                if(person.isAlive())
                {
                    String output = String.format("%s (%s) was born on %s %s.\n", name, initials, weekDayBirth,
                                                  birthDate);
                    writer.write(output);
                }
                else
                {
                    String deathDate = person.getDateOfDeath().getYyyyMmDd();
                    String weekDayDeath = person.getDateOfDeath().getDayOfTheWeek();
                    String output = String.format("%s (%s) was born on %s %s and died on %s %s.\n", name,
                                                  initials, weekDayBirth, birthDate, weekDayDeath,deathDate);
                    writer.write(output);
                }
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}
