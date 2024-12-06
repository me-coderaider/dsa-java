
import sorting_algorithms.BubbleSort;

class Main {

	public static void main(String[] args) {
		// Sorting -- Bubble Sort
		int[] arr= {11,31,4,66,45,32,76};
		
		BubbleSort bubbleSort=new BubbleSort();
		
		bubbleSort.bubbleSort(arr);
		
		bubbleSort.printArray(arr);
		
	}

}