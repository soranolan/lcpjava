package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lcp_392_Is_Subsequence {
	
	/**
	 * time  : O(n + m)
	 * space : O(1)
	 * 
	 * int sLength <- s length
	 * int tLength <- t length
	 * 
	 * if sLength is equal to zero && tLength is equal to zero
	 * 		return true
	 * end if
	 * 
	 * if sLength is equal to zero
	 * 		return true
	 * end if
	 * 
	 * if tLength is equal to zero
	 * 		return false
	 * end if
	 * 
	 * int left <- 0
	 * int right <- 0
	 * 
	 * while left is lower than sLength
	 * 		if right is greater than or equal to tLength
	 * 			return false
	 * 		end if
	 * 		
	 * 		if s charAt(left) is equal to t charAt(right)
	 * 			left++
	 * 			right++
	 * 		else
	 * 			right++
	 * 		end if
	 * end while
	 * 
	 * return true
	 * */
	public boolean isSubsequence_1(String s, String t) {
		int sLength = s.length();																					// n
		int tLength = t.length();																					// m
		if (sLength == 0 && tLength == 0) { return true; }
		if (sLength == 0) { return true; }
		if (tLength == 0) { return false; }
		
		int left = 0;
		int right = 0;
		
		while (left < sLength) {
			if (right >= tLength) { return false; }
			
			if (s.charAt(left) == t.charAt(right)) {
				left++;
				right++;
			} else {
				right++;
			}
		}
		
		return true;
	}
	
	/**
	 * time  : O(n + m)
	 * space : O(1)
	 * 
	 * int sLength <- s length
	 * int tLength <- t length
	 * 
	 * if sLength is equal to zero && tLength is equal to zero
	 * 		return true
	 * end if
	 * 
	 * if sLength is equal to zero
	 * 		return true
	 * end if
	 * 
	 * if tLength is equal to zero
	 * 		return false
	 * end if
	 * 
	 * int left <- 0
	 * int right <- 0
	 * 
	 * while left is lower than sLength && right is lower than tLength
	 * 		if s charAt(left) is equal to t charAt(right)
	 * 			left++
	 * 		end if
	 * 		
	 * 		right++
	 * end while
	 * 
	 * return if left is equal to sLength
	 * */
	public boolean isSubsequence_2(String s, String t) {
		int sLength = s.length();																					// n
		int tLength = t.length();																					// m
		if (sLength == 0 && tLength == 0) { return true; }
		if (sLength == 0) { return true; }
		if (tLength == 0) { return false; }
		
		int left = 0;
		int right = 0;
		
		while (left < sLength && right < tLength) {
			if (s.charAt(left) == t.charAt(right)) {
				left++;
			}
			right++;
		}
		
		return left == sLength;
	}
	
	/**
	 * time  : O(n + m)
	 * space : O(n + m)
	 * 
	 * https://leetcode.com/problems/is-subsequence/discuss/1811180/C%2B%2B-oror-Easy-oror-3-Approaches-oror-Brute-Force-oror-Recursive-oror-Memoization
	 * 
	 * 
	 * if recursion(s length, t length, s, t) is true
	 * 		return true
	 * end if
	 * 
	 * return false
	 * */
	public boolean isSubsequence_3(String s, String t) {
		if (recursion(s.length(), t.length(), s, t)) { return true; }
		return false;
	}
	
	/**
	 * if left is equal to zero
	 * 		return true
	 * end if
	 * 
	 * if right is equal to zero
	 * 		return false
	 * end if
	 * 
	 * if s charAt(left minus one) is equal to t charAt(right minus one)
	 * 		return recursion(left minus one, right minus one, s, t)
	 * else
	 * 		return recursion(left, right minus one, s, t)
	 * end if
	 * */
	public boolean recursion(int left, int right, String s, String t) {
		if (left == 0) { return true; }
		if (right == 0) { return false; }
		
		if (s.charAt(left - 1) == t.charAt(right - 1)) {
			return recursion(left - 1, right - 1, s, t);
		} else {
			return recursion(left, right - 1, s, t);
		}
	}
	
	/**
	 * time  : O(n + m)
	 * space : O(n * m)
	 * 
	 * Memoization
	 * 
	 * 
	 * int sLength <- s length
	 * int tLength <- t length
	 * int[][] dp <- new int[sLength plus one][tLength plus one]
	 * fill dp with minus one
	 * 
	 * if recursion(sLength, tLength, s, t, dp) is equal to sLength
	 * 		return true
	 * end if
	 * 
	 * return false
	 * */
	public boolean isSubsequence_4(String s, String t) {
		int sLength = s.length();																					// n
		int tLength = t.length();																					// m
		int[][] dp = new int[sLength + 1][tLength + 1];																// S : O(n * m)
		Arrays.asList(dp).stream().forEach(arr -> Arrays.fill(arr, -1));											// T : O(n * m)
		
		if (recursion(sLength, tLength, s, t, dp) == sLength) { return true; }
		
		return false;
	}
	
	/**
	 * if left is equal to zero || right is equal to zero
	 * 		return zero
	 * end if
	 * 
	 * if dp[left][right] is not equal to minus one
	 * 		return dp[left][right]
	 * end if
	 * 
	 * if s charAt(left minus one) is equal to t charAt(right minus one)
	 * 		return dp[left][right] <- one plus recursion(left minus one, right minus one, s, t, dp)
	 * else
	 * 		return dp[left][right] <- recursion(left, right minus one, s, t, dp)
	 * end if
	 * */
	public int recursion(int left, int right, String s, String t, int[][] dp) {
		if (left == 0 || right == 0) { return 0; }
		if (dp[left][right] != -1) { return dp[left][right]; }
		
		if (s.charAt(left - 1) == t.charAt(right - 1)) {
			return dp[left][right] = 1 + recursion(left - 1, right - 1, s, t, dp);
		} else {
			return dp[left][right] = recursion(left, right - 1, s, t, dp);
		}
	}
	
	/**
	 * Follow Up
	 * https://leetcode.com/problems/is-subsequence/discuss/87302/Binary-search-solution-for-follow-up-with-detailed-comments
	 * https://leetcode.com/problems/is-subsequence/discuss/87268/Java-code-for-the-follow-up-question
	 * */
	/**
	 * time  : O(n * k * log t)
	 * space : O(128 * m)
	 * 
	 * List<List<Integer>> tList <- new ArrayList<List<Integer>>(128)
	 * fill tList with empty ArrayList
	 * 
	 * for int i <- 0; if i is lower than t length; i++
	 * 		tList get(t charAt(i)) add(i)
	 * end for
	 * 
	 * int previousIndex <- minus one
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		List<Integer> indexList <- tList get(s charAt(i))
	 * 		if indexList is null
	 * 			return false
	 * 		end if
	 * 		
	 * 		int index <- binarySearch(previousIndex, indexList)
	 * 		
	 * 		if index is equal to minus one
	 * 			return false
	 * 		end if
	 * 		
	 * 		previousIndex <- index
	 * end for
	 * 
	 * return true
	 * */
	public boolean isSubsequence(String s, String t) {
		List<List<Integer>> tList = new ArrayList<List<Integer>>(128);												// S : O(128)
		for (int i = 0; i < 128; i++) { tList.add(new ArrayList<>()); }												// T : O(128)
		for (int i = 0; i < t.length(); i++) { tList.get(t.charAt(i)).add(i); }										// T : O(m)
		
		int previousIndex = -1;																						// previous character index
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			List<Integer> indexList = tList.get(s.charAt(i));
			if (indexList == null) { return false; }
			
			int index = binarySearch(previousIndex, indexList);														// T : O(log t)
			
			if (index == -1) { return false; }
			
			previousIndex = index;
		}
		
		return true;
	}
	
	/**
	 * int index <- minus one
	 * int start <- 0
	 * int end <- indexList size minus one
	 * 
	 * while start is lower than or equal to end
	 * 		int mid <- start plus (end minus start) divide by two
	 * 		int pivot <- indexList get(mid)
	 * 		
	 * 		if target is lower than pivot
	 * 			index <- pivot
	 * 			end <- mid minus one
	 * 		else
	 * 			start <- mid plus one
	 * 		end if
	 * end while
	 * 
	 * return index
	 * */
	public int binarySearch(int target, List<Integer> indexList) {
		int index = -1;
		int start = 0;
		int end = indexList.size() - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int pivot = indexList.get(mid);
			
			if (target < pivot) {
				index = pivot;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return index;
	}
	
}
