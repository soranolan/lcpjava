package com.example.lcpjava.array;

import java.util.HashMap;
import java.util.Map;

public class Lcp_242_Valid_Anagram {
	
	/**
	 * time  : O(t + s)
	 * space : O(26)
	 * */
	public boolean isAnagram_1(String s, String t) {
		if (s.length() != t.length()) { return false; }
		
		int[] bucket = new int[26];																					// S : O(26)
		
		for (int i = 0; i < s.length(); i++) { bucket[s.charAt(i) - 'a']++; }										// T : O(s)
		
		for (int i = 0; i < t.length(); i++) { bucket[t.charAt(i) - 'a']--; }										// T : O(t)
		
		for (int i = 0; i < bucket.length; i++) {																	// T : O(26)
			if (bucket[i] != 0) { return false; }
		}
		
		return true;
	}
	
	/**
	 * time  : O(t + s)
	 * space : O(26)
	 * 
	 * https://leetcode.com/problems/valid-anagram/discuss/66484/Accepted-Java-O(n)-solution-in-5-lines
	 * */
	public boolean isAnagram_2(String s, String t) {
		if (s.length() != t.length()) { return false; }
		
		int[] bucket = new int[26];																					// S : O(26)
		
		for (int i = 0; i < s.length(); i++) { bucket[s.charAt(i) - 'a']++; }										// T : O(s)
		
		for (int i = 0; i < t.length(); i++) {																		// T : O(t)
			if (--bucket[t.charAt(i) - 'a'] < 0) { return false; }
		}
		
		for (int i = 0; i < bucket.length; i++) {																	// T : O(26)
			if (bucket[i] != 0) { return false; }
		}
		
		return true;
	}
	
	/**
	 * Follow up:
	 * 
	 * What if the inputs contain Unicode characters?
	 * 
	 * How would you adapt your solution to such a case?
	 * */
	/**
	 * time  : O(t + s)
	 * space : O(t + s)
	 * 
	 * TODO need to know more about Unicode
	 * 
	 * https://leetcode.com/problems/valid-anagram/discuss/66533/Java-solution-HashMap-Unicode-Follow-up
	 * http://www.unicode.org/reports/tr29/#Grapheme_Cluster_Boundaries
	 * https://leetcode.com/problems/valid-anagram/discuss/66777/Unicode-and-supplementary-characters
	 * https://cloud.tencent.com/developer/article/1642354
	 * https://blog.cruciferslab.net/?p=477&referrer-analytics=1
	 * https://zhuanlan.zhihu.com/p/53714077
	 * https://en.wikipedia.org/wiki/Character_encoding
	 * https://en.wikipedia.org/wiki/Code_point
	 * */
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) { return false; }
		
		int index = 0;
		Map<Integer, Integer> dict = new HashMap<>();																// S : O(t + s)
		
		while (index < s.length()) {																				// T : O(s)
			// Get the integer representation of Unicode
			int charCode = s.codePointAt(index);
			
			dict.put(charCode, dict.getOrDefault(charCode, 0) + 1);
			
			// The Unicode could be represented by either one char or two chars
			index += Character.charCount(charCode);
		}
		
		index = 0;
		while (index < t.length()) {																				// T : O(t)
			int charCode = t.codePointAt(index);
			int count = dict.getOrDefault(charCode, 0);
			
			if (count == 0) {
				return false;
			} else {
				dict.put(charCode, count - 1);
			}
			
			index += Character.charCount(charCode);
		}
		
		return true;
	}
	
}
