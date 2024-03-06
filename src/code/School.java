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


    /*
      This is an instance initializer block, used to set up the "List" of "Person" references/objects.
     */
    {
        listOfPerson = new ArrayList<>();
    }


    // /**
    //  * CONSTRUCTOR
    //  * @param listOfPerson
    //  */
    // public School(List<Person> listOfPerson)
    // {
    //
    //     this.listOfPerson = new ArrayList<>();
    //
    // }


    /**
     * GETTER
     * @return
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
     *
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
