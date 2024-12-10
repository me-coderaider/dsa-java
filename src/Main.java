import java.util.Arrays;

import greedy_algorithms.coin_change_problem.CoinChangeProblem;

class Main {

	public static void main(String[] args) {
		// Greedy Algorithms -- Coin Change Problem

		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 1000 };
		int amount = 2035;

		System.out.println("Coins available: " + Arrays.toString(coins));
		System.out.println("Target amount: " + amount);
		CoinChangeProblem.coinChangeProblem(coins, amount);
	}

}