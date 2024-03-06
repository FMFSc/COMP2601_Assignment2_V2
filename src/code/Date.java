/**
 * COMP2601 - Assignment 01
 * The date class will implement several methods to be utilized within the other classes.
 * It implements the Orderable and Comparable interfaces.
 *
 * @version 2.0
 * @author Fellipe Matheus Fumagali Scirea
 */


public class Date implements Orderable, Comparable<Date>
{
    private final int day;
    private final int month;
    private final int year;

    /**
     * This class defines constants to be used throughout the code, following best practices.
     * These constants represent various date-related values:
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
     *   CENTENNIAL: Used to represent 100 years within the code.
     *   FORTH_CENTURY: Used to represent 400 years.
     *   FORTH_YEAR: Used to represent 4 years;
     *   SINGLE: Used to represent the number 1;
     *   NUM_TWO: Used to represent the number 2;
     *   NUM_THREE: Used to represent the number 3;
     *   NUM_FOUR: Used to represent the number 4;
     *   NUM_FIVE: Used to represent the number 5;
     *   NUM_SIX: Used to represent the number 6;
     *   NUM_SEVEN: Used to represent the number 7;
     *   NUM_TWELVE: Used to represent the number 12;
     *   NUM_SIXTEEN: Used to represent the number 16;
     *   NUM_SEVENTEEN: Used to represent the number 17;
     *   NUM_EIGHTEEN: Used to represent the number 18;
     *   NUM_TWENTY: Used to represent the number 20;
     *   NUM_TWENTY_ONE: Used to represent the number 21;
     *   daysOfTheWeek: An array with the abbreviation for the days of the week, with only the initial 3 letters.
     */
    private static final int      MINIMUM_YEAR;
    private static final int      MINIMUM_MONTH;
    private static final int      MAXIMUM_MONTH;
    private static final int      MINIMUM_DAY;
    private static final int      JAN;
    private static final int      FEB;
    private static final int      MAR;
    private static final int      APR;
    private static final int      MAY;
    private static final int      JUN;
    private static final int      JUL;
    private static final int      AUG;
    private static final int      SEP;
    private static final int      OCT;
    private static final int      NOV;
    private static final int      DEC;
    private static final int      NONE;
    private static final int      CENTENNIAL;
    private static final int      FORTH_CENTURY;
    private static final int      FORTH_YEAR;
    private static final int      DAYS_IN_MONTH_31;
    private static final int      DAYS_IN_MONTH_30;
    private static final int      DAYS_IN_MONTH_29; // Leap year specific
    private static final int      DAYS_IN_MONTH_28;
    private static final int      SINGLE;
    private static final int      NUM_TWO;
    private static final int      NUM_THREE;
    private static final int      NUM_FOUR;
    private static final int      NUM_FIVE;
    private static final int      NUM_SIX;
    private static final int      NUM_SEVEN;
    private static final int      NUM_TWELVE;
    private static final int      NUM_SIXTEEN;
    private static final int      NUM_SEVENTEEN;
    private static final int      NUM_EIGHTEEN;
    private static final int      NUM_TWENTY;
    private static final int      NUM_TWENTY_ONE;
    private static final String[] daysOfTheWeek;


