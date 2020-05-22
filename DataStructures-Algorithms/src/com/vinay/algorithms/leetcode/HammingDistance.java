
package com.vinay.algorithms.leetcode;


/**
 * @author VINAY
 *
 */
public class HammingDistance {
	
	/*
	 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     *
	 * Given two integers x and y, calculate the Hamming distance.
	 * 
	 * Note: 0 <= x, y < 231. Example: Input: x = 1, y = 4 Output: 2 Explanation: 
	 * 1 (0 0 0 1)
	 * 4 (0 1 0 0)  The above arrows point to positions where the
	 * corresponding bits are different.
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int hammingDistance = hammingDistance(5,10);
		System.out.println(hammingDistance);
	}
	
    private static int hammingDistance(int x, int y) {
        
    int xor = x ^ y;
        return Integer.bitCount(xor);
    }

}
