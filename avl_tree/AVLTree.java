
/*
 * Height balanced AVL Tree implementation.
 * @author: arvind-rs
 * @date: 02/25/2018
 */

import java.util.*;

class AVLTree<T extends Comparable<T>>  {

	// Root variable to reference the tree.
	private Node<T> root = null;

	// Node class implemented as an internal member of the AVLTree class for better encapsulation.
	private class Node<T extends Comparable<T>> {
		T data;
		Node<T> left, right;
		int height;
		public Node(T data) {
			this.data = data;
		}
		public int compareTo(Node<T> n) {
			return this.data.compareTo(n.data);
		}
	}

	// Method to check if the tree is empty.
	public boolean isEmpty() {
		return root == null;
	}

	// Method to add an element to the tree.
	public void add(T data) {
		Node<T> temp = new Node<T>(data);
		root = add(root, temp);
	}

	// Private overloaded add().
	private Node<T> add(Node<T> current, Node<T> temp) {
		// Add the data.
		if(current == null) return temp;
		else if(temp.data.compareTo(current.data) <= 0)
			current.left = add(current.left, temp);
		else
			current.right = add(current.right, temp);
		// Update the height and rebalance if necessary.
		current.height = 1 + getMaxHeight(current);
		current = rebalanceAt(current);
		return current;
	}

	// Method to delete an element from the tree.
	public void delete(T data) {
		root = delete(root, data);
	}

	// Private overloaded delete().
	private Node<T> delete(Node<T> current, T data) {
		// Delete the data.
		if(current == null) return current;
		else if(data.compareTo(current.data) < 0)
			current.left = delete(current.left, data);
		else if(data.compareTo(current.data) > 0)
			current.right = delete(current.right, data);
		else {
			if(current.left == null && current.right == null)
				current = null;
			else if(current.left == null)
				current = current.right;
			else if(current.right == null)
				current = current.left;
			else {
				Node<T> successor = findMin(current.right);
				current.data = successor.data;
				current.right = delete(current.right, successor.data);
			}
		}
		// Update the height and rebalance if necessary
		if(current == null) return current;
		current.height = 1 + getMaxHeight(current);
		current = rebalanceAt(current);
		return current;
	}

	// Method to find the minimum element from a given Node in the tree.
	private Node<T> findMin(Node<T> current) {
		while(current.left != null)
			current = current.left;
		return current;
	}

	// Method to get the max height upto the given Node.
	private int getMaxHeight(Node<T> current) {
		if(current.left == null && current.right == null)
			return 0;
		else if(current.left == null)
			return current.right.height;
		else if(current.right == null)
			return current.left.height;
		else
			return Math.max(current.left.height, current.right.height);
	}

	// Method to get the balance factor at a given Node
	private int balanceFactor(Node<T> current) {
		if(current.left == null && current.right == null)
			return 0;
		else if(current.left == null)
			return 0 - current.right.height;
		else if(current.right == null)
			return current.left.height - 0;
		else
			return current.left.height - current.right.height;
	}

	// Method to perform the rebalancing operation.
	private Node<T> rebalanceAt(Node<T> current) {
		int bf = balanceFactor(current);
		// If balance factor > 1 then the node is left heavy, else it's right heavy.
		if(bf > 1) {
			if(balanceFactor(current.left) >= 1)
				current = rotateRight(current);
			else {
				current.left = rotateLeft(current.left);
				current = rotateRight(current);
			}
		} else if(bf < -1) {
			if(balanceFactor(current.right) <= -1)
				current = rotateLeft(current);
			else {
				current.right = rotateRight(current.right);
				current = rotateLeft(current);
			}
		}
		return current;
	}

	// Method to perform Left rotation.
	private Node<T> rotateLeft(Node<T> current) {
		Node<T> newRoot;
		Node<T> orphan;
		if(current == null || current.right == null)
			return current;
		newRoot = current.right;
		orphan = newRoot.left;
		newRoot.left = current;
		current.right = orphan;
		current.height = 1 + getMaxHeight(current);
		newRoot.height = 1 + getMaxHeight(newRoot);
		return newRoot;
	}

	// Method to perform Right rotation.
	private Node<T> rotateRight(Node<T> current) {
		Node<T> newRoot;
		Node<T> orphan;
		if(current == null || current.left == null)
			return current;
		newRoot = current.left;
		orphan = newRoot.right;
		newRoot.right = current;
		current.left = orphan;
		current.height = 1 + getMaxHeight(current);
		newRoot.height = 1 + getMaxHeight(newRoot);
		return newRoot;
	}

	// Method to display the tree elements inorder.
	public void display() {
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> current = root;
		while(!stack.isEmpty() || current != null) {
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}
		System.out.println();
	}

	// Method to get the height of the tree
	public int getHeight() {
		if(isEmpty()) return -1;
		return root.height;
	}

	// Driver main method to test the code.
	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(5);
		System.out.println(tree.getHeight());
		tree.add(10);
		tree.add(1);
		System.out.println(tree.getHeight());
		tree.add(3);
		tree.display();
		System.out.println(tree.getHeight());
		tree.add(2);
		tree.display();
		System.out.println(tree.getHeight());
		tree.delete(3);
		tree.display();
		tree.delete(10);
		tree.display();
		tree.delete(5);
		tree.display();
		tree.delete(2);
		tree.display();
	}
}