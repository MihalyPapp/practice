package com.mihalypapp.data_structures;

public class DoublyLinkedList {

	private Node head;

	public void add(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
			return;
		}
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		node.prev = last;
		last.next = node;
	}
	
	public void addFirst(int data) {
		Node node = new Node(data);
		node.next = head;
		if(head != null)
			head.prev = node;
		head = node;
	}
	
	public void insertAt(int pos, int data) {
		if(pos == 0) {
			addFirst(data);
			return; 
		}
		Node node = new Node(data);
		Node previous = head;
		int i = 0;
		while (previous != null && i < pos - 1) {
			previous = previous.next;
			i++;
		}
		node.next = previous.next;
		node.prev = previous;
		previous.next = node;
		if(node.next != null)
			node.next.prev = node;
	}
	
	public int size() {
		if(head == null) return 0;
		Node last = head;
		int size = 0;
		while(last != null) {
			last = last.next;
			size++;
		}
		return size;
	}
	
	public void print() {
		System.out.print("  Printing the array: [ ");
		if(head == null) System.out.print("NULL ");
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println("]");
	}
	
	public void printReverse() {
		System.out.print("  Printing reversed:  [ ");
		if(head == null) System.out.print("NULL ");
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.prev;
		}
		System.out.println("]");
	}
	
	public void delete(int pos) {
		if(head == null) return;
		Node current = head;
		int i = 0;
		while (current != null && i < pos) {
			current = current.next;
			i++;
		}
		if(current.prev != null)
			current.prev.next = current.next;
		else
			head = current.next;
		if(current.next != null)
			current.next.prev = current.prev;
	}

	/*	Swap k-th node from beginning with k-th node from end.	*/
	public void swapNode(int k) {
		if(k < 1) return;
		Node nodeFromLeft = null;
		Node nodeFromRight = head;
		Node current = head;
		int i = 0;
		
		while (current != null) {
			if(i == k - 1) nodeFromLeft = current;
			if(i >= k) nodeFromRight = nodeFromRight.next;
			current = current.next;
			i++;
		}
		
		if(nodeFromLeft == null || nodeFromLeft == nodeFromRight) return;
		
		Node temp1 = nodeFromRight.prev;
		Node temp2 = nodeFromRight.next;
		if(nodeFromLeft.next == nodeFromRight) {
			nodeFromRight.prev = nodeFromLeft.prev;
			nodeFromRight.next = nodeFromLeft;
			nodeFromLeft.prev = nodeFromRight;
			nodeFromLeft.next = temp2;
		} else if(nodeFromLeft.prev == nodeFromRight) {
			nodeFromRight.prev = nodeFromLeft;
			nodeFromRight.next = nodeFromLeft.next;
			nodeFromLeft.prev = temp1;
			nodeFromLeft.next = nodeFromRight;
		} else if(nodeFromLeft.next != nodeFromRight && nodeFromLeft.prev != nodeFromRight) {
			nodeFromRight.prev = nodeFromLeft.prev;
			nodeFromRight.next = nodeFromLeft.next;
			nodeFromLeft.prev = temp1;
			nodeFromLeft.next = temp2;
		}
		
		
		if(nodeFromLeft.prev != null)
			nodeFromLeft.prev.next = nodeFromLeft;
		if(nodeFromLeft.next != null)
			nodeFromLeft.next.prev = nodeFromLeft;
		if(nodeFromRight.prev != null)
			nodeFromRight.prev.next = nodeFromRight;
		if(nodeFromRight.next != null)
			nodeFromRight.next.prev = nodeFromRight;
		
		if(k == 1)
			head = nodeFromRight;
		if(k == i)
			head = nodeFromLeft;
	}
	
	public void reverse() {
		if(head == null) return;
		Node current = head;
		Node temp = null;
		while(current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		if(temp != null) {
			head = temp.prev;
		}
	}
	
	class Node {
		int data;
		Node prev;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}

}
