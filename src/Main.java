import hashing.direct_chaining.DirectChaining;
import hashing.open_addressing.DoubleHashing;
import hashing.open_addressing.LinearProbing;
import hashing.open_addressing.QuadraticProbing;

class Main {

	public static void main(String[] args) {
		// Hashing -- Open Addressing -- Double Hashing
		DoubleHashing doubleHashing = new DoubleHashing(13);
		doubleHashing.insertKeyInHashTable("The");
		doubleHashing.insertKeyInHashTable("quick");
		doubleHashing.insertKeyInHashTable("brown");
		doubleHashing.insertKeyInHashTable("fox");
		doubleHashing.insertKeyInHashTable("over");
		doubleHashing.insertKeyInHashTable("lazy");
//		doubleHashing.displayHashTable();
		doubleHashing.searchHashTable("over");

		/*
		 * // Hashing -- Open Addressing -- Quadratic Probing QuadraticProbing
		 * quadraticProbing=new QuadraticProbing(13);
		 * quadraticProbing.insertKeyInHashTable("The");
		 * quadraticProbing.insertKeyInHashTable("quick");
		 * quadraticProbing.insertKeyInHashTable("brown");
		 * quadraticProbing.insertKeyInHashTable("fox");
		 * quadraticProbing.insertKeyInHashTable("over");
		 * quadraticProbing.insertKeyInHashTable("lazy"); //
		 * quadraticProbing.displayHashTable();
		 * quadraticProbing.searchHashTable("lazny");
		 */

		/*
		 * // Hashing -- Open Addressing -- Linear Probing LinearProbing
		 * linearProbing=new LinearProbing(13); linearProbing.insertInHashTable("The");
		 * linearProbing.insertInHashTable("quick");
		 * linearProbing.insertInHashTable("brown");
		 * linearProbing.insertInHashTable("fox");
		 * linearProbing.insertInHashTable("over");
		 * 
		 * // linearProbing.displayHashTable(); // linearProbing.searchHashTable("ox");
		 * linearProbing.deleteKeyHashTable("over"); linearProbing.displayHashTable();
		 */

		// Hashing -- Direct Chaining

		/*
		 * DirectChaining directChaining=new DirectChaining(15);
		 * directChaining.insertHashTable("The");
		 * directChaining.insertHashTable("quick");
		 * directChaining.insertHashTable("brown");
		 * directChaining.insertHashTable("fox");
		 * directChaining.insertHashTable("jumps");
		 * 
		 * directChaining.displayHashTable(); // directChaining.searchHashTable("fox");
		 * 
		 * directChaining.deleteKeyHashTable("fox"); directChaining.displayHashTable();
		 */

	}

}