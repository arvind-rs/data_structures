/*
* A simple implementation of Stack using LinkedList.
* author: ArvindRS
* date: 11/13/16
*/
public class StackLinkedListImplementation {

	private Node first = null;
	private int N = 0;

	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null; 
	}

	public void push(String item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	public String pop() {
		String item = first.item;
		Node newFirst = first.next;
		first = newFirst;
		N--;
		return item;
	}

	public String top() {
		return first.item;
	}

	public int size() {
		return N;
	}
}