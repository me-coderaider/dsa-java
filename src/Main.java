import stack.stack_using_array.Stack;

class Main {

	public static void main(String[] args) {
		// Stack 
		Stack newStack=new Stack(4);
		newStack.push(11);
		newStack.push(12);
		newStack.push(13);
		newStack.push(14);
//		int result = newStack.peek();
//		System.out.println(result);
//		int result2 = newStack.peek();
//		System.out.println(result2);
		
		newStack.deleteStack();
		
	}
}