package edu.iastate.cs228.hw2;

/**
 *
 * @author
 *
 */

import java.util.ListIterator;

public class PrimeFactorization implements Iterable<PrimeFactor>
{
	private static final long OVERFLOW = -1;
	private long value; 	// the factored integer
							// it is set to OVERFLOW when the number is greater than 2^63-1, the
						    // largest number representable by the type long.

	/**
	 * Reference to dummy node at the head.
	 */
	private Node head;

	/**
	 * Reference to dummy node at the tail.
	 */
	private Node tail;

	private int size;     	// number of distinct prime factors


    public void iterTester()
    {
        PrimeFactorizationIterator iter = iterator();

        iter.previous();
        iter.next();

        iter.add(new PrimeFactor(3,3));

        iter.add(new PrimeFactor(5,1));

        iter.previous();

        iter.add(new PrimeFactor(3,1));




    }

	// ------------
	// Constructors
	// ------------

    /**
	 *  Default constructor constructs an empty list to represent the number 1.
	 *
	 *  Combined with the add() method, it can be used to create a prime factorization.
	 */
	public PrimeFactorization()
	{
		// TODO - WIP

		value = 1;
		size = 0;
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.previous = head;
	}


	/**
	 * Obtains the prime factorization of n and creates a doubly linked list to store the result.
	 * Follows the direct search factorization algorithm in Section 1.2 of the project description.
	 *
	 * @param n
	 * @throws IllegalArgumentException if n < 1
	 */
	public PrimeFactorization(long n) throws IllegalArgumentException
	{
		// TODO - WIP

        if(n < 1)
        {
            throw new IllegalArgumentException("[ ERR: Cannot prime factorize n < 1 ]");
        }
        value = 1;
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;

        if(n > 1)
        {
            int divisor = 2;
            int multiplicity = 0;
            int previousMultiplicity = 0;

            while(divisor * divisor <= n)
            {
                if(n % divisor == 0)
                {
                    n = n / divisor;
                    multiplicity++;
                    previousMultiplicity = multiplicity;
                }
                else
                {
                    // if multiplicity > 0, then add new node with
                    // Prime number = divisor
                    // Multiplicity = multiplicity
                    if(multiplicity > 0)
                    {
//                  System.out.println("P["+divisor+"] M["+multiplicity+"]");
//                        System.out.print(divisor+"^"+multiplicity+" * ");
                        Node newNode = new Node(divisor, multiplicity);
                        newNode.next = tail;
                        newNode.previous = tail.previous;
                        tail.previous.next = newNode;
                        tail.previous = newNode;
                    }

                    // reset multiplicity
                    multiplicity = 0;

                    // increment divisor
                    if(divisor == 2)
                    {
                        divisor++;
                    }
                    else
                    {
                        divisor += 2;
                    }
                }
            }
            // add node with
            // Prime number = n
            // Multiplicity = 1 if n != prev divisor, else final multiplicity + 1

            if(multiplicity > 0 && n != divisor)
            {
//          System.out.println("P["+divisor+"] M["+multiplicity+"]");
//                System.out.print(divisor+"^"+multiplicity+" * ");
                Node newNode = new Node(divisor, multiplicity);
                newNode.next = tail;
                newNode.previous = tail.previous;
                tail.previous.next = newNode;
                tail.previous = newNode;
            }

            if(n != divisor)
            {
//          System.out.println("P["+n+"] M["+1+"]");
//                System.out.print(n+"^"+1+" * ");
                Node newNode = new Node(n, 1);
                newNode.next = tail;
                newNode.previous = tail.previous;
                tail.previous.next = newNode;
                tail.previous = newNode;
            }
            else
            {
//          System.out.println("P["+n+"] M["+(1+previousMultiplicity)+"]");
//                System.out.print(n+"^"+(1+previousMultiplicity)+" * ");
                Node newNode = new Node(n,1+previousMultiplicity);
                newNode.next = tail;
                newNode.previous = tail.previous;
                tail.previous.next = newNode;
                tail.previous = newNode;
            }
        }

	}


	/**
	 * Copy constructor. It is unnecessary to verify the primality of the numbers in the list.
	 *
	 * @param pf
	 */
	public PrimeFactorization(PrimeFactorization pf)
	{
        // TODO - Question: Should we do a deep copy of all nodes?
		// TODO
	}

	/**
	 * Constructs a factorization from an array of prime factors.  Useful when the number is
	 * too large to be represented even as a long integer.
	 *
	 * @param pfList
	 */
	public PrimeFactorization (PrimeFactor[] pfList)
	{
		// TODO
	}



