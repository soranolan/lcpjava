package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_1051_Height_Checker {
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * int count <- 0
	 * int[] clone <- array clone
	 * array sort clone
	 * 
	 * for int i <- 0; if i is lower than array length; i++
	 * 		if array[i] is not equal to clone[i]
	 * 			count++
	 * 		end if
	 * end for
	 * 
	 * return count
	 * */
	public int heightChecker_1(int[] heights) {
		int count = 0;
		int[] clone = heights.clone();																				// S : O(n)
		Arrays.sort(clone);																							// T : O(n log n)
		
		for (int i = 0; i < heights.length; i++) {																	// T : O(n)
			if (heights[i] != clone[i]) { count++; }
		}
		
		return count;
	}
	
	/**
	 * time  : O(max(max(height), length) ?
	 *         O(max(height)) while loop
	 *         O(n)           for loop
	 * space : O(n)
	 * 
	 * Counting sort
	 * 
	 * int[] bucket <- size constraint plus 1
	 * 
	 * for number in array
	 * 		bucket[number]++
	 * end for
	 * 
	 * int count <- 0
	 * int bucketIndex <- 0
	 * 
	 * for int i <- 0; if i is lower than array length; i++
	 * 		while bucket[bucketIndex] is equal to zero
	 * 			bucketIndex++
	 * 		end while
	 * 		
	 * 		if array[i] is not equal to bucketIndex
	 * 			count++
	 * 		end if
	 * 		
	 * 		bucket[bucketIndex]--
	 * end for
	 * 
	 * return count
	 * */
	public int heightChecker(int[] heights) {
		int[] bucket = new int[101];																				// S : O(n)
		for (int height : heights) { bucket[height]++; }															// T : O(n)
		
		int count = 0;
		int bucketIndex = 0;
		
		for (int i = 0; i < heights.length; i++) {																	// T : O(n)
			while (bucket[bucketIndex] == 0) { bucketIndex++; }														// T : O(max n)
			if (heights[i] != bucketIndex) { count++; }
			bucket[bucketIndex]--;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Lcp_1051_Height_Checker lcp = new Lcp_1051_Height_Checker();
		int[] input = null;
		int output = -1;
		
		// 3
		input = new int[] { 1, 1, 4, 2, 1, 3 };
		output = lcp.heightChecker(input);
		System.out.println(output);
		
		// 5
		input = new int[] { 5, 1, 2, 3, 4 };
		output = lcp.heightChecker(input);
		System.out.println(output);
		
		// 0
		input = new int[] { 1, 2, 3, 4, 5 };
		output = lcp.heightChecker(input);
		System.out.println(output);
		
		// 16
		input = new int[] { 0, 100, 0, 99, 0, 98, 0, 97, 0, 96, 0, 95, 0, 94, 0, 93, 0, 92, 0, 91, 0, 90 };
		output = lcp.heightChecker(input);
		System.out.println(output);
	}
	
}
