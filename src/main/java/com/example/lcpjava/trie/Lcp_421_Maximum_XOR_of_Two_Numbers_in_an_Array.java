package com.example.lcpjava.trie;

import com.example.lcpjava.common.Lcp_421_TrieNode;

public class Lcp_421_Maximum_XOR_of_Two_Numbers_in_an_Array {
	
	private Lcp_421_TrieNode root;
	
	public Lcp_421_Maximum_XOR_of_Two_Numbers_in_an_Array() {
		root = new Lcp_421_TrieNode();
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/solutions/1722805/java-a-very-detailed-explanation-with-sim-understanding-trie-bit/
	 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/solutions/1722805/java-a-very-detailed-explanation-with-sim-understanding-trie-bit/comments/1238974
	 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/solutions/91059/java-o-n-solution-using-trie/
	 * */
	public int findMaximumXOR_1(int[] nums) {
		int[] max = new int[1];
		
		for (int num : nums) {																						// T : O(n)
			insert(num);
		}
		
		for (int num : nums) {																						// T : O(n)
			find(num, max);
		}
		
		return max[0];
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/solutions/91059/java-o-n-solution-using-trie/comments/158398
	 * */
	public int findMaximumXOR(int[] nums) {
		int result = 0;
		
		for (int num : nums) {
			Lcp_421_TrieNode current = root;
			Lcp_421_TrieNode complement = root;
			int sum = 0;
			
			for (int i = 31; i >= 0; i--) {
				int bit = (num >> i) & 1;
				int requireBit = 1 - bit;
				
				if (current.children[bit] == null) {
					current.children[bit] = new Lcp_421_TrieNode();
				}
				
				current = current.children[bit];
				
				if (complement.children[requireBit] != null) {
					complement = complement.children[requireBit];
					sum |= (1 << i);
				} else {
					complement = complement.children[bit];
				}
			}
			
			result = Math.max(result, sum);
		}
		
		return result;
	}
	
	private void insert(int num) {
		Lcp_421_TrieNode current = root;
		
		for (int i = 31; i >= 0; i--) {																				// T : O(32)
			int bit = (num >> i) & 1;
			
			if (current.children[bit] == null) {
				current.children[bit] = new Lcp_421_TrieNode();
			}
			
			current = current.children[bit];
		}
	}
	
	private void find(int num, int[] max) {
		Lcp_421_TrieNode current = root;
		int sum = 0;
		
		for (int i = 31; i >= 0; i--) {																				// T : O(32)
			int bit = (num >> i) & 1;
			int requireBit = 1 - bit;
			
			if (current.children[requireBit] != null) {
				current = current.children[requireBit];
				sum |= (1 << i);
			} else {
				current = current.children[bit];
			}
		}
		
		max[0] = Math.max(max[0], sum);
	}
	
}
