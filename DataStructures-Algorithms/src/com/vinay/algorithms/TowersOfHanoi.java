/**
 * 
 */
package com.vinay.algorithms;

/**
 * @author VINAY
 *
 */
public class TowersOfHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n = 4;
		towersOfHanoi(n,'A','B','C');
	}
	
	/**
	 * Towers Of Hanoi recursive method.
	 * 
	 * @param n
	 * @param fromRod
	 * @param toRod
	 * @param auxRod
	 */
	private static void towersOfHanoi(int n,char fromRod, char toRod, char auxRod) {
		
		if( n==1) {
			System.out.println("Moving disk 1 from "+fromRod+" to "+toRod);
			return;
		}
		towersOfHanoi(n-1, fromRod, auxRod, toRod);
		System.out.println("Moving disk "+n+" from "+fromRod+" to "+toRod);
		towersOfHanoi(n-1, auxRod, toRod, fromRod);
	}
}
