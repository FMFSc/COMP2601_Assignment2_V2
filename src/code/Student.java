/**
 * COMP2601 - Assignment 01
 * This class extends the Person class and further develops the implementation of a Student structure.
 * It also has an additional instance variable and its accessor method: String studentNumber and public String
 * getStudentNumber().
 *
 * @version 2.0
 * @Author Fellipe Matheus Fumagali Scirea
 */


public class Student extends Person
{
    private final String studentNumber;


    /**
     * Getter method for the student number variable
     *
     * @return
     */
    public final String getStudentNumber()
    {

        return studentNumber;
    }


    /**
     * Constructor method for the Student class, extending attributes from the Person class, such as name and date of
     * birth. This constructor throws IllegalPersonException exceptions if born or name is null. It throws
     * IllegalPersonException exceptions if studentNumber is null, blank, or not nine characters long.
     *
     * @param dateOfBirth   Student's date of birth
     * @param name          Student's full name
     * @param studentNumber Student number, composed of 9 digits, in a String format.
     */
    public Student(Date dateOfBirth, Name name, String studentNumber)
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
        else if(studentNumber == null || studentNumber.isBlank() || studentNumber.length() != 9)
        {
            throw new IllegalPersonException("bad student number");
        }
        this.studentNumber = studentNumber;
    }


    /**
     * This class overrides the public String toString() method, which returns a String in one of these two exact
     * formats:
     *      a) Alive people example: "Tiger Woods (student number: A12345678) was born 1975-12-30 and is still
     * alive"
     *      b) Dead people example: "Albert Einstein (student number: A87654321) was born 1879-03-14 and died 1955-
     * 04-18" Use the parent's getName() return value, then its getPrettyName() method, and the born/died getYyyyMmDd()
     * method.
     *
     * @return a formatted string with the student personal data: Name, date of birth and death (if deceased)
     */
    @Override
    public final String toString()
    {

        if(isAlive())
        {
            return String.format("%s (student number: %s) was born %s and is still alive.", getName().getPrettyName(),
                                 getStudentNumber(), getDateOfBirth().getYyyyMmDd());
        }
        return String.format("%s (student number: %s) was born %s and died on %s.", getName().getPrettyName(),
                             getStudentNumber(), this.getDateOfBirth().getYyyyMmDd(),
                             this.getDateOfDeath().getYyyyMmDd());

    }
}
