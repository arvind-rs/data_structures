import java.util.*;

public class ArrayList {

	private static int[] array;
	private static int N;

	public ArrayList() {
		array = new int[1];
		N = 0;
	}

	public void add(int data) {

		if(N == array.length) resize(2 * array.length);
		array[N++] = data;
	}

	public void delete(int position) {
		if(N >= 0 && position < N) {
			int current = position;
			while(current < N - 1) {
				array[current] = array[current + 1];
				current++;
			}
			array[--N] = -1;
			if(N == array.length / 4) resize(array.length / 2);
		}
	}

	public int size() {
		return N;
	}

	public int actualSize() {
		return array.length;
	}

	public int get(int position) {
		if(position <= N)
			return array[position];
		else
			return -1;
	}

	public static void resize(int capacity) {
		int[] newArray = new int[capacity];
		for(int i = 0; i < N; i++)
			newArray[i] = array[i];
		array = newArray;
	}
}