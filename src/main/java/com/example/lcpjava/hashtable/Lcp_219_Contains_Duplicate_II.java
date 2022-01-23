package com.example.lcpjava.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lcp_219_Contains_Duplicate_II {
	
	/**
	 * time  : O(k * n)
	 * space : O(1)
	 * 
	 * int length <- nums length
	 * 
	 * while k is greater than zero
	 * 		for int left <- 0; if left is lower than length; left++
	 * 			int right <- left plus k
	 * 			
	 * 			if right is greater than or equal to length
	 * 				break for loop
	 * 			end if
	 * 			
	 * 			if nums[left] is equal to nums[right] && (right minus left is lower than or equal to k)
	 * 				return true
	 * 			end if
	 * 		end for
	 * 		
	 * 		k--;
	 * end while
	 * 
	 * return false
	 * */
	public boolean containsNearbyDuplicate_1(int[] nums, int k) {
		int length = nums.length;
		
		while (k > 0) {																								// T : O(k)
			for (int left = 0; left < length; left++) {																// T : O(n - k)
				int right = left + k;
				
				if (right >= length) { break; }
				if (nums[left] == nums[right] && (right - left <= k)) { return true; }
			}
			
			k--;
		}
		
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Map<Integer, Integer> memo <- new HashMap
	 * 
	 * for int i <- 0; if i is lower than nums length; i++
	 * 		int num <- nums[i]
	 * 		
	 * 		if memo containsKey(num) && (i minus memo get(num) is lower than or equal to k)
	 * 			return true
	 * 		end if
	 * 		
	 * 		memo put(num, i)
	 * end for
	 * 
	 * return false
	 * */
	public boolean containsNearbyDuplicate_2(int[] nums, int k) {
		Map<Integer, Integer> memo = new HashMap<>();																// S : O(n)
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			int num = nums[i];
			
			if (memo.containsKey(num) && i - memo.get(num) <= k) { return true; }									// T : O(1)
			
			memo.put(num, i);																						// T : O(1)
		}
		
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Map<Integer, Integer> memo <- new HashMap
	 * 
	 * for int i <- 0; if i is lower than nums length; i++
	 * 		int num <- nums[i]
	 * 		
	 * 		Integer index <- memo put(num, i)
	 * 		
	 * 		if index is not equal to null && (i minus index is lower than or equal to k)
	 * 			return true
	 * 		end if
	 * end for
	 * 
	 * return false
	 * */
	public boolean containsNearbyDuplicate_3(int[] nums, int k) {
		Map<Integer, Integer> memo = new HashMap<>();																// S : O(n)
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			int num = nums[i];
			Integer index = memo.put(num, i);																		// T : O(1)
			if (index != null && i - index <= k) { return true; }
		}
		
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(min(n, k + 1))
	 * 
	 * Sliding window
	 * 
	 * 
	 * Set<Integer> window <- new HashSet
	 * 
	 * for int i <- 0; if i is lower than nums length; i++
	 * 		if i is greater than k
	 * 			window remove(nums[i minus k minus one])
	 * 		end if
	 * 		
	 * 		if window does not add(nums[i])
	 * 			return true
	 * 		end if
	 * end for
	 * 
	 * return false
	 * */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> window = new HashSet<>();																		// S : O(n)
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			if (i > k) { window.remove(nums[i - k - 1]); }															// T : O(1)
			if (!window.add(nums[i])) { return true; }																// T : O(1)
		}
		
		return false;
	}
	
}
