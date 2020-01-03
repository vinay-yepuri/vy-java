/**
 * 
 */
package com.vinay.algorithms;

/**
 * @author VINAY
 *
 */
public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "m a 343 la y a l am";
		if(isPalindrome(str))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	/**
	 * 
	 * Check whether the characters in given string forms a palindrome
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isPalindrome(String str) {
		int firstChar = 0;
		int lastChar = str.length() - 1;
		
		boolean ch = true;
		
		for(int i = 0; i < str.length(); i++) {
			firstChar = firstPos(str,firstChar,lastChar);
			lastChar = lastPos(str,lastChar, firstChar);
	
		
			if(firstChar < 0 || lastChar < 0)
				break;
			
			if(str.charAt(firstChar) == str.charAt(lastChar))
			{
				firstChar++;
				lastChar--;
				continue;
			}
			// if mismatch found break the loop
			ch = false;
			break;
		}
		return ch;
	}

	/**
	 * Utility function to get the position of the last character in the string
	 * 
	 * @param str
	 * @param lastChar
	 * @param firstChar
	 * @return
	 */
	private static int lastPos(String str, int start, int end) {
		
		int lastChar = -1;
		
		for(int i = start; i >= end; i--) {
			
			char ch = str.charAt(i);
			if( ch >= 'a' && ch <= 'z') {
				lastChar = i;
				break;
			}
		}
		return lastChar;
	}

	/**
	 * Utility function to find the position of the first character
	 * 
	 * @param str
	 * @param firstChar
	 * @param lastChar
	 * @return
	 */
	private static int firstPos(String str, int start, int end) {
		int firstChar = -1;
		
		for(int i = start; i <= end; i++) {
			
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				firstChar = i;
				break;
			}
		}
		return firstChar;
	}

}
