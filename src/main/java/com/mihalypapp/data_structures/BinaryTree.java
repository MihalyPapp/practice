package com.mihalypapp.data_structures;

import java.util.LinkedList;
import java.util.Queue;

import com.mihalypapp.data_structures.BinaryTree.Node.NodeAndHeight;

public class BinaryTree {

	private Node root;
	
	public void insert(int value) {	
		Node node = new Node(value);
		Node temp = root;

		if (root == null) {
			root = node;
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(temp);

		while (!queue.isEmpty()) {
			if (temp.left == null) {
				temp.left = node;
				break;
			} else {
				queue.add(temp.left);
			}

			if (temp.right == null) {
				temp.right = node;
				break;
			} else {
				queue.add(temp.right);
			}

			temp = queue.peek();
			queue.remove();
		}
	}

	public void deleteAndShrink(int value) {
		if(root == null) return;
		Node found = root.find(value);
		if (found == null) return;
		NodeAndHeight last = root.findLast(0);
		
		/*NodeAndHeight last = new NodeAndHeight();
		last.node = root;
		last.height = 0;
		root.findLast(last, 0);*/
		
		found.value = last.node.value;
		deleteNode(last.node);
	}

	/*
	 * public void deleteAndShrink(int value) { if (root == null) return;
	 * 
	 * Queue<Node> queue = new LinkedList<>(); queue.add(root); Node keyNode = null;
	 * Node current = null;
	 * 
	 * while (!queue.isEmpty()) { current = queue.peek(); if (current.value ==
	 * value) { keyNode = current; } if (current.left != null) {
	 * queue.add(current.left); } if (current.right != null) {
	 * queue.add(current.right); } queue.remove(); }
	 * 
	 * if (keyNode != null) { keyNode.value = current.value; deleteNode(root,
	 * current); } }
	 */

	private void deleteNode(Node node) {
		if (root == null)
			return;

		if (this.root == node) {
			this.root = null;
			return;
		}

		root.deleteChild(node);
	}

	/*
	 * private void deleteNode(Node node) { Queue<Node> queue = new LinkedList<>();
	 * queue.add(root); Node current = null;
	 * 
	 * while (!queue.isEmpty()) { current = queue.peek(); if (current == node) {
	 * root = null; return; } if (current.left != null) { if (current.left == node)
	 * { current.left = null; return; } queue.add(current.left); } if (current.right
	 * != null) { if (current.right == node) { current.right = null; return; }
	 * queue.add(current.right); } queue.remove(); } }
	 */

	public int height(Node root) {
		if (root == null)
			return 0;

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public void printlevelOrder() {
		for(int i = 1; i <= height(root); i++) {
			printLevel(root, i);
			System.out.println();
		}
 	}

	public void printLevel(Node root, int level) {
		if (root == null)
			return;

		if (level == 1) {
			System.out.print(root.value + " ");
		} else {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
		}
	}

	public void print(Node node) {
		if (node == null)
			return;
		print(node.left);
		System.out.print(node.value + " ");
		print(node.right);
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}

		private void deleteChild(Node node) {
			if (left == node) {
				left = null;
			} else if (right == node) {
				right = null;
			} else {
				if(left != null)
					left.deleteChild(node);
				if(right != null)
					right.deleteChild(node);
			}
		}

		public Node find(int value) {
			if (this.value == value)
				return this;

			Node found = null;
			if (left != null)
				found = left.find(value);
			if (found == null && right != null)
				found = right.find(value);
			return found;
		}

		public NodeAndHeight findLast(int currentHeight) {
			if (left == null && right == null) {
				NodeAndHeight result = new NodeAndHeight();
				result.node = this;
				result.height = currentHeight;
				return result;
			}

			if (left != null && right != null) {
				NodeAndHeight resultLeft = left.findLast(currentHeight + 1);
				NodeAndHeight resultRight = right.findLast(currentHeight + 1);
				if (resultLeft.height > resultRight.height) {
					return resultLeft;
				} else {
					return resultRight;
				}
			}

			if (left != null) {
				return left.findLast(currentHeight + 1);
			}

			return right.findLast(currentHeight + 1);
		}

		public void findLast(NodeAndHeight result, int currentHeight) {
			if (left == null && right == null) {
				if (result.height < currentHeight) {
					result.height = currentHeight;
					result.node = this;
				}
				return;
			}

			if (left != null)
				left.findLast(result, currentHeight + 1);

			if (right != null)
				right.findLast(result, currentHeight + 1);
		}

		public static class NodeAndHeight {
			public Node node;
			public int height;
		}
	}

}
