package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

/**
 *  
 * @author
 *
 */

/**
 * 
 * This class implements the version of the quicksort algorithm presented in the lecture.   
 *
 */

public class QuickSorter extends AbstractSorter
{
	// Other private instance variables if you need ... 
		
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *   
	 * @param pts   input array of integers
	 */
	public QuickSorter(Point[] pts)
	{
		// TODO - WIP

		super(pts);
		super.algorithm = "QuickSort";
	}
		

	/**
	 * Carry out quicksort on the array points[] of the AbstractSorter class.  
	 * 
	 */
	@Override 
	public void sort()
	{
		// TODO - WIP

        int firstIndex = 0;
        int  lastIndex = points.length - 1;
        quickSortRec(firstIndex, lastIndex);
	}
	
	
	/**
	 * Operates on the subarray of points[] with indices between first and last. 
	 * 
	 * @param first  starting index of the subarray
	 * @param last   ending index of the subarray
	 */
	private void quickSortRec(int first, int last)
	{
		// TODO - WIP

        if(first < last)
        {
            int correctPivotPosition = partition(first, last);

            quickSortRec(first, correctPivotPosition - 1);
            quickSortRec(correctPivotPosition + 1, last);
        }
	}
	
	
	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	private int partition(int first, int last)
	{
		// TODO - WIP

        int desiredPivotPositionTracker = first - 1;

        for(int i = first; i < last; i++)
        {
            // Assume last index element is the pivot -> points[last]
            if(pointComparator.compare(points[i], points[last]) < 0)
            {
                desiredPivotPositionTracker++;
                swap(desiredPivotPositionTracker,i);
            }
        }

        // Place the pivot element in its rightful place
        swap(++desiredPivotPositionTracker, last);

		return desiredPivotPositionTracker;
	}	

	// Other private methods in case you need ...
}
