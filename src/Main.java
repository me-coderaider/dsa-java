import doublylinkedlist.DoublyLinkedList;

class Main {

	public static void main(String[] args) {
		// Doubly LinkedList
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.createDLL(11);
		dll.insertDLL(12, 0);
		dll.insertDLL(13, 1);
		dll.insertDLL(14, 5);
		dll.insertDLL(15, 3);
		dll.traverseDLL();
//		dll.reverseTraverseDLL();
//		dll.searchNode(16);
		dll.deleteNodeDLL(2);
		dll.traverseDLL();
		dll.deleteDLL();
		dll.traverseDLL();
	}
}