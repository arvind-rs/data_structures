/*
* A simple implementation of Stack using resizing arrays.
* author: ArvindRS
* date: 11/13/16
*/
public class StackArrayImplementation {

	private String[] s;
	private int N = 0;

	StackArrayImplementation() {
		s = new String[1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public String top() {
		return s[N-1];
	}

	public void push(String item) {
		if(N == s.length) resize(2 * s.length);
		s[N++] = item;
	}

	public String pop() {
		String item = s[--N];
		s[N] = null;
		if(N > 0 && N == s.length/4) resize(s.length/2);
		return item;
	}

	private void resize(int capacity) {
		String[] newS = new String[capacity];
		for(int i = 0; i < N; i++)
			newS[i] = s[i];
		s = newS;
	}
}