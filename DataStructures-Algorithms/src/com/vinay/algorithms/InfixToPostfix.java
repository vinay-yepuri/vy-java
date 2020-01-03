/**
 * 
 */
package com.vinay.algorithms;

import java.util.Stack;

/**
 * @author VINAY
 *
 */
public class InfixToPostfix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String exp ="A+B*(C^D-E)";
		System.out.println("Infix expression : "+exp);
		System.out.println("Postfix expression : "+infixToPostfix(exp));

	}
	
	/**
	 * Converts infix expression to postfix expression
	 * 
	 * @param exp
	 * @return
	 */
	private static String infixToPostfix(String exp) {
		
		// empty string for result
		String result = new String("");
		
		// Initialize empty stack
		Stack<Character> operands = new Stack<>();
		
		for(int i = 0; i < exp.length(); i++) {
			
			char c = exp.charAt(i);
			
			// check for operator
			if(precedence(c) > 0) {
				
				// if the precedence of 'c' is less than the top of the stack then pop the operator from stack and add it to result.
				while(!operands.isEmpty() && precedence(operands.peek()) >= precedence(c)) {
					result += operands.pop();
				}
				operands.push(c);
			}
			else if( c == '(') // push if it is '('
				operands.push(c);
			else if( c == ')') { // pop all the elements from stack and add to result until ')' is popped
				char ch = operands.pop();
				
				while( ch != '(') {
					result += ch;
					ch = operands.pop();
				}
			}
			else
				result += c; // add operands to result
		}
		
		for( int i = 0; i <= operands.size(); i++)
			result += operands.pop();
		
		return result;
	}
	
	/**
	 * Utility to return the precedence of the given operator
	 * 
	 * @param c
	 * @return
	 */
	private static int precedence(char c) {
		switch(c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

}
