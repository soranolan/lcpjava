package com.example.lcpjava.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Lcp_1641_Count_Sorted_Vowel_Strings {
	
	/**
	 * time  : O(n!)
	 * space : O(n!)
	 * 
	 * https://leetcode.com/problems/count-sorted-vowel-strings/discuss/1779312/Java-Backtracking
	 * 
	 * 
	 * List<String> result <- new ArrayList
	 * String[] vowels <- a e i o u
	 * StringBuilder sb <- new StringBuilder
	 * 
	 * recursive(n, zero, sb, vowels, result)
	 * 
	 * return result size
	 * */
	public int countVowelStrings_1(int n) {
		List<String> result = new ArrayList<>();
		String[] vowels = { "a", "e", "i", "o", "u" };
		StringBuilder sb = new StringBuilder();
		
		recursive(n, 0, sb, vowels, result);
		
		return result.size();
	}
	
	/**
	 * if n is equal to sb length
	 * 		result add(sb to string)
	 * 		return
	 * end if
	 * 
	 * for int i <- lastCharacter; if i is lower than vowerls length; i++
	 * 		sb append(vowels[i])
	 * 		
	 * 		recursive(n, i, sb, vowels, result)
	 * 		
	 * 		sb delete last char
	 * end for
	 * */
	private void recursive(int n, int lastCharacter, StringBuilder sb, String[] vowels, List<String> result) {
		if (n == sb.length()) {
			result.add(sb.toString());
			return;
		}
		for (int i = lastCharacter; i < vowels.length; i++) {
			sb.append(vowels[i]);
			recursive(n, i, sb, vowels, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	/**
	 * time  : O(n!)
	 * space : O(n!)
	 * 
	 * https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918481/JAVA-Back-Track
	 * 
	 * count <- 0
	 * 
	 * recursive(n, zero)
	 * 
	 * return count
	 * */
	private int count;
	public int countVowelStrings_2(int n) {
		count = 0;
		recursive(n, 0);
		return count;
	}
	
	/**
	 * if n is equal to zero
	 * 		count++
	 * 		return
	 * end if
	 * 
	 * for int i <- lastCharacter; if i is lower than five; i++
	 * 		recursive(n minus one, i)
	 * end for
	 * */
	private void recursive(int n, int lastCharacter) {
		if (n == 0) {
			count++;
			return;
		}
		for (int i = lastCharacter; i < 5; i++) { recursive(n - 1, i); }
	}
	
	/**
	 * https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918498/JavaC%2B%2BPython-DP-O(1)-Time-and-Space
	 * 
	 *        u  o  i  e  a
	 *  k  0  1  2  3  4  5
	 * n
	 * 0   0  0  0  0  0  0
	 * 1   0  1  1  1  1  1
	 * 2   0  1  2  3  4  5
	 * 3   0  1  3  6 10 15
	 * 4   0  1  4 10 20 35
	 * */
	/**
	 * time  : O(n * k)
	 * space : O(n * k)
	 * 
	 * int[][] dp <- new int[n plus two][6]
	 * dp[0][1] <- 1
	 * 
	 * for int i <- 1; if i is lower than or equal to n plus one; i++
	 * 		for int k <- 1; if k is lower than or equal to five; k++
	 * 			dp[i][k] <- dp[i minus one][k] plus dp[i][k minus one]
	 * 		end for
	 * end for
	 * 
	 * return dp[n plus one][5]
	 * */
	public int countVowelStrings_3(int n) {
		int[][] dp = new int[n + 2][6];																				// S : O(n * k)
		dp[0][1] = 1;
		
		for (int i = 1; i <= n + 1; i++) {																			// T : O(n)
			for (int k = 1; k <= 5; k++) {																			// T : O(k)
				dp[i][k] = dp[i - 1][k] + dp[i][k - 1];
			}
		}
		
		return dp[n + 1][5];
	}
	
	/**
	 * 0  1  1  1  1  1
	 * 0  1  2  3  4  5
	 * 0  1  3  6 10 15
	 * 0  1  4 10 20 35
	 * 0  1  5 15 35 70
	 * */
	/**
	 * time  : O(n * k)
	 * space : O(6)
	 * 
	 * int[] dp <- [ 0, 1, 1, 1, 1, 1 ]
	 * 
	 * for int i <- 1; if i is lower than or equal to n; i++
	 * 		for int k <- 1; if k is lower than or equal to five; k++
	 * 			dp[k] <- dp[k] plus dp[k minus one]
	 * 		end for
	 * end for
	 * 
	 * return dp[5]
	 * */
	public int countVowelStrings_4(int n) {
		int[] dp = { 0, 1, 1, 1, 1, 1 };																			// S : O(6)
		
		for (int i = 1; i <= n; i++) {																				// T : O(n)
			for (int k = 1; k <= 5; k++) {																			// T : O(k)
				dp[k] += dp[k - 1];
			}
		}
		
		return dp[5];
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * 
	 * Math is the king!
	 * 
	 * https://leetcode.com/problems/count-sorted-vowel-strings/discuss/1021493/One-line-solution-or-Math-or-No-DP-no-Big-Integers-or-O(1)-time-space
	 * */
	public int countVowelStrings(int n) {
		return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
	}
	
}
