package com.example.lcpjava.array;

public class Lcp_2145_Count_the_Hidden_Sequences {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public int numberOfArrays_1(int[] differences, int lower, int upper) {
		int n = differences.length;
		long[] temp = new long[n + 1];																				// S : O(n + 1)
		
		for (int i = 1; i < temp.length; i++) {																		// T : O(n)
			temp[i] = temp[i - 1] + differences[i - 1];
		}
		
		long min = 100001L;
		long max = -100001L;
		for (long num : temp) {																						// T : O(n)
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		long range = max - min;
		long result = (upper - lower + 1L) - range;
		
		return (int) (result > 0L ? result : 0L);
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/count-the-hidden-sequences/discuss/1709755/JavaC%2B%2BPython-Straight-Forward-Solution-with-Explantion
	 * https://leetcode.com/problems/count-the-hidden-sequences/discuss/1709755/JavaC++Python-Straight-Forward-Solution-with-Explantion/1230844
	 * https://leetcode.com/problems/count-the-hidden-sequences/discuss/1711078/C%2B%2B-or-O(N)-Easy-Solution-just-use-SIMPLE-MATH
	 * */
	public int numberOfArrays(int[] differences, int lower, int upper) {
		long x = 0L;
		long max = 0L;
		long min = 0L;
		
		for (int diff : differences) {																				// T : O(n)
			x += diff;
			max = Math.max(max, x);
			min = Math.min(min, x);
		}
		
		return (int) Math.max(0L, (upper - lower + 1L) - (max - min));
	}
	
}
