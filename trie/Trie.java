import java.util.*;

public class Trie {

	public Node root;

	public Trie() {
		root = new Node();
	}

	class Node {

		char character;
		boolean isLeaf;
		HashMap<Character,Node> children = new HashMap<Character,Node>();
	}

	public Node getRoot() {
		return root;
	}

	public void add(String word) {
		HashMap<Character,Node> children = root.children;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Node temp;
			if(children.containsKey(c))
				temp = children.get(c);
			else {
				temp = new Node();
				temp.character = c;
				children.put(c,temp);
			}
			children = temp.children;
			if(i == word.length() - 1)
				temp.isLeaf = true;
		}
	}

	public void depthFirstTraversal(Node current) {
		if(current == null) {
			return;
		}
		else {
			System.out.print(current.character);
			if(current.isLeaf)
				System.out.println();
			for(char c : current.children.keySet())
				depthFirstTraversal(current.children.get(c));
		}
	}

	public boolean searchWord(String word) {
		Node temp = search(word);
		if(temp != null && temp.isLeaf)
			return true;
		else
			return false;
	}

	public boolean searchPrefix(String word) {
		Node temp = search(word);
		if(temp == null)
			return false;
		else
			return true;
	}

	public Node search(String word) {
		HashMap<Character,Node> children = root.children;
		Node temp = null;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(children.containsKey(c)) {
				temp = children.get(c);
				children = temp.children;
			}
			else
				return null;
		}
		return temp;
	}

	public void delete(String word) {
		if(word.length() == 0)
			return;
		HashMap<Character,Node> children = root.children;
		Node forkNode = root;
		char forkChar = word.charAt(0);
		Node temp = root;
		for(int i = 0; i < word.length() - 1; i++) {
			char c = word.charAt(i);
			if(children.containsKey(c)) {
				temp = children.get(c);
				if(temp.children.size() > 1) {
					forkNode = temp;
					forkChar = word.charAt(i + 1);
				}
				children = temp.children;
			}
			else {
				System.out.println("No such word!");
				return;
			}
		}
		temp = children.get(word.charAt(word.length() - 1));
		if(temp.isLeaf && temp.children.size() == 0) {
			forkNode.children.remove(forkChar);
		}
		else if(temp.isLeaf && temp.children.size() > 0) {
			temp.isLeaf = false;
		}
	}
}