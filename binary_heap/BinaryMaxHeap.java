
public class BinaryMaxHeap {

	int[] heap = new int[1];
	int N = 0;

	public void insert(int data) {

		if(N == heap.length - 1) resize(heap.length * 2);
		heap[++N] = data;
		swim(N);
	}

	private void swim(int k) {

		while(k > 1 && heap[k] > heap[k / 2]) {
			int j = k / 2;
			swap(k,j);
			k = j;
		}
	}

	public int deleteMax() {
		int data = heap[1];
		swap(1,N);
		heap[N--] = -9999;
		sink(1);
		if(N > 0 && N == heap.length / 4) resize(heap.length / 2);
		return data;
	}

	private void sink(int k) {

		while(2 * k <= N && heap[k] < heap[2 * k]) {
			int j = 2 * k;
			if(j < N && heap[j] < heap[j + 1]) j++;
			swap(k,j);
			k = j;
		}
	}

	public int getMax() {
		return heap[1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void display() {
		for(int i = 1; i <= N; i++)
			System.out.print(heap[i] + " ");
	}

	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp; 
	}

	private void resize(int capacity) {
		int[] copy = new int[capacity];
		for(int i = 0; i < heap.length; i++)
			copy[i] = heap[i];
		heap = copy;
	}

	public static void main(String[] args) {

		BinaryMaxHeap heap = new BinaryMaxHeap();

		heap.insert(5);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);

		System.out.println(heap.getMax());

		heap.display();

		heap.deleteMax();

		System.out.println(heap.getMax());

		heap.display();
	}
}