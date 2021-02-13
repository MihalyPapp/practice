package com.mihalypapp.data_structures;

public class DoublyLinkedApp {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.print();
		System.out.println("Size: " + list.size() + "\n");
		
		list.add(5);	
		list.addFirst(6);	
		list.insertAt(0, 4);		
		list.insertAt(1, 1);	
		list.add(5);
		list.insertAt(3, 3);
		list.print();
		
		System.out.println("	Swapping 5nd elements from both sides");
		list.swapNode(5);
		list.print();
		System.out.println("Size: " + list.size() + "\n");
		
		list.insertAt(6, 3);
		list.delete(0);
		list.delete(5);
		list.delete(2);
		list.print();
		
		System.out.println("	Reversing");
		list.reverse();
		list.print();
		
		System.out.println("	Swapping 3th elements from both sides");
		list.swapNode(3);
		list.print();
		System.out.println("Size: " + list.size() + "\n");
	}
	
}
