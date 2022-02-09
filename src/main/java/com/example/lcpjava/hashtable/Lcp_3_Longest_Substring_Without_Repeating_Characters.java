package com.example.lcpjava.hashtable;

import java.util.HashSet;
import java.util.Set;

public class Lcp_3_Longest_Substring_Without_Repeating_Characters {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Sliding window
	 * 
	 * 
	 * int max <- 0
	 * Set<Character> window <- new HashSet
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char c <- s charAt(i)
	 * 		
	 * 		while window contains(c)
	 * 			window remove(s charAt(i minus window size))
	 * 		end while
	 * 		
	 * 		window add(c)
	 * 		
	 * 		max <- Math max(max, window size)
	 * end for
	 * 
	 * return max
	 * */
	public int lengthOfLongestSubstring_1(String s) {
		int max = 0;
		Set<Character> window = new HashSet<>();																	// S : O(n)
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			
			while (window.contains(c)) {																			// T : O(m)
				window.remove(s.charAt(i - window.size()));															// T : O(1)
			}
			
			window.add(c);																							// T : O(1)
			
			max = Math.max(max, window.size());
		}
		
		return max;
	}
	
	/**
	 * time  : O(n)
	 * space : O(128)
	 * 
	 * Sliding window
	 * 
	 * 
	 * int max <- 0
	 * int size <- 0
	 * boolean[] bucket <- new boolean[128]
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char c <- s charAt(i)
	 * 		
	 * 		while bucket[c] is true
	 * 			bucket[s charAt(i minus size)] <- false
	 * 			size--
	 * 		end while
	 * 		
	 * 		bucket[c] <- true
	 * 		size++
	 * 		
	 * 		max <- Math max(max, size)
	 * end for
	 * 
	 * return max
	 * */
	public int lengthOfLongestSubstring_2(String s) {
		int max = 0;
		int size = 0;
		boolean[] bucket = new boolean[128];																		// S : O(128)
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			
			while (bucket[c]) {																						// T : O(m)
				bucket[s.charAt(i - size)] = false;
				size--;
			}
			
			bucket[c] = true;
			size++;
			
			max = Math.max(max, size);
		}
		
		return max;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Sliding window
	 * 
	 * 
	 * int max <- 0
	 * int size <- 0
	 * long lower64 <- 0L
	 * long upper64 <- 0L
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		int value <- s charAt(i)
	 * 		
	 * 		if value is greater than 64
	 * 			upper(s, i, value);
	 * 		else
	 * 			lower(s, i, value);
	 * 		end if
	 * end for
	 * 
	 * return max
	 * */
	int max = 0;
	int size = 0;
	long lower64 = 0L;
	long upper64 = 0L;
	public int lengthOfLongestSubstring(String s) {
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			int value = s.charAt(i);																				// T : O(1)
			
			if (value > 64) {
				upper(s, i, value);
			} else {
				lower(s, i, value);
			}
		}
		
		return max;
	}
	
	/**
	 * long bits <- 1L left shift value
	 * 
	 * while (upper64 & bits) is not equal to zero
	 * 		upper64 <- upper64 & ~(1L left shift s charAt(index minus size))
	 * 		size--
	 * end while
	 * 
	 * upper64 <- upper64 | bits
	 * size++
	 * 
	 * max <- Math max(max, size)
	 * */
	public void upper(String s, int index, int value) {
		long bits = 1L << value;
		
		while ((upper64 & bits) != 0) {
			upper64 &= ~(1L << s.charAt(index - size));
			size--;
		}
		
		upper64 |= bits;
		size++;
		
		max = Math.max(max, size);
	}
	
	/**
	 * long bits <- 1L left shift value
	 * 
	 * while (lower64 & bits) is not equal to zero
	 * 		lower64 <- lower64 & ~(1L left shift s charAt(index minus size))
	 * 		size--
	 * end while
	 * 
	 * lower64 <- lower64 | bits
	 * size++
	 * 
	 * max <- Math max(max, size)
	 * */
	public void lower(String s, int index, int value) {
		long bits = 1L << value;
		
		while ((lower64 & bits) != 0) {
			lower64 &= ~(1L << s.charAt(index - size));
			size--;
		}
		
		lower64 |= bits;
		size++;
		
		max = Math.max(max, size);
	}
	
}
