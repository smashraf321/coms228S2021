package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

import java.util.Comparator;
import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

/**
 * 
 * This abstract class is extended by SelectionSort, InsertionSort, MergeSort, and QuickSort.
 * It stores the input (later the sorted) sequence. 
 *
 */
public abstract class AbstractSorter
{
	
	protected Point[] points;    // array of points operated on by a sorting algorithm. 
	                             // stores ordered points after a call to sort(). 
	
	protected String algorithm = null; // "selection sort", "insertion sort", "mergesort", or
	                                   // "quicksort". Initialized by a subclass constructor.
	// QUE What's the use of the String algorithm?
		 
	protected Comparator<Point> pointComparator = null;  
	
	
	// Add other protected or private instance variables you may need. 
	

	protected AbstractSorter()
	{
		// No implementation needed. Provides a default super constructor to subclasses. 
		// Removable after implementing SelectionSorter, InsertionSorter, MergeSorter, and QuickSorter.
	}
	
	
	/**
	 * This constructor accepts an array of points as input. Copy the points into the array points[]. 
	 * 
	 * @param  pts  input array of points 
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	protected AbstractSorter(Point[] pts) throws IllegalArgumentException
	{
		// TODO - WIP

		if (pts == null || pts.length == 0)
		{
			throw new IllegalArgumentException("pts are empty");
		}

		// QUE Is copying a reference good enough or should we perform a deep copy??
		this.points = pts;// for testing

//		this.points = new Point[pts.length];
//		for(int i = 0; i < pts.length; i++)
//		{
//			this.points[i] = pts[i];
//		}

	}
	

	/**
	 * Generates a comparator on the fly that compares by x-coordinate if order == 0, by y-coordinate
	 * if order == 1. Assign the 
     * comparator to the variable pointComparator. 
     * 
	 * 
	 * Need to create an object of the PolarAngleComparator class and call the compareTo() method in the 
	 * Point class.                   (QUE what is this PolarAngleComparator??)
	 * 
	 * @param order  0   by x-coordinate 
	 * 				 1   by y-coordinate
	 * 			    
	 * 
	 * @throws IllegalArgumentException if order is less than 0 or greater than 1
	 *        
	 */
	public void setComparator(int order) throws IllegalArgumentException
	{
		// TODO - WIP

		if(order < 0 || order > 1)
		{
			throw new IllegalArgumentException("order invalid");
		}


        // this works as well
//        if(order == 0)
//        {
//            Point.setXorY(true);
//            // QUE we could even do Point.xORy = true; Why this method then?
//        }
//        else
//        {
//            Point.setXorY(false);
//        }

		// QUE Why have a comparator, can't we directly use p1.compareTo(p2) in sort()???
		pointComparator = new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if(order == 0)
				{
					Point.setXorY(true);
					// QUE we could even do Point.xORy = true; Why this method then?
				}
				else
				{
					Point.setXorY(false);
				}
				return p1.compareTo(p2);
			}
		};

		// QUE Using Lambdas for Java 1.8 onwards, is it okay??
//		pointComparator = (Point p1, Point p2) ->
//		{
//			if(order == 0)
//			{
//				Point.setXorY(true);
//				// QUE we could even do Point.xORy = true; Why this method then?
//			}
//			else
//			{
//				Point.setXorY(false);
//			}
//			return p1.compareTo(p2);
//		};
	}


	/**
	 * Use the created pointComparator to conduct sorting.  
	 * 
	 * Ought to be protected. Made public for testing. 
	 */
	public abstract void sort(); 
	
	
	/**
	 * Obtain the point in the array points[] that has median index 
	 * 
	 * @return	median point 
	 */
	public Point getMedian()
	{
		return points[points.length/2]; 
	}
	// QUE Makes sense for odd input set,
    // what about even?
    // Let's say array has 1, 2, 3, 4
    // length is 4 and max index is 3
    // is the median 2 (at index 1 (since maxindex 3 / 2 = 1))
    // or 3 (at index 2 (since length 4 / 2 = 2))?
    // The current logic returns 3 as its's not directly based on max index
	
	/**
	 * Copies the array points[] onto the array pts[].
	 * 
	 * @param pts
	 */
	public void getPoints(Point[] pts)
	{
		// TODO - WIP

		// QUE Is copying a reference good enough or should we perform a deep copy??
//		pts = this.points;

		pts = new Point[this.points.length];
		for(int i = 0; i < points.length; i++)
		{
			pts[i] = this.points[i];
		}

	}
	

	/**
	 * Swaps the two elements indexed at i and j respectively in the array points[]. 
	 * 
	 * @param i
	 * @param j
	 */
	protected void swap(int i, int j)
	{
		// TODO - WIP

		Point temp = points[i];
		points[i] = points[j];
		points[j] = temp;
	}	
}
