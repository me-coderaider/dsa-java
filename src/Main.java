
import sorting_algorithms.BucketSort;

class Main {

	public static void main(String[] args) {
		// Sorting -- Bucket Sort -- good if data is uniformly distributed over range
		int[] arr = { 9, 7, 5, 4, 2, 1, 3, 6, 8 ,10, 11};
		BucketSort bucketSort=new BucketSort(arr);
		bucketSort.bucketSort();
		bucketSort.printArray(arr);
		

		/*
		 * // Sorting -- Insertion Sort int[] arr = { 11, 31, 4, 66, 45, 32, 76 };
		 * InsertionSort insertionSort=new InsertionSort();
		 * insertionSort.insertionSort(arr); insertionSort.printArray(arr);
		 */

		/*
		 * SelectionSort ss = new SelectionSort(); ss.selectionSort(arr);
		 * ss.printArray(arr);
		 */

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