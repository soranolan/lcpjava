package com.example.lcpjava.graph;

import com.example.lcpjava.common.UnionFind;

public class Lcp_990_Satisfiability_of_Equality_Equations {
	
	/**
	 * time  : O(n)
	 * space : O(26)
	 * 
	 * handle equal first
	 * */
	public boolean equationsPossible_1(String[] equations) {
		int[] bucket = new int[26];																					// S : O(26)
		
		for (int i = 0; i < 26; i++) { bucket[i] = i; }																// T : O(26)
		
		for (String equation : equations) {																			// T : O(n)
			if (equation.charAt(1) == '=') {
				int group = bucket[equation.charAt(3) - 'a'];
				
				for (int i = 0; i < 26; i++) {																		// T : O(26)
					if (bucket[i] == group) {
						bucket[i] = bucket[equation.charAt(0) - 'a'];
					}
				}
			}
		}
		
		for (String equation : equations) {																			// T : O(n)
			if (equation.charAt(1) == '!') {
				if (bucket[equation.charAt(0) - 'a'] == bucket[equation.charAt(3) - 'a']) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(52)
	 * 
	 * https://leetcode.com/problems/satisfiability-of-equality-equations/discuss/234486/JavaC%2B%2BPython-Easy-Union-Find
	 * */
	public boolean equationsPossible(String[] equations) {
		UnionFind uf = new UnionFind(26);																			// T : O(26)
		
		for (String equation : equations) {																			// T : O(n)
			if (equation.charAt(1) == '=') {
				uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
			}
		}
		
		for (String equation : equations) {																			// T : O(n)
			if (equation.charAt(1) == '!') {
				if (uf.find(equation.charAt(0) - 'a') == uf.find(equation.charAt(3) - 'a')) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
