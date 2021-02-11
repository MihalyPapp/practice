package com.mihalypapp.data_structures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class SinglyLinkedList {

	private SinglyLinkedNode head;

	public void addFirst(String string) {
		SinglyLinkedNode newNode = new SinglyLinkedNode(string);
		newNode.node = head;
		head = newNode;
	}

	public void add(String string) {
		addLast(string);
	}

	public void addLast(String string) {
		SinglyLinkedNode newNode = new SinglyLinkedNode(string);

		if (head == null) {
			head = newNode;
			return;
		}

		SinglyLinkedNode last = head;
		while (last.node != null) {
			last = last.node;
		}

		last.node = newNode;
	}

	public void add(int pos, String string) {
		SinglyLinkedNode newNode = new SinglyLinkedNode(string);

		if (head == null && pos > 0) {
			throw new ArrayIndexOutOfBoundsException();
		}

		if (pos == 0) {
			addFirst(string);
			return;
		}

		SinglyLinkedNode current = head;
		SinglyLinkedNode previous = null;
		int i = 0;

		while (i < pos) {
			if (pos - i == 1) {
				previous = current;
			}
			current = current.node;
			i++;
		}

		newNode.node = current;
		previous.node = newNode;
	}
	
	public int size() {
		SinglyLinkedNode current = head;
		int size = 0;
		while(current != null) {
			size++;
			current = current.node;
		}
		return size;
	}
	
	public String getMiddleNode() {
		int i = 0;
		SinglyLinkedNode current = head;
		SinglyLinkedNode middle = head;
		while(current != null) {
			if(i % 2 == 1) {
				middle = middle.node;
			}
			++i;
			current = current.node;
		}
		return middle.data;
	}

	public SinglyLinkedNode contains(String string) {
		SinglyLinkedNode current = head;
		while (current != null) {
			if (current.data.equals(string)) {
				return current;
			}
			current = current.node;
		}
		return null;
	}

	public void remove(String string) {
		SinglyLinkedNode current = head;
		SinglyLinkedNode previous = null;

		if (head != null && head.data.equals(string)) {
			head = head.node;
			return;
		}

		while (current != null && !current.data.equals(string)) {
			previous = current;
			current = current.node;;
		}

		if (previous.node == null)
			return;

		previous.node = current.node;
	}

	public String[] toArray() {
		int length = 0;
		SinglyLinkedNode current = head;
		while (current != null) {
			length++;
			current = current.node;
		}
		String[] array = new String[length];
		int i = 0;
		current = head;
		while(current != null) {
			array[i] = current.data;
			current = current.node;
			i++;
		}
		return array;
	}
	
	public boolean isPalindrome() {
		Stack<String> stack = new Stack<>();
		SinglyLinkedNode current = head;
		while(current != null) {
			stack.push(current.data);
			current = current.node;
		}
		current = head;
		while(current != null) {
			if(!stack.pop().equals(current.data)) {
				return false;
			}
			current = current.node;
		}
		
		return true;
	}

	public void print() {
		SinglyLinkedNode current = head;
		while (current != null) {
			System.out.print(current.data + ", ");
			current = current.node;
		}
		System.out.println();
	}
	
	public boolean hasLoop() {
		if(head == null || head.node == null)
			return false;
		SinglyLinkedNode slow = head;
		SinglyLinkedNode fast = head;
		while(fast != null) {
			slow = slow.node;
			fast = fast.node;
			if(fast != null)
				fast = fast.node;
			if(slow == fast)
				return true;
		}
		return false;
	}
	
	public void removeDuplicates() {
		HashSet<String> hashSet = new HashSet<>();
		SinglyLinkedNode current = head;
		SinglyLinkedNode previous = null;
		while(current != null) {
			if(!hashSet.contains(current.data)) {
				hashSet.add(current.data);
				previous = current;
			} else {
				previous.node = current.node;
			}
			current = current.node;
		}
	}

	public SinglyLinkedNode getHead() {
		return head;
	}

	public void setHead(SinglyLinkedNode head) {
		this.head = head;
	}

	class SinglyLinkedNode implements Node {

		private String data;
		private SinglyLinkedNode node;

		public SinglyLinkedNode(String data) {
			this.data = data;
			this.node = null;
		}

		@Override
		public String getString() {
			return this.data;
		}

		public void setNode(SinglyLinkedNode node) {
			this.node = node;
		}

	}

}
