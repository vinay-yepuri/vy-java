/**
 * 
 */
package com.vinay.algorithms;

import java.util.Stack;

/**
 * @author VINAY
 *
 */
public class MaxRectangleArea {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] hist = {4,2,5,3,8};
		System.out.println("Max Area is "+getMaxArea(hist));
	}

	/**
	 * 
	 * Function to find largest rectangle under histogram
	 * 
	 * Time Complexity = O(n)
	 * Space Complexity = O(n)
	 * 
	 * @param hist
	 * @return
	 */
	private static int getMaxArea(int[] hist) {
		
		// Create an empty stack which holds indexes of hist[] array.
		// the bars stored in the stack are always in increasing order of their heights
		Stack<Integer> s = new Stack<Integer>();
		
		int maxArea = 0;
		int areaOfTop = 0;
		int top;
		
		// go through all bars of the histogram
		int i = 0;
		while( i < hist.length) {
			
			// if the bar is higher than the bar on top of the stack then push it
			if(s.isEmpty() || hist[s.peek()] <= hist[i])
				s.push(i++);
			
			// If this bar is lower than top of stack, then calculate area of rectangle  
            // with stack top as the smallest (or minimum height) bar. 'i' is  
            // 'right index' for the top and element before top in stack is 'left index' 

			else {
				
				top = s.peek();
				s.pop();
				
		        // Calculate the area with hist[top] stack as smallest bar 
				areaOfTop = hist[top] * (s.isEmpty() ? i : (i-s.peek()-1));
				
				// update max area if needed
				if(maxArea < areaOfTop)
					maxArea = areaOfTop;
			}
		}
        // Now pop the remaining bars from stack and calculate area with every 
        // popped bar as the smallest bar
		while(s.isEmpty()) {
			top = s.peek();
			s.pop();
			
			areaOfTop = hist[top] * (s.isEmpty() ? i : (i-s.peek()-1));
			
			if(maxArea < areaOfTop)
				maxArea = areaOfTop;			
		}
		return maxArea;
	}

}
