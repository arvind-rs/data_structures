

public class DriverProgram {

	public static void main(String args[]) {

		StackLinkedListImplementation stack = new StackLinkedListImplementation();

		String[] input = {"foo","bar","-","bar","-","dekho","-","-","bar","-"};

		for(int i=0;i<input.length;i++) {
			if(input[i].equals("-") && !stack.isEmpty())
				System.out.println(stack.pop());
			else
				stack.push(input[i]);
			System.out.println(stack.size());
		}


	}
}