	// --------------
	// Primality Test
	// --------------

    /**
	 * Test if a number is a prime or not.  Check iteratively from 2 to the largest
	 * integer not exceeding the square root of n to see if it divides n.
	 *
	 *@param n
	 *@return true if n is a prime
	 * 		  false otherwise
	 */
    public static boolean isPrime(long n)
	{
	    // TODO - Question: Why do we need this method?
	    // TODO - WIP

        boolean isPrimeNumber = true;

        if(n <= 1)
        {
            isPrimeNumber = false;
        }
        else if(n > 3)
        {
            if(n % 2 == 0 || n % 3 == 0)
            {
                isPrimeNumber = false;
            }
            else
            {
                for(int i = 5; i * i <= n; i += 6)
                {
                    if(n % i == 0 || n % (i + 2) == 0)
                    {
                        isPrimeNumber = false;
                    }
                }
            }
        }

		return isPrimeNumber;
	}


	// ---------------------------
	// Multiplication and Division
	// ---------------------------

	/**
	 * Multiplies the integer v represented by this object with another number n.  Note that v may
	 * be too large (in which case this.value == OVERFLOW). You can do this in one loop: Factor n and
	 * traverse the doubly linked list simultaneously. For details refer to Section 3.1 in the
	 * project description. Store the prime factorization of the product. Update value and size.
	 *
	 * @param n
	 * @throws IllegalArgumentException if n < 1
	 */
	public void multiply(long n) throws IllegalArgumentException
	{
		// TODO
	}

	/**
	 * Multiplies the represented integer v with another number in the factorization form.  Traverse both
	 * linked lists and store the result in this list object.  See Section 3.1 in the project description
	 * for details of algorithm.
	 *
	 * @param pf
	 */
	public void multiply(PrimeFactorization pf)
	{
		// TODO
	}


	/**
	 * Multiplies the integers represented by two PrimeFactorization objects.
	 *
	 * @param pf1
	 * @param pf2
	 * @return object of PrimeFactorization to represent the product
	 */
	public static PrimeFactorization multiply(PrimeFactorization pf1, PrimeFactorization pf2)
	{
		// TODO
		return null;
	}


	/**
	 * Divides the represented integer v by n.  Make updates to the list, value, size if divisible.
	 * No update otherwise. Refer to Section 3.2 in the project description for details.
	 *
	 * @param n
	 * @return  true if divisible
	 *          false if not divisible
	 * @throws IllegalArgumentException if n <= 0
	 */
	public boolean dividedBy(long n) throws IllegalArgumentException
	{
		// TODO
		return false;
	}


	/**
	 * Division where the divisor is represented in the factorization form.  Update the linked
	 * list of this object accordingly by removing those nodes housing prime factors that disappear
	 * after the division.  No update if this number is not divisible by pf. Algorithm details are
	 * given in Section 3.2.
	 *
	 * @param pf
	 * @return	true if divisible by pf
	 * 			false otherwise
	 */
	public boolean dividedBy(PrimeFactorization pf)
	{
		// TODO
		return false;
	}


	/**
	 * Divide the integer represented by the object pf1 by that represented by the object pf2.
	 * Return a new object representing the quotient if divisible. Do not make changes to pf1 and
	 * pf2. No update if the first number is not divisible by the second one.
	 *
	 * @param pf1
	 * @param pf2
	 * @return quotient as a new PrimeFactorization object if divisible
	 *         null otherwise
	 */
	public static PrimeFactorization dividedBy(PrimeFactorization pf1, PrimeFactorization pf2)
	{
		// TODO
		return null;
	}


	// -------------------------------------------------
	// Greatest Common Divisor and Least Common Multiple
	// -------------------------------------------------

	/**
	 * Computes the greatest common divisor (gcd) of the represented integer v and an input integer n.
	 * Returns the result as a PrimeFactor object.  Calls the method Euclidean() if
	 * this.value != OVERFLOW.
	 *
	 * It is more efficient to factorize the gcd than n, which can be much greater.
	 *
	 * @param n
	 * @return prime factorization of gcd
	 * @throws IllegalArgumentException if n < 1
	 */
	public PrimeFactorization gcd(long n) throws IllegalArgumentException
	{
		// TODO
		return null;
	}


	/**
	  * Implements the Euclidean algorithm to compute the gcd of two natural numbers m and n.
	  * The algorithm is described in Section 4.1 of the project description.
	  *
	  * @param m
	  * @param n
	  * @return gcd of m and n.
	  * @throws IllegalArgumentException if m < 1 or n < 1
	  */
 	public static long Euclidean(long m, long n) throws IllegalArgumentException
	{
 		// TODO
 		return 0;
	}


