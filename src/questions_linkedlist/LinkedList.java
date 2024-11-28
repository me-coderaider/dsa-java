package questions_linkedlist;

public class LinkedList {
	public Node head;
	public Node tail;
	public int size;
	
	public void createLL(int nodeValue) {
		Node newNode=new Node();
		newNode.value=nodeValue;
		newNode.next=null;
		
		head=newNode;
		tail=newNode;
		
		size=1;
	}
	
	// inserting node at the end;
	public void insertNode(int nodeValue) {
		if(head == null) {
			createLL(nodeValue);
			return;
		}
		Node newNode=new Node();
		newNode.value=nodeValue;
		newNode.next=null;
		
		tail.next=newNode;
		tail=newNode;
		size++;
	}
	
	// traverse 
	public void traversalLL() {
		if(head != null) {
			Node tempNode=head;
			int index=0;
			while(index < size) {
				System.out.print(tempNode.value);
				if(index != size-1) {
					System.out.print(" -> ");
				}
				tempNode=tempNode.next;
				index++;
			}
			System.out.println();
		}else {
			System.out.println("LL does not exist!");
		}
	}
}
