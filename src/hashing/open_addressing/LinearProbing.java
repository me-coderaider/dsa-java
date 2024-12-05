package hashing.open_addressing;

import java.util.ArrayList;

public class LinearProbing {
	// creating a hashTable
	String[] hashTable;
	int usedCellNumber;

	public LinearProbing(int size) {
		hashTable = new String[size];
		usedCellNumber = 0;
	}

	// hash value calculation
	public int modASCIIHashFunction(String word, int M) {
		char ch[];
		ch = word.toCharArray();
		int i, sum;
		for (sum = 0, i = 0; i < word.length(); i++) {
			sum = sum + ch[i];
		}
		return sum % M;
	}

	// loadFactor calculation
	public double getLoadFactor() {
		double loadFactor = usedCellNumber * 1.0 / hashTable.length;
		return loadFactor;
	}

	// Rehashing
	public void rehashKeys(String word) {
		usedCellNumber = 0; // as we'll create a new HashTable again, so making it to 0
		ArrayList<String> data = new ArrayList<String>();
		for (String s : hashTable) {
			if (s != null) {
				data.add(s);
			}
		}
		data.add(word);
		hashTable = new String[hashTable.length * 2];
		for (String s : data) {
			// insert in new HashTable
			insertInHashTable(s);
		}
	}

	// Insert in new HashTable
	public void insertInHashTable(String word) {

		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) {
			rehashKeys(word);
		} else {
			int index = modASCIIHashFunction(word, hashTable.length);
			for (int i = index; i < index + hashTable.length; i++) {
				int newIndex = i % hashTable.length;
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println("The \"" + word + "\" successfully inserted at location: " + newIndex);
					break;
				} else {
					System.out.println(newIndex + " is already occupied. Trying next empty cell.");
				}
			}
		}
		usedCellNumber++;
	}

	// display() hashtable
	public void displayHashTable() {
		if (hashTable == null) {
			System.out.println("HashTable does not exist.");
			return;
		} else {
			System.out.println("-----------------HashTable------------------");
			for (int i = 0; i < hashTable.length; i++) {
				System.out.println("Index " + i + ", Key:" + hashTable[i]);
			}
		}
	}

	// search()
	public boolean searchHashTable(String word) {
		int index = modASCIIHashFunction(word, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {

			int newIndex = i % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				System.out.println("\"" + word + "\" found at location: " + newIndex);
				return true;
			}
		}
		System.out.println("\"" + word + "\" not found in HashTable");
		return false;
	}

	// delete()
	public void deleteKeyHashTable(String word) {
		int index = modASCIIHashFunction(word, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				hashTable[newIndex] = null;
				System.out.println("\"" + word + "\" has been deleted from HashTable");
				return;
			}
		}
		System.out.println("\"" + word + "\" not found in HashTable");
	}
}
