import java.util.*;

public class DriverProgram {

	public static void main(String[] args) {

		BinaryMaxHeap heap = new BinaryMaxHeap();

		System.out.println(heap.isEmpty());
		heap.insert(5);
		heap.insert(10);
		System.out.println(heap.getMax());
		heap.insert(2);
		System.out.println(heap.getMax());
		System.out.println(heap.deleteMax());
		System.out.println(heap.getMax());
	}
}