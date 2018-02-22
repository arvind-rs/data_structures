
/*
 * Hash table implemented using separate chaining for collision resolution.
 * @author: arvind-rs
 * @date: 01/13/2018
 */

import java.util.*;

class HashTableSC {

	private int capacity;
	private ArrayList<LinkedList<Pair>> table;

	public HashTableSC(int capacity) {
		this.capacity = capacity;
		this.table = new ArrayList<LinkedList<Pair>>(capacity);
		for(int i = 0; i < capacity; i++)
			table.add(new LinkedList<Pair>());
	}

	// Inner pair class
	private class Pair {
		String key;
		Integer value;
		public Pair(String key, Integer value) {
			this.key = key;
			this.value = value;
		}
	}

	// Hash function. Uses Horner's rule.
	private int hash(String key) {
		int value = 17;
		for(int i = 0; i < key.length(); i++)
			value = key.charAt(i) + (31 * value);
		return Math.abs(value % capacity);
	}

	// Put method
	public boolean put(String key, Integer value) {
		if(key == null) return false;
		int index = hash(key);
		for(int i = 0; i < table.get(index).size(); i++) {
			if(table.get(index).get(i).key.equals(key)) {
				table.get(index).get(i).value = value;
				return true;
			}
		}
		table.get(index).add(new Pair(key, value));
		return true;
	}

	// Get method
	public Integer get(String key) {
		if(key == null) return null;
		int index = hash(key);
		for(int i = 0; i < table.get(index).size(); i++) {
			if(table.get(index).get(i).key.equals(key))
				return table.get(index).get(i).value;
		}
		return null;
	}

	// Remove method
	public boolean remove(String key) {
		if(key == null) return false;
		int index = hash(key);
		for(int i = 0; i < table.get(index).size(); i++) {
			if(table.get(index).get(i).key.equals(key)) {
				table.get(index).remove(i);
				return true;
			}
		}
		return false;
	}

	// Main method
	public static void main(String[] args) {
		HashTableSC map = new HashTableSC(10);

		map.put("Goku",1);
		map.put("Naruto",2);
		map.put("Luffy",3);
		System.out.println("Luffy: " + map.get("Luffy"));
		map.remove("Luffy");
		System.out.println("Luffy: " + map.get("Luffy"));
		map.put("Ichigo",3);
		System.out.println("Naruto: " + map.get("Naruto"));
	}
}