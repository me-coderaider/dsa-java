package sorting_algorithms;

public class HeapSort {
	// NOTE -- We're going to use 'insert()' & 'extract()' methods which in turn
	// uses 'heapify()' of 'BinaryHeap.java' class

	int[] arr = null;

	public HeapSort(int[] arr) {
		this.arr = arr;
	}

	public void sort() {
		BinaryHeap bh = new BinaryHeap(arr.length);
		// inserting all elements inside heap
		for (int i = 0; i < arr.length; i++) {
			bh.insert(arr[i], "Min");
		}

		// extracting elements from the binary element
		for (int i = 0; i < arr.length; i++) {
			arr[i] = bh.extractHeapOfBP("Min");
		}
	}

	// printArray
	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
