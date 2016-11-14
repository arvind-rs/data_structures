/*
* Simple driver program to test the Stack implementations.
* author: ArvindRS
* date: 11/13/16
*/
public class DriverProgram {

	public static void main(String[] args) {

		StackLinkedListImplementation<String> stack = new StackLinkedListImplementation<String>();
		StackArrayImplementation stackArray = new StackArrayImplementation();

		String[] input = {"foo","bar","-","bar","-","dekho","-","-","bar","-"};

		System.out.println("List\tArray");
		for(int i=0;i<input.length;i++) {
			if(input[i].equals("-") && !stack.isEmpty() && !stackArray.isEmpty()) {
				System.out.println(stack.pop() + "\t" + stackArray.pop());
			}
			else {
				stack.push(input[i]);
				stackArray.push(input[i]);
			}
			System.out.println(stack.size() + "\t" + stackArray.size());
		}


	}
}