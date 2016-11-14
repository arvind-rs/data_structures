/*
* Simple driver program to test the Queue implementations.
* author: ArvindRS
* date: 11/13/16
*/
public class DriverProgram {

	public static void main(String[] args) {

		QueueLinkedListImplementation<String> queue = new QueueLinkedListImplementation<String>();

		String[] input = {"foo","bar","-","bar","-","dekho","-","-","bar","-"};

		for(int i=0;i<input.length;i++) {
			if(input[i].equals("-") && !queue.isEmpty()) {
				System.out.println(queue.dequeue());
			}
			else {
				queue.enqueue(input[i]);
			}
		}
	}
}