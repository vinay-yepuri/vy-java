/**
 * 
 */
package com.vinay.algorithms;

import java.util.Arrays;

/**
 * @author VINAY
 *
 */
public class MissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] A = {1,2,4,6,3,7,8};
		
		System.out.println("Missing num = "+findMissingNumber(A));

		System.out.println("Missing Num = "+findMissingNumberUsingSorting(A));
		
		// imagine from 1 to n numbers, n-1 nnumbers are repeared 3 times and one number repeated 2 times.
		// find the number which is repeated 2 times.
		
		int[] A1 = {1,2,4,6,3,7,8,5,1,1,2,2,3,3,4,4,5,5,6,7,7,8,8};
		System.out.println("Missing num = "+findMissingNumber(A1,8));
	}
	
	/**
	 * @param a
	 * @return
	 * 
	 * 
	 * Time Complexity = O(nlogn) space complexity = O(1)
	 */
	private static int findMissingNumberUsingSorting(int[] a) {
		int missingNum = 0;
		
		Arrays.sort(a);
		
		int n = a.length;
		
		for(int i = 0; i < n-1; i++)
		{
			if( (a[i+1] - a[i]) != 1)
				missingNum = a[i]+1;
		}
		
		return missingNum;
	}

	/**
	 * @param A
	 * @return
	 * 
	 * Time Complexity = O(n), Space complexity = O(1)
	 */
	private static int findMissingNumber(int[] A)
	{
		int missingNumber = 0;
		int X = 0, Y=0;
		for(int i =0; i < A.length; i++)
		{
			X^=A[i];
		}
		for(int i =1; i <= 8; i++)
		{
			Y^=i;
		}
		
		System.out.println(" X = "+X +" Binary value = "+Integer.toBinaryString(X));
		System.out.println(" Y = "+Y +" Binary Value = "+Integer.toBinaryString(Y));
		missingNumber = X ^ Y;
		
		return missingNumber;
	}
	
	/**
	 * @param A
	 * @return
	 * 
	 * Time Complexity = O(n), Space complexity = O(1)
	 */
	private static int findMissingNumber(int[] A, int n)
	{
		int missingNumber = 0;
		int X = 0, Y=0;
		for(int i =0; i < A.length; i++)
		{
			X^=A[i];
		}
		for(int i =1; i <= n; i++)
		{
			Y^=i;
		}
		
		System.out.println(" X = "+X +" Binary value = "+Integer.toBinaryString(X));
		System.out.println(" Y = "+Y +" Binary Value = "+Integer.toBinaryString(Y));
		missingNumber = X ^ Y;
		
		return missingNumber;
	}

}
