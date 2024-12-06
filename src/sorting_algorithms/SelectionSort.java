package sorting_algorithms;

public class SelectionSort {
	
	public void selectionSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			int minIndex=i;
			for(int j=i+1;j<n;j++) {	
				if(arr[j] < arr[minIndex]) { // if arr[j] is < than assumed minimum arr[minIndex]
					minIndex=j;
				}
			}
			if(minIndex != i) {				
				swap(arr, i, minIndex);
			}
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
