package com.example.lcpjava.array;

public class Lcp_485 {
	
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
		for (int i = 0; i < length; i++) {
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
	
	public static void main(String[] args) {
		Lcp_485 lcp = new Lcp_485();
		
		// 3
		int[] input = { 1, 1, 0, 1, 1, 1 };
		int output = lcp.findMaxConsecutiveOnes(input);
		System.out.println(output);
		
		// 2
		input = new int[] { 1, 0, 1, 1, 0, 1 };
		output = lcp.findMaxConsecutiveOnes(input);
		System.out.println(output);
	}
	
}
