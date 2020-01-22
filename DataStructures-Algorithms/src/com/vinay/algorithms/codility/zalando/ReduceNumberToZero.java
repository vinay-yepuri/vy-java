/**
 * 
 */
package com.vinay.algorithms.codility.zalando;

/**
 * @author VINAY
 * 
 * Reduce the given number to 0 by performing below operations
 * 
 * if even divide by 2
 * if odd subtract 1
 *
 */
public class ReduceNumberToZero {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String s ="0011100";
		System.out.println(steps(s));
	}
	
	/**
	 * @param a
	 * @return
	 * 
	 * Convert the binary string into a number and reduce the number to zero by performaing below steps
	 * 
	 * if even divide by 2
	 * if odd subtract 1
	 */
	private static int steps(String a)
	{
		int steps = 0;
		
		// convert binary string to int
		int n = Integer.parseInt(a, 2);
		
		while ( n > 0)
		{
			if(n%2 == 0) 
				n = n/2;
			else 
				n = n-1;
			steps++;
		}
		return steps;
	}
}
