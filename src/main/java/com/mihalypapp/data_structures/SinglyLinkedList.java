package com.mihalypapp.data_structures;

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
	
	public void add(String string, int rep, int weigth) {
		addLast(string, rep, weigth);
	}
	
	public void addLast(String string) {
		SinglyLinkedNode newNode = new SinglyLinkedNode(string);
		addLast(newNode);
	}
	
	public void addLast(String string, int reps, int weight) {
		SinglyLinkedNode newNode = new SinglyLinkedNode(string, reps, weight);
		addLast(newNode);
	}
	
	public void addLast(SinglyLinkedNode newNode) {

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
		
	public int getMaxWeigthGivenReps(SinglyLinkedNode list, int givenReps) {
		if(list == null) return -1;
		int maxWeight = 0;
		SinglyLinkedNode current = list.getNext();
		while(current != null) {
			if(current.getWeight() > maxWeight && current.getReps() == givenReps) {
				maxWeight = current.getWeight();
			}
			current = current.getNext();
		}
		return maxWeight;
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
		while (current != null) {
			size++;
			current = current.node;
		}
		return size;
	}

	public String getMiddleNode() {
		int i = 0;
		SinglyLinkedNode current = head;
		SinglyLinkedNode middle = head;
		while (current != null) {
			if (i % 2 == 1) {
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
			current = current.node;
			;
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
		while (current != null) {
			array[i] = current.data;
			current = current.node;
			i++;
		}
		return array;
	}

	public boolean isPalindrome() {
		Stack<String> stack = new Stack<>();
		SinglyLinkedNode current = head;
		while (current != null) {
			stack.push(current.data);
			current = current.node;
		}
		current = head;
		while (current != null) {
			if (!stack.pop()
					.equals(current.data)) {
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
		if (head == null || head.node == null)
			return false;
		SinglyLinkedNode slow = head;
		SinglyLinkedNode fast = head;
		while (fast != null) {
			slow = slow.node;
			fast = fast.node;
			if (fast != null)
				fast = fast.node;
			if (slow == fast)
				return true;
		}
		return false;
	}

	public void removeDuplicates() {
		HashSet<String> hashSet = new HashSet<>();
		SinglyLinkedNode current = head;
		SinglyLinkedNode previous = null;
		while (current != null) {
			if (!hashSet.contains(current.data)) {
				hashSet.add(current.data);
				previous = current;
			} else {
				previous.node = current.node;
			}
			current = current.node;
		}
	}

	public void swap(int pos1, int pos2) {
		int i = 0;
		SinglyLinkedNode current = head;
		SinglyLinkedNode node1 = null;
		SinglyLinkedNode node1_prev = null;
		SinglyLinkedNode node2 = null;
		SinglyLinkedNode node2_prev = null;
		while (current != null) {
			if (i == pos1 - 1)
				node1_prev = current;
			if (i == pos1)
				node1 = current;
			if (i == pos2 - 1)
				node2_prev = current;
			if (i == pos2)
				node2 = current;
			current = current.node;
			i++;
		}
		if (node1 == null || node2 == null)
			return;
		System.out.println(node1.data + " + " + node2.data);

		if (node1_prev == null)
			head = node2;
		else
			node1_prev.node = node2;

		if (node2_prev == null)
			head = node1;
		else
			node2_prev.node = node1;

		SinglyLinkedNode temp = node1.node;
		node1.node = node2.node;
		node2.node = temp;
	}
	
	public void pairwiseSwap() {
		if (head == null || head.node == null)
			return;
		SinglyLinkedNode previous = head;
		SinglyLinkedNode current = head.node;
		head = current;
		while (current != null) {
			SinglyLinkedNode temp = current.node;
			current.node = previous;
			if(temp.node == null) {
				previous.node = temp;
				break;
			}
			previous.node = temp.node;
			previous = temp;
			current = previous.node;
		}
	}
	
	public static SinglyLinkedList merge(SinglyLinkedList a, SinglyLinkedList b) {
		SinglyLinkedList resultList = new SinglyLinkedList();
		SinglyLinkedNode node1 = a.getHead();
		SinglyLinkedNode node2 = b.getHead();
		SinglyLinkedNode result = new SinglyLinkedNode();
		resultList.setHead(result);
		while(node1 != null || node2 != null) {
			if(node1 == null) {
				result.node = node2;
				break;
			}
			if(node2 == null) {
				result.node = node1;
				break;
			}
			
			if(Integer.valueOf(node1.getString()) <= Integer.valueOf(node2.getString())) {
				result.node = node1;
				node1 = node1.node;
			} else {
				result.node = node2;
				node2 = node2.node;
			}
			result = result.node;
		}
		resultList.setHead(resultList.getHead().node);
		return resultList;
	}

	public SinglyLinkedNode getHead() {
		return head;
	}

	public void setHead(SinglyLinkedNode head) {
		this.head = head;
	}

	static class SinglyLinkedNode implements Node, TrainingDairy {

		private int reps;
		private int weigth;
		private String data;
		private SinglyLinkedNode node;
		
		public SinglyLinkedNode getNext() {
			return node;
		}
		
		public SinglyLinkedNode() {
			this.node = null;
		}
		
		public SinglyLinkedNode(String data) {
			this.data = data;
			this.node = null;
		}
		
		public SinglyLinkedNode(String data, int reps, int weight) {
			this.data = data;
			this.reps = reps;
			this.weigth = weight;
			this.node = null;
		}

		@Override
		public String getString() {
			return this.data;
		}

		public void setNode(SinglyLinkedNode node) {
			this.node = node;
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
















