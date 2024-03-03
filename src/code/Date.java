/**
 * @version 2.0
 * @Author Fellipe Matheus Fumagali Scirea
 */
public class Date implements Orderable, Comparable<Date>
{
    private final int day;
    private final int month;
    private final int year;
    private  int      maximumDay;



    /**
     * This class defines constants to be used throughout the code, following best practices.
     * These constants represent various date-related values:
     *
     * Minimum year:
     *   MINIMUM_YEAR: The minimum supported year within the application.
     * Month and day ranges:
     *   MINIMUM_MONTH: The minimum supported month (1 for January).
     *   MAXIMUM_MONTH: The maximum supported month (12 for December).
     *   MINIMUM_DAY: The minimum supported day within a month (1).
     * Month constants: These represent the numerical values for each month.
     *   JAN: January (1)
     *   FEB: February (2)
     *   MAR: March (3)
     *   APR: April (4)
     *   MAY: May (5)
     *   JUN: June (6)
     *   JUL: July (7)
     *   AUG: August (8)
     *   SEP: September (9)
     *   OCT: October (10)
     *   NOV: November (11)
     *   DEC: December (12)
     * Calculation Constants:
     *   NONE: Used to represent zero within the code.
     *   CENTURY: Used to represent 100 years within the code.
     *   FORTH_CENTURY: Used to represent 400 years.
     *   FORTH_YEAR: Used to represent 4 years;
     */
    private static final int MINIMUM_YEAR;
    private static final int MINIMUM_MONTH;
    private static final int MAXIMUM_MONTH;
    private static final int MINIMUM_DAY;
    public static final  int JAN;
    public static final  int FEB;
    public static final  int MAR;
    public static final  int APR;
    public static final  int MAY;
    public static final  int JUN;
    public static final  int JUL;
    public static final  int AUG;
    public static final  int SEP;
    public static final  int OCT;
    public static final  int NOV;
    public static final  int DEC;
    private static final int NONE;
    private static final int CENTURY;
    private static final int FORTH_CENTURY;
    private static final int FORTH_YEAR;




    /**
     * Initializing the constants in a static block, to avoid initializing and assigning on the same line;
     */
    static
    {
        MINIMUM_DAY   = 1;
        MINIMUM_MONTH = 1;
        MINIMUM_YEAR  = 1;
        MAXIMUM_MONTH = 12;
        JAN           = 1;
        FEB           = 2;
        MAR           = 3;
        APR           = 4;
        MAY           = 5;
        JUN           = 6;
        JUL           = 7;
        AUG           = 8;
        SEP           = 9;
        OCT           = 10;
        NOV           = 11;
        DEC           = 12;
        NONE          = 0;
        CENTURY       = 100;
        FORTH_CENTURY = 400;
        FORTH_YEAR    = 4;
    }


    /**
     * Getter for the day portion of the Date object
     *
     * @return day of the date object
     */
    public int getDay()
    {

        return day;
    }


    /**
     * Getter for the month portion of the Date object
     *
     * @return month of the date object
     */
    public int getMonth()
    {

        return month;
    }


    /**
     * Getter for the year portion of the Date object
     *
     * @return year of the date object
     */
    public int getYear()
    {

        return year;
    }


    /**
     * This method is used to determine if a given date, is in a year that has 366 days, also known as leap year. Every
     * year that is exactly divisible by four is a leap year, except for years that are exactly divisible by 100, but
     * these centurial years are leap years if they are exactly divisible by 400. For example, the years 1700, 1800, and
     * 1900 are not leap years, but the years 1600 and 2000 are.
     *
     * @return true when the year is a leap year.
     */
    private boolean isLeapYear()
    {
        if(this.getYear() % FORTH_YEAR != NONE)
        {
            return false;
        }
        else if(this.getYear() % CENTURY == NONE && this.getYear() % FORTH_CENTURY != NONE)
        {
            return false;
        }
        return true;
    }


    /**
     * This method will obtain the maximum days in a month, based on the month, as the roman calendar established.
     *
     * @return maximumDay and that is the maximum number of day on the selected month.
     */
    private final int getNumberOfDaysPerMonth(int month, int year)
    {
        switch (month)
        {
            case JAN:
            case MAR:
            case MAY:
            case JUL:
            case AUG:
            case OCT:
            case DEC:
                maximumDay = 31;
                return maximumDay;
                break;
            case APR:
            case JUN:
            case SEP:
            case NOV:
                maximumDay = 30;
                return maximumDay;
                break;
            case FEB:
                if(isLeapYear = true){
                    maximumDay = 29;
                    return maximumDay;
                    break;
                }
                maximumDay = 28;
                return maximumDay;
        }
        return maximumDay;
    }

    /**
     * The constructor for the Date class will test the provided arguments against the parameters established as
     * minimum and maximum days, months and minimum year.
     * @param day Day from the date being created.
     * @param month Month from the date being created.
     * @param year Year from the date being created.
     */
    public Date(int day, int month, int year)
    {

        if(year <= MINIMUM_YEAR)
        {
            throw new IllegalArgumentException("invalid year");
        }
        else if(month < MINIMUM_MONTH || month > MAXIMUM_MONTH)
        {
            throw new IllegalArgumentException("invalid month");
        }
        else if(day < MINIMUM_DAY || day > maximumDay)
        {
            throw new IllegalArgumentException("invalid day");
        }

        this.day   = day;
        this.month = month;
        this.year  = year;
    }

    /**
     * Formatting date method, that will present it in the ISO 8601 format
     *
     * @return a string with the formatted date
     */
    public String getYyyyMmDd()
    {
        return String.format("%04d-%02d-%02d", year, month, day);
    }


    @Override
    public Orderable next()
    {

        return null;
    }


    @Override
    public Orderable previous()
    {

        return null;
    }


    @Override
    public int compareTo(Date o)
    {

        return 0;
    }


    /**
     * Overriding the toString method as a requirement
     * @return
     */
    @Override
    public String toString()
    {
        return getYyyyMmDd();
    }
}
