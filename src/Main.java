import divide_and_conquer.zero_one_knapsack.ZeroOneKnapsack;

class Main {

	public static void main(String[] args) {
		// Divide and Conquer -- Zero One Knapsack

		ZeroOneKnapsack zoknapsack = new ZeroOneKnapsack();
		int[] profits= {31,26,17,72};
		int[] weights= {3,1,2,5};
		int capacity=7;
		// answer == 98
		System.out.println(zoknapsack.zoKnapsack(profits, weights, capacity));
	}

}