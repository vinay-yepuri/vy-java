/**
 * 
 */
package com.vinay.algorithms;

/**
 * @author VINAY
 *
 */
public class IsArraySoreted {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {20,23,23,45,78,88};
		int n = arr.length;
		
		// Recursive function to find sorted array where time complexity is O(n) and space complexity is O(n)
		if(isArrayInSortedOrder(arr, n) != 0)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		// Iterative function to find sorted array where time complexity is O(n) and space complexity is O(1)
		if(isArraySorted(arr, n))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	
	/**
	 * Recursive method to check whether the array is in sorted order or not
	 * 
	 * @param a
	 * @param n
	 * @return
	 */
	private static int isArrayInSortedOrder(int a[], int n) {
		if(n == 1)
			return 1;
		return (a[n-1] < a[n-2] ? 0 : isArrayInSortedOrder(a, n-1));
	}
	
	private static boolean isArraySorted(int a[], int n) {
		if( n == 0 || n == 1)
			return true;
		for(int i = 1; i < n;i++)
			// unsorted pair found
			if(a[i-1] > a[i])
				return false;
		// No unsorted pair found
		return true;
	}
}
