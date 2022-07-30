package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_916_Word_Subsets {
	
	/**
	 * time  : O(a + b)
	 * space : O(a + b)
	 * 
	 * [ "lo", "eo" ]
	 * 
	 * l : 1
	 * e : 1
	 * o : 1 not 2
	 * 
	 * https://leetcode.com/problems/word-subsets/discuss/175854/JavaC%2B%2BPython-Straight-Forward
	 * https://leetcode.com/problems/word-subsets/discuss/1128123/Short-and-Easy-w-Explanation-or-O(A-%2B-B)-using-max-frequency-count-or-Beats-100
	 * */
	public List<String> wordSubsets(String[] words1, String[] words2) {
		List<String> result = new ArrayList<>();
		
		int[] words2Count = new int[26];
		int[] temp = null;
		
		for (String word2 : words2) {																				// T : O(b)
			temp = count(word2);																					// T : O(10)
			
			for (int i = 0; i < words2Count.length; i++) {															// T : O(10)
				words2Count[i] = Math.max(words2Count[i], temp[i]);
			}
		}
		
		int index = 0;
		
		for (String word1 : words1) {																				// T : O(a)
			temp = count(word1);																					// T : O(10)
			
			for (index = 0; index < words2Count.length; index++) {													// T : O(10)
				if (words2Count[index] > temp[index]) { break; }
			}
			
			if (index == 26) { result.add(word1); }
		}
		
		return result;
	}
	
	private int[] count(String word) {
		int[] count = new int[26];
		
		for (int i = 0; i < word.length(); i++) {
			count[word.charAt(i) - 'a']++;
		}
		
		return count;
	}
	
}
