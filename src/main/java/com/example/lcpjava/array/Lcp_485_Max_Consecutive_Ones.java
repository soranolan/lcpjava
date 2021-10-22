package com.example.lcpjava.array;

public class Lcp_485_Max_Consecutive_Ones {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int count <- 0
	 * int max <- 0
	 * 
	 * for number in array
	 * 		if number is equal to one
	 * 			count++
	 * 		else
	 * 			if max is lower than count
	 * 				max <- count
	 * 			end if
	 * 			count <- 0
	 * 		end if
	 * end for
	 * 
	 * if max is lower than count
	 * 		max <- count
	 * end if
	 * 
	 * return max
	 * */
	public int findMaxConsecutiveOnes_1(int[] nums) {
		int count = 0;
		int max = 0;
		
		for (int num : nums) {																						// T : O(n)
			if (num == 1) {
				count++;
			} else {
				if (max < count) { max = count; }
				count = 0;
			}
		}
		if (max < count) { max = count; }
		
		return max;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int temp <- 0
	 * int max <- 0
	 * 
	 * for number in array
	 * 		if number is one
	 * 			temp++
	 * 		else
	 * 			if temp greater than max
	 * 				max <- temp
	 * 			end if
	 * 			temp <- 0
	 * 		end if
	 * 		if is array end && temp greater than max
	 * 			max <- temp
	 * 		end if
	 * end for
	 * 
	 * return max
	 * */
	public int findMaxConsecutiveOnes(int[] nums) {
		int temp = 0;
		int max = 0;
		int length = nums.length;
		for (int i = 0; i < length; i++) {																			// T : O(n)
			if (nums[i] == 1) {
				temp++;
			} else {
				if (temp > max) { max = temp; }
				temp = 0;
			}
			if ((i + 1) == length && temp > max) { max = temp; }
		}
		return max;
	}
	
}
