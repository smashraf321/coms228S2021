package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the 
 * execution times of these algorithms on the same input. 
 *
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random; 


public class CompareSorters 
{
	/**
	 * Repeatedly take integer sequences either randomly generated or read from files. 
	 * Use them as coordinates to construct points.  Scan these points with respect to their 
	 * median coordinate point four times, each time using a different sorting algorithm.  
	 * 
	 * @param args
	 **/
	public static void main(String[] args) throws FileNotFoundException
	{
		// 
		// Conducts multiple rounds of comparison of four sorting algorithms.  Within each round, 
		// set up scanning as follows: 
		// 
		//    a) If asked to scan random points, calls generateRandomPoints() to initialize an array 
		//       of random points. 
		// 
		//    b) Reassigns to the array scanners[] (declared below) the references to four new 
		//       PointScanner objects, which are created using four different values  
		//       of the Algorithm type:  SelectionSort, InsertionSort, MergeSort and QuickSort. 
		// 
		//

        int trialNumber = 0;
        int userEnteredKey = 0;
//        boolean exceptionCaught = false;
        Scanner userInput = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("Performances of Four Sorting Algorithms in Point Scanning");
        System.out.println("---------------------------------------------------------\n");
        System.out.println("Please select how you'd like to obtain input points for\n"
                         + "sorting or if you want to exit the program from the\n"
                         + "following keys:\n");

        while(userEnteredKey != 3)
        {
//            if(!exceptionCaught)
            {
                userEnteredKey = 0;
                System.out.println("Keys: 1 (random integers) 2 (file input) 3 (exit)");
                System.out.println("Trial "+(++trialNumber)+":");
            }
            try
            {
                boolean firstTimeInValidityCheckingOuterLoop = true;

                while(userEnteredKey != 1 && userEnteredKey != 2 && userEnteredKey != 3)
                {
                    while(!firstTimeInValidityCheckingOuterLoop || !userInput.hasNextInt())
                    {
                        System.err.println("[ ERR: Please enter a valid key! ]");
                        userInput.nextLine();
                        firstTimeInValidityCheckingOuterLoop = true;
                    }

                    userEnteredKey = userInput.nextInt();
                    firstTimeInValidityCheckingOuterLoop = false;
                }

                PointScanner[] scanners = new PointScanner[4];

                Algorithm[] sortingTechniques = Algorithm.values();

                // For each input of points, do the following.
                //
                //     a) Initialize the array scanners[].
                //
                //     b) Iterate through the array scanners[], and have every scanner call the scan()
                //        method in the PointScanner class.
                //
                //     c) After all four scans are done for the input, print out the statistics table from
                //		  section 2.
                //
                // A sample scenario is given in Section 2 of the project description.

                if(userEnteredKey == 1)
                {
                    Random randomNumberGenerator = new Random();
                    System.out.println("Please enter the number of random points:");

                    userInput.nextLine();
                    while(!userInput.hasNextInt())
                    {
                        System.err.println("[ ERR: Please enter a valid integer ]");
                        userInput.nextLine();
                    }

                    Point[] inputPoints = generateRandomPoints(userInput.nextInt(), randomNumberGenerator);

                    for (int i = 0; i < scanners.length; i++)
                    {
                        scanners[i] = new PointScanner(inputPoints, sortingTechniques[i]);
                    }
                }
                else if(userEnteredKey == 2)
                {
                    System.out.println("Please enter a file name from which you'd like to read a list of points:");
                    String inputFileName = userInput.next();

                    for (int i = 0; i < scanners.length; i++)
                    {
                        scanners[i] = new PointScanner(inputFileName, sortingTechniques[i]);
                    }
                }

                if(userEnteredKey != 3)
                {
                    for (PointScanner sortByScan : scanners)
                    {
                        sortByScan.scan();
                    }

                    if(!scanners[0].stats().equals(""))
                    {
                        System.out.println("---------------------------------------------------------");
                        System.out.printf("%-18s%-7s%-25s\n","algorithm","size","time (ns)");
                        System.out.println("---------------------------------------------------------");
                    }

                    for (PointScanner statsByScan : scanners)
                    {
                        System.out.println(statsByScan.stats());
                    }

                    if(!scanners[0].stats().equals(""))
                    {
                        System.out.println("---------------------------------------------------------\n\n");
//                        exceptionCaught = false;
                    }
//                    else
//                    {
//                        exceptionCaught = true;
//                    }
                }
            }
            catch(FileNotFoundException noFileException)
            {
                System.err.println("[ ERR: " + noFileException.getMessage() + "]");
                System.err.println("[ ERR: FYI, your application running directory is:  [" + System.getProperty("user.dir") + "] ]");
                System.err.println("[ ERR: Please ensure your input file is present there or provide an absolute path. ]");
//                exceptionCaught = true;
            }
            catch(InputMismatchException | IllegalArgumentException exception)
            {
                System.err.println(exception.getMessage());
//                exceptionCaught = true;
            }
        }
        userInput.close();
    }
	
	
	/**
	 * This method generates a given number of random points.
	 * The coordinates of these points are pseudo-random numbers within the range 
	 * [-50,50] X [-50,50]. Please refer to Section 3 on how such points can be generated.
	 * 
	 * Ought to be private. Made public for testing. 
	 * 
	 * @param numPts  	number of points
	 * @param rand      Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException if numPts < 1
	 */
	public static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException
	{
		if(numPts < 1)
		{
			throw new IllegalArgumentException("[ ERR: Please enter a valid number of points that is greater than 1 ]");
		}

		Point[] points = new Point[numPts];

		for(int i = 0; i < numPts; i++)
		{
			points[i] = new Point((rand.nextInt(101) - 50), (rand.nextInt(101) - 50));
		}

		return points;
	}
}
