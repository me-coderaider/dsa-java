package sorting_algorithms;

public class QuickSort {

	// partition() -- helper function
	public static int partition(int[] arr, int start, int end) {
		int pivot = end;
		int i = start - 1;
		for (int j = start; j <= end; j++) {
			if (arr[j] <= arr[pivot]) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		return i;
	}

	// quickSort()
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
	}

	// printArray
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
