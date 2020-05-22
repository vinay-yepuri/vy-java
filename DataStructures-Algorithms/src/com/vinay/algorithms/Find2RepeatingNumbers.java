/**
 * 
 */
package com.vinay.algorithms;

import java.util.Arrays;

/**
 * @author VINAY
 *
 */
public class Find2RepeatingNumbers {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {4,2,4,5,2,3,1,4};
		
		findTwoRepeatingNumsUsingHashTable(A);
		
		findTwoRepeatingNumbersUsingSorting(A);
	}

	/**
	 * @param a
	 * 
	 * Time Complexity = O(nlogn) space complexity = O(1)
	 */
	private static void findTwoRepeatingNumbersUsingSorting(int[] a) {
		
		Arrays.sort(a);
		
		for(int i = 0;i < a.length-1; i++) {
			
			if(a[i] == a[i+1])
				System.out.println("Repeating elements are : "+a[i]);
		}
	}

	/**
	 * @param a
	 * 
	 * Time Complexity = O(n), Space Complexity = O(n)
	 */
	private static void findTwoRepeatingNumsUsingHashTable(int[] A) {
	
		int[] tempArr = new int[A.length-1];
		
		for(int i = 0; i < A.length; i++)
		{
			tempArr[A[i]]++;
			if(tempArr[A[i]] == 2)
				System.out.println(" Repeating elements are : "+A[i]);
		}
		
	}

}
