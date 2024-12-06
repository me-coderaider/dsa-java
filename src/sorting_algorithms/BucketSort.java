package sorting_algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

	int[] arr;

	public BucketSort(int[] arr) {
		this.arr = arr;
	}

	// printArray
	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// printBuckets
	public void printBuckets(ArrayList<Integer>[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			System.out.println("Bucket #" + (i + 1) + ":");
			for (int j = 0; j < buckets[i].size(); j++) {
				System.out.print(buckets[i].get(j) + " ");
			}
			System.out.println();
		}
	}

	// BucketSort
	public void bucketSort() {
		int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
		int maxValue = Integer.MIN_VALUE;
		for (int ele : arr) {
			if (ele > maxValue) {
				maxValue = ele;
			}
		}

		ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets]; // creating empty buckets
//		ArrayList<ArrayList<Integer>> buckets=new ArrayList<ArrayList<Integer>>(numberOfBuckets);
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>(); // initializing each bucket with an arrayList
		}

		// populating buckets with elements
		for (int ele : arr) {

			int bucketNumber = (int) Math.ceil(((float) ele * numberOfBuckets) / (float) maxValue);
			buckets[bucketNumber - 1].add(ele);
		}

		// just for our purpose::
		System.out.println("\n\nPrinting buckets before sorting::");
		printBuckets(buckets);

		// sorting individual buckets using Collections
		for (ArrayList<Integer> bucket : buckets) {
			Collections.sort(bucket);
		}

		System.out.println("\n\nPrinting buckets After sorting::");
		printBuckets(buckets);

		// populating 'arr' back as buckets are sorted now::
		int index = 0;
		for (ArrayList<Integer> bucket : buckets) {
			for (int ele : bucket) {
				arr[index] = ele;
				index++;
			}
		}
	}
}
