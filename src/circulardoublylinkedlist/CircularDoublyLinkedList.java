package circulardoublylinkedlist;

public class CircularDoublyLinkedList {
	public DoublyNode head;
	public DoublyNode tail;
	public int size;

	// Creative CDLL
	public DoublyNode createCDLL(int nodeValue) {
		head = new DoublyNode();

		DoublyNode newNode = new DoublyNode();
		newNode.value = nodeValue;
		head = newNode;
		tail = newNode;

		newNode.next = newNode;
		newNode.prev = newNode;

		size = 1;

		return head;
	}

	// INSERTION METHOD
	public void insertNode(int nodeValue, int location) {
		DoublyNode newNode = new DoublyNode();
		newNode.value = nodeValue;

		if (head == null) {
			createCDLL(nodeValue);
			return;
		} else if (location == 0) { // START
			newNode.next = head;
			newNode.prev = tail;

			head.prev = newNode;
			tail.next = newNode;

			head = newNode;
		} else if (location >= size) {
			newNode.next = head;
			newNode.prev = tail;

			tail.next = newNode;
			head.prev = newNode;

			tail = newNode;
		} else {
			DoublyNode tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			newNode.next = tempNode.next;
			newNode.prev = tempNode;

			tempNode.next = newNode;
			newNode.next.prev = newNode;
		}
		size++;
	}

	// Traverse CDLL
	public void traverseCDLL() {
		if (head != null) {
			DoublyNode tempNode = head;
			int index = 0;
			while (index < size) {
				System.out.print(tempNode.value);
				if (index != size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.next;
				index++;
			}
			System.out.println();
		} else {
			System.out.println("CDLL does not exist!");
		}
	}

	// Reverse Traverse CDLL
	public void reverseTraverseCDLL() {
		if (head != null) {
			DoublyNode tempNode = tail;
			int index = 0;
			while (index < size) {
				System.out.print(tempNode.value);
				if (index != size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.prev;
				index++;
			}
		} else {
			System.out.println("CDLL does not exist!");
		}
	}

	// Search Node
	public boolean searchNode(int nodeValue) {

		if (head != null) {
			DoublyNode tempNode = head;
			int index = 0;
			while (index < size) {
				if (tempNode.value == nodeValue) {
					System.out.println("Node found at location: " + index);
					return true;
				}
				tempNode = tempNode.next;
				index++;
			}
		}
		System.out.println("Node not found!");
		return false;
	}

	// DELETION METHOD
	public void deleteNode(int location) {
		if (head == null) {
			System.out.println("The CDLL does not exit!");
			return;
		} else if (location == 0) { // START
			if (size == 1) { // 1 element in LL
				head.prev = null;
				head.next = null;
				head = null;
				tail = null;
				size--;
				return;

			} else {
				head = head.next;
				head.prev = tail;

				tail.next = head;
				size--;
			}
		} else if (location >= size) { // END
			if (size == 1) {
				head.prev = null;
				head.next = null;
				head = null;
				tail = null;
				size--;
				return;
			} else {
				tail = tail.prev;
				tail.next = head;

				head.prev = tail;
				size--;

			}
		} else { // MIDDLE
			DoublyNode tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}

			tempNode.next = tempNode.next.next; // need 'address' of node, not what 'prev' & 'next' holding
			tempNode.next.prev = tempNode;
			size--;
		}
	}

	// DELETE ENTIRE CDLL
	public void deleteCDLL() {
		if (head == null) {
			System.out.println("CDLL does not exist!");
		} else {
			DoublyNode tempNode = head;
//			head.prev=null;
//			tail.next=null;
			int index = 0;
			while (index < size) {
				tempNode.prev = null;
				tempNode = tempNode.next;
				index++;
			}
			head = null;
			tail = null;
			System.out.println("CDLL has been deleted!");
		}
	}
}
