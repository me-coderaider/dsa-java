import circulardoublylinkedlist.CircularDoublyLinkedList;

class Main {

	public static void main(String[] args) {
		// Circular Doubly LinkedList
		
		CircularDoublyLinkedList cdll=new CircularDoublyLinkedList();
		cdll.createCDLL(11);
		cdll.insertNode(12, 1);
		cdll.insertNode(13, 0);
		cdll.insertNode(14, 2);
		cdll.insertNode(15, 6);
		cdll.traverseCDLL();
//		cdll.reverseTraverseCDLL();
//		cdll.searchNode(16);
		cdll.deleteNode(12);
		cdll.traverseCDLL();
		cdll.deleteCDLL();
		cdll.traverseCDLL();
	}
}