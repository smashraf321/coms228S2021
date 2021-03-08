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
 * This class implements insertion sort.   
 *
 */

public class InsertionSorter extends AbstractSorter 
{
	// Other private instance variables if you need ... 
	
	/**
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 * 
	 * @param pts  
	 */
	public InsertionSorter(Point[] pts) 
	{
		super(pts);
		super.algorithm = "InsertionSort";
	}	

	/** 
	 * Perform insertion sort on the array points[] of the parent class AbstractSorter.  
	 */
	@Override 
	public void sort()
	{
        for (int i = 1; i < points.length; i++)
        {
            Point pointBeingChecked = points[i];
            int j;
            for(j = i - 1; j >= 0 && pointComparator.compare(pointBeingChecked,points[j]) < 0; j--)
            {
                points[j+1] = points[j];
            }
            points[j+1] = pointBeingChecked;
        }

//		System.out.println("------");
//		for( Point p : points)
//		{
//			System.out.println(p.toString());
//		}
	}		
}
