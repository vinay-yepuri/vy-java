/**
 * 
 */
package com.vinay.algorithms.sorting;

import java.util.Arrays;

/**
 * @author VINAY
 *
 */
public class CountingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = {2,7,4,1,5,3};
		System.out.println(Arrays.toString(array));
		countingSort(array);
		System.out.println(Arrays.toString(array));

	}
	/**
	 * @param A
	 */
	private static void countingSort(int[] A) {
		
		// find the max element in the given array
		int max = 0;
		
		for(int i = 0; i < A.length; i++)
			max = Math.max(max, A[i]);
		
		// Create an auxuliary Array
		int[] aux = new int[max+1];
		
		for( int i =0; i <= max; i++)
			aux[i] = 0;
		
		//  store the count of each element in A[] as  by mapping it value as index.
		for(int i =0; i < A.length; i++) {
			aux[A[i]]++;
		}
		
		System.out.println(Arrays.toString(aux));
		
		int[] sortedArray = new int[A.length];
		
		int j = 0;
		for(int i = 0; i <= max; i++) {
			
			int tmp = aux[i];
			
			while ( tmp > 0 ) {
				
				sortedArray[j] = i;
				j++;
				tmp--;
			}
		}
		System.out.println(Arrays.toString(sortedArray));
	}
}
