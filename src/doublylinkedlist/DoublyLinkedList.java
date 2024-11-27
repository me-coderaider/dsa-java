package doublylinkedlist;

public class DoublyLinkedList {
	public DoublyNode head;
	public DoublyNode tail;
	public int size;

	public DoublyNode createDLL(int nodeValue) {
		head = new DoublyNode();

		DoublyNode newNode = new DoublyNode();
		newNode.value = nodeValue;
		newNode.next = null;
		newNode.prev = null;

		head = newNode;
		tail = newNode;

		size = 1;
		return head;
	}

	// INSERT METHOD
	public void insertDLL(int nodeValue, int location) {
		DoublyNode newNode = new DoublyNode();
		newNode.value = nodeValue;
		if (head == null) {
			createDLL(nodeValue);
			return;
		} else if (location == 0) { // START
			newNode.next = head;
			newNode.prev = null;

			head.prev = newNode;
			head = newNode;
		} else if (location >= size) { // END
			newNode.next = null;
			newNode.prev = tail;

			tail.next = newNode;
			tail = newNode;
		} else { // MIDDLE
			DoublyNode tempNode = head;

			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}

			newNode.next = tempNode.next;
			newNode.prev = tempNode;

			tempNode.next = newNode;
//			tempNode.next.next.prev=newNode;
			newNode.next.prev = newNode;
		}
		size++;
	}

	// TRAVERSAL DLL
	public void traverseDLL() {
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
			System.out.println("DLL does not exist!!");
		}
	}

	// REVERSE TRAVERSE DLL
	public void reverseTraverseDLL() {
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
			System.out.println();
		} else {
			System.out.println("The DLL does not exist");
		}
	}

	// SEARCH NODE
	public boolean searchNode(int nodeValue) {
		if (head != null) {
			DoublyNode tempNode = head;
			int index = 0;
			while (index < size) {
				if (tempNode.value == nodeValue) {
					System.out.println("Node found at location " + index);
					return true;
				}
				tempNode = tempNode.next;
				index++;
			}
		}
		System.out.println("Node not found!!");
		return false;
	}

	// DELETION METHOD
	public void deleteNodeDLL(int location) {
		if (head == null) {
			System.out.println("The DLL does not exist!");
			return;
		} else if (location == 0) { // START
			if (size == 1) {
				head = null;
				tail = null;
				size--;
				return;
			} else {
				head = head.next;
				head.prev = null;
				size--;
			}
		} else if (location >= size) { // END
			DoublyNode tempNode = tail.prev;
			if (size == 1) {
				head = null;
				tail = null;
				size--;
				return;
			} else {
				tempNode.next = null;
				tail = tempNode;
				size--;
			}
		} else { // MIDDLE
			DoublyNode tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			tempNode.next = tempNode.next.next;
			tempNode.next.prev = tempNode;
			size--;
		}
	}
	
	// DELETE ENTIRE DLL
	public void deleteDLL() {
		DoublyNode tempNode=head;
		int index=0;
		while(index < size) {
			tempNode.prev=null;
					
			tempNode=tempNode.next;
			index++;
		}
		head=null;
		tail=null;
		System.out.println("The DLL has been deleted.");
	}
}
