package com.mihalypapp.data_structures;

import com.mihalypapp.data_structures.SinglyLinkedList.SinglyLinkedNode;

public class SinglyLinkedListApp {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add("First");
		list.add("Second");
		list.add("Third");
		//list.delete("Third");
		list.addLast("Fourth");
		list.remove("something");
		list.add("Fifth");
		list.add(4, "AddAt");
		list.add(0, "AddAt");
		//list.delete("AddAt");
		//list.remove("AddAt");
		list.addLast("last");
		list.remove("last");
		//list.removeDuplicates();
		list.print();
		
		SinglyLinkedNode node = list.contains("Fifth");
		System.out.println(node.getString());
		
		String[] array = list.toArray();
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println("\nhasLoop: " + list.hasLoop());
		System.out.println("-----");
		
		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.add("a");
		list2.add("b");
		list2.add("a");
		list2.add("d");
		list2.add("a");
		list2.add("b");
		list2.add("a");
		list2.print();
		System.out.println("isPalindrome: " + list2.isPalindrome());
		System.out.println("size: " + list2.size());
		System.out.println("Middle element: " + list2.getMiddleNode());
		System.out.println("hasLoop: " + list2.hasLoop());
		list2.removeDuplicates();
		list2.print();
		System.out.println("\n-----");
		
		SinglyLinkedList list3 = new SinglyLinkedList();
		SinglyLinkedNode node1 = list3.new SinglyLinkedNode("1");
		SinglyLinkedNode node2 = list3.new SinglyLinkedNode("2");
		SinglyLinkedNode node3 = list3.new SinglyLinkedNode("3");
		SinglyLinkedNode node4 = list3.new SinglyLinkedNode("4");
		SinglyLinkedNode node5 = list3.new SinglyLinkedNode("5");
		node1.setNode(node2);
		node2.setNode(node3);
		node3.setNode(node4);		// 1->2->3->4->5
		node4.setNode(node5);		//	  *        *
		node5.setNode(node2);
		list3.setHead(node1);
		System.out.println("hasLoop: " + list3.hasLoop());
	}

}
