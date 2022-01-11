package com.example.lcpjava.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lcp_217_Contains_Duplicate {
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * Arrays sort(nums)
	 * 
	 * for int i <- 0; if i is lower than nums length; i++
	 * 		if nums[i minus one] is equal to nums[i]
	 * 			return true
	 * 		end if
	 * end for
	 * 
	 * return false
	 * */
	public boolean containsDuplicate_1(int[] nums) {
		Arrays.sort(nums);																							// T : O(n log n)
		for (int i = 1; i < nums.length; i++) {																		// T : O(n)
			if (nums[i - 1] == nums[i]) { return true; }
		}
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Set<Integer> set <- new HashSet
	 * 
	 * for number in array
	 * 		if set contains(number)
	 * 			return true
	 * 		end if
	 * 		
	 * 		set add(number)
	 * end for
	 * 
	 * return false
	 * */
	public boolean containsDuplicate_2(int[] nums) {
		Set<Integer> set = new HashSet<>();																			// S : O(n)
		for (int num : nums) {																						// T : O(n)
			if (set.contains(num)) { return true; }																	// T : O(1)
			set.add(num);																							// T : O(1)
		}
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Set<Integer> set <- new HashSet
	 * 
	 * for number in array
	 * 		if set does not add(number)
	 * 			return true
	 * 		end if
	 * end for
	 * 
	 * return false
	 * */
	public boolean containsDuplicate_3(int[] nums) {
		Set<Integer> set = new HashSet<>();																			// S : O(n)
		for (int num : nums) {																						// T : O(n)
			if (!set.add(num)) { return true; }																		// T : O(1)
		}
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * just for fun
	 * 
	 * int max <- Integer min value
	 * int min <- Integer max value
	 * 
	 * for number in array
	 * 		if number is greater than max
	 * 			max <- number
	 * 		end if
	 * 		if number is lower than min
	 * 			min <- number
	 * 		end if
	 * end for
	 * 
	 * if max is lower than zero
	 * 		max <- max multiply negative one
	 * end if
	 * if min is lower than zero
	 * 		min <- min multiply negative one
	 * end if
	 * 
	 * int[] positive <- new int[max divide 32 plus one]
	 * int[] negative <- new int[min divide 32 plus one]
	 * 
	 * for number in array
	 * 		boolean isNegative <- false
	 * 		if number is lower than zero
	 * 			isNegative <- true
	 * 			number <- number multiply negative one
	 * 		end if
	 * 		
	 * 		int index <- number divide 32;
	 * 		int shift <- number mod 32;
	 * 		int bit <- 1 << shift;
	 * 		
	 * 		if number is not negative
	 * 			if (positive[index] & bit) is not equal to zero
	 * 				return true
	 * 			end if
	 * 			positive[index] <- positive[index] | bit
	 * 		else
	 * 			if (negative[index] & bit) is not equal to zero
	 * 				return true
	 * 			end if
	 * 			negative[index] <- negative[index] | bit
	 * 		end if
	 * end for
	 * 
	 * return false
	 * */
	public boolean containsDuplicate(int[] nums) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int num : nums) {																						// T : O(n)
			if (num > max) { max = num; }
			if (num < min) { min = num; }
		}
		if (max < 0) { max *= -1; }
		if (min < 0) { min *= -1; }
		
		int[] positive = new int[max / 32 + 1];																		// S : O(n)
		int[] negative = new int[min / 32 + 1];																		// S : O(n)
		
		for (int num : nums) {																						// T : O(n)
			boolean isNegative = false;
			if (num < 0) {
				isNegative = true;
				num *= -1;
			}
			
			int index = num / 32;
			int shift = num % 32;
			int bit = 1 << shift;
			
			if (!isNegative) {
				if ((positive[index] & bit) != 0) { return true; }
				positive[index] |= bit;
			} else {
				if ((negative[index] & bit) != 0) { return true; }
				negative[index] |= bit;
			}
		}
		
		return false;
	}
	
}
