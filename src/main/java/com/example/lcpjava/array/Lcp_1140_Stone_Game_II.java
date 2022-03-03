package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_1140_Stone_Game_II {
	
	/**
	 * time  : O(4 * M ^ 2)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/stone-game-ii/discuss/434340/Recursive-Bruteforce-Recursive-DP-two-state-Recursive-DP-Single-state-and-Iterative-DP-Solutions.
	 * Brute Force
	 * 
	 * 
	 * return recursion(zero, one, piles, false)
	 * */
	public int stoneGameII_1(int[] piles) {
		return recursion_1(0, 1, piles, false);
	}
	
	/**
	 * int length <- piles length
	 * 
	 * if index is greater than or equal to length
	 * 		return zero
	 * end if
	 * 
	 * int stones <- 0
	 * int temp <- 0
	 * 
	 * if turn is true
	 * 		stones <- Integer max value
	 * 		
	 * 		for int i <- 0; if i is lower than two multiply M; i++
	 * 			if index plus i is greater than or equal to length
	 * 				break
	 * 			end if
	 * 			
	 * 			stones <- Math min(stones, recursion(index plus i plus one, Math max(M, i plus one), piles, switch turn))
	 * 		end for
	 * else
	 * 		for int i <- 0; if i is lower than two multiply M; i++
	 * 			if index plus i is greater than or equal to length
	 * 				break
	 * 			end if
	 * 			
	 * 			temp <- temp plus piles[index plus i]
	 * 			stones <- Math max(stones, temp plus recursion(index plus i plus one, Math max(M, i plus one), piles, switch turn))
	 * 		end for
	 * end if
	 * 
	 * return stones
	 * */
	public int recursion_1(int index, int M, int[] piles, boolean turn) {
		int length = piles.length;
		if (index >= length) { return 0; }
		
		int stones = 0;
		int temp = 0;
		
		if (turn) {
			stones = Integer.MAX_VALUE;
			for (int i = 0; i < 2 * M; i++) {																		// T : O(2M)
				if (index + i >= length) { break; }
				stones = Math.min(stones, recursion_1(index + i + 1, Math.max(M, i + 1), piles, !turn));
			}
		} else {
			for (int i = 0; i < 2 * M; i++) {																		// T : O(2M)
				if (index + i >= length) { break; }
				temp += piles[index + i];
				stones = Math.max(stones, temp + recursion_1(index + i + 1, Math.max(M, i + 1), piles, !turn));
			}
		}
		
		return stones;
	}
	
	/**
	 * time  : O(4 * M ^ 2)
	 * space : O(101 * 65 * 2)
	 * 
	 * int length <- piles length
	 * 
	 * int maxM <- 1
	 * 
	 * while maxM multiply two is lower than length
	 * 		maxM <- maxM multiply two
	 * end while
	 * 
	 * int[][][] dp <- new int[length plus one][maxM plus one][2]
	 * 
	 * Arrays fill (dp, minus one)
	 * 
	 * return recursion(zero, one, piles, zero, dp)
	 * */
	public int stoneGameII_2(int[] piles) {
		int length = piles.length;
		
		int maxM = 1;
		while (maxM * 2 < length) { maxM *= 2; }
		
		int[][][] dp = new int[length + 1][maxM + 1][2];																// S : O(101 * 65 * 2)
		
		Arrays.stream(dp).forEach(twoD -> Arrays.stream(twoD).forEach(oneD -> Arrays.fill(oneD, -1)));
		
		return recursion_2(0, 1, piles, 0, dp);
	}
	
	/**
	 * int length <- piles length
	 * 
	 * if index is greater than or equal to length
	 * 		return zero
	 * end if
	 * 
	 * if dp[index][M][turn] is not equal to minus one
	 * 		return dp[index][M][turn]
	 * end if
	 * 
	 * int stones <- 0
	 * int temp <- 0
	 * 
	 * if turn is equal to one
	 * 		stones <- Integer max value
	 * 		
	 * 		for int i <- 0; if i is lower than two multiply M; i++
	 * 			if index plus i is greater than or equal to length
	 * 				break
	 * 			end if
	 * 			
	 * 			stones <- Math min(stones, recursion(index plus i plus one, Math max(M, i plus one), piles, zero, switch turn))
	 * 		end for
	 * else
	 * 		for int i <- 0; if i is lower than two multiply M; i++
	 * 			if index plus i is greater than or equal to length
	 * 				break
	 * 			end if
	 * 			
	 * 			temp <- temp plus piles[index plus i]
	 * 			stones <- Math max(stones, temp plus recursion(index plus i plus one, Math max(M, i plus one), piles, one, switch turn))
	 * 		end for
	 * end if
	 * 
	 * dp[index][M][turn] <- stones
	 * 
	 * return stones
	 * */
	public int recursion_2(int index, int M, int[] piles, int turn, int[][][] dp) {
		int length = piles.length;
		if (index >= length) { return 0; }
		if (dp[index][M][turn] != -1) { return dp[index][M][turn]; }
		
		int stones = 0;
		int temp = 0;
		
		if (turn == 1) {
			stones = Integer.MAX_VALUE;
			for (int i = 0; i < 2 * M; i++) {																		// T : O(2M)
				if (index + i >= length) { break; }
				stones = Math.min(stones, recursion_2(index + i + 1, Math.max(M, i + 1), piles, 0, dp));
			}
		} else {
			for (int i = 0; i < 2 * M; i++) {																		// T : O(2M)
				if (index + i >= length) { break; }
				temp += piles[index + i];
				stones = Math.max(stones, temp + recursion_2(index + i + 1, Math.max(M, i + 1), piles, 1, dp));
			}
		}
		
		dp[index][M][turn] = stones;
		return stones;
	}
	
	/**
	 * time  : O(2M)
	 * space : O(101 * 65)
	 * 
	 * https://leetcode.com/problems/stone-game-ii/discuss/345230/JavaPython-DP-Solution
	 * Minimax Algorithm
	 * 
	 * 
	 * int length <- piles length
	 * int[] preSum <- Arrays copyOf(piles, length)
	 * 
	 * for int i <- length minus two; if i is greater than or equal to zero; i--
	 * 		preSum[i] <- preSum[i] plus preSum[i plus one]
	 * end for
	 * 
	 * int maxM <- 1
	 * 
	 * while maxM multiply two is lower than length
	 * 		maxM <- maxM multiply two
	 * end while
	 * 
	 * int[][] dp <- new int[length plus one][maxM plus one]
	 * 
	 * return recursion(zero, one, preSum, dp)
	 * */
	public int stoneGameII(int[] piles) {
		int length = piles.length;
		int[] preSum = Arrays.copyOf(piles, length);																// S : O(n)
		for (int i = length - 2; i >= 0; i--) { preSum[i] += preSum[i + 1]; }										// T : O(n - 2)
		
		int maxM = 1;
		while (maxM * 2 < length) { maxM *= 2; }
		int[][] dp = new int[length + 1][maxM + 1];																	// S : O(101 * 65)
		
		return recursion(0, 1, preSum, dp);
	}
	
	/**
	 * int length <- preSum length
	 * 
	 * if index is greater than or equal to length
	 * 		return zero
	 * end if
	 * 
	 * int thisTurnSum <- preSum[index]
	 * 
	 * if length minus index is lower than two multiply M
	 * 		return thisTurnSum
	 * end if
	 * 
	 * if dp[index][M] is greater than zero
	 * 		return dp[index][M]
	 * end if
	 * 
	 * int stones <- 0
	 * int myStones <- 0
	 * 
	 * for int i <- 1; if i is lower than or equal to two multiply M; i++
	 * 		int nextTurnSum <- preSum[index plus i]
	 * 		myStones <- thisTurnSum minus nextTurnSum
	 * 		
	 * 		int nextPlayerStones <- recursion(index plus i, Math max(i, M), preSum, dp)
	 * 		int remaining <- nextTurnSum minus nextPlayerStones
	 * 		
	 * 		stones <- Math max(stones, myStones plus remaining)
	 * end for
	 * 
	 * dp[index][M] <- stones
	 * return stones
	 * */
	public int recursion(int index, int M, int[] preSum, int[][] dp) {
		int length = preSum.length;
		if (index >= length) { return 0; }
		
		int thisTurnSum = preSum[index];
		if (length - index <= 2 * M) { return thisTurnSum; }														// take the remaining stones
		
		if (dp[index][M] > 0) { return dp[index][M]; }
		
		int stones = 0;
		int myStones = 0;
		
		for (int i = 1; i <= 2 * M; i++) {																			// T : O(2M)
			int nextTurnSum = preSum[index + i];
			myStones = thisTurnSum - nextTurnSum;
			
			int nextPlayerStones = recursion(index + i, Math.max(i, M), preSum, dp);
			int remaining = nextTurnSum - nextPlayerStones;
			
			stones = Math.max(stones, myStones + remaining);
		}
		
		dp[index][M] = stones;
		return stones;
	}
	
}
