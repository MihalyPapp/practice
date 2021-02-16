package com.mihalypapp.algorithms;

import java.util.Stack;

public class PrefixToPostfix {
	
	private Stack<String> stack;
	private String prefix;
	private String postfix;
	
	public PrefixToPostfix(String prefix) {
		this.stack = new Stack<>();
		this.prefix = prefix;
		this.postfix = new String();
		calculatePostfix();
	}	

	private void calculatePostfix() {
		for(int i = prefix.length() - 1; i >= 0; i--) {
			String current = String.valueOf(prefix.charAt(i));
			if(!isOperator(current)) {
				stack.push(String.valueOf(current));
			} else if (!isOperator(stack.peek())) {
				stack.push(stack.pop() + stack.pop() + current);
			}
		}
		while(!stack.empty()) {
			postfix = stack.pop();
		}
	}
	
	private boolean isOperator(String string) {
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

	public String getPostfix() {
		return this.postfix;
	}

	public static void main(String[] args) {
		String prefix = "+4/*842";	// 484*2/+		// 69+42^+ // ((6+9)+(4^2))
		String postfix = new PrefixToPostfix(prefix).getPostfix();
		System.out.println(postfix);
	}
	
}
