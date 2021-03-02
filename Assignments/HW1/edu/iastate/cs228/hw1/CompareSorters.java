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
		// TODO - WIP
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

		Random randomNumberGenerator = new Random();

		// WIP - Use a try catch block for all methods that throw exceptions.
		Point[] inputPoints = generateRandomPoints(100, randomNumberGenerator);

		for( Point p : inputPoints)
		{
			System.out.println(p.toString());
		}

		PointScanner ps = new PointScanner(inputPoints,Algorithm.InsertionSort);

		ps.scan();

		System.out.println("------");
		System.out.println(ps.stats());

		System.out.println(ps.toString());

//		PointScanner[] scanners = new PointScanner[4];
//
//		Algorithm[] sortingTechniques = Algorithm.values();

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

//		for (int i = 0; i < scanners.length; i++)
//		{
//			scanners[i] = new PointScanner(inputPoints, sortingTechniques[i]);
//		}
//
//		for (PointScanner sortByScan : scanners)
//		{
//			sortByScan.scan();
//		}
//
//		// Display heading and other stuff as well like --------
//		for (PointScanner statsByScan : scanners)
//		{
//			System.out.println(statsByScan.stats());
//		}

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
		// TODO - WIP
		if(numPts < 1)
		{
			throw new IllegalArgumentException();
		}

		Point[] points = new Point[numPts];

		for(int i = 0; i < numPts; i++)
		{
			points[i] = new Point((rand.nextInt(101) - 50), (rand.nextInt(101) - 50));
		}

		return points;
	}
	
}
