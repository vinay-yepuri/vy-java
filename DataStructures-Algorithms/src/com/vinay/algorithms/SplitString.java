/**
 * 
 */
package com.vinay.algorithms;

import java.util.regex.Pattern;

/**
 * @author VINAY
 *
 */
public class SplitString {

	/**
	 * @param args
	 * 
	 * Split the string based on the delimiter
	 * 
	 */
	public static void main(String[] args) {
		
		// Specify the delimiter
		String delimiter = "\\d";
		String text = "geeks1for3geeks";
		
		Pattern pattern = Pattern.compile(delimiter, Pattern.CASE_INSENSITIVE);
		
		// Split the string using the delimiter
		String[] result = pattern.split(text);
		
		for(String str: result)
			System.out.println(str);
		
		// Remove Ovals from a String
	    String str = "GeeeksforGeeks - A Computer Science Portal for Geeks"; 
          
	    System.out.println(removeOvals(str)); 
		
	}
	
	private static String removeOvals(String str) {
		return str.replaceAll("[BCDFGHJKLMNPQRSTVQXYZbcdfghjklmnpqrstcqxyz]", "");
	}

}
