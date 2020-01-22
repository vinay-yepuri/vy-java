/**
 * 
 */
package com.vinay.algorithms.sorting;

import java.util.Arrays;

/**
 * @author VINAY
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = {2,7,4,1,5,3};
		System.out.println(Arrays.toString(array));
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	/**
	 * @param A
	 */
	private static void mergeSort(int[] A) {
		
		int n = A.length;
		
		if( n < 2)
			return;
		
		int mid = n/2;
		
		// Left & right arrays
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		
		// Fill left array from 0 to mid from A
		for(int i = 0; i < mid; i++) 
			left[i] = A[i];
		
		// Copy Right array from mid to length of A
		for(int j = mid; j < n; j++)
			right[j-mid] = A[j];
		
		mergeSort(left);
		mergeSort(right);
		merge(left,right,A);
	}

	/**
	 * @param left
	 * @param right
	 * @param A
	 */
	private static void merge(int[] left, int[] right, int[] A) {
		
		int nL = left.length;
		int nR = right.length;
		
		int i = 0 ,j = 0, k = 0;

		// compare left right arrays starting from 0th index,
		// whichever is small copy that to final array and increment the pointers accordingly.
		while ( i < nL && j < nR) {
			if( left[i] <= right[j]) {
				A[k] = left[i];
				i++;
			}
			else {
				A[k] = right[j];
				j++;
			}
			k++;
		}
		
		while ( i < nL) {
			A[k] = left[i];
			k++;
			i++;
		}
		
		while( j < nR) {
			A[k] = right[j];
			k++;
			j++;
		}
	}
}
