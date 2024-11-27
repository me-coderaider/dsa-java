package circularsinglylinkedlist;

public class CircularSinglyLinkedList {
	public Node head;
	public Node tail;
	public int size;

	public Node createCSLL(int nodeValue) {
		head = new Node();

		Node newNode = new Node();
		newNode.next = newNode; // pointing to itself
		newNode.value = nodeValue;

		head = newNode;
		tail = newNode;

		size = 1;

		return head;
	}

	// INSERTION METHOD
	// NOTE -- '0-index' based location for inserting the new-nodes
	public void insertCSLL(int nodeValue, int location) {
		Node newNode = new Node();
		newNode.value = nodeValue;

		if (head == null) { // linkedlist does not exist.
			createCSLL(nodeValue);
			return;
		} else if (location == 0) { // INSERTING AT THE 'START' OF LINKEDLIST
			newNode.next = head;
			head = newNode;
			tail.next = newNode; // or tail.next=head;
		} else if (location >= size) { // INSERTING AT THE 'END' OF LINKEDLIST
//			newNode.next=head;
			tail.next = newNode;
			tail = newNode;
			tail.next = head; // alternate of first-line
		} else {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			newNode.next = tempNode.next;
			tempNode.next = newNode;
		}
		size++;
	}

	// TRAVERSAL METHOD
	public void traverseCSLL() {
		if (head != null) {
			Node tempNode = head;
			int index = 0;
			while (index < size) {
				System.out.print(tempNode.value);
				if (index != (size - 1)) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.next;
				index++;
			}
			System.out.println();
		} else {
			System.out.println("CSLL doesn not exist!");
		}
	}

	// SEARCH METHOD
	public boolean searchNode(int nodeValue) {

		if (head != null) {
			Node tempNode = head;
			int index = 0;
			while (index < size) {
				if (tempNode.value == nodeValue) {
					System.out.println("Node with value " + nodeValue + " found at location " + index + "!");
					return true;
				}
				tempNode = tempNode.next;
				index++;
			}

		}
		System.out.println("Node not found!");
		return false;
	}

	// DELETE METHOD
	public void deleteNodeCSLL(int location) {
		if (head == null) {
			System.out.println("The CSLL does not exist");
			return;
		} else if (location == 0) { // DELETE from 'start' with 2 cases
			head = head.next;
			tail.next = head;
			size--;
			if (size == 0) {
				tail = null;
				head.next = null;
				head = null;
			}

		} else if (location >= size) { // looping through the LL to go to 2nd-last node of LL
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			if (tempNode == head) { // means loop does not get execute depicting only 1 node in LL
				head.next = null;
				head = null;
				tail = null;
				size--;
				return;
			}
			tempNode.next = head;
			tail = tempNode;
			size--;

		} else { // any other given node location
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			tempNode.next = tempNode.next.next;
			size--;

		}

	}
	
	// DELELTE CSLL
	public void deleteCSLL() {
		if(head == null) {
			System.out.println("The CSLL does not exist!!");
		}else {
			head=null;
			tail.next=null;
			tail=null;
			System.out.println("The CSLL has been deleted.");
		}
	}
}