	/**
	 * Computes the gcd of the values represented by this object and pf by traversing the two lists.  No
	 * direct computation involving value and pf.value. Refer to Section 4.2 in the project description
	 * on how to proceed.
	 *
	 * @param  pf
	 * @return prime factorization of the gcd
	 */
	public PrimeFactorization gcd(PrimeFactorization pf)
	{
		// TODO
		return null;
	}


	/**
	 *
	 * @param pf1
	 * @param pf2
	 * @return prime factorization of the gcd of two numbers represented by pf1 and pf2
	 */
	public static PrimeFactorization gcd(PrimeFactorization pf1, PrimeFactorization pf2)
	{
		// TODO
		return null;
	}


	/**
	 * Computes the least common multiple (lcm) of the two integers represented by this object
	 * and pf.  The list-based algorithm is given in Section 4.3 in the project description.
	 *
	 * @param pf
	 * @return factored least common multiple
	 */
	public PrimeFactorization lcm(PrimeFactorization pf)
	{
		// TODO
		return null;
	}


	/**
	 * Computes the least common multiple of the represented integer v and an integer n. Construct a
	 * PrimeFactors object using n and then call the lcm() method above.  Calls the first lcm() method.
	 *
	 * @param n
	 * @return factored least common multiple
	 * @throws IllegalArgumentException if n < 1
	 */
	public PrimeFactorization lcm(long n) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	/**
	 * Computes the least common multiple of the integers represented by pf1 and pf2.
	 *
	 * @param pf1
	 * @param pf2
	 * @return prime factorization of the lcm of two numbers represented by pf1 and pf2
	 */
	public static PrimeFactorization lcm(PrimeFactorization pf1, PrimeFactorization pf2)
	{
		// TODO
		return null;
	}


	// ------------
	// List Methods
	// ------------

	/**
	 * Traverses the list to determine if p is a prime factor.
	 *
	 * Precondition: p is a prime.
	 *
	 * @param p
	 * @return true  if p is a prime factor of the number v represented by this linked list
	 *         false otherwise
	 * @throws IllegalArgumentException if p is not a prime
	 */
	public boolean containsPrimeFactor(int p) throws IllegalArgumentException
	{
		// TODO
        // TODO - Question: I don't think we need to check if p is prime, is there?
        
		return false;
	}

	// The next two methods ought to be private but are made public for testing purpose. Keep
	// them public

	/**
	 * Adds a prime factor p of multiplicity m.  Search for p in the linked list.  If p is found at
	 * a node N, add m to N.multiplicity.  Otherwise, create a new node to store p and m.
	 *
	 * Precondition: p is a prime.
	 *
	 * @param p  prime
	 * @param m  multiplicity
	 * @return   true  if m >= 1
	 *           false if m < 1
	 */
    public boolean add(int p, int m)
    {
    	// TODO
    	return false;
    }


    /**
     * Removes m from the multiplicity of a prime p on the linked list.  It starts by searching
     * for p.  Returns false if p is not found, and true if p is found. In the latter case, let
     * N be the node that stores p. If N.multiplicity > m, subtracts m from N.multiplicity.
     * If N.multiplicity <= m, removes the node N.
     *
     * Precondition: p is a prime.
     *
     * @param p
     * @param m
     * @return true  when p is found.
     *         false when p is not found.
     * @throws IllegalArgumentException if m < 1
     */
    public boolean remove(int p, int m) throws IllegalArgumentException
    {
    	// TODO
    	return false;
    }


    /**
     *
     * @return size of the list
     */
	public int size()
	{
		// TODO
		return 0;
	}


	/**
	 * Writes out the list as a factorization in the form of a product. Represents exponentiation
	 * by a caret.  For example, if the number is 5814, the returned string would be printed out
	 * as "2 * 3^2 * 17 * 19".
	 */
	@Override
	public String toString()
	{
		// TODO - WIP

        PrimeFactorizationIterator myIterator = iterator();
        boolean firstElement = true;
        StringBuilder primeFactorizationStringBuilder = new StringBuilder();
        final String starFormatter = " * ";

        while(myIterator.hasNext())
        {
            if(!firstElement)
            {
                primeFactorizationStringBuilder.append(starFormatter);
            }

            primeFactorizationStringBuilder.append(myIterator.next().toString());

            firstElement = false;
        }

		return primeFactorizationStringBuilder.toString();
	}


	// The next three methods are for testing, but you may use them as you like.