    /**
     * This static block is used to initialize the constants previously created. to avoid
     * Initializing the constants in this static block will ensure that all constants are set up before they are used
     * anywhere in the class, avoiding the practice of hardcoding or inline initialization.
     * line;
     */
    static
    {
        MINIMUM_DAY      = 1;
        MINIMUM_MONTH    = 1;
        MINIMUM_YEAR     = 1;
        MAXIMUM_MONTH    = 12;
        JAN              = 1;
        FEB              = 2;
        MAR              = 3;
        APR              = 4;
        MAY              = 5;
        JUN              = 6;
        JUL              = 7;
        AUG              = 8;
        SEP              = 9;
        OCT              = 10;
        NOV              = 11;
        DEC              = 12;
        NONE             = 0;
        CENTENNIAL       = 100;
        FORTH_CENTURY    = 400;
        FORTH_YEAR       = 4;
        DAYS_IN_MONTH_31 = 31;
        DAYS_IN_MONTH_30 = 30;
        DAYS_IN_MONTH_29 = 29;
        DAYS_IN_MONTH_28 = 28;
        SINGLE           = 1;
        NUM_TWO          = 2;
        NUM_THREE        = 3;
        NUM_FOUR         = 4;
        NUM_FIVE         = 5;
        NUM_SIX          = 6;
        NUM_SEVEN        = 7;
        NUM_TWELVE       = 12;
        NUM_SIXTEEN      = 16;
        NUM_SEVENTEEN    = 17;
        NUM_EIGHTEEN     = 18;
        NUM_TWENTY       = 20;
        NUM_TWENTY_ONE   = 21;
        daysOfTheWeek    = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    }


    /**
     * Getter for the day portion of the Date object
     *
     * @return day of the date object
     */
    public final int getDay()
    {

        return day;
    }


    /**
     * Getter for the month portion of the Date object
     *
     * @return month of the date object
     */
    public final int getMonth()
    {

        return month;
    }


    /**
     * Getter for the year portion of the Date object
     *
     * @return year of the date object
     */
    public final int getYear()
    {

        return year;
    }


    /**
     * The constructor for the Date class will test the provided arguments against the parameters established as minimum
     * and maximum days, months and minimum year.
     *
     * @param day   Day from the date being created.
     * @param month Month from the date being created.
     * @param year  Year from the date being created.
     */
    public Date(int day, int month, int year)
    {

        if(year < MINIMUM_YEAR)
        {
            throw new IllegalArgumentException("invalid year");
        }
        else if(month < MINIMUM_MONTH || month > MAXIMUM_MONTH)
        {
            throw new IllegalArgumentException("invalid month");
        }
        else if(day < MINIMUM_DAY)
        {
            throw new IllegalArgumentException("invalid day");
        }
        else if(day > this.getNumberOfDaysPerMonth(month, year))
        {
            throw new IllegalArgumentException("invalid day of the month");
        }

        this.day   = day;
        this.month = month;
        this.year  = year;
    }


    /**
     * This method is used to determine if a given date, is in a year that has 366 days, also known as leap year. Every
     * year that is exactly divisible by four is a leap year, except for years that are exactly divisible by 100, but
     * these centurial years are leap years if they are exactly divisible by 400. For example, the years 1700, 1800, and
     * 1900 are not leap years, but the years 1600 and 2000 are.
     *
     * @return true when the year is a leap year.
     */
    private final boolean isLeapYear(int year)
    {

        if(year % FORTH_YEAR != NONE)
        {
            return false;
        }
        else if(year % CENTENNIAL == NONE && year % FORTH_CENTURY != NONE)
        {
            return false;
        }
        return true;
    }


    /**
     * This method will obtain the maximum days in a month, based on the month, as the Gregorian calendar established.
     *
     * @return daysInMonth: which represents the number of days on the month of the provided month and year arguments.
     */
    private final int getNumberOfDaysPerMonth(int month, int year)
    {

        int daysInMonth;

        if(month == JAN || month == MAR || month == MAY || month == JUL || month == AUG || month == OCT || month == DEC)
        {
            daysInMonth = DAYS_IN_MONTH_31;
        }
        else if(month == APR || month == JUN || month == SEP || month == NOV)
        {
            daysInMonth = DAYS_IN_MONTH_30;
        }
        else if(month == FEB && isLeapYear(year))
        {
            daysInMonth = DAYS_IN_MONTH_29;
        }
        else
        {
            daysInMonth = DAYS_IN_MONTH_28;
        }
        return daysInMonth;

    }



    /**
     * Formatting date method, that will present it in the ISO 8601 format
     *
     * @return a string with the formatted date
     */
    public final String getYyyyMmDd()
    {
        return String.format("%04d-%02d-%02d", year, month, day);
    }


