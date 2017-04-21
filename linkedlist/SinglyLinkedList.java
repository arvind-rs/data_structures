import java.util.*;

/*
* A simple implementation of LinkedList data structure in java
*/ 

public class SinglyLinkedList<T> {

	Node head;

	class Node<T> {
		T data;
		Node next;
	}

	public void insertAt(T data, int position) {
		Node temp = new Node<T>();
		temp.data = data;

		Node current = head;
		Node previous = null;
		int count = 0;
		while(current != null) {
			
			if(count == position)
				break;
			previous = current;
			current = current.next;
			count += 1;
		}
		temp.next = current;
		if(previous != null)
			previous.next = temp;
		if(head == null || position == 0)
			head = temp;
	}

	public void display() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void delete(T data) {
		Node current = head;
		Node previous = null;
		while(current != null) {
			if(current.data == data)
				break;
			previous = current;
			current = current.next;
		}
		if(current == null) {
			System.out.println("Error! List is empty or element not found!");
		}
		else {
			if(previous != null)
				previous.next = current.next;
			else
				head = current.next;
		}
	}

	public static void main(String[] args) {

		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

		list.insertAt(5,0);
		list.insertAt(10,0);
		list.insertAt(15,0);
		list.insertAt(20,1);
		list.display();

		list.delete(10);

		list.display();
	}


}
