/**
 * 
 */
package com.vinay.algorithms;

/**
 * @author VINAY
 *
 */
public class FibonacciSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n = 10;

		fibonacciUsingForLoop(n);
		System.out.println();
		fibonacciUsingWhileLoop(n);
		System.out.println();
		fibonacciUsingRecursion(n);
	}

	/**
	 * Fibonacci series using recursion
	 * 
	 * @param n
	 */
	private static void fibonacciUsingRecursion(int n) {
		
		System.out.println(" Fibonacci series using recursion ");
		for(int i = 0; i <= n; i++) {
			System.out.print
			(fibonacciRecursion(i)+" ");
		}
	}

	/**
	 * Utility function for fibonacci series using recursion
	 * 
	 * Here time complexity is O(2 power n) which is exponential time algorithm
	 * 
	 * @param string
	 */
	private static int fibonacciRecursion(int num) {
		
		if( num == 0)
			return 0;
		if( num == 1 || num == 2)
			return 1;
		else
			return fibonacciRecursion(num-2) + fibonacciRecursion(num-1);
	}

	/**
	 * 
	 * Function to generate fibonacci series using While loop
	 * 
	 * Time complexity is O(n) which is linear time algorithm
	 * 
	 * @param n
	 */
	private static void fibonacciUsingWhileLoop(int n) {
		
		int i = 1, t1 = 0, t2 = 1;
		
		System.out.println(" Fibonacci series using while loop ");
		
		while ( i <= n) {
			
			System.out.print(" "+t1);
			
			int sum = t1 + t2;
			t1 = t2;
			t2 = sum;
			
			i++;
		}
	}

	/**
	 * 
	 * Time complexity is O(n) which is linear time algorithm
	 * 
	 * Function to generate fibonacci series using for loop
	 * 
	 * @param n
	 */
	private static void fibonacciUsingForLoop(int n) {
		
		int t1 = 0, t2 = 1;
		
		System.out.println(" Fibonacci series using For loop ");
		
		for(int i = 1; i <= 10; i++) {
			
			System.out.print(" "+t1);
			
			int sum = t1 + t2;
			t1 = t2;
			t2 = sum;
		}
	}
}
