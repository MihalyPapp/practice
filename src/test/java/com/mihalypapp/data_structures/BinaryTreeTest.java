package com.mihalypapp.data_structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

	BinaryTree tree;
	
	@BeforeEach
	void init() {
		tree = new BinaryTree();
	}
	
	// TODO
	@Test
	void test() {
		BinaryTree.Node root = new BinaryTree.Node(10);
        root.left = new BinaryTree.Node(11);
        root.left.left = new BinaryTree.Node(7);
        root.right = new BinaryTree.Node(9);
        root.right.left = new BinaryTree.Node(15);
        root.right.right = new BinaryTree.Node(8);
		tree.setRoot(root);
		tree.print(tree.getRoot());
		tree.insert(12);
		System.out.println();
		tree.print(tree.getRoot());
		tree.deleteAndShrink(12);
		System.out.println();
		tree.print(tree.getRoot());
		System.out.println();
		System.out.println();
		
		tree.printlevelOrder();
	}

}
