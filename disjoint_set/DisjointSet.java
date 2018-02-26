
/*
 * Disjoint set implementation with Union-by-rank and path compression optimizations in Java.
 * @author: arvind-rs
 * @date: 02/25/2018
 */

import java.util.*;

class DisjointSet {
	// Parent array holds the set representative for each element.
	private int[] parent;
	// Rank array holds the supposed height of the abstract set tree.
	// Helps to keep the runtime for findSet() from becoming O(n).
	// This technique is called Union-by-rank.
	private int[] rank;
	// Variable to hold the number of elements in the set.
	private int N;

	// Public constructor. This will call the makeSet().
	public DisjointSet(int N) {
		this.N = N;
		parent = new int[N+1];
		rank = new int[N+1];
		makeSet();
	}

	// makeSet() method builds the set.
	private void makeSet() {
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	// Public method to perform the union of two set elements.
	// TC = O(alpha(n)), where alpha(n) is the inverse Ackermann function.
	// Runtime is amortized constant. SC = O(n).
	public void union(int x, int y) {
		// Find the set representatives for x and y elements.
		int setx = findSet(x);
		int sety = findSet(y);

		// Join the smaller set tree to the bigger set tree to keep the 
		// path length as small as possible. 
		if(rank[setx] < rank[sety])
			parent[setx] = sety;
		else if(rank[setx] > rank[sety])
			parent[sety] = setx;
		else {
			parent[sety] = setx;
			rank[setx]++;
		}
	}

	// findSet() is used to find the set representative of a given set element
	// This method also implements the path compression technique.
	// TC = O(alpha(x)), SC = O(1) [near constant because of path compression]
	public int findSet(int x) {
		if(parent[x] == x) return x;
		parent[x] = findSet(parent[x]);
		return parent[x];
	}

	// isIn() method is used to test set membership.
	public boolean isIn(int x, int y) {
		if(findSet(x) == findSet(y)) return true;
		else return false;
	}

	// countSets() is used to count the number of sets available.
	public int countSets() {
		int count = 0;
		for(int i = 1; i <= N; i++) {
			if(parent[i] == i)
				count++;
		}
		return count;
	}

	// Helper method to display the contents of the parent array.
	public void display() {
		for(int i = 1; i <= N; i++)
			System.out.print(parent[i] + " ");
		System.out.println();
	}

	// Driver main method to run the tests.
	public static void main(String[] args) {
		DisjointSet set = new DisjointSet(5);
		set.display();
		set.union(4,5);
		set.display();
		System.out.println(set.isIn(2,4));
		set.union(2,5);
		set.display();
		System.out.println(set.isIn(2,4));
		System.out.println(set.countSets());
	}
}