import queue.queue_using_array.QueueArray;

class Main {

	public static void main(String[] args) {
		// Queue using Array
		QueueArray newQueue=new QueueArray(3);
		newQueue.enQueue(11);
		newQueue.enQueue(12);
		newQueue.enQueue(13);
		
		newQueue.deleteQueue();
				
	}
}