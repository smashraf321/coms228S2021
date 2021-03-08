package edu.iastate.cs228.hw1;

/**
 * 
 * @author 
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * This class sorts all the points in an array of 2D points to determine a reference point whose x and y 
 * coordinates are respectively the medians of the x and y coordinates of the original points. 
 * 
 * It records the employed sorting algorithm as well as the sorting time for comparison. 
 *
 */
public class PointScanner  
{
	private Point[] points; 
	
	private Point medianCoordinatePoint;  // point whose x and y coordinates are respectively the medians of 
	                                      // the x coordinates and y coordinates of those points in the array points[].
	private Algorithm sortingAlgorithm;
		
	protected long scanTime; 	       // execution time in nanoseconds. 

    private boolean successfulSort;
	/**
	 * This constructor accepts an array of points and one of the four sorting algorithms as input. Copy 
	 * the points into the array points[].
	 * 
	 * @param  pts  input array of points 
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException
	{
		if (pts == null || pts.length == 0)
		{
			throw new IllegalArgumentException("[ ERR: Your list of input points is empty ]");
		}

        this.points = pts;

        this.sortingAlgorithm = algo;

        successfulSort = false;
	}

	
	/**
	 * This constructor reads points from a file. 
	 * 
	 * @param  inputFileName
	 * @throws FileNotFoundException 
	 * @throws InputMismatchException   if the input file contains an odd number of integers
	 */
	protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException
	{
        File inputFile = new File(inputFileName);
        Scanner inputFileReader = new Scanner(inputFile);

        try
        {
            successfulSort = false;
            boolean evenNumberOfInputs = true;
            int x,y;
            x = y = 0;
            ArrayList<Point> inputPoints = new ArrayList<>();

            while(inputFileReader.hasNext())
            {
                if(inputFileReader.hasNextInt())
                {
                    if(evenNumberOfInputs)
                    {
                        x = inputFileReader.nextInt();
                    }
                    else
                    {
                        y = inputFileReader.nextInt();

                        // Create new point as we now have both x and y coordinate pair
                        Point p = new Point(x,y);
                        // Add it to our ArrayList
                        inputPoints.add(p);
                    }

                    // Toggle the even number inputs tracker flag
                    // Even number is every other number

                    evenNumberOfInputs ^= true;

                }
                else
                {
                    inputFileReader.next();
                }
            }

            if(!evenNumberOfInputs)
            {
                throw new InputMismatchException("[ ERR: There are odd number of integers in the input file ]");
            }

            points = inputPoints.toArray(new Point[0]);

            this.sortingAlgorithm = algo;
        }
        finally
        {
            inputFileReader.close();
        }
	}
	
	/**
	 * Carry out two rounds of sorting using the algorithm designated by sortingAlgorithm as follows:  
	 *    
	 *     a) Sort points[] by the x-coordinate to get the median x-coordinate. 
	 *     b) Sort points[] again by the y-coordinate to get the median y-coordinate.
	 *     c) Construct medianCoordinatePoint using the obtained median x- and y-coordinates.     
	 *  
	 * Based on the value of sortingAlgorithm, create an object of SelectionSorter, InsertionSorter, MergeSorter,
	 * or QuickSorter to carry out sorting.       
	 *
	 */
	public void scan()
	{
		try
		{
            scanTime = 0;
            long timeBeforeSorting = 0;
            final int sortByX = 0;
            final int sortByY = 1;
            AbstractSorter aSorter;

            // create an object to be referenced by aSorter according to sortingAlgorithm. for each of the two
            // rounds of sorting, have aSorter do the following:
            //
            //     a) call setComparator() with an argument 0 or 1.
            //
            //     b) call sort().
            //
            //     c) use a new Point object to store the coordinates of the Median Coordinate Point
            //
            //     d) set the medianCoordinatePoint reference to the object with the correct coordinates.
            //
            //     e) sum up the times spent on the two sorting rounds and set the instance variable scanTime.

            switch(sortingAlgorithm)
            {
                case SelectionSort:
                    aSorter = new SelectionSorter(points);
                    break;
                case InsertionSort:
                    aSorter = new InsertionSorter(points);
                    break;
                case MergeSort:
                    aSorter = new MergeSorter(points);
                    break;
                case QuickSort:
                    aSorter = new QuickSorter(points);
                    break;
                default:
                    System.err.println("[ ERR: Unsupported sorting technique ]");
                    return;
            }

            aSorter.setComparator(sortByX);

            timeBeforeSorting = System.nanoTime();
            aSorter.sort();
            scanTime = System.nanoTime() - timeBeforeSorting;

            int medianX = aSorter.getMedian().getX();

            aSorter.setComparator(sortByY);

            timeBeforeSorting = System.nanoTime();
            aSorter.sort();
            scanTime += System.nanoTime() - timeBeforeSorting;

            int medianY = aSorter.getMedian().getY();

            medianCoordinatePoint = new Point(medianX, medianY);

            successfulSort = true;
        }
        catch(IllegalArgumentException invalidValues)
        {
            System.err.println(invalidValues.getMessage());
            successfulSort = false;
        }
	}
	
	
	/**
	 * Outputs performance statistics in the format: 
	 * 
	 * <sorting algorithm> <size>  <time>
	 * 
	 * For instance, 
	 * 
	 * selection sort   1000	  9200867
	 * 
	 * Use the spacing in the sample run in Section 2 of the project description. 
	 */
	public String stats()
	{
	    if(successfulSort)
        {
            String algorithm;

            switch(sortingAlgorithm)
            {
                case SelectionSort:
                    algorithm = "SelectionSort";
                    break;
                case InsertionSort:
                    algorithm = "InsertionSort";
                    break;
                case MergeSort:
                    algorithm = "MergeSort";
                    break;
                case QuickSort:
                    algorithm = "QuickSort";
                    break;
                default:
                    System.err.println("[ ERR: Unsupported sorting technique ]");
                    return null;
            }
            return String.format("%-18s%-7d%-25d",algorithm,points.length,scanTime);
        }
        else
        {
            return "";
        }
	}

	/**
	 * Write MCP after a call to scan(),  in the format "MCP: (x, y)"   The x and y coordinates of the point are displayed on the same line with exactly one blank space 
	 * in between. 
	 */
	@Override
	public String toString()
	{
		return "MCP: " + medianCoordinatePoint.toString();
	}

	/**
	 *  
	 * This method, called after scanning, writes point data into a file by outputFileName. The format 
	 * of data in the file is the same as printed out from toString().  The file can help you verify 
	 * the full correctness of a sorting result and debug the underlying algorithm. 
	 * 
	 * @throws FileNotFoundException
	 */
	public void writeMCPToFile() throws IOException
	{
        FileWriter outputFile = new FileWriter("outputFileName.txt");

        try
        {
            outputFile.write(toString());
        }
        finally
        {
            outputFile.close();
        }
	}
}
