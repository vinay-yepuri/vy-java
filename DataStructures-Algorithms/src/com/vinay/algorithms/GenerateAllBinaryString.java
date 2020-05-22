/**
 * 
 */
package com.vinay.algorithms;

/**
 * @author VINAY
 *
 */
public class GenerateAllBinaryString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;
		int[] arr = new int[4];
	//	generateAllBinaryStrings(arr, n, 0);
		
		for (int i = 0; i < (Math.pow(2, n)); i++) {
			System.out.println(Integer.toBinaryString(i));
		}
		
		String str = "1?0?1?";
		char[] charArr = str.toCharArray();
	//	print(charArr,0);
	}
	
	/**
	 * Function to generate all binary strings using recursion and backtracking it has O(2 power n) running time complexity
	 * 
	 * @param arr
	 * @param n
	 * @param i
	 */
	private static void generateAllBinaryStrings(int[] arr, int n,int i) {
		
		if( n == i) {
			printArray(arr,n);
			return;
		}
		// first assign '0' at ith position and try all other permutations for remaining positions
		arr[i] = 0;
		generateAllBinaryStrings(arr, n, i+1);
		
		// first assign '1' at ith position and try all other permutations for remaining positions
		arr[i] = 1;
		generateAllBinaryStrings(arr, n, i+1);
	}

	/**
	 * 
	 * prints the array elements in a row
	 * 
	 * @param arr
	 * @param n
	 */
	private static void printArray(int[] arr, int n) {
		for(int i = 0 ; i < n; i++)
			System.out.print(arr[i]);
		System.out.println();
	}
	
	/**
	 * Recursive function to generate all binary strings by replacing each wild card character by '1' and '0'.
	 * 
	 * @param a
	 * @param index
	 */
	private static void print(char a[], int index) {
		if(index == a.length) {
			System.out.println(a);
			return;
		}
		else if(a[index] == '?') {
			// Replace '?' with '0' and recurse
			a[index] = '0';
			print(a,index+1);
			
			// Replace '?' with '1' and recurse
			a[index] = '1';
			print(a,index+1);
			
			// Need to backtrack as string to passed by reference to the function
			a[index] = '?';
		}
		else
			print(a,index+1);
	}
}
