package com.example.lcpjava.array;

import com.example.lcpjava.common.UF_1061;

public class Lcp_1061_Lexicographically_Smallest_Equivalent_String {
	
	/**
	 * time  : O(n + m)
	 * space : O(26 * 2)
	 * */
	public String smallestEquivalentString(String s1, String s2, String baseStr) {
		int n = s1.length();																						// n
		
		UF_1061 uf = new UF_1061(26);																				// T : O(26)
		for (int i = 0; i < n; i++) {																				// T : O(n)
			uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');														// T : O(α(26))
		}
		
		int m = baseStr.length();																					// m
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {																				// T : O(m)
			sb.append((char) (uf.find(baseStr.charAt(i) - 'a') + 'a'));												// T : O(α(26))
		}
		
		return sb.toString();
	}
	
}
