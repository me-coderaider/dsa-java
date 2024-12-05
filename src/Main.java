import hashing.direct_chaining.DirectChaining;
import hashing.open_addressing.LinearProbing;

class Main {

	public static void main(String[] args) {
		// Hashing -- Open Addressing -- Linear Probing
		LinearProbing linearProbing=new LinearProbing(13);
		linearProbing.insertInHashTable("The");
		linearProbing.insertInHashTable("quick");
		linearProbing.insertInHashTable("brown");
		linearProbing.insertInHashTable("fox");
		linearProbing.insertInHashTable("over");
		
//		linearProbing.displayHashTable();
//		linearProbing.searchHashTable("ox");
		linearProbing.deleteKeyHashTable("over");
		linearProbing.displayHashTable();
		
		
		// Hashing -- Direct Chaining
		
		/*
		DirectChaining directChaining=new DirectChaining(15);
		directChaining.insertHashTable("The");
		directChaining.insertHashTable("quick");
		directChaining.insertHashTable("brown");
		directChaining.insertHashTable("fox");
		directChaining.insertHashTable("jumps");
		
		directChaining.displayHashTable();
//		directChaining.searchHashTable("fox");
		
		directChaining.deleteKeyHashTable("fox");
		directChaining.displayHashTable(); */
		
	}
	

}