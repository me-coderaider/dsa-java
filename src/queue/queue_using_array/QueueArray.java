package queue.queue_using_array;

public class QueueArray {
	int[] arr;
	int topOfQueue; // rear
	int beginningOfQueue; // front

	// create Queue
	public QueueArray(int size) { 
		arr = new int[size];
		topOfQueue = -1;
		beginningOfQueue = -1;
		System.out.println("The queue is successfully created with a size of: " + size);
	}

	// isFull()
	public boolean isFull() {
		if (topOfQueue == arr.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	// isEmpty()
	public boolean isEmpty() {
		if (beginningOfQueue == -1 || beginningOfQueue == arr.length) {
			return true;
		} else {
			return false;
		}
	}

	// enqueue()
	public void enQueue(int value) {
		if (isFull()) {
			System.out.println("The Queue is full!");
		} else if (isEmpty()) {
			beginningOfQueue = 0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted " + value + " in the queue.");
		} else {
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted " + value + " in the queue.");

		}
	}

	// deQueue
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("The queue is empty");
			return -1;
		} else {
			int result = arr[beginningOfQueue];
			beginningOfQueue++;
			if (beginningOfQueue > topOfQueue) { // means we've popped 1 last element of queue in between the queue
				beginningOfQueue = -1;
				topOfQueue = -1;
			}
			return result;
		}
	}

	// peek()
	public int peek() {
		if (!isEmpty()) {
			return arr[beginningOfQueue];
		} else {
			System.out.println("The queue is empty");
			return -1;
		}
	}
	
	// delete()
	public void deleteQueue() {
		arr=null;
		System.out.println("The Queue is successfully deleted!");
	}
}
