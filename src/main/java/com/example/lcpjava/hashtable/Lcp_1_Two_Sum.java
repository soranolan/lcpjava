package com.example.lcpjava.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Lcp_1_Two_Sum {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int[] result <- new int[2]
	 * Map<Integer, Integer> memo <- new HashMap
	 * 
	 * for int i <- 0; if i is lower than nums length; i++
	 * 		int pair <- target minus nums[i]
	 * 		
	 * 		if memo containsKey pair
	 * 			result[0] <- memo get(pair)
	 * 			result[1] <- i
	 * 			return result
	 * 		end if
	 * 		
	 * 		memo put(nums[i], i)
	 * end for
	 * 
	 * return result
	 * */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];																					// S : O(2)
		Map<Integer, Integer> memo = new HashMap<>();																// S : O(n)
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			int pair = target - nums[i];
			if (memo.containsKey(pair)) {																			// T : O(1)
				result[0] = memo.get(pair);																			// T : O(1)
				result[1] = i;
				return result;
			}
			memo.put(nums[i], i);																					// T : O(1)
		}
		
		return result;
	}
	
}
