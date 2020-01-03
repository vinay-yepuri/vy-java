/**
 * 
 */
package com.vinay.algorithms;

import java.util.Stack;

/**
 * @author VINAY
 *
 */
public class InfixToPrefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "A+B*(C^D-E)";
		System.out.println("Infix Expression : "+str);
		System.out.println("Prefix Expression : "+infixToPrefix(str));
	}
	
	/**
	 * Converts infix expression to postfix expression
	 * 
	 * @param exp
	 * @return
	 */
	private static String infixToPrefix(String exp) {
		
		// empty string for result
		StringBuilder result = new StringBuilder();
		
		// Input expression
		StringBuilder input = new StringBuilder(exp);
		
		// For converting infix to prefix follow below steps
		// 1. Reverse input expression
		// 2. Replace '(' with ')' and vice versa
		// 3. Apply postfix logic on above expression
		// 4. Reverse the final result
		
		// Step 1
		input.reverse();
		
		// Initialize empty stack
		Stack<Character> operands = new Stack<>();
		
		char [] charsExp = new String(input).toCharArray();
		
		// Step 2
		for(int i = 0; i < charsExp.length; i++) {
			if(charsExp[i] == '(') {
				charsExp[i] = ')';
				i++;
			}
			if(charsExp[i] == ')') {
				charsExp[i] = '(';
				i++;
			}
		}
		
		// Step 3
		for(int i = 0; i < charsExp.length; i++) {
			
			char c = charsExp[i];
			
			// check for operator
			if(precedence(c) > 0) {
				
				// if the precedence of 'c' is less than the top of the stack then pop the operator from stack and add it to result.
				while(!operands.isEmpty() && precedence(operands.peek()) >= precedence(c)) {
					result.append(operands.pop());
				}
				operands.push(c);
			}
			else if( c == '(') // push if it is '('
				operands.push(c);
			else if( c == ')') { // pop all the elements from stack and add to result until ')' is popped
				char ch = operands.pop();
				
				while( ch != '(') {
					result.append(ch);
					ch = operands.pop();
				}
			}
			else
				result.append(c); // add operands to result
		}
		
		for( int i = 0; i <= operands.size(); i++)
			result.append(operands.pop());
		
		return result.reverse().toString();
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
