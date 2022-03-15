package com.example.lcpjava.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lcp_387_First_Unique_Character_in_a_String {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int minIndex <- 100000
	 * Map<Character, Integer> countMemo <- new HashMap
	 * Map<Character, Integer> indexMemo <- new HashMap
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char c <- s charAt(i)
	 * 		
	 * 		if countMemo does not containsKey(c)
	 * 			countMemo put(c, 1)
	 * 		else
	 * 			countMemo put(c, countMemo get(c) plus one)
	 * 		end if
	 * 		
	 * 		if indexMemo does not containsKey(c)
	 * 			indexMemo put(c, i)
	 * 		end if
	 * end for
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char c <- s charAt(i)
	 * 		
	 * 		int count <- countMemo get(c)
	 * 		if count is greater than one
	 * 			continue
	 * 		end if
	 * 		
	 * 		int index <- indexMemo get(c)
	 * 		if index is lower than minIndex
	 * 			minIndex <- index
	 * 		end if
	 * end for
	 * 
	 * return if minIndex is equal to 100000 then minus one else minIndex
	 * */
	public int firstUniqChar_1(String s) {
		int minIndex = 100000;
		Map<Character, Integer> countMemo = new HashMap<>();														// S : O(n)
		Map<Character, Integer> indexMemo = new HashMap<>();														// S : O(26)
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			if (!countMemo.containsKey(c)) {																		// T : O(1)
				countMemo.put(c, 1);																				// T : O(1)
			} else {
				countMemo.put(c, countMemo.get(c) + 1);																// T : O(1)
			}
			if (!indexMemo.containsKey(c)) { indexMemo.put(c, i); }													// T : O(1)
		}
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			int count = countMemo.get(c);																			// T : O(1)
			if (count > 1) { continue; }
			
			int index = indexMemo.get(c);																			// T : O(1)
			if (index < minIndex) { minIndex = index; }
		}
		
		return (minIndex == 100000) ? -1 : minIndex;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int minIndex <- 100000
	 * Map<Character, Integer> memo <- new HashMap
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char c <- s charAt(i)
	 * 		
	 * 		if memo containsKey(c)
	 * 			memo put(c, minus one)
	 * 		else
	 * 			memo put(c, i)
	 * 		end if
	 * end for
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char c <- s charAt(i)
	 * 		int index <- memo get(c)
	 * 		
	 * 		if index is equal to minus one
	 * 			continue
	 * 		end if
	 * 		
	 * 		if index is lower than minIndex
	 * 			minIndex <- index
	 * 		end if
	 * end for
	 * 
	 * return if minIndex is equal to 100000 then minus one else minIndex
	 * */
	public int firstUniqChar_2(String s) {
		int minIndex = 100000;
		Map<Character, Integer> memo = new HashMap<>();																// S : O(n)
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			
			if (memo.containsKey(c)) {																				// T : O(1)
				memo.put(c, -1);																					// T : O(1)
			} else {
				memo.put(c, i);																						// T : O(1)
			}
		}
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			int index = memo.get(c);																				// T : O(1)
			if (index == -1) { continue; }
			if (index < minIndex) { minIndex = index; }
		}
		
		return (minIndex == 100000) ? -1 : minIndex;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Map<Character, Integer> memo <- new HashMap
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char c <- s charAt(i)
	 * 		
	 * 		if memo containsKey(c)
	 * 			memo put(c, memo get(c) plus one)
	 * 		else
	 * 			memo put(c, one)
	 * 		end if
	 * end for
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char c <- s charAt(i)
	 * 		int count <- memo get(c)
	 * 		
	 * 		if count is equal to one
	 * 			return i
	 * 		end if
	 * end for
	 * 
	 * return minus one
	 * */
	public int firstUniqChar_3(String s) {
		Map<Character, Integer> memo = new HashMap<>();																// S : O(n)
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			
			if (memo.containsKey(c)) {																				// T : O(1)
				memo.put(c, memo.get(c) + 1);																		// T : O(1)
			} else {
				memo.put(c, 1);																						// T : O(1)
			}
		}
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			int count = memo.get(c);																				// T : O(1)
			if (count == 1) { return i; }
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(26)
	 * 
	 * int[] memo <- new int[26]
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char c <- s charAt(i)
	 * 		int index <- c minus 'a'
	 * 		
	 * 		memo[index] <- memo[index] + 1
	 * end for
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char c <- s charAt(i)
	 * 		int index <- c minus 'a'
	 * 		
	 * 		if memo[index] is equal to one
	 * 			return i
	 * 		end if
	 * end for
	 * 
	 * return minus one
	 * */
	public int firstUniqChar_4(String s) {
		int[] memo = new int[26];																					// S : O(26)
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			int index = c - 'a';
			memo[index]++;
		}
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			int index = c - 'a';
			if (memo[index] == 1) { return i; }
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(26)
	 * 
	 * 097 098 099 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122
	 *   a   b   c   d   e   f   g   h   i   j   k   l   m   n   o   p   q   r   s   t   u   v   w   x   y   z
	 *  -2  -2  -2  -2  -2  -2  -2  -2  -2  -2  -2   0  -2  -2  -2  -2  -2  -2  -2  -2  -2  -2  -2  -2  -2  -2
	 * 
	 * int minIndex <- 100000
	 * int[] memo <- new int[26]
	 * Arrays fill(memo, minus two)
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char c <- s charAt(i)
	 * 		int index <- c minus 'a'
	 * 		
	 * 		if memo[index] is equal to minus two
	 * 			memo[index] <- i
	 * 		else if memo[index] is greater than or equal to zero
	 * 			memo[index] <- minus one
	 * 		end if
	 * end for
	 * 
	 * for int index in memo
	 * 		if index is lower than zero
	 * 			continue
	 * 		end if
	 * 		
	 * 		if index is lower than minIndex
	 * 			minIndex <- index
	 * 		end if
	 * end for
	 * 
	 * return if minIndex is equal to 100000 then minus one else minIndex
	 * */
	public int firstUniqChar(String s) {
		int minIndex = 100000;
		int[] memo = new int[26];																					// S : O(26)
		Arrays.fill(memo, -2);																						// T : O(26)
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			int index = c - 'a';
			
			if (memo[index] == -2) {
				memo[index] = i;
			} else if (memo[index] >= 0) {
				memo[index] = -1;
			}
		}
		
		for (int index : memo) {																					// T : O(26)
			if (index < 0) { continue; }
			if (index < minIndex) { minIndex = index; }
		}
		
		return (minIndex == 100000) ? -1 : minIndex;
	}
	
}
