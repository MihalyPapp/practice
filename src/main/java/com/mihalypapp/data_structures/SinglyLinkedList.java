package com.mihalypapp.data_structures;

import java.util.HashSet;
import java.util.Stack;

public class SinglyLinkedList {

	private Node head;

	public void addFirst(String string) {
		Node newNode = new Node(string);
		newNode.next = head;
		head = newNode;
	}
	
	public void add(String string) {
		addLast(string);
	}
	
	public void add(String string, int rep, int weigth) {
		addLast(string, rep, weigth);
	}
	
	public void addLast(String string) {
		Node newNode = new Node(string);
		addLast(newNode);
	}
	
	public void addLast(String string, int reps, int weight) {
		Node newNode = new Node(string, reps, weight);
		addLast(newNode);
	}
	
	public void addLast(Node newNode) {

		if (head == null) {
			head = newNode;
			return;
		}

		Node last = head;
		while (last.next != null) {
			last = last.next;
		}

		last.next = newNode;
	}

	public void addAt(int pos, String string) {
		Node newNode = new Node(string);

		if (head == null && pos > 0) {
			throw new ArrayIndexOutOfBoundsException();
		}

		if (pos == 0) {
			addFirst(string);
			return;
		}

		Node current = head;
		Node previous = null;
		int i = 0;

		while (i < pos) {
			if (pos - i == 1) {
				previous = current;
			}
			current = current.next;
			i++;
		}

		newNode.next = current;
		previous.next = newNode;
	}

	public int size() {
		Node current = head;
		int size = 0;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	public String getMiddleNode() {
		int i = 0;
		Node current = head;
		Node middle = head;
		while (current != null) {
			if (i % 2 == 1) {
				middle = middle.next;
			}
			++i;
			current = current.next;
		}
		return middle.data;
	}

	public Node contains(String string) {
		Node current = head;
		while (current != null) {
			if (current.data.equals(string)) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	public void remove(String string) {
		Node current = head;
		Node previous = null;

		if (head != null && head.data.equals(string)) {
			head = head.next;
			return;
		}

		while (current != null && !current.data.equals(string)) {
			previous = current;
			current = current.next;
			;
		}

		if (previous.next == null)
			return;

		previous.next = current.next;
	}

	public String[] toArray() {
		int length = 0;
		Node current = head;
		while (current != null) {
			length++;
			current = current.next;
		}
		String[] array = new String[length];
		int i = 0;
		current = head;
		while (current != null) {
			array[i] = current.data;
			current = current.next;
			i++;
		}
		return array;
	}

	public boolean isPalindrome() {
		Stack<String> stack = new Stack<>();
		Node current = head;
		while (current != null) {
			stack.push(current.data);
			current = current.next;
		}
		current = head;
		while (current != null) {
			if (!stack.pop()
					.equals(current.data)) {
				return false;
			}
			current = current.next;
		}

		return true;
	}

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + ", ");
			current = current.next;
		}
		System.out.println();
	}

	public boolean hasLoop() {
		if (head == null || head.next == null)
			return false;
		Node slow = head;
		Node fast = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	public void removeDuplicates() {
		HashSet<String> hashSet = new HashSet<>();
		Node current = head;
		Node previous = null;
		while (current != null) {
			if (!hashSet.contains(current.data)) {
				hashSet.add(current.data);
				previous = current;
			} else {
				previous.next = current.next;
			}
			current = current.next;
		}
	}

	public void swap(int pos1, int pos2) {
		int i = 0;
		Node current = head;
		Node node1 = null;
		Node node1_prev = null;
		Node node2 = null;
		Node node2_prev = null;
		while (current != null) {
			if (i == pos1 - 1)
				node1_prev = current;
			if (i == pos1)
				node1 = current;
			if (i == pos2 - 1)
				node2_prev = current;
			if (i == pos2)
				node2 = current;
			current = current.next;
			i++;
		}
		if (node1 == null || node2 == null)
			return;
		System.out.println(node1.data + " + " + node2.data);

		if (node1_prev == null)
			head = node2;
		else
			node1_prev.next = node2;

		if (node2_prev == null)
			head = node1;
		else
			node2_prev.next = node1;

		Node temp = node1.next;
		node1.next = node2.next;
		node2.next = temp;
	}
	
	public void pairwiseSwap() {
		if (head == null || head.next == null)
			return;
		Node previous = head;
		Node current = head.next;
		head = current;
		while (current != null) {
			Node temp = current.next;
			current.next = previous;
			if(temp.next == null) {
				previous.next = temp;
				break;
			}
			previous.next = temp.next;
			previous = temp;
			current = previous.next;
		}
	}
	
	public static SinglyLinkedList merge(SinglyLinkedList a, SinglyLinkedList b) {
		SinglyLinkedList resultList = new SinglyLinkedList();
		Node node1 = a.getHead();
		Node node2 = b.getHead();
		Node result = new Node();
		resultList.setHead(result);
		while(node1 != null || node2 != null) {
			if(node1 == null) {
				result.next = node2;
				break;
			}
			if(node2 == null) {
				result.next = node1;
				break;
			}
			
			if(Integer.valueOf(node1.getData()) <= Integer.valueOf(node2.getData())) {
				result.next = node1;
				node1 = node1.next;
			} else {
				result.next = node2;
				node2 = node2.next;
			}
			result = result.next;
		}
		resultList.setHead(resultList.getHead().next);
		return resultList;
	}
	
	public int getMaxWeigthGivenReps(Node list, int givenReps) {
		if(list == null) return -1;
		int maxWeight = 0;
		Node current = list.getNext();
		while(current != null) {
			if(current.getWeight() > maxWeight && current.getReps() == givenReps) {
				maxWeight = current.getWeight();
			}
			current = current.getNext();
		}
		return maxWeight;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	static class Node implements TrainingDairy {

		private int reps;
		private int weigth;
		private String data;
		private Node next;
		
		public Node getNext() {
			return next;
		}
		
		public Node() {
			this.next = null;
		}
		
		public Node(String data) {
			this.data = data;
			this.next = null;
		}
		
		public Node(String data, int reps, int weight) {
			this.data = data;
			this.reps = reps;
			this.weigth = weight;
			this.next = null;
		}

		public String getData() {
			return this.data;
		}

		public void setNode(Node node) {
			this.next = node;
		}

		@Override
		public int getReps() {
			return reps;
		}

		@Override
		public int getWeight() {
			return weigth;
		}		

	}
	
	interface TrainingDairy {

		int getReps();

		int getWeight();

	}

}
















