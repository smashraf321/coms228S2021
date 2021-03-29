package edu.iastate.cs228.hw2;

/**
 *
 * @author
 *
 */

public class PrimeFactor
{
	public long prime; 		 // prime factor
	public long multiplicity; // number of times the prime factor appears in a factorization

	/**
	 * Precondition: p is a prime number.
	 *
	 * @param p	 prime
	 * @param m  multiplicity
	 * @throws IllegalArgumentException if m < 1
	 */
	public PrimeFactor(long p, long m) throws IllegalArgumentException
	{
		// TODO - WIP
        if(m < 1)
        {
            throw new IllegalArgumentException("[ ERR: Multiplicity is less than 1 ]");
        }

        // TODO - Question: I don't think we need to check if p is prime, is there?
//		if(PrimeFactorization.isPrime(p))
		prime = p;
		multiplicity = m;
	}

	@Override
	public PrimeFactor clone()
	{
		return new PrimeFactor(prime, multiplicity);
	}

	/**
	 * Prints out, for instance "2^3" if prime == 2 and multiplicity == 3, or "5" if
	 * prime == 5 and multiplicity == 1.
	 */
	@Override
	public String toString()
	{
		// TODO - WIP

        String primeAsString = String.valueOf(prime);
        String multiplicityAsString = (multiplicity > 1 ? "^" + multiplicity : "");

		return primeAsString + multiplicityAsString;
	}
}
