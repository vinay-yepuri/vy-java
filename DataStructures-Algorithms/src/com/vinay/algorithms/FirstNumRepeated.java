/**
 * 
 */
package com.vinay.algorithms;

import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author VINAY
 *
 */
public class FirstNumRepeated {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] {12,14,30,14,83,97,30};
		System.out.println(firstRepeatedNumUsingHashTable(array));
	}
	
	private static int firstRepeatedNumUsingHashTable(int[] A) {
		Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
		
		for(int i = 0; i < A.length; i++)
		{
			if(hashTable.get(A[i]) == null)
				hashTable.put(A[i], i+1);
			else if(!(hashTable.get(A[i]) < 0))
			{
				hashTable.put(A[i], -(hashTable.get(A[i])));
			}
		}
		
		int max = -255;
		int key = -1;
		
		Set<Entry<Integer,Integer>> entrySet = hashTable.entrySet();
		
		for( Entry<Integer,Integer> entry : entrySet)
		{
			int value = entry.getValue();
			int number = entry.getKey();
			if( value < 0 && max < value)
			{
				max = value;
				key = number;
			}
		}
		
		System.out.println( key +" is the first repeated element");
 		return key;
	}

}
