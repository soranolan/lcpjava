package com.example.lcpjava.array;

public class Lcp_5_Longest_Palindromic_Substring {
	
	/**
	 * time  : O(n ^ 3)
	 * space : O(1)
	 * 
	 * Brute Force
	 * Time Limit Exceeded
	 * */
	public String longestPalindrome_1(String s) {
		int length = s.length();																					// n
		if (length == 1) { return s; }
		
		int max = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int start = 0; start < length; start++) {																// T : O(n)
			for (int end = 1; end < length; end++) {																// T : O(n)
				int size = end - start + 1;
				
				if (isValid(start, end, s) && size > max) {															// T : O(n)
					sb.setLength(0);
					for (int i = start; i <= end; i++) { sb.append(s.charAt(i)); }
					max = size;
				}
			}
		}
		
		return sb.toString();
	}
	
	private boolean isValid(int start, int end, String s) {
		while (start < end) {
			char left = s.charAt(start);
			char right = s.charAt(end);
			
			if (left != right) { return false; }
			
			start++;
			end--;
		}
		return true;
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n ^ 2)
	 * 
	 * https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using-dynamic-programming
	 * */
	public String longestPalindrome_2(String s) {
		int length = s.length();																					// n
		String result = null;
		boolean[][] dp = new boolean[length][length];																// S : O(n ^ 2)
		
		for (int start = length - 1; start >= 0; start--) {															// T : O(n)
			for (int end = start; end < length; end++) {															// T : O(n)
				// end - start < 3 : ab aa aba aaa
				dp[start][end] = s.charAt(start) == s.charAt(end) && (end - start < 3 || dp[start + 1][end - 1]);
				
				int size = end - start + 1;
				if (dp[start][end] && (result == null || size > result.length())) {
					result = s.substring(start, end + 1);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * */
	public String longestPalindrome(String s) {
		int start = 0;
		int end = 0;
		int max = 0;
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			int odd = expandAroundCenter(s, i, i);																	// T : O(n)
			int even = expandAroundCenter(s, i, i + 1);																// T : O(n)
			
			int length = Math.max(odd, even);
			
			if (length > max) {
				max = length;
				start = i - (length - 1) / 2;
				end = i + length / 2;
			}
		}
		
		return s.substring(start, end + 1);
	}
	
	private int expandAroundCenter(String s, int start, int end) {
		int left = start;
		int right = end;
		
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		
		return right - left - 1;
	}
	
}
