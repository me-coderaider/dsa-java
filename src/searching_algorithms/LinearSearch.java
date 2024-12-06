package searching_algorithms;

public class LinearSearch {

	public static int linearSearch(int[] arr, int value) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				System.out.println("Element \"" + value + "\" found at an index:" + i);
				return i;
			}
		}
		System.out.println("Element \"" + value + "\" does not exist");
		return -1;
	}
}