	/**
	 * @return true if this PrimeFactorization is representing a value that is too large to be within
	 *              long's range. e.g. 999^999. false otherwise.
	 */
	public boolean valueOverflow() {
		return value == OVERFLOW;
	}

	/**
	 * @return value represented by this PrimeFactorization, or -1 if valueOverflow()
	 */
	public long value() {
		return value;
	}


	public PrimeFactor[] toArray() {
		PrimeFactor[] arr = new PrimeFactor[size];
		int i = 0;
		for (PrimeFactor pf : this)
			arr[i++] = pf;
		return arr;
	}



	@Override
	public PrimeFactorizationIterator iterator()
	{
	    return new PrimeFactorizationIterator();
	}

	/**
	 * Doubly-linked node type for this class.
	 */
    private class Node
    {
		public PrimeFactor pFactor;			// prime factor
		public Node next;
		public Node previous;

		/**
		 * Default constructor for creating a dummy node.
		 */
		public Node()
		{
			// TODO - WIP

            pFactor = null;
            next = null;
            previous = null;
		}

		/**
		 * Precondition: p is a prime
		 *
		 * @param p	 prime number
		 * @param m  multiplicity
		 * @throws IllegalArgumentException if m < 1
		 */
		public Node(long p, long m) throws IllegalArgumentException
		{
			// TODO - WIP
            // TODO - Question: I don't think we need to check if p is prime, is there?

            // see exception handling, should automatically throw without catch?
//            try
//            {
//                pFactor = new PrimeFactor(p, m);
//            }
//            catch (IllegalArgumentException invalidMultiplicity)
//            {
//                throw invalidMultiplicity;
//            }
            pFactor = new PrimeFactor(p, m);
            next = null;
            previous = null;
		}


		/**
		 * Constructs a node over a provided PrimeFactor object.
		 *
		 * @param pf
		 * @throws IllegalArgumentException
		 */
		public Node(PrimeFactor pf)
		{
			// TODO - WIP
            // TODO - Question: Deep vs shallow? I think Deep

            pFactor = pf.clone();
            next = null;
            previous = null;
		}


		/**
		 * Printed out in the form: prime + "^" + multiplicity.  For instance "2^3".
		 * Also, deal with the case pFactor == null in which a string "dummy" is
		 * returned instead.
		 */
		@Override
		public String toString()
		{
			// TODO - WIP

            String nodeAsString;

            if(pFactor != null)
            {
                nodeAsString = pFactor.toString();
            }
            else
            {
                nodeAsString = "dummy";
            }

			return nodeAsString;
		}
    }


    private class PrimeFactorizationIterator implements ListIterator<PrimeFactor>
    {
        // Class invariants:
        // 1) logical cursor position is always between cursor.previous and cursor
        // 2) after a call to next(), cursor.previous refers to the node just returned
        // 3) after a call to previous() cursor refers to the node just returned
        // 4) index is always the logical index of node pointed to by cursor

        private Node cursor;
        private Node pending;    // node pending for removal
        // make sure its null when adding or removing to prevent remove after adds and remove
        private int index;

    	// other instance variables ...


        /**
    	 * Default constructor positions the cursor before the smallest prime factor.
    	 */
    	public PrimeFactorizationIterator()
    	{
    		// TODO - WIP

            cursor = head.next;
            pending = null;
            index = 0;
    	}

    	@Override
    	public boolean hasNext()
    	{
    		// TODO - WIP

    		return cursor.next != null; // or cursor != tail
    	}


    	@Override
    	public boolean hasPrevious()
    	{
    		// TODO - WIP

    		return cursor.previous.previous != null; // or cursor.previous != head
    	}


    	@Override
    	public PrimeFactor next()
    	{
    		// TODO - WIP

            // returns cursor prime number and advances cursor to curr cursor.next
            // don't let cursor be null
            // if value is null means we're at the end of the list, do we throw an exception??

            PrimeFactor value = cursor.pFactor;

            if(hasNext())
            {
                pending = cursor;
                cursor = cursor.next;
                index++;
            }

    		return value;
    	}


    	@Override
    	public PrimeFactor previous()
    	{
    		// TODO - WIP

            PrimeFactor value = cursor.previous.pFactor;

            if(hasPrevious())
            {
                pending = cursor.previous;
                cursor = cursor.previous;
                index--;
            }

    		return value;
    	}


