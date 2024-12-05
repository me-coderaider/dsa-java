package hashing.open_addressing;

import java.util.ArrayList;

public class QuadraticProbing {
	String[] hashTable;
	int usedCellNumber;

	// Constructor
	public QuadraticProbing(int size) {
		hashTable = new String[size];
		usedCellNumber = 0;
	}

	// HashFunction to be used on the Keys
	public int modASCIIHashFunction(String x, int M) {
		char[] ch = x.toCharArray();
		int i, sum;
		for (sum = 0, i = 0; i < x.length(); i++) {
			sum = sum + ch[i];
		}
		return sum % M;
	}

	// Returns LoadFactor of HashTable
	public double getLoadFactor() {
		return usedCellNumber * 1.0 / hashTable.length;
	}

	// Rehash
	public void rehashKeys(String newStringToBeInserted) {
		usedCellNumber = 0;
		ArrayList<String> data = new ArrayList<String>();
		for (String s : hashTable) {
			data.add(s);
		}
		data.add(newStringToBeInserted);
		hashTable = new String[hashTable.length * 2];

		for (String s : data) {
			insertKeyInHashTable(s);
		}

	}

	// insert()
	public void insertKeyInHashTable(String word) {
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) {
			rehashKeys(word);
		} else {
			int index = modASCIIHashFunction(word, hashTable.length);
			int counter = 0; // 'counter' will be used for QUADRATIC PROBING
			for (int i = index; i < index + hashTable.length; i++) {
				int newIndex = (index + (counter * counter)) % hashTable.length;
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println("\"" + word + "\" has been inserted successfully.");
					break;
				} else { // going to next cell
					System.out.println(newIndex + " is already occupied. Trying next one...");

				}
				counter++;
			}
		}
		usedCellNumber++;
	}

	// Display the HashTable
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
