package divide_and_conquer.number_factor;

public class NumberFactor {
	public int waysToGetN(int n) {
		// base cases
		if (n == 0 || n == 1 || n == 2) { // {}, {1}, {1,1}
			return 1;
		}
		if (n == 3) { // {1,1,1} {3}
			return 2;
		}
		int sub1 = waysToGetN(n - 1);
		int sub2 = waysToGetN(n - 3);
		int sub3 = waysToGetN(n - 4);
		return sub1 + sub2 + sub3;
	}
}
