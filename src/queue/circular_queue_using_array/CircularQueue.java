package queue.circular_queue_using_array;

public class CircularQueue {
	int[] arr;
	int topOfQueue;
	int beginningOfQueue;
	int size; // useful for enQueue & deQueue in case of circular-queue

	// create circularQueue
	public CircularQueue(int size) {
		this.arr = new int[size];
		this.size = size;
		this.topOfQueue = -1;
		this.beginningOfQueue = -1;
		System.out.println("The CQ is successfully created with a size of: " + size);
	}

	// isEmpty()
	public boolean isEmpty() {
		if (topOfQueue == -1) {
			return true;
		} else {
			return false;
		}
	}

	// isFull()
	public boolean isFull() {
		if (topOfQueue + 1 == beginningOfQueue) { // as it is a circular-queue
			return true;
		} else if (beginningOfQueue == 0 && topOfQueue == arr.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	// enQueue()
	public void enQueue(int value) {
		if (isFull()) {
			System.out.println("The CQ is full!");
		} else if (isEmpty()) { // as per the condition of 'isEmpty()', topOfQueue == -1
			beginningOfQueue = 0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted " + value + " in the queue.");
		} else { // we have some elements in the c.queue and we've to use 'UNUSED' cells as well.
			if (topOfQueue + 1 == size) {
				topOfQueue = 0;
			} else {
				topOfQueue++;
			}
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted " + value + " in the queue.");
		}
	}

	// deQueue()
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("The CQ is empty!");
			return -1;
		} else {
			int result = arr[beginningOfQueue];
			arr[beginningOfQueue] = 0;

			if (beginningOfQueue == topOfQueue) { // means 1 element in the queue and after deQueue, CQ will be empty
				beginningOfQueue = -1;
				topOfQueue = -1;
			} else if (beginningOfQueue + 1 == size) { // means 'beginningOfQueue' pointing to last-cell
				beginningOfQueue = 0;
			} else {
				beginningOfQueue++;
			}
			return result;
		}
	}

	// peek()
	public int peek() {
		if (isEmpty()) {
			System.out.println("The CQ is empty!");
			return -1;
		} else {
			return arr[beginningOfQueue];
		}
	}

	// deleteQueue -- basically delete array from memory
	public void deleteQueue() {
		arr = null;
		System.out.println("The CQ is successfully deleted!");
	}
}
