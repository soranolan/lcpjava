package com.example.lcpjava.greedy;

public class Lcp_1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K {
	
	/**
	 * time  : O(86)
	 * space : O(44)
	 * 
	 * if k is lower than two
	 * 		return k
	 * end if
	 * 
	 * int result <- 0
	 * 
	 * int[] dp <- new int[44]
	 * dp[0] <- 1
	 * dp[0] <- 1
	 * 
	 * int length <- dp length
	 * 
	 * for int i <- 2; if i is lower than length; i++
	 * 		dp[i] <- dp[i minus one] plus dp[i minus two]
	 * end for
	 * 
	 * for int i <- length minus one; if i is greater than or equal to zero; i--
	 * 		int number <- dp[i]
	 * 		
	 * 		if number is greater than k
	 * 			continue
	 * 		end if
	 * 		
	 * 		k <- k minus number
	 * 		result++
	 * 		
	 * 		if k is equal to zero
	 * 			return result
	 * 		end if
	 * end for
	 * 
	 * return result
	 * */
	public int findMinFibonacciNumbers_1(int k) {
		if (k < 2) { return k; }
		
		int result = 0;
		
		int[] dp = new int[44];																						// S : O(44)
		dp[0] = 1;
		dp[1] = 1;
		
		int length = dp.length;
		for (int i = 2; i < length; i++) { dp[i] = dp[i - 1] + dp[i - 2]; }											// T : O(42)
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(44)
			int num = dp[i];
			if (num > k) { continue; }
			
			k -= num;
			result++;
			if (k == 0) { return result; }
		}
		
		return result;
	}
	
	/**
	 * time  : O((log k) ^ 2)
	 * space : O(log k)
	 * 
	 * if k is lower than two
	 * 		return k
	 * end if
	 * 
	 * int left <- 1
	 * int right <- 1
	 * 
	 * while right is lower than or equal to k
	 * 		right <- right plus left
	 * 		left <- right minus left
	 * end while
	 * 
	 * return one plus findMinFibonacciNumbers(k minus left)
	 * */
	public int findMinFibonacciNumbers_2(int k) {
		if (k < 2) { return k; }
		
		int left = 1;
		int right = 1;
		
		while (right <= k) {
			right += left;
			left = right - left;
		}
		
		return 1 + findMinFibonacciNumbers_2(k - left);
	}
	
	/**
	 * time  : O(log k)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/discuss/585632/JavaC%2B%2BPython-Easy-Prove
	 * 
	 * 
	 * if k is lower than two
	 * 		return k
	 * end if
	 * 
	 * int result <- 0
	 * int left <- 1
	 * int right <- 1
	 * 
	 * while right is lower than or equal to k
	 * 		right <- right plus left
	 * 		left <- right minus left
	 * end while
	 * 
	 * while left is greater than zero
	 * 		if left is lower than or equal to k
	 * 			k <- k minus left
	 * 			result++
	 * 		end if
	 * 		
	 * 		if k is equal to zero
	 * 			return result
	 * 		end if
	 * 		
	 * 		int temp <- left
	 * 		left <- right minus left
	 * 		right <- left
	 * end while
	 * 
	 * return result
	 * */
	public int findMinFibonacciNumbers(int k) {
		if (k < 2) { return k; }
		
		int result = 0;
		int left = 1;
		int right = 1;
		
		while (right <= k) {
			right += left;
			left = right - left;
		}
		
		while (left > 0) {
			if (left <= k) {
				k -= left;
				result++;
			}
			if (k == 0) { return result; }
			
			int temp = left;
			left = right - left;
			right = temp;
		}
		
		return result;
	}
	
}
