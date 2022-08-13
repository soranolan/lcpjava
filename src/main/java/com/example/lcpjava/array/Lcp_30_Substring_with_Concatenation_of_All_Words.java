package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lcp_30_Substring_with_Concatenation_of_All_Words {
	
	/**
	 * time  : O(n * a * b - (a * b) ^ 2)
	 * space : O(a + b)
	 * 
	 * Solution Tab
	 * */
	public List<Integer> findSubstring_1(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		int wordsLength = words.length;																				// a
		int wordLength = words[0].length();																			// b
		int substringLength = wordLength * wordsLength;																// a * b
		
		Map<String, Integer> word2Count = new HashMap<>();															// S : O(a)
		for (String word : words) { word2Count.put(word, word2Count.getOrDefault(word, 0) + 1); }					// T : O(a)
		
		for (int start = 0; start < s.length() - substringLength + 1; start++) {									// T : O(n - (a * b))
			if (isValid(start, substringLength, wordLength, wordsLength, word2Count, s)) {
				result.add(start);
			}
		}
		
		return result;
	}
	
	private boolean isValid(int start, int substringLength, int wordLength, int wordsLength, Map<String, Integer> word2Count, String s) {
		int wordsUsed = 0;
		Map<String, Integer> copy = new HashMap<>(word2Count);														// T : O(a)
		
		for (int i = start; i < start + substringLength; i += wordLength) {											// T : O((a * b) / b)
			String sub = s.substring(i, i + wordLength);															// T : O(b)
			
			int count = copy.getOrDefault(sub, 0);																	// T : O(1)
			if (count == 0) { break; }
			
			copy.put(sub, count - 1);																				// T : O(1)
			wordsUsed++;
		}
		
		return wordsUsed == wordsLength;
	}
	
	/**
	 * time  : O(a + n * b)
	 * space : O(a + b)
	 * 
	 * Solution Tab
	 * */
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		int wordsLength = words.length;																				// a
		int wordLength = words[0].length();																			// b
		int substringLength = wordLength * wordsLength;																// a * b
		
		Map<String, Integer> word2Count = new HashMap<>();															// S : O(a)
		for (String word : words) { word2Count.put(word, word2Count.getOrDefault(word, 0) + 1); }					// T : O(a)
		
		for (int left = 0; left < wordLength; left++) {																// T : O(b)
			slidingWindow(left, wordLength, wordsLength, substringLength, word2Count, s, result);
		}
		
		return result;
	}
	
	private void slidingWindow(int left, int wordLength, int wordsLength, int substringLength, Map<String, Integer> word2Count, String s, List<Integer> result) {
		Map<String, Integer> wordsFound = new HashMap<>();															// window
		int wordsUsed = 0;
		boolean isExceed = false;
		
		for (int right = left; right <= s.length() - wordLength; right += wordLength) {								// T : O(n / b)
			String sub = s.substring(right, right + wordLength);													// T : O(b)
			
			if (!word2Count.containsKey(sub)) {
				wordsFound.clear();
				wordsUsed = 0;
				isExceed = false;
				left = right + wordLength;
				continue;
			}
			
			while (right - left == substringLength || isExceed) {													// T : O(n / b)
				String leftmostWord = s.substring(left, left + wordLength);											// T : O(b)
				
				left += wordLength;
				
				// remove from window
				wordsFound.put(leftmostWord, wordsFound.get(leftmostWord) - 1);
				
				if (wordsFound.get(leftmostWord) >= word2Count.get(leftmostWord)) {
					isExceed = false;
				} else {
					wordsUsed--;
				}
			}
			
			wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
			
			if (wordsFound.get(sub) <= word2Count.get(sub)) {
				wordsUsed++;
			} else {
				// String aaa aaa bbb ccc <-> words [ aaa, bbb, ccc, ddd ]
				isExceed = true;
			}
			
			if (wordsUsed == wordsLength && !isExceed) { result.add(left); }
		}
	}
	
}
