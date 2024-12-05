package trie;

public class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode();
		System.out.println("The Trie has been created.");
	}

	// insert()
	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			TrieNode node = current.children.get(ch);
			if (node == null) { // means this 'character' is not present && we have to create a new TrieNode
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfString = true;
		System.out.println("Successfully inserted " + word + " in Trie.");
	}

	// search for a word in Trie
	public boolean search(String word) {
		TrieNode currentNode = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			TrieNode node = currentNode.children.get(ch);
			if (node == null) { // word does not exist in trie
				System.out.println("Word: " + word + " does not exist in Trie.");
				return false;
			}

			currentNode = node;
		}
		// out of loop, means all characters of word exists in Trie
		// Now, let's check 'endOfString' to make sure that it is entire string or some
		// prefix
		if (currentNode.endOfString == true) {
			System.out.println("Word: " + word + " exists in the Trie.");
			return true;
		} else {
			System.out.println("Word: " + word + " exists in the Trie. But it is a prefix of another string.");
		}
		return currentNode.endOfString;
	}

	// delete a string from 'Trie' -- helper for delete()
	private boolean delete(TrieNode parentNode, String word, int index) {
		char ch = word.charAt(index);

		TrieNode currentNode = parentNode.children.get(ch);
		boolean canThisNodeBeDeleted;

		// NOTE -- children.size() is checking that how many characters we've have in
		// the MAP
		if (currentNode.children.size() > 1) { // case 1::
			delete(currentNode, word, index + 1);
			return false;
		}

		if (index == word.length() - 1) { // case 2:
			if (currentNode.children.size() >= 1) {
				currentNode.endOfString = false;
				return false;
			} else {
				parentNode.children.remove(ch);
				return true;
			}
		}

		if (currentNode.endOfString == true) { // case 3:
			delete(currentNode, word, index + 1);
			return false;
		}

		canThisNodeBeDeleted = delete(currentNode, word, index + 1);
		if (canThisNodeBeDeleted == true) {
			parentNode.children.remove(ch);
			return true;
		} else {
			return false;
		}
	}

	public void delete(String word) {
		if(search(word)==true) { // if word exists only then we're going to delete
			delete(root, word, 0);
		}
	}
}
