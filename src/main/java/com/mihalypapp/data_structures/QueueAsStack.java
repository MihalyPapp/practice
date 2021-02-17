package com.mihalypapp.data_structures;

public class Queue {

	private StackAsLinkedList stack;
	private StackAsLinkedList temp;
	
	public Queue() {
		stack = new StackAsLinkedList();
		temp = new StackAsLinkedList();
	}
		
	public void enQueue(int value) {
		stack.push(value);
	}
	
	public int deQueue() {
		if(temp.isEmpty()) {
			while(!stack.isEmpty())
				temp.push(stack.pop());
		}
		return temp.pop();
	}
	
	/*public void enQueue(int value) {
	while(!stack.isEmpty())
		temp.push(stack.pop());
	stack.push(value);
	while(!temp.isEmpty())
		stack.push(temp.pop());
	}
	
	public int deQueue() {
		if(stack.isEmpty()) throw new EmptyStackException();
		return stack.pop();
	}*/
	
}