    /**
     * Calculates and returns the next chronological date following the current date.
     * This method implements the `next` method from the Orderable interface.
     * It increments the current date by one day, taking into account the length of the month and the transition
     * between years. If the current date is the last day of the month, the method advances to the first day of the
     * following month. Similarly, if it's the last day of December, the method transitions to January 1st of the
     * next year.
     *
     * @return Date representing the day immediately following the current date.
     */
    @Override
    public final Date next()
    {

        Date next = new Date(this.day, this.month, this.year);
        if(next.day < getNumberOfDaysPerMonth(next.month, next.year))
        {
            next = new Date(next.day + SINGLE, next.month, next.year);
        }
        else
        {
            if(next.month < MAXIMUM_MONTH)
            {
                next = new Date(MINIMUM_DAY, next.month + SINGLE, next.year);
            }
            else
            {
                next = new Date(MINIMUM_DAY, MINIMUM_MONTH, next.year + SINGLE);
            }
        }

        return next;
    }


    /**
     * Implements the 'previous' method as specified by the Orderable interface.
     * This method calculates and returns the date immediately preceding the current date.
     * It decrements the current date by one day, taking into account the length of the month and the transition
     * between years. If the current date is the first day of a month, the method returns the last day of the
     * preceding month. Specifically, if the current date is January 1st, the method returns December 31st of the
     * previous year.
     * *
     * @return Date representing the day immediately preceding the current date.
     */
    @Override
    public final Date previous()
    {

        Date previous = new Date(this.day, this.month, this.year);
        if(previous.day > MINIMUM_DAY)
        {
            previous = new Date(previous.day - SINGLE, previous.month, previous.year);
        }
        else
        {
            if(previous.month > MINIMUM_MONTH)
            {
                previous = new Date(previous.getNumberOfDaysPerMonth(previous.month - SINGLE, previous.year),
                                    previous.month - SINGLE,
                                    previous.year);
            }
            else
            {
                previous = new Date(previous.getNumberOfDaysPerMonth(MAXIMUM_MONTH, previous.year - SINGLE),
                                    MAXIMUM_MONTH,
                                    previous.year - SINGLE);
            }
        }

        return previous;
    }


    /**
     * Overriding the compareTo method will allow this method to determine which date is greater. As the requirement
     * states 'Later dates are "larger"'.
     *
     * @param d the object to be compared.
     * @return a POSITIVE integer if the date instance being compare to a provided date is later/larger. A NEGATIVE
     *         integer if it is smaller, or ZERO if they are considered to be equals in an order perspective.
     */
    @Override
    public final int compareTo(Date d)
    {
        if(d == null)
        {
            return 1;
        }
        else if(this.year != d.year)
        {
            return this.year - d.year;
        }
        else if(this.month != d.month)
        {
            return this.month - d.month;
        }
        else if(this.day != d.day)
        {
            return this.day - d.day;
        }
        return 0;
    }


    /**
     * Overrides the default toString method. This implementation represents the object in a 'YYYY-MM-DD' format,
     * leveraging the getYyyyMmDd() method.
     *
     * @return A string representing the date in 'YYYY-MM-DD' format.
     */
    @Override
    public final String toString()
    {
        return getYyyyMmDd();
    }


    /**
     * Provides the numerical code associated with each month, which is an integral part of the algorithm used in the
     * getDayOfTheWeek() method. This method maps each month to a specific code that is used in calculating the day of
     * the week. Each month's code is determined by its position in the calendar, with January being 1, February being
     * 2, and so on. Additionally, the month code should be as provided in the program requirements for the
     * implementation of this algorithm, as follows: January = 1 | February = 4; | March = 4; | April = 0; | May = 2 |
     * June = 5 | July = 0 | August = 3 | September = 6 | October = 1 | November = 4 | December = 6
     *
     * @param month The integer representing the month (1 for January, 2 for February, etc.).
     * @return The code associated with the given month, as used in the day-of-the-week calculation.
     */
    private final int getCodeForMonth(int month)
    {
        final int[] monthCodes;
        monthCodes = new int[] {SINGLE, NUM_FOUR, NUM_FOUR, NONE, NUM_TWO, NUM_FIVE, NONE, NUM_THREE, NUM_SIX, SINGLE,
                       NUM_FOUR, NUM_SIX};
        return monthCodes[month-1];
    }


