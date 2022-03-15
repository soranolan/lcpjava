package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_977_Squares_of_a_Sorted_Array {
	
	/**
	 * time  : O(n log n)
	 * space : O(1)
	 * 
	 * for number in array
	 * 		number <- number times number
	 * end for
	 * sort array
	 * 
	 * return array
	 * */
	public int[] sortedSquares_1(int[] nums) {
		for (int i = 0; i < nums.length; i++) { nums[i] = nums[i] * nums[i]; }										// T : O(n)
		Arrays.sort(nums);																							// T : O(n log n)
		return nums;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int length <- array length
	 * int left <- 0
	 * int right <- length minus one
	 * int[] newArray <- empty array[length]
	 * 
	 * for i <- right; if i is greater than or equal to zero; i--
	 * 		if array[left] lower than array[right]
	 * 			newArray[i] <- array[right] times array[right]
	 * 			right--
	 * 		else
	 * 			newArray[i] <- array[left] times array[left]
	 * 			left++
	 * 		end if
	 * end for
	 * 
	 * return newArray
	 * */
	public int[] sortedSquares_2(int[] nums) {
		int length = nums.length;
		int left = 0;
		int right = length - 1;
		int[] newArray = new int[length];
		
		for (int i = right; i >= 0; i--) {																			// T : O(n)
			if (Math.abs(nums[left]) < Math.abs(nums[right])) {
				newArray[i] = nums[right] * nums[right];
				right--;
			} else {
				newArray[i] = nums[left] * nums[left];
				left++;
			}
		}
		return newArray;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int length <- array length
	 * int left <- 0
	 * int right <- length minus one
	 * int[] newArray <- empty array[length]
	 * 
	 * while left is lower than or equal to right
	 * 		if array[left] lower than array[right]
	 * 			newArray[i] <- array[right] times array[right]
	 * 			i--
	 * 			right--
	 * 		else
	 * 			newArray[i] <- array[left] times array[left]
	 * 			i--
	 * 			left++
	 * 		end if
	 * end while
	 * 
	 * return newArray
	 * */
	public int[] sortedSquares(int[] nums) {
		int length = nums.length;
		int left = 0;
		int right = length - 1;
		int i = right;
		int[] newArray = new int[length];																			// S : O(n)
		
		while (left <= right) {																						// T : O(n)
			if (Math.abs(nums[left]) < Math.abs(nums[right])) {
				newArray[i--] = nums[right] * nums[right];
				right--;
			} else {
				newArray[i--] = nums[left] * nums[left];
				left++;
			}
		}
		return newArray;
	}
	
}
