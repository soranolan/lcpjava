package com.example.lcpjava.array;

public class Lcp_28_Implement_strStr {
	
	/**
	 * time  : O(m * n)
	 * space : O(1)
	 * 
	 * int hLen <- haystack length
	 * int nLen <- needle length
	 * int hIdx <- 0
	 * int nIdx <- 0
	 * int pos <- 0
	 * 
	 * while hIdx is lower than hLen && nIdx is lower than nLen
	 * 		if haystack charAt(hIdx) is equal to needle charAt(nIdx)
	 * 			hIdx++
	 * 			nIdx++
	 * 		else
	 * 			hIdx++
	 * 			hIdx <- hIdx - nIdx
	 * 			nIdx <- 0
	 * 			pos <- hIdx
	 * 		end if
	 * end while
	 * 
	 * if nIdx is equal to nLen
	 * 		return pos
	 * else
	 * 		return -1
	 * end if
	 * */
	public int strStr_1(String haystack, String needle) {
		int hLen = haystack.length();
		int nLen = needle.length();
		int hIdx = 0;
		int nIdx = 0;
		int pos = 0;
		
		while (hIdx < hLen && nIdx < nLen) {																		// T : O(n)
			if (haystack.charAt(hIdx) == needle.charAt(nIdx)) {
				hIdx++;
				nIdx++;
			} else {
				hIdx++;
				hIdx = hIdx - nIdx;
				nIdx = 0;
				pos = hIdx;
			}
		}
		
		return nIdx == nLen ? pos : -1;
	}
	
	/**
	 * time  : O(m + n)
	 * space : O(n)
	 * 
	 * KMP
	 * 
	 * int hIdx <- 0
	 * int nIdx <- 0
	 * int hLen <- haystack length
	 * int nLen <- needle length
	 * int[] lps <- buildLPS(needle)
	 * 
	 * while hIdx is lower than hLen && nIdx is lower than nLen
	 * 		if haystack charAt(hIdx) is equal to needle charAt(nIdx)
	 * 			hIdx++
	 * 			nIdx++
	 * 		else if nIdx is greater than zero
	 * 			nIdx <- lps[nIdx - 1]
	 * 		else
	 * 			hIdx++
	 * 		end if
	 * end while
	 * 
	 * if nIdx is equal to nLen
	 * 		return hIdx minus nIdx
	 * else
	 * 		return -1
	 * end if
	 * */
	public int strStr(String haystack, String needle) {
		int hIdx = 0;
		int nIdx = 0;
		int hLen = haystack.length();
		int nLen = needle.length();
		int[] lps = buildLPS(needle);																				// T : O(n); S : O(n)
		
		while (hIdx < hLen && nIdx < nLen) {																		// T : O(n)
			if (haystack.charAt(hIdx) == needle.charAt(nIdx)) {
				hIdx++;
				nIdx++;
			} else if (nIdx > 0) {
				nIdx = lps[nIdx - 1];
			} else {
				hIdx++;
			}
		}
		
		return nIdx == nLen ? hIdx - nIdx : -1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int left <- 0
	 * int right <- 1
	 * int length <- pattern length
	 * int[] lps <- empty array
	 * 
	 * while right is lower than length
	 * 		if pattern charAt(left) is equal to pattern charAt(right)
	 * 			lps[right] <- left + 1
	 * 			left++
	 * 			right++
	 * 		else if left is greater than zero
	 * 			left <- lps[left - 1]
	 * 		else
	 * 			lps[right] <- 0
	 * 			right++
	 * 		end if
	 * end while
	 * 
	 * return lps
	 * */
	public int[] buildLPS(String pattern) {
		int left = 0;
		int right = 1;
		int length = pattern.length();
		int[] lps = new int[length];																				// S : O(n)
		
		while (right < length) {																					// T : O(n)
			if (pattern.charAt(left) == pattern.charAt(right)) {
				lps[right] = left + 1;
				left++;
				right++;
			} else if (left > 0) {
				left = lps[left - 1];
			} else {
				lps[right] = 0;
				right++;
			}
		}
		
		return lps;
	}
	
	public static void main(String[] args) {
		Lcp_28_Implement_strStr lcp = new Lcp_28_Implement_strStr();
		String haystack = null;
		String needle = null;
		int output = -1;
		
		// 2
		haystack = "hello";
		needle = "ll";
		output = lcp.strStr(haystack, needle);
		System.out.println(output);
		
		// -1
		haystack = "aaaaa";
		needle = "bba";
		output = lcp.strStr(haystack, needle);
		System.out.println(output);
		
		// 0
		haystack = "";
		needle = "";
		output = lcp.strStr(haystack, needle);
		System.out.println(output);
		
		// 4
		haystack = "mississippi";
		needle = "issip";
		output = lcp.strStr(haystack, needle);
		System.out.println(output);
		
		// 9
		haystack = "mississippi";
		needle = "pi";
		output = lcp.strStr(haystack, needle);
		System.out.println(output);
	}
	
}
