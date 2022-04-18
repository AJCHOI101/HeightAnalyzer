import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * This program will perform some 
 * basic analysis on a set of 
 * values representing the 
 * heights of a group of people 
 * in inches
 *
 * @author (Andrew Choi)
 * @version (03.24.2020)
 */
public class HeightAnalyzer
{
    /**
     * Main driving method for program
     */
    public static void analyze () throws FileNotFoundException 
    {
        Scanner in = new Scanner("heights.txt");
        //print values
        System.out.println("Your average of numbers is : " + getAverage(in));
        System.out.println("Min height: " + getMin(in));
        System.out.println("Max height: " + getMax(in));
        System.out.println("Average height: " + getAverage(in));
        System.out.println("Standard deviation: " + getStandardDeviation());
    }

    /**
     * Finds and returns the lowest value in a file.
     * @param Scanner the file values.
     * @return the lowest value in the scanner.
     */
    public static int getMin(Scanner in)
    {
        int smallest = in.nextInt();
        while (in.hasNextInt()) {
            int numberSmall= in.nextInt();
            if (numberSmall < smallest) 
            {
                smallest = numberSmall;
            }
        }
        return smallest;
    }

    /**
     * Finds and returns the largest value in a file.
     * @param Scanner the file values.
     * @return the lowest value in the scanner.
     */
    public static int getMax(Scanner in)
    {
        int largest = in.nextInt();
        while (in.hasNextInt())
        {
            int numberLarge = in.nextInt();
            if (numberLarge > largest)
            {
                largest = numberLarge;
            }
        }
        return largest;
    }

    /**
     * Finds and returns the average of value in a file.
     * @param Scanner the file values.
     * @return the lowest value in the scanner.
     */
    public static int getAverage(Scanner in)
    {
        int size = 1;
        while (in.hasNextInt())
        { 
            int value = in.nextInt();
            size++;
        }
        int sum = getMax(in) + getMin(in);
        int average = sum / 2;
        return average;
    }

    /**
     * Finds and returns the standard deviation 
     * of values in a file.
     * @param Scanner the file values.
     * @return floating-point standard deviation of the 
     * values in the Scanner.
     */
    public static double getStandardDeviation(Scanner in, double average)
    {
        double size = 1;  
        double standardDeviation = 0;
        while (in.hasNextInt())
        { 
            int value = in.nextInt();
            size++;
        }
        standardDeviation = Math.sqrt((Math.pow((in) - getAverage(in))) / (size - 1));
        return standardDeviation;
    }
}

