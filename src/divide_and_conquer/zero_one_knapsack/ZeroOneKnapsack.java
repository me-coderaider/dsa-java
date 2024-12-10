package divide_and_conquer.zero_one_knapsack;

public class ZeroOneKnapsack {

	private int zoKnapsack(int[] profits, int[] weights, int capacity, int currentIndex) {
		if (capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length) {
			return 0;
		}

		int pickProfit1 = 0;
		if (weights[currentIndex] <= capacity) {
			pickProfit1 = profits[currentIndex]
					+ zoKnapsack(profits, weights, capacity - weights[currentIndex], currentIndex + 1);

		}
		int skipProfit2 = zoKnapsack(profits, weights, capacity, currentIndex + 1);
		return Math.max(pickProfit1, skipProfit2);

	}

	public int zoKnapsack(int[] profits, int[] weights, int capacity) {
		return this.zoKnapsack(profits, weights, capacity, 0);
	}
}
