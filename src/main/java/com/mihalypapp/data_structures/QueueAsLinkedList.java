package com.mihalypapp.data_structures;

public class QueueAsLinkedList {

	private Node front;
	private Node rear;
		
	public void enQueue(int value) {
		Node node = new Node(value);
		if (front == null) {
			front = node;
			rear = node;
		} else {
			rear.next = node;
			rear = rear.next;
		}
	}
	
	public int deQueue() {
		int value = front.value;
		front = front.next;
		if(front == null) rear = null;
		return value;
	}
	
	public static class Node {
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
}
