/*
* A simple implementation of Stack using LinkedList.
* author: ArvindRS
* date: 11/13/16
*/
public class StackLinkedListImplementation<Type> {

	private Node first = null;
	private int N = 0;

	private class Node {
		Type item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null; 
	}

	public void push(Type item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	public Type pop() {
		Type item = first.item;
		Node newFirst = first.next;
		first = newFirst;
		N--;
		return item;
	}

	public Type top() {
		return first.item;
	}

	public int size() {
		return N;
	}
}