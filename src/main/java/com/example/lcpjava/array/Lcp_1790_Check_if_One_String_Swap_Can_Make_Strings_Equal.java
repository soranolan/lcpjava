package com.example.lcpjava.array;

public class Lcp_1790_Check_if_One_String_Swap_Can_Make_Strings_Equal {
	
	/**
	 * time  : O(n)
	 * space : O(52)
	 * 
	 * Wrong Answer
	 * 
	 * at most one string swap on exactly one of the strings.
	 * */
	public boolean areAlmostEqual_1(String s1, String s2) {
		int[] bucket1 = new int[26];																				// S : O(26)
		int[] bucket2 = new int[26];																				// S : O(26)
		
		for (int i = 0; i < s1.length(); i++) { bucket1[s1.charAt(i) - 'a']++; }									// T : O(n)
		
		for (int i = 0; i < s2.length(); i++) { bucket2[s2.charAt(i) - 'a']++; }									// T : O(n)
		
		for (int i = 0; i < 26; i++) {																				// T : O(26)
			if (bucket1[i] != bucket2[i]) { return false; }
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(52)
	 * 
	 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/discuss/1108695/Java-100-faster-runtime-memory-I-bet-the-easiest-to-understand
	 * */
	public boolean areAlmostEqual_2(String s1, String s2) {
		int difference = 0;
		int[] bucket1 = new int[26];																				// S : O(26)
		int[] bucket2 = new int[26];																				// S : O(26)
		
		for (int i = 0; i < s1.length(); i++) {																		// T : O(n)
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			
			if (c1 != c2) { difference++; }
			if (difference > 2) { return false; }
			
			bucket1[c1 - 'a']++;
			bucket2[c2 - 'a']++;
		}
		
		for (int i = 0; i < 26; i++) {																				// T : O(26)
			if (bucket1[i] != bucket2[i]) { return false; }
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * 
	 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/discuss/1108295/Python3-check-diff
	 * */
	public boolean areAlmostEqual(String s1, String s2) {
		int diff1 = -1;
		int diff2 = -1;
		
		for (int i = 0; i < s1.length(); i++) {																		// T : O(n)
			if (s1.charAt(i) == s2.charAt(i)) { continue; }
			
			if (diff1 == -1) {
				diff1 = i;
			} else if (diff2 == -1) {
				diff2 = i;
			} else {
				return false;
			}
		}
		
		if (diff1 != -1 && diff2 != -1) { return s1.charAt(diff1) == s2.charAt(diff2) && s1.charAt(diff2) == s2.charAt(diff1); }
		
		if (diff1 != -1) { return false; }
		
		return true;
	}
	
}
