package com.mihalypapp.data_structures;

import java.util.EmptyStackException;

public class Stack {

	private final static boolean IS_DYNAMIC = true;
	private final static int INITIAL_SIZE = 5;
	private int[] stack;
	private int size;
	private int top;
	
	public Stack() {
		this.stack = new int[INITIAL_SIZE];
		this.size = INITIAL_SIZE;
		this.top = -1;
	}
	
	public void push(int value) {
		if(isStackFull()) {
			if(!IS_DYNAMIC) throw new StackOverflowError();
			increaseStackCapacity();
		}
		stack[++top] = value;
	}
	
	public int pop() {
		if(isStackEmpty()) throw new EmptyStackException();
		return stack[top--];
	}
	
	public int peek() {
		if(isStackEmpty()) throw new EmptyStackException();
		return stack[top];
	}
	
	public int size() {
		return top + 1;
	}

	private boolean isStackEmpty() {
		return top == -1;
	}
	
	private boolean isStackFull() {
		return top == size - 1;
	}
	
	private void increaseStackCapacity() {
		int[] temp = new int[size * 2];
		for(int i = 0; i < size; i++)
			temp[i] = stack[i];
		stack = temp;
		size *= 2;
	}
			
}
