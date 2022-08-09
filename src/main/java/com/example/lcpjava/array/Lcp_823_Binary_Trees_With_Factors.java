package com.example.lcpjava.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lcp_823_Binary_Trees_With_Factors {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/binary-trees-with-factors/discuss/126277/Concise-Java-solution-using-HashMap-with-detailed-explanation.-Easily-understand!!!
	 * */
	public int numFactoredBinaryTrees_1(int[] arr) {
		Arrays.sort(arr);																							// T : O(n log n)
		
		Map<Integer, Long> numberAsRoot2Count = new HashMap<>();													// S : O(n)
		numberAsRoot2Count.put(arr[0], 1L);
		
		for (int i = 1; i < arr.length; i++) {																		// T : O(n - 1)
			long count = 1;
			int root = arr[i];
			
			for (Integer left : numberAsRoot2Count.keySet()) {
				int right = root / left;
				
				if (root % left == 0 && numberAsRoot2Count.containsKey(right)) {									// T : O(1)
					count = count + numberAsRoot2Count.get(left) * numberAsRoot2Count.get(right);					// T : O(1)
				}
			}
			
			numberAsRoot2Count.put(root, count);																	// T : O(1)
		}
		
		long result = 0;
		
		for (long count : numberAsRoot2Count.values()) { result += count; }											// T : O(n)
		
		return (int) (result % (1e9 + 7));
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * Solution Tab
	 * */
	public int numFactoredBinaryTrees(int[] arr) {
		Arrays.sort(arr);																							// T : O(n log n)
		
		int length = arr.length;																					// n
		long[] dp = new long[length];																				// S : O(n)
		Arrays.fill(dp, 1L);																						// T : O(n)
		
		Map<Integer, Integer> number2Index = new HashMap<>();														// S : O(n)
		for (int i = 0; i < length; i++) { number2Index.put(arr[i], i); }											// T : O(n)
		
		for (int rootIndex = 0; rootIndex < length; rootIndex++) {													// T : O(n)
			int rootValue = arr[rootIndex];
			
			for (int leftIndex = 0; leftIndex < length; leftIndex++) {												// T : O(n)
				int leftValue = arr[leftIndex];
				int rightValue = rootValue / leftValue;
				
				if (rootValue % leftValue == 0 && number2Index.containsKey(rightValue)) {							// T : O(1)
					dp[rootIndex] = dp[rootIndex] + (dp[leftIndex] * dp[number2Index.get(rightValue)]);				// T : O(1)
				}
			}
		}
		
		long result = 0;
		
		for (long count : dp) { result += count; }																	// T : O(n)
		
		return (int) (result % (1e9 + 7));
	}
	
}
