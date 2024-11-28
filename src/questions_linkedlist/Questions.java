package questions_linkedlist;

import java.util.HashSet;

public class Questions {
	// Sol - Question 1:: Remove copy of duplicates using 'HashSet'
	public void deleteDups(LinkedList ll) {
		HashSet<Integer> set = new HashSet<>();
		Node current = ll.head;
		Node prev = null;

		while (current != null) {
			if (set.contains(current.value)) {
				prev.next = current.next;
				ll.size--;
			} else {
				prev = current;
				set.add(current.value);
			}
			current = current.next;
		}
	}

	// Sol - Question 2:: Nth to last || USING 2-pointer approach
	public Node nthToLast(LinkedList ll, int n) {
		Node first = ll.head;
		Node second = ll.head;

		int index = 0;
		while (index < n) {
			if (second == null) {
				return null;
			}
			second = second.next;
			index++;
		}

		while (second != null) {
			first = first.next;
			second = second.next;
		}
		return first;
	}

	// Sol - Question 3:: Partition || USING
	public LinkedList partition(LinkedList ll, int x) {
		Node currentNode = ll.head;
		ll.tail = ll.head;

		while (currentNode != null) {
			Node next = currentNode.next;

			if (currentNode.value < x) {
				currentNode.next = ll.head;
				ll.head = currentNode;
			} else {
				ll.tail.next = currentNode;
				ll.tail = currentNode;
			}
			currentNode = next;
		}
		ll.tail.next = null;
		return ll;
	}

	// Sol - Question 4:: Sum Two Lists || USING
	public LinkedList sumLists(LinkedList ll1, LinkedList ll2) {
		Node l1 = ll1.head;
		Node l2 = ll2.head;
		int carry = 0;
		LinkedList resultLL = new LinkedList();
		while (l1 != null || l2 != null) {
			int result = carry;
			if (l1 != null) {
				result += l1.value;
				l1 = l1.next;
			}
			if (l2 != null) {
				result += l2.value;
				l2 = l2.next;
			}
			resultLL.insertNode(result % 10);
			carry = result / 10;
		}
		return resultLL;
	}

	// Sol - Question 5:: Intersection || USING
	// we will need some helper functions for this
	// getKthNode
	public Node getKthNode(Node head, int k) {
		Node currentNode = head;
		while(k>0 && currentNode!=null) {
			currentNode=currentNode.next;
			k--;
		}
		return currentNode;
	}
	// Intersection method
	public Node findIntersection(LinkedList ll1, LinkedList ll2) {
		if(ll1.head == null || ll2.head == null) {
			return null;
		}
		
		if(ll1.tail != ll2.tail) {
			return null;
		}
		Node shorter=new Node();
		Node longer=new Node();
		if(ll1.size > ll2.size) {
			longer=ll1.head;
			shorter=ll2.head;
		}else {
			longer=ll2.head;
			shorter=ll1.head;
		}
		longer=getKthNode(longer, Math.abs(ll1.size - ll2.size));
		while(shorter!=longer) {
			shorter=shorter.next;
			longer=longer.next;
		}
		return shorter;
	}
	
	// Add same node to 2 linkedlist (for testing)
	public void addSameNode(LinkedList ll1, LinkedList ll2, int nodeValue) {
		Node newNode=new Node();
		newNode.value=nodeValue;
		
		ll1.tail.next=newNode;
		ll1.tail=newNode;
		
		ll2.tail.next=newNode;
		ll2.tail=newNode;
	}
}




















