/**
 * 
 */
package com.vinay.algorithms;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author VINAY
 *
 */
public class MaxOccurance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {3,2,1,2,3};
		
		System.out.println(bruteForceSolution(A) +" Occurred max number of times in an array !!!");
		System.out.println(findMaxOccuranceWithSorting(A)+" Occurred max number of times in an array !!!");
		System.out.println(findMaxOccuranceUsingHashTable(A)+" Occurred max number of times in an array !!!");

	}

	/**
	 * @param a
	 * @return
	 * 
	 * Time Complexity = O(n2), Space Complexity = O(1)
	 */
	private static int bruteForceSolution(int[] a) {
		
		int maxCnt = 0;
		int counter = 0;
		
		for(int i = 0; i < a.length; i++)
		{
			counter = 0;
			for(int j = 0; j < a.length; j++) {
				
				if(a[i] == a[j])
					counter++;
			}
			if(counter > maxCnt) maxCnt = counter;
		}
		return maxCnt;
	}
	
	/**
	 * @param A
	 * @return
	 * 
	 * Time Complexity = O(nlogn), Space complexity = O(1)
	 */
	private static int findMaxOccuranceWithSorting(int[] A)
	{
		int maxCnt = 0;
		Arrays.sort(A);
		
		int counter = 1;
		for( int i = 0; i < A.length-1; i++)
		{
			if(A[i] == A[i+1])
				counter++;
			else if(counter >= maxCnt){
				maxCnt = counter;
				counter = 1;
			}
		}
		if(counter >= maxCnt){
			maxCnt = counter;
		}
		return maxCnt;
	}
	
	/**
	 * @param A
	 * @return
	 * 
	 * TimeComplexity = O(n) Space Complexity = O(n)
	 * 
	 */
	private static int findMaxOccuranceUsingHashTable(int[] A)
	{
		int max = 0;
		
		Map<Integer,Integer> hashTable = new Hashtable<Integer, Integer>();
		
		for(int i = 0; i < A.length; i++)
		{
			if(hashTable.get(A[i]) == null) {
				hashTable.put(A[i], 1);
			}
			else
				hashTable.put(A[i], hashTable.get(A[i])+1);
		}
		
		Set<Entry<Integer, Integer>> entrySet = hashTable.entrySet();
		
		
		for(Entry<Integer,Integer> entry : entrySet) {
			if(max < entry.getValue())
				max = entry.getValue();
		}
		return max;
	}

}
