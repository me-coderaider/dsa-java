import queue.queue_using_linkedlist.QueueLinkedList;

class Main {

	public static void main(String[] args) {
		// Queue using LinkedList
		QueueLinkedList newQLL=new QueueLinkedList();
		newQLL.enQueue(11);
		newQLL.enQueue(12);
		newQLL.enQueue(13);
		newQLL.enQueue(14);
		System.out.println(newQLL.deQueue());
//		newQLL.deleteQueue();
	}
}