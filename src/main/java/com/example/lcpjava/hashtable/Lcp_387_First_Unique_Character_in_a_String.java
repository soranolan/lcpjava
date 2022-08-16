package com.example.lcpjava.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lcp_387_First_Unique_Character_in_a_String {
	
	/**
	 * time  : O(n)
	 * space : O(n)
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
	 * https://leetcode.com/problems/first-unique-character-in-a-string/discuss/86348/Java-7-lines-solution-29ms
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
	
	/**
	 * https://leetcode.com/problems/first-unique-character-in-a-string/discuss/86511/Java-One-Pass-Solution-with-LinkedHashMap
	 * */
	
}
