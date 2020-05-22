/**
 * 
 */
package com.vinay.algorithms;

/**
 * @author VINAY
 *
 */
public class NumOccurOddTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,2,3,2,3,1,3,2,1,1,2};
		
		System.out.println(" Number which occured odd number of times is "+findOddOccuranceNumber(A));

	}

	/**
	 * @param a
	 * @return
	 * 
	 * Time Complexity = O(n), Space complexity = O(1)
	 * 
	 */
	private static int findOddOccuranceNumber(int[] a) {
		int oddOccurNum = 0;
		
		for(int i = 0; i < a.length; i++) {
			
			oddOccurNum ^= a[i];
		}
		return oddOccurNum;
	}

}
