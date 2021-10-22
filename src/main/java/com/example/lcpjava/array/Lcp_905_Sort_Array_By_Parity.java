package com.example.lcpjava.array;

public class Lcp_905_Sort_Array_By_Parity {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int left <- 0
	 * int right <- array length minus one
	 * 
	 * while left is lower than right
	 * 		if array[left] mod two is greater than array[right] mod two
	 * 			int temp <- array[left]
	 * 			array[left] <- array[right]
	 * 			array[right] <- temp
	 * 		end if
	 * 		if array[left] mod two is equal to zero
	 * 			left++
	 * 		end if
	 * 		if array[right] mod two is equal to one
	 * 			right--
	 * 		end if
	 * end while
	 * 
	 * return array
	 * */
	public int[] sortArrayByParity_1(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		
		while (left < right) {																						// T : O(n)
			if (nums[left] % 2 > nums[right] % 2) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
			}
			if (nums[left] % 2 == 0) { left++; }
			if (nums[right] % 2 == 1) { right--; }
		}
		
		return nums;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int left <- 0
	 * 
	 * for int right <- 0; if right is lower than array length; right++
	 * 		if array[right] mod two is equal to zero
	 * 			int temp <- array[left]
	 * 			array[left] <- array[right]
	 * 			array[right] <- temp
	 * 			left++
	 * 		end if
	 * end for
	 * 
	 * return array
	 * */
	public int[] sortArrayByParity(int[] nums) {
		int left = 0;
		
		for (int right = 0; right < nums.length; right++) {															// T : O(n)
			if (nums[right] % 2 == 0) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
			}
		}
		
		return nums;
	}
	
}
