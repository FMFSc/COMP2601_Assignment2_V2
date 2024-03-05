/**
 * COMP2601 - Assignment 01
 * This Writeable interface will be a functional interface, therefore, will only have one abstract method.
 * The implementation is expected to have a suitable application to print the data.
 * @Author Fellipe Matheus Fumagali Scirea
 * @version 2.0
 */


@FunctionalInterface
public interface Writeable
{
    /**
     * This abstract method will take arguments and upon implementation, will return a
     * @param s     String data to be printed.
     * @param min   minimum value as parameter argument to be printed.
     * @param max   maximum value as parameter argument to be printed.
     */
    public void printData(String s, int min, int max);
}
