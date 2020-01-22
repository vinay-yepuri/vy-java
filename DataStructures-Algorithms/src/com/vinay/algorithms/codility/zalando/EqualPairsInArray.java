/**
 * 
 */
package com.vinay.algorithms.codility.zalando;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VINAY
 * 
 * Given an array of n elements. 
 * The task is to count the total number of indices (i, j) 
 * such that arr[i] = arr[j] and i < j
 *
 */
public class EqualPairsInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] A = {3,5,6,3,3,5};
		int pairs = findPairs(A);
		System.out.println("pairs : "+pairs);
	}
	
	/**
	 * Calculate count equal pairs(i,j ) such that A[i] = A[j] where i < j
	 * 
	 * @param a
	 * @return
	 */
	private static int findPairs(int[] a) {

		int pairs = 0;
		
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		// Find count of each element
		for(int i = 0; i < a.length; i++)
		{
			if( map.containsKey(a[i])) 
				map.put(a[i], map.get(a[i])+1);
			else
				map.put(a[i], 1);
		}
		// count equal pairs where i < j
		for(Map.Entry<Integer, Integer> entry: map.entrySet())
		{
			int count = entry.getValue();
			pairs += (count * (count-1))/2;
		}
		return pairs;
	}

}
