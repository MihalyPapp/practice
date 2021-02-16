package com.mihalypapp.algorithms;

import java.util.Stack;

public class InfixToPrefix {

	Stack<Character> stack;
	private String infix;
	private String prefix;

	public InfixToPrefix(String infix) {
		this.infix = infix;
		this.prefix = new String();
		this.stack = new Stack<>();
		calculatePrefix();
	}

	private void calculatePrefix() {
		for(int i = infix.length() - 1; i >= 0; i--) {
			char current = infix.charAt(i);
			if(Character.isLetterOrDigit(current)) {
				prefix = current + prefix;
			} else if (current == ')') {
				stack.push(current);
			} else if (current == '(') {
				while(stack.peek() != ')') {
					prefix = stack.pop() + prefix;
				}
				stack.pop();
			} else {
				while(!stack.isEmpty() && precedence(current) < precedence(stack.peek()) && stack.peek() != ')') {
					prefix = stack.pop() + prefix;
				}
				stack.push(current);
			}
		}
		while(!stack.isEmpty()) {
			prefix = stack.pop() + prefix;
		}
	}

	private int precedence(Character character) {
		switch (character) {
		case '+':
		case '-':
			return 0;
		case '*':
		case '/':
			return 1;
		case '^':
			return 2;
		default:
			return -1;
		}
	}

	private String getPrefix() {
		return prefix;
	}

	public static void main(String[] args) {
		String infix = "((3+2)^2+3)-9+3^2"; // +-+^+32239^32
		String prefix = new InfixToPrefix(infix).getPrefix();
		System.out.println(prefix);
	}

}
