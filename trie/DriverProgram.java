import java.util.*;

public class DriverProgram {

	public static void main(String[] args) {

		Trie trie = new Trie();

		trie.add("Hello");
		trie.add("world");
		trie.add("Hope");
		trie.depthFirstTraversal(trie.getRoot());

		System.out.println("Searching for word 'world':"+(trie.searchWord("world")?"Found!":"Not found!"));
		System.out.println("Searching for word 'work':"+(trie.searchWord("work")?"Found!":"Not found!"));
		System.out.println("Searching for word 'h':"+(trie.searchWord("h")?"Found!":"Not found!"));
		System.out.println("Searching for word 'H':"+(trie.searchWord("H")?"Found!":"Not found!"));
		System.out.println("Searching for word 'Hop':"+(trie.searchWord("Hop")?"Found!":"Not found!"));

		System.out.println("Searching for prefix 'world':"+(trie.searchPrefix("world")?"Found!":"Not found!"));
		System.out.println("Searching for prefix 'work':"+(trie.searchPrefix("work")?"Found!":"Not found!"));
		System.out.println("Searching for prefix 'h':"+(trie.searchPrefix("h")?"Found!":"Not found!"));
		System.out.println("Searching for prefix 'H':"+(trie.searchPrefix("H")?"Found!":"Not found!"));
		System.out.println("Searching for prefix 'Hop':"+(trie.searchPrefix("Hop")?"Found!":"Not found!"));
		trie.add("Hot");
		trie.add("Hotty");
		trie.depthFirstTraversal(trie.getRoot());
		System.out.println("Searching for word 'Hot':"+(trie.searchWord("Hot")?"Found!":"Not found!"));
		System.out.println("Searching for word 'Hotty':"+(trie.searchWord("Hotty")?"Found!":"Not found!"));
		trie.delete("Hot");
		System.out.println("Searching for word 'Hot':"+(trie.searchWord("Hot")?"Found!":"Not found!"));
		trie.depthFirstTraversal(trie.getRoot());
		trie.delete("Hotty");
		System.out.println("Searching for word 'Hotty':"+(trie.searchWord("Hotty")?"Found!":"Not found!"));
		trie.depthFirstTraversal(trie.getRoot());
		trie.delete("H");
		System.out.println("Searching for word 'H':"+(trie.searchWord("H")?"Found!":"Not found!"));
		trie.depthFirstTraversal(trie.getRoot());
		trie.delete("world");
		System.out.println("Searching for word 'world':"+(trie.searchWord("world")?"Found!":"Not found!"));
		trie.depthFirstTraversal(trie.getRoot());
	}
}