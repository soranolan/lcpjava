package com.example.lcpjava.array;

public class Lcp_2114_Maximum_Number_of_Words_Found_in_Sentences {
	
	/**
	 * time  : O(n * m)
	 * space : O(m)
	 * */
	public int mostWordsFound_1(String[] sentences) {
		int result = 0;
		
		for (String sentence : sentences) {																			// T : O(n)
			int space = 0;
			
			for (char c : sentence.toCharArray()) {																	// T : O(m)
				if (c == ' ') { space++; }
			}
			
			result = Math.max(result, space);
		}
		
		return result + 1;
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(1)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public int mostWordsFound(String[] sentences) {
		int result = 0;
		
		for (String sentence : sentences) {																			// T : O(n)
			int words = findWords(sentence);
			result = Math.max(result, words);
		}
		
		return result;
	}
	
	private int findWords(String sentence) {
		int space = 0;
		
		for (int i = 0; i < sentence.length(); i++) {																// T : O(m)
			if (sentence.charAt(i) == ' ') { space++; }
		}
		
		return space + 1;
	}
	
}
