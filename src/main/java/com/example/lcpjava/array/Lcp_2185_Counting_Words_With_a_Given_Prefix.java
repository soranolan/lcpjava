package com.example.lcpjava.array;

public class Lcp_2185_Counting_Words_With_a_Given_Prefix {
	
	/**
	 * time  : O(n * prefix)
	 * space : O(1)
	 * 
	 * int count <- 0
	 * int pLength <- prefix length
	 * 
	 * for String word in words
	 * 		if word length is lower than pLength
	 * 			continue
	 * 		end if
	 * 		
	 * 		int pIndex <- 0
	 * 		int wIndex <- 0
	 * 		
	 * 		while pIndex is lower than pLength
	 * 			if word charAt(wIndex) is not equal to prefix charAt(pIndex)
	 * 				break
	 * 			end if
	 * 			
	 * 			pIndex++
	 * 			wIndex++
	 * 		end while
	 * 		
	 * 		if pIndex is equal to pLength
	 * 			count++
	 * 		end if
	 * end for
	 * 
	 * return count
	 * */
	public int prefixCount_1(String[] words, String pref) {
		int count = 0;
		int pLength = pref.length();
		
		for (String word : words) {																					// T : O(n)
			if (word.length() < pLength) { continue; }
			
			int pIndex = 0;
			int wIndex = 0;
			
			while (pIndex < pLength) {																				// T : O(prefix)
				if (word.charAt(wIndex) != pref.charAt(pIndex)) { break; }
				pIndex++;
				wIndex++;
			}
			
			if (pIndex == pLength) { count++; }
		}
		
		return count;
	}
	
	/**
	 * time  : O(n * prefix)
	 * space : O(1)
	 * 
	 * int count <- 0
	 * int pLength <- prefix length
	 * 
	 * for String word in words
	 * 		if isPrefix(word, prefix, pLength)
	 * 			count++
	 * 		end if
	 * end for
	 * 
	 * return count
	 * */
	public int prefixCount_2(String[] words, String pref) {
		int count = 0;
		int pLength = pref.length();
		
		for (String word : words) {																					// T : O(n)
			if (isPrefix(word, pref, pLength)) { count++; }															// T : O(prefix)
		}
		
		return count;
	}
	
	/**
	 * if word length is lower than pLength
	 * 		return false
	 * end if
	 * 
	 * int pIndex <- 0
	 * int wIndex <- 0
	 * 
	 * while pIndex is lower than pLength
	 * 		if word charAt(wIndex) is not equal to prefix charAt(pIndex)
	 * 			return false
	 * 		end if
	 * 		
	 * 		wIndex++
	 * 		pIndex++
	 * end while
	 * 
	 * return true
	 * */
	public boolean isPrefix(String word, String pref, int pLength) {
		if (word.length() < pLength) { return false; }
		
		int pIndex = 0;
		int wIndex = 0;
		
		while (pIndex < pLength) {																					// T : O(prefix)
			if (word.charAt(wIndex++) != pref.charAt(pIndex++)) { return false; }
		}
		
		return true;
	}
	
	/**
	 * time  : O(n * prefix)
	 * space : O(1)
	 * 
	 * int count <- 0
	 * 
	 * for String word in words
	 * 		if word starts with prefix
	 * 			count++
	 * 		end if
	 * end for
	 * 
	 * return count
	 * */
	public int prefixCount(String[] words, String pref) {
		int count = 0;
		
		for (String word : words) {																					// T : O(n)
			if (word.startsWith(pref)) { count++; }																	// T : O(prefix)
		}
		
		return count;
	}
	
}
