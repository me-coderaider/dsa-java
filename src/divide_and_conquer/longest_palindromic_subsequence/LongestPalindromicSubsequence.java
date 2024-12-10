package divide_and_conquer.longest_palindromic_subsequence;

public class LongestPalindromicSubsequence {

	private int findLPSLength(String s1, int startIndex, int endIndex) {
		if(startIndex > endIndex) {
			return 0;
		}
		
		if(startIndex == endIndex) {
			return 1;
		}
		
		int c1 = 0;
		if (s1.charAt(startIndex) == s1.charAt(endIndex)) {
			c1 = 2 + findLPSLength(s1,  startIndex + 1, endIndex - 1);
		}
		int c2 = findLPSLength(s1,  startIndex + 1, endIndex);
		int c3 = findLPSLength(s1,  startIndex , endIndex - 1);

		return Math.max(c1, Math.max(c2, c3));
	}

	public int findLPSLength(String s1) {
		return findLPSLength(s1, 0, s1.length()-1);
	}
}
