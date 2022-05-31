package com.example.lcpjava.array;

import java.util.HashSet;
import java.util.Set;

public class Lcp_1461_Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
	
	/**
	 * time  : O(n * k)
	 * space : O(k * 2 ^ k)
	 * */
	public boolean hasAllCodes_1(String s, int k) {
		int length = s.length();																					// n
		Set<String> combinations = new HashSet<>();																	// S : O(k * 2 ^ k)
		
		for (int i = 0; i < length - k + 1; i++) {																	// T : O(n - k + 1)
			StringBuilder binary = new StringBuilder();
			
			for (int j = 0; j < k; j++) { binary.append(s.charAt(i + j)); }											// T : O(k)
			
			combinations.add(binary.toString());
		}
		
		return combinations.size() == Math.pow(2, k);
	}
	
	/**
	 * time  : O(n * k)
	 * space : O(k * 2 ^ k)
	 * */
	public boolean hasAllCodes_2(String s, int k) {
		int length = s.length();																					// n
		Set<String> combinations = new HashSet<>();																	// S : O(k * 2 ^ k)
		
		for (int i = 0; i < length - k + 1; i++) {																	// T : O(n - k + 1)
			combinations.add(s.substring(i, i + k));
		}
		
		return combinations.size() == Math.pow(2, k);
	}
	
	/**
	 * time  : O(n * k)
	 * space : O(k * 2 ^ k)
	 * */
	public boolean hasAllCodes_3(String s, int k) {
		int length = s.length();																					// n
		int count = 1 << k;																							// 2 ^ k
		Set<String> combinations = new HashSet<>();																	// S : O(k * 2 ^ k)
		
		for (int i = 0; i < length - k + 1; i++) {																	// T : O(n - k + 1)
			String binary = s.substring(i, i + k);																	// T : O(k)
			if (combinations.contains(binary)) { continue; }
			
			combinations.add(binary);
			
			count--;
			if (count == 0) { return true; }
		}
		
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(2 ^ k)
	 * 
	 * Rolling Hash
	 * 
	 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/discuss/1105885/Check-If-a-String-Contains-All-Binary-Codes-of-Size-K-or-Short-and-Easy-w-explanation
	 * */
	public boolean hasAllCodes(String s, int k) {
		int length = s.length();																					// n
		int count = 1 << k;																							// 2 ^ k
		int mask = ~count;
		int hash = 0;
		boolean[] seen = new boolean[count];																		// S : O(2 ^ k)
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			// prepare for next binary
			hash <<= 1;
			
			// remove previous number ( most significant bit )
			hash &= mask;
			
			// add next number ( least significant bit )
			hash |= (s.charAt(i) - '0');
			
			// for the first k round
			if (i < k - 1 || seen[hash]) { continue; }
			
			seen[hash] = true;
			count--;
			if (count == 0) { return true; }
		}
		
		return false;
	}
	
}
