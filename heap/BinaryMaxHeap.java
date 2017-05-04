
public class BinaryMaxHeap {

	int[] a = new int[1];
	int N = 0;

	public void insert(int key) {

		if(N == a.length - 1) resize(2 * a.length);
		a[++N] = key;
		swim(N);
	}

	private void swim(int k) {
		while(k > 1 && a[k/2] < a[k]) {
			swap(k,k/2);
			k = k / 2;
		}
	}

	public int deleteMax() {
		
		int max = a[1];
		swap(1,N);
		a[N] = -99;
		N--;
		sink(1);
		if(N > 0 && N == a.length/4) resize(a.length/2);
		return max;

	}

	private void sink(int k) {

		while(2*k <= N) {
			int j = 2 * k;
			if(j < N && a[j] < a[j+1]) j++;
			if(a[k] > a[j]) break;
			swap(k,j);
			k = j;
		}

	}

	private void swap(int i,int j) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	private void resize(int capacity) {

		int[] copy = new int[capacity];
		for(int i=0;i<a.length;i++)
			copy[i] = a[i];
		a = copy;

	}

	public boolean isEmpty() {

		return N == 0;

	}

	public int getMax() {

		return a[1];
	}
}