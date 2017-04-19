import java.util.*;

public class DriverProgram {

	public static void main(String[] args) {

		ArrayList array = new ArrayList();
		array.add(5);
		System.out.println(array.actualSize());
		array.add(10);
		System.out.println(array.actualSize());
		array.add(15);
		System.out.println(array.actualSize());
		array.add(5);
		System.out.println(array.actualSize());
		array.add(25);
		System.out.println(array.actualSize());
		array.add(25);
		System.out.println(array.actualSize());
		array.add(35);
		System.out.println(array.actualSize());
		array.add(45);
		System.out.println(array.actualSize());

		System.out.println();
		for(int i = 0; i < array.size(); i++)
			System.out.println(array.get(i));

		System.out.println();
		array.delete(5);
		array.delete(3);
		array.delete(5);
		array.delete(2);
		//array.delete(1);
		//array.delete(1);
		System.out.println(array.actualSize());
		array.delete(1);
		array.delete(1);
		System.out.println(array.actualSize());
		for(int i = 0; i < array.size(); i++)
			System.out.println(array.get(i));
		System.out.println(array.actualSize());

	}
}