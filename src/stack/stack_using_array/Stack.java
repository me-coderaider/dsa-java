package stack.stack_using_array;

public class Stack {
	int[] arr;
	int topOfStack;

	public Stack(int size) {
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("The Stack is created with a size of: " + size);
	}

	// isEmpty
	public boolean isEmpty() {
		if (topOfStack == -1) {
			return true;
		} else {
			return false;
		}
	}

	// isFull
	public boolean isFull() {
		if (topOfStack == arr.length - 1) {
//			System.out.println("The Stack is full!");
			return true;
		} else {
			return false;
		}
	}

	// Push
	public void push(int value) {
		if (isFull()) {
			System.out.println("The Stack is full!");
		} else {
			arr[topOfStack + 1] = value;
			topOfStack++;
			System.out.println("The value is successfully inserted.");
		}
	}

	// Pop
	public int pop() {
		if (isEmpty()) {
			System.out.println("The Stack is empty!");
			return -1;
		} else {
			int value = arr[topOfStack];
			topOfStack--;
			return value;
		}
	}

	// Peek
	public int peek() {
		if (isEmpty()) {
			System.out.println("The stack is empty!");
			return -1;
		} else {
			return arr[topOfStack];
		}
	}

	// delete -- deleting the entire stack
	public void deleteStack() {
		arr = null;
		System.out.println("The stack is successfully deleted!");
	}
}

