/**
 * 
 */
package com.vinay.algorithms;

import java.util.Stack;

/**
 * @author VINAY
 *
 */
public class BalancedSymbols {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "(A+B)+[D] {}";
		if(isBalancedExpression(str))
			System.out.println("Balanced");
		else
			System.out.println("Not Balanced");
	}
	
	private static boolean isBalancedExpression(String exp) {
		
		Stack<Character> stack = new Stack<Character>();
		
		if(exp == null || exp.length() == 0)
			return false;
		else {
			for(int i = 0; i < exp.length();i++)
			{
				char ch = exp.charAt(i);
				
				if(ch == '(' || ch == '{' || ch == '[') {
					stack.push(ch);
				}
				else if(ch == ')' || ch == '}' || ch == ']'){
					
					if(stack.isEmpty())
						return false;
					
					char chPeek = (char)stack.peek();
					
					if((chPeek == '(' && ch ==')') || 
					   (chPeek == '{' && ch =='}') || 
					   (chPeek == '[' && ch ==']'))
					{
						stack.pop();
					}
				}
			}
		}
		return stack.isEmpty();
	}
}
