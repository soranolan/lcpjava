package com.example.lcpjava.array;

public class Lcp_647_Palindromic_Substrings {
	
	/**
	 * time  : O(n ^ 3)
	 * space : O(1)
	 * 
	 * Brute Force
	 * 
	 * 
	 * int count <- 0
	 * int length <- s length
	 * if s is equal to null || length is equal to zero
	 * 		return zero
	 * end if
	 * 
	 * for int left <- 0; if left is lower than length; left++
	 * 		for int right <- left; if right is lower than length; right++
	 * 			if valid(left, right, s)
	 * 				count++
	 * 			end if
	 * 		end for
	 * end for
	 * 
	 * return count
	 * */
	public int countSubstrings_1(String s) {
		int count = 0;
		int length = s.length();
		if (s == null || length == 0) { return 0; }
		
		for (int left = 0; left < length; left++) {																	// T : O(n)
			for (int right = left; right < length; right++) {														// T : O(n)
				if (valid(left, right, s)) { count++; }
			}
		}
		
		return count;
	}
	
	/**
	 * while left is lower than or equal to right
	 * 		if s charAt(left) is not equal to s charAt(right)
	 * 			return false
	 * 		end if
	 * 		
	 * 		left++
	 * 		right--
	 * end while
	 * 
	 * return true
	 * */
	public boolean valid(int left, int right, String s) {
		while (left <= right) {																						// T : O(n)
			if (s.charAt(left) != s.charAt(right)) { return false; }
			left++;
			right--;
		}
		return true;
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/palindromic-substrings/discuss/105688/Very-Simple-Java-Solution-with-Detail-Explanation
	 * 
	 * 
	 * int length <- s length
	 * if s is equal to null || length is equal to zero
	 * 		return zero
	 * end if
	 * 
	 * int count <- 0
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		count <- count + getCount(i, i, s)
	 * 		count <- count + getCount(i, i plus one, s)
	 * end for
	 * 
	 * return count
	 * */
	public int countSubstrings_2(String s) {
		int length = s.length();
		if (s == null || length == 0) { return 0; }
		
		int count = 0;
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			count += getCount(i, i, s);																				// odd
			count += getCount(i, i + 1, s);																			// even
		}
		
		return count;
	}
	
	/**
	 * int length <- s length
	 * int count <- 0
	 * 
	 * while left is greater than or equal to zero && right is lower than length
	 * 		if s charAt(left) is not equal to s charAt(right)
	 * 			break
	 * 		end if
	 * 		
	 * 		left--
	 * 		right++
	 * 		count++
	 * end while
	 * 
	 * return count
	 * */
	public int getCount(int left, int right, String s) {
		int length = s.length();
		int count = 0;
		
		while (left >= 0 && right < length) {																		// T : O(n)
			if (s.charAt(left) != s.charAt(right)) { break; }
			left--;
			right++;
			count++;
		}
		
		return count;
	}
	
	/**
	 * https://leetcode.com/problems/palindromic-substrings/discuss/105707/Java-Python-DP-solution-based-on-longest-palindromic-substring
	 * 
	 * s.charAt(start) == s.charAt(end) : start and end is equal
	 * end - start == 0 : single character
	 * end - start == 1 : two character
	 * end - start == 2 : three character, but we can ignore the middle one
	 * 
	 * dp[start + 1][end - 1] : checking the middle character
	 * acda : dp[1][4]
	 * cd   : dp[2][3]
	 *                 e
	 *                 ¡õ
	 *         a a c d a
	 *         0 1 2 3 4
	 *     a 0 t f f f f
	 * s ¡÷ a 1 f t f f f
	 *     c 2 f f t f f
	 *     d 3 f f f t f
	 *     a 4 f f f f t
	 * */
	/**
	 * time  : O(n ^ 2)
	 * space : O(n ^ 2)
	 * 
	 * int length <- s length
	 * if s is equal to null || length is equal to zero
	 * 		return zero
	 * end if
	 * 
	 * int count <- 0
	 * boolean[][] dp <- new boolean[length][length]
	 * 
	 * for int start <- length minus one; if start is greater than zero; start--
	 * 		for int end <- start; if end is lower than length; end++
	 * 			dp[start][end] <- if substring left is equal to right && substring size is lower than or equal to three else dp[middle]
	 * 			
	 * 			if dp[start][end] is true
	 * 				count++
	 * 			end if
	 * 		end for
	 * end for
	 * 
	 * return count
	 * */
	public int countSubstrings(String s) {
		int length = s.length();
		if (s == null || length == 0) { return 0; }
		
		int count = 0;
		boolean[][] dp = new boolean[length][length];																// S : O(n ^ 2)
		
		for (int start = length - 1; start >= 0; start--) {															// T : O(n)
			for (int end = start; end < length; end++) {															// T : O(n)
				dp[start][end] = s.charAt(start) == s.charAt(end) && (end - start + 1 < 3 || dp[start + 1][end - 1]);
				if (dp[start][end]) { count++; }
			}
		}
		
		return count;
	}
	
}
