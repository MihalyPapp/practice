package com.mihalypapp.algorithms;

import java.util.Stack;

public class PrefixToInfix {

	Stack<String> stack;
	private String prefix;
	private String infix;

	public PrefixToInfix(String prefix) {
		this.stack = new Stack<>();
		this.prefix = prefix;
		this.infix = new String();
		calculateInfix();
	}

	private void calculateInfix() {
		for (int i = prefix.length() - 1; i >= 0; i--) {
			String current = String.valueOf(prefix.charAt(i));
			if(isOperand(current))
				stack.push(current);
			else
				stack.push("(" + stack.pop() + current + stack.pop() + ")");
		}
		infix = stack.pop();
	}

	private boolean isOperand(String string) {
		switch (string) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "^":
			return false;
		default:
			return true;
		}
	}

	public String getInfix() {
		return infix;
	}

	public static void main(String[] args) {
		//String prefix = "-5*3+-^235*73"; 	//(5-(3*(((2^3)-5)+(7*3))))
		String prefix = "+-+^+32239^32";	// (((((3+2)^2)+3)-9)+(3^2))
		String infix = new PrefixToInfix(prefix).getInfix();
		System.out.println(infix);
	}

}
