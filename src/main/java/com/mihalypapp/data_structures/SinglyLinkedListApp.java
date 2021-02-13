package com.mihalypapp.data_structures;

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
		list.addAt(4, "AddAt");
		list.addAt(0, "AddAt");
		//list.delete("AddAt");
		//list.remove("AddAt");
		list.addLast("last");
		list.remove("last");
		//list.removeDuplicates();
		list.print();
		
		SinglyLinkedList.Node node = list.contains("Fifth");
		System.out.println(node.getData());
		
		String[] array = list.toArray();
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println("\nhasLoop: " + list.hasLoop());
		System.out.println("-----");
		
		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list2.add("d");
		list2.add("e");
		list2.add("f");
		list2.add("g");
		list2.print();
		System.out.println("isPalindrome: " + list2.isPalindrome());
		System.out.println("size: " + list2.size());
		System.out.println("Middle element: " + list2.getMiddleNode());
		System.out.println("hasLoop: " + list2.hasLoop());
		list2.pairwiseSwap();
		list2.print();
		list2.removeDuplicates();
		list2.swap(0, list2.size() - 1);
		list2.print();
		System.out.println("\n-----");
		
		SinglyLinkedList list3 = new SinglyLinkedList();
		SinglyLinkedList.Node node1 = new SinglyLinkedList.Node("1");
		SinglyLinkedList.Node node2 = new SinglyLinkedList.Node("2");
		SinglyLinkedList.Node node3 = new SinglyLinkedList.Node("3");
		SinglyLinkedList.Node node4 = new SinglyLinkedList.Node("4");
		SinglyLinkedList.Node node5 = new SinglyLinkedList.Node("5");
		node1.setNode(node2);
		node2.setNode(node3);
		node3.setNode(node4);		// 1->2->3->4->5
		node4.setNode(node5);		//	  *        *
		node5.setNode(node2);
		list3.setHead(node1);
		System.out.println("hasLoop: " + list3.hasLoop());
		
		SinglyLinkedList list4 = new SinglyLinkedList();
		list4.addLast("f", 10, 100);
		list4.addLast("b", 12, 20);
		list4.addLast("g", 10, 160);
		list4.addLast("t", 12, 25);
		System.out.println(list4.getMaxWeigthGivenReps(list4.getHead(), 12));
		
		SinglyLinkedList a = new SinglyLinkedList();
		a.add("1");
		a.add("2");
		a.add("4");
		a.add("8");
		a.add("10");
		a.print();
		SinglyLinkedList b = new SinglyLinkedList();
		b.add("1");
		b.add("3");
		b.add("5");
		b.add("7");
		b.add("9");
		b.print();
		SinglyLinkedList c = SinglyLinkedList.merge(a, b);
		c.print();
	}

}
