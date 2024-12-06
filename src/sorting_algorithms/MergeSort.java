package sorting_algorithms;

public class MergeSort {
	
	// merge() -- mergeSort() helper
	public static void merge(int[] arr, int left, int middle, int right) {
		int[] leftTmpArray = new int[middle - left + 2];
		int[] rightTmpArray = new int[right - middle + 1];

		leftTmpArray[middle - left + 1] = Integer.MAX_VALUE;
		rightTmpArray[right - middle] = Integer.MAX_VALUE;

		for (int i = 0; i <= middle - left; i++) {
			leftTmpArray[i] = arr[left + i];
		}

		for (int i = 0; i < right - middle; i++) {
			rightTmpArray[i] = arr[middle + 1 + i];
		}


		int i = 0, j = 0;
		for (int k = left; k <= right; k++) {
			if (leftTmpArray[i] < rightTmpArray[j]) {
				arr[k] = leftTmpArray[i];
				i++;
			} else {
				arr[k] = rightTmpArray[j];
				j++;
			}
		}
	}

	// mergeSort
	public static void mergeSort(int[] arr, int left, int right) {
		if (right > left) {
			int middle = (left + right) / 2;
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			merge(arr, left, middle, right);
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
