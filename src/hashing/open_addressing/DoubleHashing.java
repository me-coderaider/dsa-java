package hashing.open_addressing;

import java.util.ArrayList;

public class DoubleHashing {

	String[] hashTable;
	int usedCellNumber;

	// Constructor
	public DoubleHashing(int size) {
		hashTable = new String[size];
		usedCellNumber = 0;
	}

	// HashFunction to be used on the Keys
	public int simpleASCIIHashFunction(String x, int M) {
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

	// Creates new HashTable and does Rehashing
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

	// helper() function for secondHashFunction
	private int addAllDigitsTogether(int sum) {
		int value = 0;
		while (sum > 0) {
			value = value + sum % 10;
			sum = sum / 10;
		}
		return value;
	}

	public int secondHashFunction(String x, int M) {
		char[] ch = x.toCharArray();
		int i, sum;
		for (sum = 0, i = 0; i < x.length(); i++) {
			sum += ch[i];
		}
		while (sum > hashTable.length) {
			sum = addAllDigitsTogether(sum);
		}
		return sum % M;
	}

	// insert()
	public void insertKeyInHashTable(String word) {
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) {
			rehashKeys(word);
		} else {
			int x = simpleASCIIHashFunction(word, hashTable.length);
			int y = secondHashFunction(word, hashTable.length);
			for (int i = 0; i < hashTable.length; i++) {
				int newIndex = (x + i * y) % hashTable.length;
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println("\"" + word + "\" has been inserted successfully at location:" + newIndex);
					break;
				} else { // going to next cell
					System.out.println(newIndex + " is already occupied. Trying next one...");
				}
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
		int index = simpleASCIIHashFunction(word, hashTable.length);
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
		int index = simpleASCIIHashFunction(word, hashTable.length);
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
