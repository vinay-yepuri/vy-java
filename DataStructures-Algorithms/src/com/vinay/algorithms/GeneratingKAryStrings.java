/**
 * 
 */
package com.vinay.algorithms;

/**
 * @author VINAY
 *
 */
public class GeneratingKAryStrings {
	
	private static int cnt = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] set1 = {'V','I','N','A','Y'};
		int k = 4;
		printAllKLength(set1, k);
		System.out.println("Possible variables are : "+cnt);
	}
	
	/**
	 * Prints all possible strings of length K
	 * 
	 * @param set
	 * @param k
	 */
	private static void printAllKLength(char[] set,int k) {
		int n = set.length;
		printAllKLengthRec(set,"",n,k);
	}

	/**
	 * Recursive function to print all possible strings of length K
	 * @param set
	 * @param prefix
	 * @param n
	 * @param k
	 */
	private static void printAllKLengthRec(char[] set, String prefix, int n, int k) {
		// Base case 
		if( k == 0) {
			System.out.println(prefix);
			cnt++;
			return;
		}
		
		// Add all characters of set one by one and recursively call for k equals to k-1
		for(int i = 0; i < n; i++) {
			// New character of input added
			String newPrefix = prefix + set[i];
			// K is decreased because we have added a new character
			printAllKLengthRec(set, newPrefix, n, k-1);
		}
	}
}
