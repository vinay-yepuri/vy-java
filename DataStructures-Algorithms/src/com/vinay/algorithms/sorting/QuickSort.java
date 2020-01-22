/**
 * 
 */
package com.vinay.algorithms.sorting;

import java.util.Arrays;

/**
 * @author VINAY
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = {2,7,4,1,5,3};
		System.out.println(Arrays.toString(array));
		quickSort(array,0,array.length);
		System.out.println(Arrays.toString(array));
	}
	
	/**
	 * @param A
	 * @param start
	 * @param end
	 */
	private static void quickSort(int[] A, int start, int end) {
		
		if( start < end)
		{
			// rearrange the elements and get pivot index
			int pivotIndex = partition(A,start,end);
			
			quickSort(A, start, pivotIndex);
			
			quickSort(A, pivotIndex+1, end);
		}
	}

	/**
	 * @param a
	 * @param start
	 * @param end
	 * @return
	 */
	private static int partition(int[] A, int start, int end) {
		
		int pivot = A[end-1];
		
		int pivotIndex = start;
		
		for(int i = start; i < end-1 ; i++) {
			
			if(A[i] <= pivot) {
				int temp = A[i];
				A[i] = A[pivotIndex];
				A[pivotIndex] = temp;
				pivotIndex++;
			}
		}
		
		int temp = A[pivotIndex];
		A[pivotIndex] = A[end-1];
		A[end-1] = temp;
		return pivotIndex;
	}

}
