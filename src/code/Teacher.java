/**
 * COMP2601 - Assignment 01
 * This class extends the Person class. It also has an additional instance variable and its accessor method: String
 * specialty and public String getSpecialty().
 *
 * @version 2.0
 * @Author Fellipe Matheus Fumagali Scirea
 */


public class Teacher extends Person
{
    private final String specialty;


    /**
     * Getter accessor for the specialty variable.
     * @return the teacher specialty.
     */
    public final String getSpecialty()
    {

        return specialty;
    }


    /**
     * Constructor for the Teacher class.
     * This constructor throws IllegalPersonException exceptions if:
     *      Born or name is null.
     *      Specialty is blank (note: null is ok).
     *
     * @param dateOfBirth Teacher's date of birth.
     * @param name Teacher's name.
     * @param specialty Teacher's field or area of specialty and knowledge.
     */
    public Teacher(Date dateOfBirth, Name name, String specialty)
    {

        super(dateOfBirth, name);

        if(this.getDateOfBirth() == null)
        {
            throw new IllegalPersonException("Invalid date of birth");
        }
        else if(this.getName() == null)
        {
            throw new IllegalPersonException("Invalid name");
        }
        else if(specialty.isBlank())
        {
            throw new IllegalPersonException("bad specialty");
        }
        this.specialty = specialty;
    }


    /**
     * This class overrides the public String toString() method, which returns a String in one of these two exact
     * formats:
     *      a) Alive people example: "Tiger Woods (specialty: mathematics) was born 1975-12-30 and is still alive"
     *      b) Dead people example: "Albert Einstein (specialty: mathematics) was born 1879-03-14 and died 1955-04-18"
     *
     * @return a formatted string with the teacher's personal information.
     */
    public final String toString()
    {

        if(isAlive())
        {
            return String.format("%s (specialty: %s) was born %s and is still alive",
                                 getName().getPrettyName(),
                                 getSpecialty(), getDateOfBirth().getYyyyMmDd());
        }
        return String.format("%s (specialty: %s) was born %s and died %s", getName().getPrettyName(), getSpecialty(),
                             getDateOfBirth().getYyyyMmDd(), getDateOfDeath().getYyyyMmDd());


    }
}
