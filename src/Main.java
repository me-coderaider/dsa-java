import queue.circular_queue_using_array.CircularQueue;

class Main {

	public static void main(String[] args) {
		// Circular Queue using Array
		
		CircularQueue newCq=new CircularQueue(4);
		newCq.enQueue(11);
		newCq.enQueue(12);
		newCq.enQueue(13);
		newCq.enQueue(14);
		System.out.println(newCq.deQueue());
		newCq.enQueue(15);
		newCq.deleteQueue();
	}
}