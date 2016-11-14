/*
* A simple implementation of Queue using LinkedList.
* author: ArvindRS
* date: 11/13/16
*/
public class QueueLinkedListImplementation<Type> {

	private Node first, last;

	private class Node {
		Type item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void enqueue(Type item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldLast.next = last;
	}

	public Type dequeue() {
		Type item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		return item;
	}
}