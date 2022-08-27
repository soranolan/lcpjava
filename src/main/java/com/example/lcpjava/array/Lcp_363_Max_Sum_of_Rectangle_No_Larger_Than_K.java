package com.example.lcpjava.array;

import java.util.TreeSet;

public class Lcp_363_Max_Sum_of_Rectangle_No_Larger_Than_K {
	
	/**
	 * time  : O(m * n * m * n)
	 * space : O(m * n)
	 * 
	 * Brute Force
	 * 
	 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/2485717/Simple-Java-Solution-with-Explanation-Prefix-Sum-with-Brute-Force-check
	 * */
	public int maxSumSubmatrix_1(int[][] matrix, int k) {
		int rows = matrix.length;																					// m
		int cols = matrix[0].length;																				// n
		int[][] prefixSum = new int[rows + 1][cols + 1];															// S : O((m + 1) * (n + 1))
		
		// copy each cell
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				prefixSum[row + 1][col + 1] = matrix[row][col];
			}
		}
		
		// from left to right prefix sum
		for (int row = 1; row <= rows; row++) {																		// T : O(m)
			for (int col = 2; col <= cols; col++) {																	// T : O(n - 1)
				prefixSum[row][col] = prefixSum[row][col] + prefixSum[row][col - 1];
			}
		}
		
		// from top to down prefix sum
		for (int row = 2; row <= rows; row++) {																		// T : O(m - 1)
			for (int col = 1; col <= cols; col++) {																	// T : O(n)
				prefixSum[row][col] = prefixSum[row][col] + prefixSum[row - 1][col];
			}
		}
		
		int maxSum = -100001;
		
		// calculate all possible size rectangle
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				for (int r = row; r < rows; r++) {																	// T : O(m)
					for (int c = col; c < cols; c++) {																// T : O(n)
						// down right - down left - top right + top left
						int sum = prefixSum[r + 1][c + 1] - prefixSum[row][c + 1] - prefixSum[r + 1][col] + prefixSum[row][col];
						
						if (sum <= k) {
							maxSum = Math.max(maxSum, sum);
						}
					}
				}
			}
		}
		
		return maxSum;
	}
	
	/**
	 * time  : O(n * n *(m + m log m))
	 * space : O(n * n * m)
	 * 
	 * Kadane's algorithm
	 * 
	 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/83599/Accepted-C%2B%2B-codes-with-explanation-and-references
	 * https://www.youtube.com/watch?v=yCQN096CwWM
	 * */
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int maxSum = -100001;
		int rows = matrix.length;																					// m
		int cols = matrix[0].length;																				// n
		
		for (int left = 0; left < cols; left++) {																	// T : O(n)
			int[] sums = new int[rows];
			
			for (int right = left; right < cols; right++) {															// T : O(n)
				for (int i = 0; i < rows; i++) {																	// T : O(m)
					sums[i] = sums[i] + matrix[i][right];
				}
				
				int sum = findMaxSum(sums, k);																		// T : O(m log m)
				maxSum = Math.max(sum, maxSum);
			}
		}
		
		return maxSum;
	}
	
	/**
	 * time  : O(m log m)
	 * space : O(m)
	 * */
	private int findMaxSum(int[] sums, int k) {
		int maxSum = -100001;
		int currentSum = 0;
		TreeSet<Integer> set = new TreeSet<Integer>();																// S : O(m)
		
		// [ 2, 1 ] k = 2
		set.add(0);
		
		for (int sum : sums) {																						// T : O(m)
			currentSum += sum;
			
			/**
			 * TODO
			 * cumulative sum - k <= number
			 * cumulative sum - number <= k
			 * */
			Integer number = set.ceiling(currentSum - k);															// T : O(log m)
			if (number != null) {
				maxSum = Math.max(maxSum, currentSum - number);
			}
			
			set.add(currentSum);
		}
		
		return maxSum;
	}
	
}
