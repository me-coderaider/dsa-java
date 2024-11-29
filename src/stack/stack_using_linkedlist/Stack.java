package stack.stack_using_linkedlist;

public class Stack {
	LinkedList linkedList;

	public Stack() {
		linkedList = new LinkedList();
	}

	// Push method
	public void push(int value) {
		linkedList.insertInLinkedList(value, 0); // using LinkedList class methods
		System.out.println("Inserted " + value + " in Stack.");

	}

	// isEmpty()
	public boolean isEmpty() {
		if (linkedList.head == null) {
			return true;
		} else {
			return false;
		}
	}

	// pop() method
	public int pop() {
		int result = -1;
		if (isEmpty()) {
			System.out.println("The Stack is empty!");
		} else {
			result = linkedList.head.value;
//			linkedList.head=linkedList.head.next;
			linkedList.deletionOfNode(0); // using LinkedList class methods
		}
		return result;
	}

	// peek() method
	public int peek() {
		int result = -1;
		if (isEmpty()) {
			System.out.println("The Stack is empty!");
		} else {
			result = linkedList.head.value;
		}
		return result;
	}

	// delete() entire stack
	public void deleteStack() {
		linkedList.head = null;
		System.out.println("The stack is deleted!");
	}
}
