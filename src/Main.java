import circularsinglylinkedlist.CircularSinglyLinkedList;

class Main {

    public static void main(String[] args) {
        // Circular SLL
    	CircularSinglyLinkedList csll=new CircularSinglyLinkedList();
    	
    	csll.createCSLL(11);
    	csll.insertCSLL(12, 0);
    	csll.insertCSLL(13, 1);
    	csll.insertCSLL(14, 5);
    	csll.traverseCSLL();
//    	csll.searchNode(15);
//    	csll.deleteNodeCSLL(1);
    	csll.deleteCSLL();
    	csll.traverseCSLL();
    	
    }
}