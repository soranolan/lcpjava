package com.example.lcpjava.array;

public class Lcp_66_Plus_One {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int length <- array length
	 * 
	 * for int right <- length minus one; if right is greater than or equal to zero; right--
	 * 		if array[right] is lower than nine
	 * 			array[right] += 1
	 * 			return array
	 * 		end if
	 * 		array[right] <- 0
	 * end for
	 * 
	 * int[] exceed <- length plus one
	 * exceed[0] <- 1
	 * 
	 * return exceed
	 * */
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		
		for (int right = length - 1; right >= 0; right--) {															// T : O(n)
			if (digits[right] < 9) {
				digits[right] += 1;
				return digits;
			}
			digits[right] = 0;
		}
		
		int[] exceed = new int[length + 1];																			// S : O(n)
		exceed[0] = 1;
		
		return exceed;
	}
	
}
