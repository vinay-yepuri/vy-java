/**
 * 
 */
package com.vinay.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VINAY
 *
 */
public class WordCount {

	/**
	 * @param args
	 * 
	 * Program to count all words whose count is 2
	 * 
	 */
	public static void main(String[] args) {
		
		String[] words = {"Manya","Ammu","Vinay","Buddi","Manya","Vinay","Ammu"};
		int length = words.length;
		System.out.println(countWords(words, length));

	}
	
	/**
	 * Return words whose count is n
	 * @param str
	 * @param n
	 * @return
	 */
	private static int countWords(String[] str, int n) {
		
		// Map to store count of each word
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		
		for(int i = 0; i < n; i++) {
			
			if(countMap.containsKey(str[i])) {
				
				int count = countMap.get(str[i]);
				countMap.put(str[i], count+1);
			}
			else {
				countMap.put(str[i], 1);
			}
		}
		
		int result = 0;
		
		for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
			
			if(entry.getValue() == 2)
				result++;
		}
		
		return result;
	}

}
