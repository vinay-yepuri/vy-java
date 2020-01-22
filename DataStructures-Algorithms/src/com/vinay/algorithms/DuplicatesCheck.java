/**
 * 
 */
package com.vinay.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author VINAY
 *
 */
public class DuplicatesCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] {12,14,30,14,83,97,30};
		System.out.println("======Duplicates Using Brute Force======");
		findDuplicatesUsingBruteForce(array);
		
		System.out.println("======Duplicates Using HashSet======");
		findDuplicatesUsindHashSet(array);
		
		System.out.println("======Duplicates Using HashMap======");
		findDuplicatesUsingHashMap(array);


	}
	
	/**
	 * @param A
	 */
	private static void findDuplicatesUsingBruteForce(int[] A) {
		
		for(int i = 0; i < A.length; i++) {
			for(int j = i+1; j < A.length; j++) {
				if(A[i] == A[j])
					System.out.println("Duplicate element " + A[i]);
			}
		}
	}
	
	private static void findDuplicatesUsindHashSet(int[] a) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int item : a) {
			if(!set.add(item))
				System.out.println("Duplicate element : "+item);
		}
	}
	
	private static void findDuplicatesUsingHashMap(int[] a) {
		
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		for(int item: a) {
			if(map.get(item) == null)
					map.put(item, 1);
			else
				map.put(item, map.get(item)+1);
		}
		
		Set<Entry<Integer,Integer>> entrySet = map.entrySet();
		
		for(Entry<Integer,Integer> entry : entrySet) {
			if(entry.getValue() > 1)
				System.out.println("Duplicate Value is : "+entry.getKey());
		}
	}

}
