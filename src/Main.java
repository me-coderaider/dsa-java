
import divide_and_conquer.number_of_paths_to_reach_last_cell.NumberOfPathsToReachLastCell;

class Main {

	public static void main(String[] args) {
		// Divide and Conquer -- Number of paths to Reach Last Cell

		// we'll move in reverse manner, from last to first cell
		int[][] array = { 
				{ 4, 7, 1, 6 }, 
				{ 5, 7, 3, 9 }, 
				{ 3, 2, 1, 2 }, 
				{ 7, 1, 6, 3} };
		
		int cost=25;
		
		NumberOfPathsToReachLastCell nop=new NumberOfPathsToReachLastCell();
		System.out.println(nop.numberOfPaths(array, array.length-1, array[0].length-1, cost)); // 2
		
		
	}

}