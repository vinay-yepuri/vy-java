/**
 * 
 */
package com.vinay.algorithms.sorting;

import java.util.Arrays;

/**
 * @author VINAY
 *
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = {2,7,4,1,5,3};
		System.out.println(Arrays.toString(array));
		insertionSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	/**
	 * @param a
	 */
	private static void insertionSort(int[] a) {
		 
		int value, hole, n = a.length;
		
		for(int i = 1; i < n; i++) {
			 value = a[i];
			 hole = i;
			 
			 while( hole > 0 && a[hole-1] > value) {
				 a[hole] = a[hole-1];
				 hole--;
			 }
			 a[hole] = value;
		}
	}

}
