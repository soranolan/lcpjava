package com.example.lcpjava.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Lcp_13_Roman_to_Integer {
	
	/**
	 * time  : O(n)
	 * space : O(7)
	 * 
	 * int result <- zero
	 * int length <- s length
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		char c <- s charAt(i)
	 * 		int current <- memo get(c)
	 * 		int next <- zero
	 * 		
	 * 		if i plus one is lower than length
	 * 			next <- memo get(s charAt(i plus one))
	 * 		end if
	 * 		
	 * 		if current is lower than next
	 * 			result <- result plus (next minus current)
	 * 			i++
	 * 		else
	 * 			result <- result plus current
	 * 		end if
	 * end for
	 * 
	 * return result
	 * */
	public int romanToInt_1(String s) {
		Map<Character, Integer> memo = new HashMap<>();																// S : O(7)
		memo.put('I', 1);
		memo.put('V', 5);
		memo.put('X', 10);
		memo.put('L', 50);
		memo.put('C', 100);
		memo.put('D', 500);
		memo.put('M', 1000);
		int result = 0;
		int length = s.length();
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			int current = memo.get(c);																				// T : O(1)
			int next = 0;
			
			if (i + 1 < length) { next = memo.get(s.charAt(i + 1)); }												// T : O(1)
			
			if (current < next) {
				result += (next - current);
				i++;
			} else {
				result += current;
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(7)
	 * 
	 * Prefer this one
	 * 
	 * int result <- zero
	 * int length <- s length
	 * 
	 * for int i <- length minus one; if i is greater than or equal to zero; i--
	 * 		char c <- s charAt(i)
	 * 		int current <- memo get(c)
	 * 		int next <- zero
	 * 		
	 * 		if i plus one is lower than length
	 * 			next <- memo get(s charAt(i plus one))
	 * 		end if
	 * 		
	 * 		if current is lower than next
	 * 			result <- result minus current
	 * 		else
	 * 			result <- result plus current
	 * 		end if
	 * end for
	 * 
	 * return result
	 * */
	public int romanToInt_2(String s) {
		Map<Character, Integer> memo = new HashMap<>();																// S : O(7)
		memo.put('I', 1);
		memo.put('V', 5);
		memo.put('X', 10);
		memo.put('L', 50);
		memo.put('C', 100);
		memo.put('D', 500);
		memo.put('M', 1000);
		int result = 0;
		int length = s.length();
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			int current = memo.get(c);																				// T : O(1)
			int next = 0;
			
			if (i + 1 < length) { next = memo.get(s.charAt(i + 1)); }												// T : O(1)
			
			if (current < next) {
				result -= current;
			} else {
				result += current;
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(7)
	 * 
	 * int result <- zero
	 * int length <- s length
	 * 
	 * 
	 * for int i <- length minus one; if i is greater than or equal to zero; i--
	 * 		char c <- s charAt(i)
	 * 		int current <- memo get(c)
	 * 		
	 * 		if result is greater than four times of current
	 * 			result <- result minus current
	 * 		else
	 * 			result <- result plus current
	 * 		end if
	 * end for
	 * 
	 * return result
	 * */
	public int romanToInt(String s) {
		Map<Character, Integer> memo = new HashMap<>();																// S : O(7)
		memo.put('I', 1);
		memo.put('V', 5);
		memo.put('X', 10);
		memo.put('L', 50);
		memo.put('C', 100);
		memo.put('D', 500);
		memo.put('M', 1000);
		int result = 0;
		int length = s.length();
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			char c = s.charAt(i);																					// T : O(1)
			int current = memo.get(c);																				// T : O(1)
			
			if (result > 4 * current) {
				result -= current;
			} else {
				result += current;
			}
		}
		
		return result;
	}
	
}
