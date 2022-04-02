package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Lcp_412_Fizz_Buzz {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * String Concatenation
	 * 
	 * 
	 * List<String> result <- new ArrayList
	 * StringBuilder sb <- new StringBuilder
	 * 
	 * for int i <- 1; if i is lower than or equal to n; i++
	 * 		boolean isMod3 <- if i modulo three is equal to zero
	 * 		boolean isMod5 <- if i modulo five is equal to zero
	 * 		
	 * 		if isMod3 is true
	 * 			sb append("Fizz")
	 * 		end if
	 * 		
	 * 		if isMod5 is true
	 * 			sb append("Buzz")
	 * 		end if
	 * 		
	 * 		if sb length is equal to zero
	 * 			sb append(i to string)
	 * 		end if
	 * 		
	 * 		result add(sb to string)
	 * 		
	 * 		sb set length to zero
	 * end for
	 * 
	 * return result
	 * */
	public List<String> fizzBuzz_1(int n) {
		List<String> result = new ArrayList<>();																	// S : O(n)
		StringBuilder sb = new StringBuilder();																		// S : O(8)
		
		for (int i = 1; i <= n; i++) {																				// T : O(n)
			boolean isMod3 = (i % 3 == 0);
			boolean isMod5 = (i % 5 == 0);
			
			if (isMod3) { sb.append("Fizz"); }
			if (isMod5) { sb.append("Buzz"); }
			if (sb.length() == 0) { sb.append(Integer.toString(i)); }
			
			result.add(sb.toString());
			
			sb.setLength(0);
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Naive Approach
	 * 
	 * 
	 * List<String> result <- new ArrayList
	 * 
	 * for int i <- 1; if i is lower than or equal to n; i++
	 * 		if i modulo fifteen is equal to zero
	 * 			result add("FizzBuzz")
	 * 		else if i modulo three is equal to zero
	 * 			result add("Fizz")
	 * 		else if i modulo five is equal to zero
	 * 			result add("Buzz")
	 * 		else
	 * 			result add(i to string)
	 * 		end if
	 * end for
	 * 
	 * return result
	 * */
	public List<String> fizzBuzz_2(int n) {
		List<String> result = new ArrayList<>();																	// S : O(n)
		
		for (int i = 1; i <= n; i++) {																				// T : O(n)
			if (i % 15 == 0) {
				result.add("FizzBuzz");
			} else if (i % 3 == 0) {
				result.add("Fizz");
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else {
				result.add(Integer.toString(i));
			}
		}
		
		return result;
	}
	
	/**
	 * Follow Up
	 * 
	 * Hash
	 * */
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * List<String> result <- new ArrayList
	 * StringBuilder sb <- new StringBuilder
	 * Map<Integer, String> memo <- new LinkedHashMap
	 * 
	 * memo put(3, "Fizz");
	 * memo put(5, "Buzz");
	 * 
	 * for int i <- 1; if i is lower than or equal to n; i++
	 * 		for Integer key in memo keySet()
	 * 			if i modulo key is equal to zero
	 * 				sb append(memo get(key))
	 * 			end if
	 * 		end for
	 * 		
	 * 		if sb length is equal to zero
	 * 			sb append(i to string)
	 * 		end if
	 * 		
	 * 		result add(sb to string)
	 * 		
	 * 		sb set length to zero
	 * end for
	 * 
	 * return result
	 * */
	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();																	// S : O(n)
		StringBuilder sb = new StringBuilder();																		// S : O(8)
		Map<Integer, String> memo = new LinkedHashMap<>();															// S : O(2)
		
		memo.put(3, "Fizz");
		memo.put(5, "Buzz");
		
		for (int i = 1; i <= n; i++) {																				// T : O(n)
			for (Integer key : memo.keySet()) {																		// T : O(2)
				if (i % key == 0) {
					sb.append(memo.get(key));
				}
			}
			if (sb.length() == 0) { sb.append(Integer.toString(i)); }
			
			result.add(sb.toString());
			
			sb.setLength(0);
		}
		
		return result;
	}
	
}
