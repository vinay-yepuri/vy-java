/**
 * 
 */
package com.vinay.algorithms.sorting;

import java.util.Arrays;

/**
 * @author VINAY
 *
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = {2,7,4,1,5,3};
		System.out.println(Arrays.toString(array));
		selectionSort(array);
		System.out.println(Arrays.toString(array));

	}
	
	/**
	 * 
	 * Find the min element in the array and move it to 0th index, 
	 * again find next min and move that to 1st position and so on till we reach end of the array
	 * 
	 * @param array
	 */
	private static void selectionSort(int[] array) {
		
		int min,tmp, n = array.length;
		
		for(int i = 0; i < n-1; i++) {
			min = i;
			for(int j = i+1; j < n; j++) {
				
				if(array[j] < array[min])
					min = j;
			}
			 tmp = array[i];
			 array[i] = array[min];
			 array[min] = tmp;
		}
		
	}

}
