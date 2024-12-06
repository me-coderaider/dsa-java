
import sorting_algorithms.SelectionSort;

class Main {

	public static void main(String[] args) {
		// Sorting -- Selection Sort
		int[] arr = { 11, 31, 4, 66, 45, 32, 76 };

		SelectionSort ss = new SelectionSort();
		ss.selectionSort(arr);
		ss.printArray(arr);

		/*
		 * // Sorting -- Bubble Sort int[] arr= {11,31,4,66,45,32,76};
		 * 
		 * BubbleSort bubbleSort=new BubbleSort();
		 * 
		 * bubbleSort.bubbleSort(arr);
		 * 
		 * bubbleSort.printArray(arr);
		 */

	}

}