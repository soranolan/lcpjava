package com.example.lcpjava.array;

public class Lcp_27_Remove_Element {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int count <- 0
	 * 
	 * for number in array
	 * 		if number is equal to val
	 * 			count++
	 * 		end if
	 * end for
	 * 
	 * int length <- array.length
	 * int left <- 0
	 * int right <- length - 1
	 * 
	 * while left is not equal right
	 * 		if array[left] is equal to val
	 * 			array[left] <- array[right]
	 * 			array[right] <- val
	 * 			right--
	 * 		else
	 * 			left++
	 * 		end if
	 * end while
	 * 
	 * return length - count
	 * */
	public int removeElement_1(int[] nums, int val) {
		int count = 0;
		for (int num : nums) {
			if (num == val) { count++; }
		}
		
		int length = nums.length;
		int left = 0;
		int right = length - 1;
		
		while (left < right) {																						// T : O(n)
			if (nums[left] == val) {
				nums[left] = nums[right];
				nums[right] = val;
				right--;
			} else {
				left++;
			}
		}
		
		for (int num : nums) { System.out.print(num + " "); }
		System.out.println();
		
		return length - count;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int count <- 0
	 * 
	 * for int i <- 0 to array end
	 * 		if array[i] is not equal to val
	 * 			array[count] <- array[i]
	 * 			count++
	 * 		end if
	 * end for
	 * 
	 * return count
	 * */
	public int removeElement(int[] nums, int val) {
		int count = 0;
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			if (nums[i] != val) {
				nums[count] = nums[i];
				count++;
			}
		}
		
		for (int num : nums) { System.out.print(num + " "); }
		System.out.println();
		
		return count;
	}
	
	public static void main(String[] args) {
		Lcp_27_Remove_Element lcp = new Lcp_27_Remove_Element();
		int output = -1;
		int val = -1;
		
		// 2; 2 2
		int[] input = { 3, 2, 2, 3 };
		val = 3;
		output = lcp.removeElement(input, val);
		System.out.println(output);
		
		// 5; 0 1 2 3 4
		input = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
		val = 2;
		output = lcp.removeElement(input, val);
		System.out.println(output);
		
		// 0;
		input = new int[] { };
		val = 0;
		output = lcp.removeElement(input, val);
		System.out.println(output);
		
		// 0;
		input = new int[] { 1 };
		val = 1;
		output = lcp.removeElement(input, val);
		System.out.println(output);
	}
	
}