    	/**
    	 *  Removes the prime factor returned by next() or previous()
    	 *
    	 *  @throws IllegalStateException if pending == null
    	 */
    	@Override
    	public void remove() throws IllegalStateException
    	{
    		// TODO - WIP

            if(pending != null)
            {
                // shift cursor to the right if pending == cursor
                if (pending == cursor)
                {
                    cursor = cursor.next;
                }
                // remove pending
                pending.previous.next = pending.next;
                pending.next.previous = pending.previous;

                pending = null;
            }
    	}


    	/**
    	 * Adds a prime factor at the cursor position.  The cursor is at a wrong position
    	 * in either of the two situations below:
    	 *
    	 *    a) pf.prime < cursor.previous.pFactor.prime if cursor.previous != head.
    	 *    b) pf.prime > cursor.pFactor.prime if cursor != tail.
    	 *
    	 * Take into account the possibility that pf.prime == cursor.pFactor.prime.
    	 *
    	 * Precondition: pf.prime is a prime.
    	 *
    	 * @param pf
    	 * @throws IllegalArgumentException if the cursor is at a wrong position.
    	 */
    	@Override
        public void add(PrimeFactor pf) throws IllegalArgumentException
        {
        	// TODO - WIP

            // won't advance cursor. next would still be same but prev will return newly added element
            // if add is successful, pending = null

            // cursor at wrong position, throw exception
            if((cursor.previous != head && pf.prime < cursor.previous.pFactor.prime)
            || (         cursor != tail && pf.prime > cursor.pFactor.prime         ))
            {
                throw new IllegalArgumentException("[ ERR: Cursor is at wrong position ]");
            }
            // empty list, add node; note: empty list doesn't mean cursor is at wrong position
            else if(cursor == tail && cursor.previous == head)
            {
                Node newNode = new Node(pf);
                newNode.next = tail;
                newNode.previous = head;
                tail.previous = newNode;
                head.next = newNode;
            }
            // cursor at tail, so compare with prev element
            else if(cursor == tail)
            {
                if(pf.prime == cursor.previous.pFactor.prime)
                {
                    cursor.previous.pFactor.multiplicity += pf.multiplicity;
                }
                else
                {
                    Node newNode = new Node(pf);
                    newNode.next = tail;
                    newNode.previous = tail.previous;
                    tail.previous.next = newNode;
                    tail.previous = newNode;
                }
            }
            // new prime == cursors prime, so just add multiplicities
            else if(pf.prime == cursor.pFactor.prime)
            {
                cursor.pFactor.multiplicity += pf.multiplicity;
            }
            // current prime has to be less than first prime if we reach here
            else if(cursor.previous == head)
            {
                Node newNode = new Node(pf);
                newNode.next = head.next;
                newNode.previous = head;
                head.next.previous = newNode;
                head.next = newNode;
            }
            // one element behind is == prime factor
            else if(cursor.previous.pFactor.prime == pf.prime)
            {
                cursor.previous.pFactor.multiplicity += pf.multiplicity;
            }
            // new prime doesn't exist so add new node
            else
            {
                Node newNode = new Node(pf);
                newNode.next = cursor;
                newNode.previous = cursor.previous;
                cursor.previous.next = newNode;
                cursor.previous = newNode;
            }

            pending = null;
            
        }


    	@Override
		public int nextIndex()
		{
			return index;
		}


    	@Override
		public int previousIndex()
		{
			return index - 1;
		}

		@Deprecated
		@Override
		public void set(PrimeFactor pf)
		{
			throw new UnsupportedOperationException(getClass().getSimpleName() + " does not support set method");
		}

    	// Other methods you may want to add or override that could possibly facilitate
    	// other operations, for instance, addition, access to the previous element, etc.
    	//
    	// ...
    	//
    }


    // --------------
    // Helper methods
    // --------------

    /**
     * Inserts toAdd into the list after current without updating size.
     *
     * Precondition: current != null, toAdd != null
     */
    private void link(Node current, Node toAdd)
    {
    	// TODO
    }


    /**
     * Removes toRemove from the list without updating size.
     */
    private void unlink(Node toRemove)
    {
    	// TODO
    }


    /**
	  * Remove all the nodes in the linked list except the two dummy nodes.
	  *
	  * Made public for testing purpose.  Ought to be private otherwise.
	  */
	public void clearList()
	{
		// TODO
	}

	/**
	 * Multiply the prime factors (with multiplicities) out to obtain the represented integer.
	 * Use Math.multiply(). If an exception is throw, assign OVERFLOW to the instance variable value.
	 * Otherwise, assign the multiplication result to the variable.
	 *
	 */
	private void updateValue()
	{
		try {
			// TODO
		}

		catch (ArithmeticException e)
		{
			value = OVERFLOW;
		}

	}
}
