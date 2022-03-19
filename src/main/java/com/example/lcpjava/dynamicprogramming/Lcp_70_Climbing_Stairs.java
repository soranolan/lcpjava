package com.example.lcpjava.dynamicprogramming;

public class Lcp_70_Climbing_Stairs {
	
	/**
	 * time  : O(2 ^ n)
	 * space : O(n)
	 * 
	 * https://stackoverflow.com/questions/7547133/why-is-the-complexity-of-computing-the-fibonacci-series-2n-and-not-n2
	 * 
	 * 
	 * if n is lower than three
	 * 		return n
	 * end if
	 * 
	 * return climbStairs(n minus one) plus climbStairs(n minus two)
	 * */
	public int climbStairs_1(int n) {
		if (n < 3) { return n; }
		return climbStairs_1(n - 1) + climbStairs_1(n - 2);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Top-Down Memoization
	 * 
	 * 
	 * int[] memo <- new int[n plus one]
	 * memo[0] <- 1
	 * memo[1] <- 1
	 * 
	 * return recursion(n, memo)
	 * */
	public int climbStairs_2(int n) {
		int[] memo = new int[n + 1];																				// S : O(n + 1)
		memo[0] = 1;
		memo[1] = 1;
		
		return recursion(n, memo);
	}
	
	/**
	 * if memo[n] is not equal to zero
	 * 		return memo[n]
	 * end if
	 * 
	 * memo[n] <- recursion(n minus one, memo) plus recursion(n minus two, memo)
	 * 
	 * return memo[n]
	 * */
	public int recursion(int n, int[] memo) {
		if (memo[n] != 0) { return memo[n]; }
		memo[n] = recursion(n - 1, memo) + recursion(n - 2, memo);
		return memo[n];
	}
	
	/**
	 * dp[1] = 1
	 * 
	 * dp[2] = 2
	 * 1 + 1
	 * 2 + 0
	 * 
	 * dp[3] = 3
	 * 1 + 2
	 * 
	 * 1 + 1 + 1
	 * 2 + 1
	 * 
	 * dp[4] = 5
	 * 1 + 1 + 1 + 1
	 * 1 + 2 + 1
	 * 2 + 1 + 1
	 * 
	 * 1 + 1 + 2
	 * 2 + 2
	 * */
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Bottom-Up
	 * 
	 * 
	 * int[] dp <- new int[n plus one]
	 * dp[0] <- 1
	 * dp[1] <- 1
	 * 
	 * for int i <- 2; if i is lower than or equal to n; i++
	 * 		dp[i] <- dp[i minus one] plus dp[i minus two]
	 * end for
	 * 
	 * return dp[n]
	 * */
	public int climbStairs_3(int n) {
		int[] dp = new int[n + 1];																					// S : O(n + 1)
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {																				// T : O(n - 1)
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		return dp[n];
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Fibonacci Optimization
	 * 
	 * 
	 * int previous <- 1
	 * int current <- 1
	 * 
	 * for int i <- 2; if i is lower than or equal to n; i++
	 * 		int sum <- previous plus current
	 * 		previous <- current
	 * 		current <- sum
	 * end for
	 * 
	 * return current
	 * */
	public int climbStairs_4(int n) {
		int previous = 1;
		int current = 1;
		
		for (int i = 2; i <= n; i++) {																				// T : O(n - 1)
			int sum = previous + current;
			previous = current;
			current = sum;
		}
		
		return current;
	}
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * 
	 * Matrix
	 * 
	 * https://leetcode.com/problems/climbing-stairs/discuss/25643/O(log(n))-solution-with-matrix-multiplication
	 * */
	public int climbStairs_5(int n) {
		int[][] matrix = {
			{ 0, 1 },
			{ 1, 1 }
		};
		int[][] result = pow(matrix, n);
		return result[1][1];
	}
	
	public int[][] pow(int[][] matrix, int n) {
		int[][] result = {
			{ 1, 0 }, { 0, 1 }
		};
		
		while (n > 0) {
			if ((n & 1) == 1) {																						// if n is odd
				result = multiply(result, matrix);																	// set value to result
			}
			n >>= 1;
			matrix = multiply(matrix, matrix);																		// add
		}
		
		return result;
	}
	
	public int[][] multiply(int[][] left, int[][] right) {
		int[][] sum = new int[2][2];
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				sum[i][j] = left[i][0] * right[0][j] + left[i][1] * right[1][j];
			}
		}
		
		return sum;
	}
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * 
	 * Fibonacci formula
	 * 
	 * https://leetcode.com/problems/climbing-stairs/discuss/25436/Using-the-Fibonacci-formular-to-get-the-answer-directly
	 * */
	public int climbStairs_6(int n) {
		n++;
		double phi = (1 + Math.pow(5, 0.5)) / 2;
		double result = (Math.pow(phi, n) - Math.pow(-phi, -n)) / Math.pow(5, 0.5);
		return (int) (result);
	}
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * 
	 * Fibonacci formula
	 * */
	public int climbStairs(int n) {
		n++;
		double phi = (1 + Math.pow(5, 0.5)) / 2;
		double result = Math.pow(phi, n) / Math.pow(5, 0.5);
		return (int) Math.round(result);
	}
	
}
