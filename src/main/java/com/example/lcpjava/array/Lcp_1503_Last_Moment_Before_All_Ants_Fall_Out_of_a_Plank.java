package com.example.lcpjava.array;

public class Lcp_1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/discuss/720189/JavaC%2B%2BPython-Ants-Keep-Walking-O(N)
	 * https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/discuss/720313/C%2B%2B-Python-Java-Beautiful-Visual-Explanation
	 * 
	 * 
	 * int max <- 0
	 * 
	 * for int ant in left
	 * 		max <- Math max(max, ant)
	 * end for
	 * 
	 * for int ant in right
	 * 		max <- Math max(max, n minus ant)
	 * end for
	 * 
	 * return max
	 * */
	public int getLastMoment(int n, int[] left, int[] right) {
		int max = 0;
		for (int ant : left) { max = Math.max(max, ant); }
		for (int ant : right) { max = Math.max(max, n - ant); }
		return max;
	}
	
}
