package hashing.direct_chaining;

import java.util.LinkedList;

public class DirectChaining {
	LinkedList<String>[] hashTable; // array of linkedList
	int maxChainSize = 5;

	public DirectChaining(int size) {
		hashTable = new LinkedList[size];
	}

	// HashFunction
	public int modASCIIHashFunction(String word, int M) {
		char ch[];
		ch = word.toCharArray();
		int i, sum;
		for (sum = 0, i = 0; i < word.length(); i++) {
			sum = sum + ch[i];
		}
		return sum % M;
	}

	// insert() new words
	public void insertHashTable(String word) {
		int newIndex = modASCIIHashFunction(word, hashTable.length);

		if (hashTable[newIndex] == null) {
			hashTable[newIndex] = new LinkedList<String>();
			hashTable[newIndex].add(word);
		} else {
			hashTable[newIndex].add(word);
		}
	}

	// display
	public void displayHashTable() {
		if (hashTable == null) {
			System.out.println("HashTable does not exist.");
			return;
		} else {
			System.out.println("-----------HashTable-------------");
			for (int i = 0; i < hashTable.length; i++) {
				System.out.println("Index " + i + ", key:" + hashTable[i]);
			}
		}
	}

	// search()
	public boolean searchHashTable(String word) {
		int newIndex = modASCIIHashFunction(word, hashTable.length); // finding hash-value of the string

		if (hashTable[newIndex] != null && hashTable[newIndex].contains(word)) {
			System.out.println("\"" + word + "\" found in the HashTable at location: " + newIndex);
			return true;
		} else {
			System.out.println("\"" + word + "\" not found in the HashTable");
			return false;
		}
	}

	// delete
	public void deleteKeyHashTable(String word) {
		int newIndex = modASCIIHashFunction(word, hashTable.length); // finding hash-value of the string
		boolean result = searchHashTable(word);

		if (result == true) {
			hashTable[newIndex].remove(word);
			System.out.println("\"" + word + "\" has been delete from the HashTable");
		} // false cases will be taken care of by the search() function.
	}
}
