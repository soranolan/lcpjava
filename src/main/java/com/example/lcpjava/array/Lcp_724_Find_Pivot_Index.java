package com.example.lcpjava.array;

public class Lcp_724_Find_Pivot_Index {
	
	/**
	 * time  : O(m + n)
	 * space : O(1)
	 * 
	 * int sum <- 0
	 * int leftSum <- 0
	 * 
	 * for number in array
	 * 		sum <- sum plus number
	 * end for
	 * 
	 * for int i <- 0; if i is lower than array length; i++
	 * 		int num <- array[i]
	 * 		if leftSum times two is equal to sum minus num
	 * 			return i
	 * 		end if
	 * 		leftSum <- leftSum plus num
	 * end for
	 * 
	 * return minus one
	 * */
	public int pivotIndex(int[] nums) {
		int sum = 0;
		int leftSum = 0;
		
		for (int num : nums) { sum += num; }																		// T : O(n)
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			int num = nums[i];
			if (leftSum * 2 == (sum - num)) { return i; }
			leftSum += num;
		}
		
		return -1;
	}
	
}
