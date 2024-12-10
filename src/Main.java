import divide_and_conquer.longest_palindromic_subsequence.LongestPalindromicSubsequence;
import divide_and_conquer.min_cost_to_reach_last_cell.MinCostToReachLastCell;

class Main {

	public static void main(String[] args) {
		// Divide and Conquer -- Minimum Cost to Reach Last Cell

		// we'll move in reverse manner, from last to first cell
		int[][] array = { 
				{ 4, 7, 8, 6, 4 }, 
				{ 6, 7, 3, 9, 2 }, 
				{ 3, 8, 1, 2, 4 }, 
				{ 7, 1, 7, 3, 7 },
				{ 2, 9, 8, 9, 3 } };
		
		MinCostToReachLastCell 	minCost=new MinCostToReachLastCell();
		System.out.println(minCost.findMinCost(array, array.length-1, array[0].length-1)); // 36
		
		
	}

}