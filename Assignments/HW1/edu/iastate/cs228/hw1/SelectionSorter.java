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
 * This class implements selection sort.   
 *
 */

public class SelectionSorter extends AbstractSorter
{
    // Other private instance variables if you need ...

    /**
     * Constructor takes an array of points.  It invokes the superclass constructor, and also
     * set the instance variables algorithm in the superclass.
     *
     * @param pts
     */
    public SelectionSorter(Point[] pts)
    {
        // TODO - WIP

        super(pts);
        super.algorithm = "SelectionSort";
    }

    /**
     * Apply selection sort on the array points[] of the parent class AbstractSorter.
     *
     */
    @Override
    public void sort()
    {
        // TODO - WIP

        // In each iteration

        for(int i = 0; i < points.length - 1; i++)
        {
            int minPointIndex = i;

            for(int j = i + 1; j < points.length; j++)
            {
                if(pointComparator.compare(points[j],points[minPointIndex]) < 0)
                {
                     minPointIndex = j;
                }
            }

            swap(i, minPointIndex);
        }
    }
}
