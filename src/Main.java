import stack.stack_using_linkedlist.Stack;

class Main {

	public static void main(String[] args) {
		// Stack using linkedlist
		Stack newStack=new Stack();
		newStack.push(11);
		newStack.push(12);
		newStack.push(13);
		System.out.println(newStack.peek());
		System.out.println(newStack.peek());
		
		newStack.deleteStack();
		
	}
}