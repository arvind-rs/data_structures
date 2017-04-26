import java.util.*;

public class DisjointUnionSet {

	int[] parent;
	int[] rank;
	int N;

	DisjointUnionSet(int N) {
		this.N = N;
		parent = new int[N];
		rank = new int[N];
		makeSet();
	}

	private void makeSet() {
		for(int i = 0; i < N; i++)
			parent[i] = i;
	}

	public int getTotalMemberCount() {
		return N;
	}

	public void union(int a, int b) {

		int aRep = find(a);
		int bRep = find(b);

		if(aRep == bRep)
			return;

		if(rank[aRep] > rank[bRep])
			parent[bRep] = aRep;
		else if(rank[bRep] > rank[aRep])
			parent[aRep] = bRep;
		else {
			parent[bRep] = aRep;
			rank[aRep]++;
		}
	}

	public int find(int a) {
		if(parent[a] == a)
			return parent[a];
		return parent[a] = find(parent[a]);
	}

	public void display() {
		for(int i = 0; i < parent.length; i++)
			System.out.print(parent[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		DisjointUnionSet set = new DisjointUnionSet(5);

		set.display();
		set.union(2,3);
		set.union(1,4);
		set.display();
		set.union(0,1);
		set.display();
		set.union(3,4);
		set.display();

	}
}