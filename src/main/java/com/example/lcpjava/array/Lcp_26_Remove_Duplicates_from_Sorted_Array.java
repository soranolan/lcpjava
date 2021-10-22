package com.example.lcpjava.array;

public class Lcp_26_Remove_Duplicates_from_Sorted_Array {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int left <- 0
	 * int right <- 1
	 * 
	 * while right is lower than array length
	 * 		if array[left] is equal to array[right]
	 * 			right++
	 * 		else
	 * 			left++
	 * 			array[left] <- array[right]
	 * 			right++
	 * 		end if
	 * end while
	 * 
	 * return left plus one
	 * */
	public int removeDuplicates_1(int[] nums) {
		int left = 0;
		int right = 1;
		
		while (right < nums.length) {																				// T : O(n)
			if (nums[left] == nums[right]) {
				right++;
			} else {
				left++;
				nums[left] = nums[right];
				right++;
			}
		}
		
		for (int num : nums) { System.out.print(num + " "); }
		System.out.println();
		return left + 1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int left <- 0
	 * 
	 * for int right <- 1; if right is lower than array length; right++
	 * 		if array[left] not equal to array[right]
	 * 			left++
	 * 			array[left] <- array[right]
	 * 		end if
	 * end for
	 * 
	 * return left plus one
	 * */
	public int removeDuplicates(int[] nums) {
		int left = 0;
		
		for (int right = 1; right < nums.length; right++) {															// T : O(n)
			if (nums[left] != nums[right]) {
				left++;
				nums[left] = nums[right];
			}
		}
		
		for (int num : nums) { System.out.print(num + " "); }
		System.out.println();
		return left + 1;
	}
	
}
