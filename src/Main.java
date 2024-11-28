import questions_linkedlist.LinkedList;
import questions_linkedlist.Questions;

class Main {

	public static void main(String[] args) {
		// LinkedList Questions Practice
		
		LinkedList ll1=new LinkedList();
		ll1.createLL(7);
		ll1.insertNode(1);
		ll1.insertNode(6);
		
		LinkedList ll2=new LinkedList();
		ll2.insertNode(5);
		ll2.insertNode(9);
		ll2.insertNode(2);
		ll2.insertNode(8);
		
//		ll.traversalLL();
		Questions q=new Questions();
//		q.deleteDups(ll);
//		ll.traversalLL();
		
//		System.out.println(q.nthToLast(ll, 2).value);
		
//		q.partition(ll, 13);
//		ll.traversalLL();
		
//		LinkedList result=q.sumLists(ll1, ll2);
//		result.traversalLL();
		
		q.addSameNode(ll1, ll2, 17);
		q.addSameNode(ll1, ll2, 11);
		q.addSameNode(ll1, ll2, 18);
		
		System.out.println(q.findIntersection(ll1, ll2).value);
		
	}
}