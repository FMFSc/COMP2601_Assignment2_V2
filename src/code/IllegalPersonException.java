/**
 * COMP2601 - Assignment 01
 * This class extends the RuntimeException class. It satisfies its parent's constructor and does nothing else.
 * Its implementation follows the documentation provided by Oracle:
 * https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html
 *
 * @version 2.0
 * @Author Fellipe Matheus Fumagali Scirea
 */


public class IllegalPersonException extends RuntimeException
{
    /**
     * Constructs a new runtime exception with null as its detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to Throwable.initCause(java.lang.Throwable).
     */
    public IllegalPersonException()
    {

        super();
    }


    /**
     * Constructs a new runtime exception with the specified detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to Throwable.initCause(java.lang.Throwable).
     *
     * @param message: The detail message. The detail message is saved for later retrieval by the Throwable
     *                 .getMessage() method.
     */
    public IllegalPersonException(String message)
    {

        super();
    }


    /**
     * Constructs a new runtime exception with the specified detail message and cause. Note that the detail message
     * associated with cause is not automatically incorporated in this runtime exception's detail message.
     *
     * @param message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
     * @param cause   - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value
     *                is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public IllegalPersonException(String message, Throwable cause)
    {

        super();
    }


    /**
     * Constructs a new runtime exception with the specified cause and a detail message of (cause==null ? null :
     * cause.toString()) (which typically contains the class and detail message of cause). This constructor is useful
     * for runtime exceptions that are little more than wrappers for other throwables.
     *
     * @param cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value
     *              is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public IllegalPersonException(Throwable cause)
    {

        super();
    }


    /**
     * Constructs a new runtime exception with the specified detail message, cause, suppression enabled or disabled, and
     * writable stack trace enabled or disabled.
     *
     * @param message            - the detail message
     * @param cause              - the cause. (A null value is permitted, and indicates that the cause is nonexistent or
     *                           unknown.)
     * @param enableSuppression  - whether suppression is enabled or disabled
     * @param writableStackTrace - whether the stack trace should be writable
     */
    protected IllegalPersonException(String message,
                                     Throwable cause,
                                     boolean enableSuppression,
                                     boolean writableStackTrace)
    {

        super();
    }


}
