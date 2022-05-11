package com.example.lcpjava.array;

public class Lcp_926_Flip_String_to_Monotone_Increasing {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/1269957/Two-concepts-four-implementation-with-explanation-for-beginners.
	 * 
	 * 
	 * int length <- s length
	 * int[] ones <- new int[length]
	 * int[] zeros <- new int[length]
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		if s charAt(i) is equal to char one
	 * 			ones[i] <- if i is equal to zero then zero else ones[i minus one], plus one
	 * 		else
	 * 			ones[i] <- if i is equal to zero then zero else ones[i minus one]
	 * 		end if
	 * end for
	 * 
	 * for int i <- length minus one; if i is greater then or equal to zero; i--
	 * 		if s charAt(i) is equal to char zero
	 * 			zeros[i] <- if i is equal to length minus one then zero else zeros[i plus one], plus one
	 * 		else
	 * 			zeros[i] <- if i is equal to length minus one then zero else zeros[i plus one]
	 * 		end if
	 * end for
	 * 
	 * int minFlips <- Integer maximum value
	 * 
	 * for int i <- 0; if i is lower than or equal to length; i++
	 * 		int leftOnes <- if i is equal to zero then zero else ones[i minus one]
	 * 		int rightZeros <- if i is equal to length then zero else zeros[i]
	 * 		minFlips <- Math min(minFlips, leftOnes plus rightZeros)
	 * end for
	 * 
	 * return minFlips
	 * */
	public int minFlipsMonoIncr_1(String s) {
		int length = s.length();																					// n
		int[] ones = new int[length];																				// S : O(n)
		int[] zeros = new int[length];																				// S : O(n)
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			if (s.charAt(i) == '1') {																				// T : O(1)
				ones[i] = (i == 0 ? 0 : ones[i - 1]) + 1;
			} else {
				ones[i] = (i == 0 ? 0 : ones[i - 1]);
			}
		}
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			if (s.charAt(i) == '0') {																				// T : O(1)
				zeros[i] = (i == length - 1 ? 0 : zeros[i + 1]) + 1;
			} else {
				zeros[i] = (i == length - 1 ? 0 : zeros[i + 1]);
			}
		}
		
		int minFlips = Integer.MAX_VALUE;
		
		for (int i = 0; i <= length; i++) {																			// T : O(n)
			int leftOnes = (i == 0 ? 0 : ones[i - 1]);
			int rightZeros = (i == length ? 0 : zeros[i]);
			minFlips = Math.min(minFlips, leftOnes + rightZeros);
		}
		
		return minFlips;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int length <- s length
	 * int[] ones <- new int[length]
	 * int[] zeros <- new int[length]
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		if s charAt(i) is equal to char one
	 * 			ones[i] <- if i is equal to zero then zero else ones[i minus one], plus one
	 * 		else
	 * 			ones[i] <- if i is equal to zero then zero else ones[i minus one]
	 * 		end if
	 * end for
	 * 
	 * int minFlips <- Integer maximum value
	 * 
	 * for int i <- 0; if i is lower than or equal to length; i++
	 * 		int leftOnes <- if i is equal to zero then zero else ones[i minus one]
	 * 		int rightOnes <- ones[length minus one] minus leftOnes
	 * 		int rightZeros <- length minus i minus rightOnes
	 * 		minFlips <- Math min(minFlips, leftOnes plus rightZeros)
	 * end for
	 * 
	 * return minFlips
	 * */
	public int minFlipsMonoIncr_2(String s) {
		int length = s.length();																					// n
		int[] ones = new int[length];																				// S : O(n)
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			if (s.charAt(i) == '1') {																				// T : O(1)
				ones[i] = (i == 0 ? 0 : ones[i - 1]) + 1;
			} else {
				ones[i] = (i == 0 ? 0 : ones[i - 1]);
			}
		}
		
		int minFlips = Integer.MAX_VALUE;
		
		for (int i = 0; i <= length; i++) {																			// T : O(n)
			int leftOnes = (i == 0 ? 0 : ones[i - 1]);
			int rightOnes = ones[length - 1] - leftOnes;
			int rightZeros = length - i - rightOnes;
			minFlips = Math.min(minFlips, leftOnes + rightZeros);
		}
		
		return minFlips;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int length <- s length
	 * int ones <- 0
	 * int[] dp <- new int[length plus one]
	 * 
	 * for int i <- 1; if i is lower than or equal to length; i++
	 * 		if s charAt(i minus one) is equal to char one
	 * 			dp[i] <- dp[i minus one]
	 * 			ones++
	 * 		else
	 * 			dp[i] <- Math min(dp[i minus one] plus one, ones)
	 * 		end if
	 * end for
	 * 
	 * return dp[length]
	 * */
	public int minFlipsMonoIncr_3(String s) {
		int length = s.length();																					// n
		int ones = 0;
		int[] dp = new int[length + 1];																				// S : O(n + 1)
		
		for (int i = 1; i <= length; i++) {																			// T : O(n)
			if (s.charAt(i - 1) == '1') {
				dp[i] = dp[i - 1];
				ones++;
			} else {
				dp[i] = Math.min(dp[i - 1] + 1, ones);
			}
		}
		
		return dp[length];
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/189751/C%2B%2B-one-pass-DP-solution-0ms-O(n)-or-O(1)-one-line-with-explaination.
	 * 
	 * 
	 * int ones <- 0
	 * int flips <- 0
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		if s charAt(i) is equal to char one
	 * 			ones++
	 * 		else
	 * 			flips <- Math min(flips plus one, ones)
	 * 		end if
	 * end for
	 * 
	 * return flips;
	 * */
	public int minFlipsMonoIncr(String s) {
		int ones = 0;
		int flips = 0;
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			if (s.charAt(i) == '1') {																				// if we encountered new one 
				ones++;
			} else {																								// if we encountered new zero
				flips = Math.min(flips + 1, ones);																	// previous flips count plus new zero v.s. previous ones count
			}
		}
		
		return flips;
	}
	
}
