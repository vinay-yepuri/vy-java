/**
 * 
 */
package com.vinay.algorithms;

import java.util.Stack;

/**
 * @author VINAY
 *
 * Time complexity is O(n ^ 2) and Space complexity is  O(n ^ 2) 
 */
public class ReverseAStackRecursion {
	
	private static Stack<Character> st  = new Stack<Character>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		st.push('V');
		st.push('I');
		st.push('N');
		st.push('A');
		st.push('Y');
		
		System.out.println("Original Stack");
		System.out.println(st);
		
		reverse();
		
		System.out.println("Reverse Stack");
		System.out.println(st);
	}
	
	private static void reverse() {
		
		if( st.size() > 0) {
			
			// hold all elements of stack using function recursion
			// Call the stack until we reach end of the stack
			char x = st.peek();
			st.pop();
			reverse();
			
            // Insert all the items held  
            // in Function Call Stack 
            // one by one from the bottom 
            // to top. Every item is 
            // inserted at the bottom  
            insert_at_bottom(x);
		}
	}
	

	/**
	 * @param x
	 */
	private static void insert_at_bottom(char x) {
		
		if(st.isEmpty())
			st.push(x);
		else {
            // All items are held in Function 
            // Call Stack until we reach end 
            // of the stack. When the stack becomes 
            // empty, the st.size() becomes 0, the 
            // above if part is executed and  
            // the item is inserted at the bottom 
			char a = st.peek();
			st.pop();
			
            // push all the items held  
            // in Function Call Stack 
            // once the item is inserted  
            // at the bottom
			insert_at_bottom(x);
			st.push(a);
		}
	} 
}
