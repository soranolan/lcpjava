package com.example.lcpjava.array;

public class Lcp_1295_Find_Numbers_with_Even_Number_of_Digits {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int even <- 0
	 * 
	 * for number in array
	 * 		if number is greater than 9 and lower than 100
	 * 		or number is greater than 999 and lower than 10000
	 * 		or number is 100000
	 * 			even++
	 * 		end if
	 * end for
	 * 
	 * return even
	 * */
	public int findNumbers(int[] nums) {
		int even = 0;
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			if ((nums[i] > 9 && nums[i] < 100) || (nums[i] > 999 && nums[i] < 10000) || nums[i] == 100000) { even++; }
		}
		return even;
	}
	
}
