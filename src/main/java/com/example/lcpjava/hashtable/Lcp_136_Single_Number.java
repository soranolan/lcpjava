package com.example.lcpjava.hashtable;

public class Lcp_136_Single_Number {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * 0 ^ 1 = 0000 ^ 0001 = 0001 = 1
	 * 1 ^ 1 = 0001 ^ 0001 = 0000 = 0
	 * 0 ^ 1 ^ 1 = 0000 ^ 0001 ^ 0001 = 0000 = 0
	 * 
	 * int single <- 0
	 * 
	 * for number in array
	 * 		single <- single ^ number
	 * end for
	 * 
	 * return single
	 * */
	public int singleNumber(int[] nums) {
		int single = 0;
		for (int num : nums) { single ^= num; }																		// T : O(n)
		return single;
	}
	
}
