package com.mihalypapp.algorithms;

import java.util.Stack;

public class PostfixToInfix {

	Stack<String> stack;
	private String postfix;
	private String infix;

	public PostfixToInfix(String postfix) {
		this.postfix = postfix;
		this.infix = new String();
		this.stack = new Stack<>();
		calculateInfix();
	}

	private void calculateInfix() {
		for(int i = 0; i < postfix.length(); i++) {
			String current = String.valueOf(postfix.charAt(i));
			if(isOperator(current)) {
				String val1 = stack.pop();
				String val2 = stack.pop();
				String temp = "(" + val2 + current + val1 + ")";
				stack.push(temp);
			} else {
				stack.push(current);
			}
		}
		infix = stack.pop();
	}

	public String getInfix() {
		return infix;
	}

	public static boolean isOperator(String string) {
		switch (string) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "^":
			return true;
		default:
			return false;
		}
	}

	public static void main(String[] args) {
		String postfix = "abcd^e-fgh*+^*+i-";
		String infix = new PostfixToInfix(postfix).getInfix();
		System.out.println(infix); //((a+(b*(((c^d)-e)^(f+(g*h)))))-i)
				
	}
	
}
