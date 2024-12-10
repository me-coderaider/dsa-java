import java.util.ArrayList;

import greedy_algorithms.activity_selection_problem.Activity;
import greedy_algorithms.activity_selection_problem.ActivitySelection;

class Main {

	public static void main(String[] args) {
		// Greedy Algorithms -- Activity Selection Problem
		
		ArrayList<Activity> activityList=new ArrayList<>();
		activityList.add(new Activity("A1", 0, 6));
		activityList.add(new Activity("A2", 3, 4));
		activityList.add(new Activity("A3", 1, 2));
		activityList.add(new Activity("A4", 5, 8));
		activityList.add(new Activity("A5", 5, 7));
		activityList.add(new Activity("A6", 8, 9));
		
		ActivitySelection.activitySelection(activityList);
	}

}