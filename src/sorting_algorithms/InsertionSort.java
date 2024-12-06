package sorting_algorithms;

public class InsertionSort {

	public void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int tmp = arr[i];
			int j = i;// we want to place this element at its right location

			while (j > 0 && arr[j - 1] > tmp) { // if previous element is > than this candidate element
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = tmp;
		}
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
