package com.example.lcpjava.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Lcp_279_Perfect_Squares {
	
	/**
	 * time  : O(n * sqrt(n))
	 * space : O(n)
	 * 
	 * Queue<Integer> queue <- new LinkedList
	 * Set<Integer> visited <- new HashSet
	 * int result <- 0
	 * 
	 * queue offer(0)
	 * visited add(0)
	 * 
	 * while queue is not empty
	 * 		int size <- queue size
	 * 		result++
	 * 		
	 * 		while size is greater than zero
	 * 			size--
	 * 			int number <- queue poll
	 * 			
	 * 			for int i <- 1; if i multiply i is lower than or equal to n; i++
	 * 				int sum <- number plus (i multiply i)
	 * 				if visited contains sum
	 * 					continue
	 * 				end if
	 * 				if sum is equal to n
	 * 					return result
	 * 				end if
	 * 				if sum is greater than n
	 * 					break loop
	 * 				end if
	 * 				
	 * 				queue offer(sum)
	 * 				visited add(sum)
	 * 			end for
	 * 		end while
	 * end while
	 * 
	 * return result
	 * */
	public int numSquares_1(int n) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();																		// S : O(n)
		int result = 0;
		
		queue.offer(0);
		visited.add(0);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			result++;
			
			while (size > 0) {																						// T : O(n)
				size--;
				int number = queue.poll();
				
				for (int i = 1; i * i <= n; i++) {																	// T : O(sqrt(n))
					int sum = number + i * i;
					if (visited.contains(sum)) { continue; }
					if (sum == n) { return result; }
					if (sum > n) { break; }
					
					queue.offer(sum);
					visited.add(sum);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(sqrt(n))
	 * space : O(1)
	 * 
	 * Math is the king!
	 * 
	 * Lagrange's Four Square theorem
	 * Legendre's three-square theorem
	 * 
	 * if n is perfect square
	 * 		return 1
	 * end if
	 * 
	 * while n mod four is equal to zero
	 * 		n <- n divide four
	 * end while
	 * 
	 * if n mod eight is equal to seven
	 * 		return 4
	 * end if
	 * 
	 * int sqrt <- (int) Math sqrt(n)
	 * for int i <- 1; if i is lower than or equal to sqrt; i++
	 * 		if n minus i * i is not perfect square
	 * 			continue
	 * 		end if
	 * 		return 2
	 * end for
	 * 
	 * return 3
	 * */
	public int numSquares_2(int n) {
		if (isSqrt(n)) { return 1; }
		
		while ((n & 3) == 0) { n >>= 2; }
		
		if ((n & 7) == 7) { return 4; }
		
		int sqrt = (int) Math.sqrt(n);
		for (int i = 1; i <= sqrt; i++) {																			// T : O(sqrt(n))
			if (!isSqrt(n - i * i)) { continue; }
			return 2;
		}
		
		return 3;
	}
	
	public boolean isSqrt(int number) {
		int sqrt = (int) Math.sqrt(number);
		if (sqrt * sqrt == number) { return true; }
		return false;
	}
	
	/**
	 * dp[0] = 0
	 * 
	 * dp[1] = 1
	 * 				= dp[0] + 1
	 * 				= dp[1 - 1 * 1] + 1
	 * 
	 * dp[2] = 2
	 * 				= dp[1] + 1
	 * 				= dp[2 - 1 * 1] + 1
	 * 
	 * dp[3] = 3
	 * 				= dp[2] + 1
	 * 				= dp[3 - 1 * 1] + 1
	 * 
	 * dp[4] = 1
	 * 				= 1 ^ 2 * 4 or 2 ^ 2
	 * 				= 4 or 1
	 * 				= dp[3] + 1 or dp[1]
	 * 				= dp[3] + 1 or dp[0] + 1
	 * 				= dp[4 - 1 * 1] + 1 or dp[4 - 2 * 2] + 1
	 * 
	 * dp[5] = 2
	 * 				= 1 ^ 2 * 5 or 2 ^ 2 + 1
	 * 				= 5 or 2
	 * 				= 2
	 * 				= dp[4] + 1 or dp[1] + 1
	 * 				= dp[5 - 1 * 1] + 1 or dp[5 - 2 * 2] + 1
	 * 
	 * dp[6] = 3
	 * 				= 1 ^ 2 * 6 or 2 ^ 2 + 1 + 1
	 * 				= 6 or 3
	 * 				= 3
	 * 				= dp[5] + 1 or dp[3]
	 * 				= dp[5] + 1 or dp[2] + 1
	 * 				= dp[6 - 1 * 1] + 1 or dp[6 - 2 * 2] + 1
	 * 
	 * dp[7] = 4
	 * 				= 1 ^ 2 * 7 or 2 ^ 2 + 1 + 1 + 1
	 * 				= 7 or 4
	 * 				= 4
	 * 				= dp[6] + 1 or dp[3] + 1
	 * 				= dp[7 - 1 * 1] + 1 or dp[7 - 2 * 2] + 1
	 * 
	 * dp[13] = 2
	 * 				= 1 or 4 or 9
	 * 				= 1 + 12 or 4 + 9 or 9 + 4
	 * 				= 1 + dp[12] or 1 + dp[9] or 1 + dp[4]
	 * */
	/**
	 * time  : O(n * sqrt(n))
	 * space : O(n)
	 * 
	 * int[] dp <- new int[n plus one]
	 * Arrays fill(dp, Integer max value)
	 * dp[0] <- 0
	 * 
	 * for int i <- 1; if i is lower than or equal to n; i++
	 * 		int min <- Integer max value
	 * 		int j <- 1
	 * 		while i minus j multiply j is greater than or equal to zero
	 * 			min <- Math min(min, dp[i minus j multiply j] plus one)
	 * 			j++
	 * 		end while
	 * 		dp[i] <- min
	 * end for
	 * 
	 * return dp[n]
	 * */
	public int numSquares_3(int n) {
		int[] dp = new int[n + 1];																					// S : O(n)
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 1; i <= n; i++) {																				// T : O(n)
			int min = Integer.MAX_VALUE;
			int j = 1;
			while (i - j * j >= 0) {																				// T : O(sqrt(n))
				min = Math.min(min, dp[i - j * j] + 1);
				j++;
			}
			dp[i] = min;
		}
		
		return dp[n];
	}
	
	/**
	 * time  : O(n * sqrt(n))
	 * space : O(n)
	 * 
	 * if list size is equal to zero
	 * 		list add(0)
	 * end if
	 * 
	 * while list size is lower than or equal to n
	 * 		int size <- list size
	 * 		int min <- Integer max value
	 * 		
	 * 		for int i <- 1; if i multiply i is lower than or equal to size; i++
	 * 			min <- Math min(min, list get(size minus i multiply i) plus one
	 * 		end for
	 * 		
	 * 		list add(min)
	 * end while
	 * 
	 * return list get(n)
	 * */
	static List<Integer> static_dp = new ArrayList<>();																// S : O(n)
	public int numSquares(int n) {
		if (static_dp.size() == 0) { static_dp.add(0); }
		
		while (static_dp.size() <= n) {																				// T : O(n)
			int size = static_dp.size();
			int min = Integer.MAX_VALUE;
			for (int i = 1; i * i <= size; i++) { min = Math.min(min, static_dp.get(size - i * i) + 1); }			// T : O(sqrt(n))
			static_dp.add(min);
		}
		
		return static_dp.get(n);
	}
	
}
