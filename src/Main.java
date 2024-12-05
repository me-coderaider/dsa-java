import hashing.direct_chaining.DirectChaining;

class Main {

	public static void main(String[] args) {
		// Hashing -- Direct Chaining
		
		DirectChaining directChaining=new DirectChaining(15);
		directChaining.insertHashTable("The");
		directChaining.insertHashTable("quick");
		directChaining.insertHashTable("brown");
		directChaining.insertHashTable("fox");
		directChaining.insertHashTable("jumps");
		
		directChaining.displayHashTable();
//		directChaining.searchHashTable("fox");
		
		directChaining.deleteKeyHashTable("fox");
		directChaining.displayHashTable();
		
	}
	

}