    /**
     * This getOffset is a supporting method to be used in the calculation of the index of the week day.
     * As some dates will require a special offset to be calculated, and this offset will be used in the step 5 of
     * the getIndexDayOfTheWeek calculation, this method will follow the these requirements:
     *
     * January and February dates in leap years: add 6 to step 5
     * All dates in the 1600s: add 6 to step 5
     * All dates in the 1700s: add 4 to step 5
     * All dates in the 1800s: add 2 to step 5
     * All dates in the 2000s: add 6 to step 5
     * All dates in the 2100s: add 4 to step 5
     *
     * @param monthOffset Month of the date being provided.
     * @param yearOffset Year of the date being provided.
     * @return the offset to be added to step 5 of the getIndexDayOfTheWeek method calculation.
     */
    private final int getOffset(int monthOffset, int yearOffset)
    {

        final int offset;
        final int century;
        century = yearOffset / CENTENNIAL;

        if((monthOffset == JAN || monthOffset == FEB) && isLeapYear(yearOffset))
        {
            offset = NUM_SIX;
        }
        else if(century == NUM_SIXTEEN || century == NUM_TWENTY)
        {
            offset = NUM_SIX;
        }
        else if(century == NUM_SEVENTEEN || century == NUM_TWENTY_ONE)
        {
            offset = NUM_FOUR;
        }
        else if(century == NUM_EIGHTEEN)
        {
            offset = NUM_TWO;
        }
        else
        {
            offset = NONE;
        }

        return offset;
    }


    /**
     *This method implements the algorithm that will be used to determine the day of the week as a String.
     * The algorithm must follow a few steps, given a certain date object:
     *
     * Step 1:  Only look at the last two digits of the year and determine how many twelves fit in it.
     * Step 2:  Determine the remainder of step 1's result, for 12.
     * Step 3:  Determine how many fours fit into the remainder (step 2's result).
     * Step 4:  Add the day of the month.
     * Step 5:  Add the month code from the table below (hint: writing a private method to determine this would be a
     *          good idea: private int getCodeForMonth(int month)):
     *          Jan=1 | Feb=4 | Mar=4 |  Apr=0 | May=2 | Jun=5 | Jul=0 | Aug=3 | Sep=6 | Oct=1 | Nov=4 | Dec=6
     * Step 6:  Add all of the above highlighted numbers, and then mod by 7.
     * NOTE: some dates require special offsets to add after step 5.
     *
     * As the algorithm needed some external supporting methods, they were created and introduced on the necessary
     * steps.
     * Step 5 need both a supporting method called getOffset and getCodeForMonth
     *
     * @return a String representing the abbreviated day of the week, with its three first letters.
     */
    public final String getDayOfTheWeek()
    {

        final int indexDayOfTheWeek;
        final int lastTwoDigitsOfYear;
        final int step1;
        final int step2;
        final int step3;
        final int step4;
        final int step5;
        final int step6;

        lastTwoDigitsOfYear = this.year % CENTENNIAL;
        step1               = lastTwoDigitsOfYear / NUM_TWELVE;
        step2               = lastTwoDigitsOfYear % NUM_TWELVE;
        step3               = step2 / NUM_FOUR;
        step4               = this.getDay();
        step5               = getCodeForMonth(this.getMonth()) + getOffset(this.getMonth(), this.getYear());
        step6               = step1 + step2 + step3 + step4 + step5;
        indexDayOfTheWeek   = step6 % NUM_SEVEN;


        return daysOfTheWeek[indexDayOfTheWeek];
    }
}
