package com.example.lcpjava.array;

public class Lcp_137_Single_Number_II {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
	 * */
	public int singleNumber_1(int[] nums) {
		int x1 = 0;
		int x2 = 0;
		int mask = 0;
		
		for (int num : nums) {																						// T : O(n)
			x2 ^= x1 & num;
			x1 ^= num;
			
			mask = ~(x1 & x2);
			
			x2 &= mask;
			x1 &= mask;
		}
		
		return x1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/single-number-ii/discuss/43294/Challenge-me-thx
	 * 
	 * 
	 * if ones does not contain number
	 * 		if twos does not contain number
	 * 			ones add number
	 * 		end if
	 * else
	 * 		ones remove number
	 * end if
	 * 
	 * if twos does not contain number
	 * 		if ones does not contain number
	 * 			twos add number
	 * 		end if
	 * else
	 * 		twos remove number
	 * end if
	 * */
	public int singleNumber(int[] nums) {
		int ones = 0;
		int twos = 0;
		
		for (int num : nums) {																						// T : O(n)
			ones = (ones ^ num) & ~twos;
			twos = (twos ^ num) & ~ones;
		}
		
		return ones;
	}
	
}
