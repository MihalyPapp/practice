package com.mihalypapp.algorithms;

import java.util.Stack;

public class InfixToPostfix {

	Stack<Character> stack;
	private String infix;
	private String postfix;

	public InfixToPostfix(String infix) {
		this.infix = infix;
		this.postfix = new String();
		this.stack = new Stack<>();
		calculatePostfix();
	}

	private void calculatePostfix() {
		for (int i = 0; i < infix.length(); i++) {
			char current = infix.charAt(i);

			if (Character.isLetterOrDigit(current)) {
				postfix += current;
				continue;
			}

			if (stack.isEmpty() || precedence(current) > precedence(stack.peek()) || stack.peek() == '('
					|| current == '(') {
				stack.push(current);
				continue;
			}

			if (current == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					postfix += stack.pop();
				stack.pop();
				continue;
			}

			while (!stack.isEmpty() && precedence(current) <= precedence(stack.peek()) && stack.peek() != ')') {
				if (stack.peek() == '(') {
					stack.pop();
					break;
				}
				postfix += stack.pop();
			}
			stack.push(current);
		}
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
	}

	public String getPostfix() {
		return postfix;
	}

	public static int precedence(Character character) {
		switch (character) {
		case '+':
		case '-':
			return 0;
		case '*':
		case '/':
			return 1;
		case '^':
			return 3;
		default:
			return -1;
		}
	}

	public static void main(String[] args) {
		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		String postfix = new InfixToPostfix(infix).getPostfix();
		System.out.println(postfix); // abcd^e-fgh*+^*+i-
	}
}
