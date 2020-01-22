/**
 * 
 */
package com.vinay.algorithms.sorting;

import java.util.Arrays;

/**
 * @author VINAY
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = {6,7,3,2,1,9,4};
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * In the 1st loop largest will be moved to the end of the array,
	 * so in the next loop we need to loop till last but one element.
	 * 
	 * @param array
	 */
	private static void bubbleSort(int[] array) {
		
		boolean isSorted = false;
		
		int lastUnsorted = array.length -1 ;
		
		while(!isSorted) {
			
			isSorted = true;
			
			for(int i = 0; i < lastUnsorted; i++) {
				if(array[i] > array[i+1]) {
					swap(array,i,i+1);
					isSorted = false; // this has become false whenever there is a swap, 
					                  //if there are no swaps that means the array is already sorted, so it avoids looping further.
				}
			}
			lastUnsorted--;
		}
	}
	
	/**
	 * Swaps array elements
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	private static void swap(int[] array,int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
