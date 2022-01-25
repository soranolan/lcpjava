package com.example.lcpjava.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lcp_49_Group_Anagrams {
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * 
	 * Map<Map<Character, Integer>, List<String>> memo <- new HashMap
	 * 
	 * for String str in strs
	 * 		Map<Character, Integer> key <- new HashMap
	 * 		List<String> anagrams <- null
	 * 		
	 * 		for int i <- 0; i < str length; i++
	 * 			char c <- str.charAt(i)
	 * 			
	 * 			if key containsKey(c)
	 * 				key put(c, key get(c) plus one)
	 * 			else
	 * 				key put(c, one)
	 * 			end if
	 * 		end for
	 * 		
	 * 		if memo containsKey(key)
	 * 			anagrams <- memo get(key)
	 * 		else
	 * 			anagrams <- new ArrayList
	 * 		end if
	 * 		
	 * 		anagrams add(str)
	 * 		memo put(key, anagrams)
	 * end for
	 * 
	 * List<List<String>> result <- new ArrayList
	 * for Map<Character, Integer> key in memo keySet()
	 * 		result add(memo get(key))
	 * end for
	 * 
	 * return result
	 * */
	public List<List<String>> groupAnagrams_1(String[] strs) {
		Map<Map<Character, Integer>, List<String>> memo = new HashMap<>();											// S : O(n * m)
		
		for (String str : strs) {																					// T : O(n)
			Map<Character, Integer> key = new HashMap<>();															// S : O(26)
			List<String> anagrams = null;
			
			for (int i = 0; i < str.length(); i++) {																// T : O(m)
				char c = str.charAt(i);																				// T : O(1)
				
				if (key.containsKey(c)) {																			// T : O(1)
					key.put(c, key.get(c) + 1);																		// T : O(1)
				} else {
					key.put(c, 1);																					// T : O(1)
				}
			}
			
			if (memo.containsKey(key)) {																			// T : O(1)
				anagrams = memo.get(key);																			// T : O(1)
			} else {
				anagrams = new ArrayList<>();
			}
			
			anagrams.add(str);																						// T : O(1)
			memo.put(key, anagrams);																				// T : O(1)
		}
		
		List<List<String>> result = new ArrayList<>();																// S : O(n * m)
		for (Map<Character, Integer> key : memo.keySet()) { result.add(memo.get(key)); }							// T : O(n * m)
		
		return result;
	}
	
	/**
	 * time  : O(n * m log m)
	 * space : O(n * m)
	 * 
	 * Map<String, List<String>> memo <- new HashMap
	 * 
	 * for String str in strs
	 * 		char[] cArr <- str to char array
	 * 		Arrays sort(cArr)
	 * 		String key <- String valueOf(cArr)
	 * 		
	 * 		if memo does not containsKey(key)
	 * 			memo put(key, new ArrayList)
	 * 		end if
	 * 		
	 * 		memo get(key) add(str)
	 * end for
	 * 
	 * List<List<String>> result <- new ArrayList
	 * for String key in memo keySet()
	 * 		result add(memo get(key))
	 * end for
	 * 
	 * return result
	 * */
	public List<List<String>> groupAnagrams_2(String[] strs) {
		Map<String, List<String>> memo = new HashMap<>();															// S : O(n * m)
		
		for (String str : strs) {																					// T : O(n)
			char[] cArr = str.toCharArray();																		// S : O(m)
			Arrays.sort(cArr);																						// T : O(m log m)
			String key = String.valueOf(cArr);
			
			if (!memo.containsKey(key)) { memo.put(key, new ArrayList<>()); }										// T : O(1)
			memo.get(key).add(str);																					// T : O(1)
		}
		
		List<List<String>> result = new ArrayList<>();																// S : O(n * m)
		for (String key : memo.keySet()) { result.add(memo.get(key)); }												// T : O(n * m)
		
		return result;
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * 
	 * Map<String, List<String>> memo <- new HashMap
	 * 
	 * for String str in strs
	 * 		int[] counts <- new int[26]
	 * 		
	 * 		for char c in str to char array
	 * 			counts[c minus 'a'] <- counts[c minus 'a'] plus one
	 * 		end for
	 * 		
	 * 		StringBuilder sb <- new StringBuilder
	 * 		
	 * 		for int count in counts
	 * 			sb append(count) append("#")
	 * 		end for
	 * 		
	 * 		String key <- sb to string
	 * 		
	 * 		if memo does not containsKey(key)
	 * 			memo put(key, new ArrayList)
	 * 		end if
	 * 		
	 * 		memo get(key) add(str)
	 * end for
	 * 
	 * List<List<String>> result <- new ArrayList
	 * for String key in memo keySet()
	 * 		result add(memo get(key))
	 * end for
	 * 
	 * return result
	 * */
	public List<List<String>> groupAnagrams_3(String[] strs) {
		Map<String, List<String>> memo = new HashMap<>();															// S : O(n * m)
		
		for (String str : strs) {																					// T : O(n)
			int[] counts = new int[26];																				// S : O(26)
			for (char c : str.toCharArray()) { counts[c - 'a']++; }													// T : O(m)
			
			StringBuilder sb = new StringBuilder();																	// S : O(52)
			for (int count : counts) { sb.append(count).append("#"); }												// T : O(26)
			String key = sb.toString();
			
			if (!memo.containsKey(key)) { memo.put(key, new ArrayList<>()); }										// T : O(1)
			memo.get(key).add(str);																					// T : O(1)
		}
		
		List<List<String>> result = new ArrayList<>();																// S : O(n * m)
		for (String key : memo.keySet()) { result.add(memo.get(key)); }												// T : O(n * m)
		
		return result;
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * 
	 * Map<String, List<String>> memo <- new HashMap
	 * 
	 * for String str in strs
	 * 		char[] counts <- new char[26]
	 * 		
	 * 		for char c in str to char array
	 * 			counts[c minus 'a'] <- counts[c minus 'a'] plus one
	 * 		end for
	 * 		
	 * 		String key <- String valueOf(counts)
	 * 		
	 * 		if memo does not containsKey(key)
	 * 			memo put(key, new ArrayList)
	 * 		end if
	 * 		
	 * 		memo get(key) add(str)
	 * end for
	 * 
	 * List<List<String>> result <- new ArrayList
	 * for String key in memo keySet()
	 * 		result add(memo get(key))
	 * end for
	 * 
	 * return result
	 * */
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> memo = new HashMap<>();															// S : O(n * m)
		
		for (String str : strs) {																					// T : O(n)
			char[] counts = new char[26];																			// S : O(26)
			for (char c : str.toCharArray()) { counts[c - 'a']++; }													// T : O(m)
			
			String key = String.valueOf(counts);
			
			if (!memo.containsKey(key)) { memo.put(key, new ArrayList<>()); }										// T : O(1)
			memo.get(key).add(str);																					// T : O(1)
		}
		
		List<List<String>> result = new ArrayList<>();																// S : O(n * m)
		for (String key : memo.keySet()) { result.add(memo.get(key)); }												// T : O(n * m)
		
		return result;
	}
	
}
