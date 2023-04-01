package com.example.lcpjava.array;

public class Lcp_704_Binary_Search {
	
	/**
	 * You must write an algorithm with O(log n) runtime complexity.
	 * */
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * */
	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return -1;
	}
	
}
