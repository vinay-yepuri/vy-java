/**
 * 
 */
package com.vinay.algorithms;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author VINAY
 *
 */
/**
 * @author VINAY
 *
 */
public class SpanOfArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] array = {100,4,5,90,120,80};
		int[] spanArray = new int[array.length];
		calculateSpan(array,spanArray);
		
		System.out.println(Arrays.toString(array));
		System.out.println("Spans of array elements are");
		System.out.println(Arrays.toString(spanArray));
		
		int[] spanResult = new int[array.length];
		calculateSpanWithStack(array,spanResult);
		
		int[] spanResult1 = new int[array.length];
		calculateSpanwithBestTimeComplexity(array,spanResult1);
	}

	/**
	 * Function to calculate span of elements with linear time complexity without stack.
	 * 
	 * T(n) = O(n)
	 * 
	 * @param array
	 * @param spanArray
	 */
	private static void calculateSpanwithBestTimeComplexity(int[] array, int[] spanArray) {
		int n = array.length;
		
		spanArray[0] = 1;
		
		for(int i = 1; i < n; i++) {
			
			int counter = 1;
			
			while( (i-counter) >= 0 && array[i] > array[i-counter]) {
				counter += spanArray[i-counter];
			}
			spanArray[i] = counter;
		}
		System.out.println(Arrays.toString(spanArray));
	}

	/**
	 * Function to calculate span using a stack.
	 * 
	 * Time complexity is O(n)
	 * 
	 * @param array
	 * @param spanArray
	 */
	private static void calculateSpanWithStack(int[] array, int[] spanArray) {
		int n = array.length;
		
		Stack<Integer> spanStack = new Stack<Integer>();
		spanStack.push(0);
		
		// span of 1st element is always 1
		spanArray[0] = 1;
		
		for(int i = 1; i < n; i++) {
			
			// Pop elements from stack while stack is not empty 
			// and top of the stack is smaller than array[i]
			
			while( !spanStack.isEmpty() && array[spanStack.peek()] <= array[i])
					spanStack.pop();
			
			spanArray[i] = spanStack.isEmpty() ? i+1 : (i-spanStack.peek());
			
			spanStack.push(i);
		}
		System.out.println(Arrays.toString(spanArray));
	}

	/**
	 * Function to calculate the span of array elements
	 * 
	 * Time complexity is O(n power 2) and space complexity is O(1).
	 * 
	 * @param spanArray 
	 * 
	 * @param spanArray
	 */
	private static void calculateSpan(int[] arrays, int[] spanArray) {
		
		int size = arrays.length;
		
		// Span of first element is always 1.
		spanArray[0] = 1;
		
		// calculate the span of remaining elements by linearly checking previous days
		for(int i = 1; i < size; i++) {
			
			int j = i-1;
			spanArray[i] = 1;
			// check whether previous elements are less then or equal to current element.
			while( j >= 0 && arrays[j] <= arrays[i]) {
				spanArray[i]++;
				j--;
			}
		}
	}

}
