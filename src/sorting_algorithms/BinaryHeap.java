package sorting_algorithms;

public class BinaryHeap {
	int[] arr;
	int sizeOfTree;

	public BinaryHeap(int size) {
		arr = new int[size + 1];
		this.sizeOfTree = 0;
		System.out.println("BinaryHeap has been created.");
	}

	// isEmpty()
	public boolean isEmpty() {
		if (sizeOfTree == 0) {
			return true;
		} else {
			return false;
		}
	}

	// peek()
	public int peek() {
		if (isEmpty()) {
			System.out.println("BinaryHeap is empty!");
			return -1;
		} else {
			return arr[1];
		}
	}

	// size of binary-heap
	public int sizeOfBH() {
		return sizeOfTree;
	}

	// levelOrder
	public void levelOrder() {
		for (int i = 1; i <= sizeOfTree; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// Heapify (heapifyBottomToTop as we're adding new-nodes at the end) -- helper
	// method
	// for insert()
	public void heapifyBottomToTop(int index, String heapType) {
		int parent = index / 2;
		if (index <= 1) { // means we're at root // BASE CONDITION
			return;
		}

		if (heapType.equals("Min")) {
			if (arr[index] < arr[parent]) {
				int tmp = arr[index];
				arr[index] = arr[parent];
				arr[parent] = tmp;
			}
		} else if (heapType.equals("Max")) {
			if (arr[index] > arr[parent]) {
				int tmp = arr[index];
				arr[index] = arr[parent];
				arr[parent] = tmp;
			}
		}

		heapifyBottomToTop(parent, heapType); // recursively calling for each parent-node
	}

	public void insert(int value, String typeOfHeap) {
		arr[sizeOfTree + 1] = value;
		sizeOfTree++;
		heapifyBottomToTop(sizeOfTree, typeOfHeap);
		System.out.println("Inserted " + value + " successfully in Heap");
	}

	// Heapify (heapifyTopToBottom as we're extracting nodes from the top) -- helper
	// method
	public void heapifyTopToBottom(int index, String heapType) {
		int left = index * 2;
		int right = index * 2 + 1;
		int swapChild = 0;
		if (sizeOfTree < left) { // no child
			return;
		}

		if (heapType.equals("Max")) {
			if (sizeOfTree == left) { // 1 child
				if (arr[index] < arr[left]) {
					int tmp = arr[index];
					arr[index] = arr[left];
					arr[left] = tmp;
				}
				return;
			} else { // 2 children
				if (arr[left] > arr[right]) {
					swapChild = left;
				} else {
					swapChild = right;

				}
				if (arr[index] < arr[swapChild]) {
					int tmp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = tmp;
				}
			}
		} else if (heapType.equals("Min")) {
			if (sizeOfTree == left) { // 1 child
				if (arr[index] > arr[left]) {
					int tmp = arr[index];
					arr[index] = arr[left];
					arr[left] = tmp;
				}
				return;
			} else { // 2 children
				if (arr[left] < arr[right]) {
					swapChild = left;
				} else {
					swapChild = right;

				}
				if (arr[index] > arr[swapChild]) {
					int tmp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = tmp;
				}
			}
		}
		heapifyTopToBottom(swapChild, heapType);
	}

	// extract head of BinaryHeap
	public int extractHeapOfBP(String heapType) {
		if (isEmpty()) {
			return -1;
		} else {
			int extractedValue = arr[1];
			arr[1] = arr[sizeOfTree];
			sizeOfTree--;
			heapifyTopToBottom(1, heapType);
			return extractedValue;
		}
	}

	// deleteBH()
	public void deleteBH() {
		arr = null;
		System.out.println("BinaryHeap has been successfully deleted.");
	}
}
