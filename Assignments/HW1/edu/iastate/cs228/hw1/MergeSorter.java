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
 * This class implements the mergesort algorithm.   
 *
 */

public class MergeSorter extends AbstractSorter
{
	// Other private instance variables if you need ... 
	
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts   input array of integers
	 */
	public MergeSorter(Point[] pts) 
	{
		super(pts);
		super.algorithm = "MergeSort";
	}


	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter. 
	 * 
	 */
	@Override 
	public void sort()
	{
        mergeSortRec(points);
	}

	
	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One 
	 * way is to make copies of the two halves of pts[], recursively call mergeSort on them, 
	 * and merge the two sorted subarrays into pts[].   
	 * 
	 * @param pts	point array 
	 */
	private void mergeSortRec(Point[] pts)
	{
	    if(pts.length > 1)
        {
            Point[] p1 = new Point[pts.length / 2];
            Point[] p2 = new Point[pts.length - (pts.length / 2)];

            for(int i = 0; i < pts.length; i++)
            {
                if(i < pts.length / 2)
                {
                    p1[i] = pts[i];
                }
                else
                {
                    p2[i - pts.length / 2] = pts[i];
                }
            }

            mergeSortRec(p1);
            mergeSortRec(p2);

            merge(pts, p1, p2);
        }
	}

	// Other private methods in case you need ...

    private void merge(Point[] pts, Point[] p1, Point[] p2)
    {
        int indexp1, indexp2;
        indexp1 = indexp2 = 0;

        while((indexp1 + indexp2) < pts.length)
        {
            if(indexp1 < p1.length && indexp2 < p2.length)
            {
                if(pointComparator.compare(p1[indexp1], p2[indexp2]) < 0)
                {
                    pts[indexp1 + indexp2] = p1[indexp1];
                    indexp1++;
                }
                else
                {
                    pts[indexp1 + indexp2] = p2[indexp2];
                    indexp2++;
                }
            }
            else if(indexp1 < p1.length)
            {
                pts[indexp1 + indexp2] = p1[indexp1];
                indexp1++;
            }
            else if(indexp2 < p2.length)
            {
                pts[indexp1 + indexp2] = p2[indexp2];
                indexp2++;
            }
        }
    }
}
