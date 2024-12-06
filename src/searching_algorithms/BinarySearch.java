package searching_algorithms;

public class BinarySearch {
	
	public static int binarySearch(int[] arr, int value) {
		
		int left=0, right=arr.length-1;
		
		while(left <= right) {
			int mid=left + (right-left)/2;
			if(arr[mid] == value) {
				System.out.println("Element \""+value+"\" found at an index:"+mid);
				return mid;
			}
			if(value > arr[mid]) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		System.out.println("Element \""+value+"\" does not exist");
		return -1;
	}
}
