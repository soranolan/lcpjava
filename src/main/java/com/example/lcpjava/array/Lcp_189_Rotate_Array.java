package com.example.lcpjava.array;

public class Lcp_189_Rotate_Array {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int length <- array length
	 * int[] copy <- empty array[length]
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		copy[(i plus k) modulo length] <- array[i]
	 * end for
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		array[i] <- copy[i]
	 * end for
	 * */
	public void rotate_1(int[] nums, int k) {
		int length = nums.length;
		int[] copy = new int[length];																				// S : O(n)
		
		for (int i = 0; i < length; i++) { copy[(i + k) % length] = nums[i]; }										// T : O(n)
		for (int i = 0; i < length; i++) { nums[i] = copy[i]; }														// T : O(n)
		
		for (int num : nums) { System.out.print(num + " "); }
		System.out.println();
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int length <- array length
	 * k <- k modulo length
	 * 
	 * reverse whole array
	 * reverse array from index zero to k minus one
	 * reverse array from index k to length minus one
	 * */
	public void rotate(int[] nums, int k) {
		int length = nums.length;
		k %= length;
		
		reverse(nums, 0, length - 1);																				// T : O(n)
		reverse(nums, 0, k - 1);																					// T : O(n)
		reverse(nums, k, length - 1);																				// T : O(n)
		
		for (int num : nums) { System.out.print(num + " "); }
		System.out.println();
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * while left is lower than right
	 * 		int temp <- array[left]
	 * 		array[left] <- array[right]
	 * 		array[right] <- temp
	 * 		left++
	 * 		right--
	 * end while
	 * */
	public void reverse(int[] nums, int left, int right) {
		while (left < right) {																						// T : O(n)
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
	
}
