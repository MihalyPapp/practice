package com.mihalypapp.data_structures;

import java.util.EmptyStackException;

public class StackAsLinkedList {

	Node stack;
	
	public void push(int value) {
		Node node = new Node(value);
		if(stack == null) {
			stack = node;
			return;
		}
		node.next = stack;
		stack = node;
	}
	
	public int pop() {
		if(stack == null) throw new EmptyStackException();
		int data = stack.data;
		stack = stack.next;
		return data;
	}
	
	public int peek() {
		if(stack == null) throw new EmptyStackException();
		int data = stack.data;
		return data;
	}
	
	public int size() {
		int size = 0;
		Node current = stack;
		while(current != null) {
			size++;
			current = current.next;
		}
		return size;
	}
	
	static class Node {
		
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
	}
	
}
