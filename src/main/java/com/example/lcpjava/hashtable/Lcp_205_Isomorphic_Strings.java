package com.example.lcpjava.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lcp_205_Isomorphic_Strings {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * String s2Num <- transform(s)
	 * String t2Num <- transform(t)
	 * 
	 * return if s2Num is equal to t2Num
	 * */
	public boolean isIsomorphic_1(String s, String t) {
		String s2Num = transform(s);
		String t2Num = transform(t);
		return s2Num.equals(t2Num);
	}
	
	/**
	 * Map<Character, Integer> mapping <- new HashMap
	 * StringBuilder sb <- new StringBuilder
	 * 
	 * for int i <- 0; if i is lower than str length; i++
	 * 		char c <- str charAt(i)
	 * 		
	 * 		if mapping does not containsKey(c)
	 * 			mapping put(c, i)
	 * 		end if
	 * 		
	 * 		sb append(Integer toString(mapping get(c))) append(" ")
	 * end for
	 * 
	 * return sb to string
	 * */
	public String transform(String str) {
		Map<Character, Integer> mapping = new HashMap<>();															// S : O(n)
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		
		for (int i = 0; i < str.length(); i++) {																	// T : O(n)
			char c = str.charAt(i);																					// T : O(1)
			if (!mapping.containsKey(c)) { mapping.put(c, i); }														// T : O(1)
			sb.append(Integer.toString(mapping.get(c))).append(" ");
		}
		
		return sb.toString();
	}
	
	/**
	 * time  : O(n)
	 * space : O(n + m)
	 * 
	 * char[] sArr <- s to char array
	 * char[] tArr <- t to char array
	 * Map<Character, Character> sMemo <- new HashMap
	 * Map<Character, Character> tMemo <- new HashMap
	 * 
	 * for int i <- 0; if i is lower than sArr length; i++
	 * 		char sKey <- sArr[i]
	 * 		char tKey <- tArr[i]
	 * 		
	 * 		if sMemo containsKey(sKey) && sMemo get(sKey) is not equal to tKey
	 * 			return false
	 * 		end if
	 * 		
	 * 		if tMemo containsKey(tKey) && tMemo get(tKey) is not equal to sKey
	 * 			return false
	 * 		end if
	 * 		
	 * 		sMemo put(sKey, tKey)
	 * 		tMemo put(tKey, sKey)
	 * end for
	 * 
	 * return true
	 * */
	public boolean isIsomorphic_2(String s, String t) {
		char[] sArr = s.toCharArray();																				// S : O(n)
		char[] tArr = t.toCharArray();																				// S : O(m)
		Map<Character, Character> sMemo = new HashMap<>();															// S : O(n)
		Map<Character, Character> tMemo = new HashMap<>();															// S : O(m)
		
		for (int i = 0; i < sArr.length; i++) {																		// T : O(n)
			char sKey = sArr[i];
			char tKey = tArr[i];
			
			if (sMemo.containsKey(sKey) && sMemo.get(sKey) != tKey) { return false; }								// T : O(1)
			
			if (tMemo.containsKey(tKey) && tMemo.get(tKey) != sKey) { return false; }								// T : O(1)
			
			sMemo.put(sKey, tKey);																					// T : O(1)
			tMemo.put(tKey, sKey);																					// T : O(1)
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n + m)
	 * 
	 * char[] sArr <- s to char array
	 * char[] tArr <- t to char array
	 * Map<String, Character> memo <- new HashMap
	 * 
	 * for int i <- 0; if i is lower than sArr length; i++
	 * 		String sKey <- "S" plus sArr[i]
	 * 		String tKey <- "T" plus tArr[i]
	 * 		
	 * 		if memo containsKey(sKey) && memo get(sKey) is not equal to tArr[i]
	 * 			return false
	 * 		end if
	 * 		
	 * 		if memo containsKey(tKey) && memo get(tKey) is not equal to sArr[i]
	 * 			return false
	 * 		end if
	 * 		
	 * 		memo put(sKey, tArr[i])
	 * 		memo put(tKey, sArr[i])
	 * end for
	 * 
	 * return true
	 * */
	public boolean isIsomorphic_3(String s, String t) {
		char[] sArr = s.toCharArray();																				// S : O(n)
		char[] tArr = t.toCharArray();																				// S : O(m)
		Map<String, Character> memo = new HashMap<>();																// S : O(n + m)
		
		for (int i = 0; i < sArr.length; i++) {																		// T : O(n)
			String sKey = "S" + sArr[i];
			String tKey = "T" + tArr[i];
			
			if (memo.containsKey(sKey) && memo.get(sKey) != tArr[i]) { return false; }								// T : O(1)
			
			if (memo.containsKey(tKey) && memo.get(tKey) != sArr[i]) { return false; }								// T : O(1)
			
			memo.put(sKey, tArr[i]);																				// T : O(1)
			memo.put(tKey, sArr[i]);																				// T : O(1)
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n + m)
	 * 
	 * Map<String, Character> memo <- new HashMap
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char sChar <- s charAt(i)
	 * 		char tChar <- t charAt(i)
	 * 		String sKey <- "S" plus sChar
	 * 		String tKey <- "T" plus tChar
	 * 		
	 * 		if memo containsKey(sKey) && memo get(sKey) is not equal to tChar
	 * 			return false
	 * 		end if
	 * 		
	 * 		if memo containsKey(tKey) && memo get(tKey) is not equal to sChar
	 * 			return false
	 * 		end if
	 * 		
	 * 		memo put(sKey, tChar)
	 * 		memo put(tKey, sChar)
	 * end for
	 * 
	 * return true
	 * */
	public boolean isIsomorphic_4(String s, String t) {
		Map<String, Character> memo = new HashMap<>();																// S : O(n + m)
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char sChar = s.charAt(i);																				// T : O(1)
			char tChar = t.charAt(i);																				// T : O(1)
			String sKey = "S" + sChar;
			String tKey = "T" + tChar;
			
			if (memo.containsKey(sKey) && memo.get(sKey) != tChar) { return false; }								// T : O(1)
			
			if (memo.containsKey(tKey) && memo.get(tKey) != sChar) { return false; }								// T : O(1)
			
			memo.put(sKey, tChar);																					// T : O(1)
			memo.put(tKey, sChar);																					// T : O(1)
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(512)
	 * 
	 * int[] sArr <- new int[256]
	 * int[] tArr <- new int[256]
	 * 
	 * Arrays fill(sArr, -1)
	 * Arrays fill(tArr, -1)
	 * 
	 * for int i <- 0; if i is lower than s length; i++
	 * 		char sChar <- s charAt(i)
	 * 		char tChar <- t charAt(i)
	 * 		
	 * 		if sArr[sChar] is equal to -1 && tArr[tChar] is equal to -1
	 * 			sArr[sChar] <- tChar
	 * 			tArr[tChar] <- sChar
	 * 		end if
	 * 		
	 * 		if sArr[sChar] is not equal to tChar || tArr[tChar] is not equal to sChar
	 * 			return false
	 * 		end if
	 * end for
	 * 
	 * return true
	 * */
	public boolean isIsomorphic(String s, String t) {
		int[] sArr = new int[256];																					// S : O(256)
		int[] tArr = new int[256];																					// S : O(256)
		
		Arrays.fill(sArr, -1);																						// T : O(256)
		Arrays.fill(tArr, -1);																						// T : O(256)
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			char sChar = s.charAt(i);																				// T : O(1)
			char tChar = t.charAt(i);																				// T : O(1)
			
			if (sArr[sChar] == -1 && tArr[tChar] == -1) {
				sArr[sChar] = tChar;
				tArr[tChar] = sChar;
			}
			if (sArr[sChar] != tChar || tArr[tChar] != sChar) { return false; }
		}
		
		return true;
	}
	
}
