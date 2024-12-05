import trie.Trie;

class Main {

	public static void main(String[] args) {
		// Trie

		Trie newTrie = new Trie();
		newTrie.insert("API");
		newTrie.insert("APIS");
		
		newTrie.search("APIS");
		
		newTrie.delete("API");
		
		newTrie.search("API");
	}

}