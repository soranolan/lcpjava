package com.example.lcpjava.array;

public class Lcp_724_Find_Pivot_Index {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int sum <- 0
	 * int leftSum <- 0
	 * 
	 * for number in array
	 * 		sum += number
	 * end for
	 * 
	 * for int i <- 0 to array end
	 * 		int num = array[i]
	 * 		if leftSum multiply two is equal to sum minus num
	 * 			return i
	 * 		end if
	 * 		leftSum += num
	 * end for
	 * 
	 * return -1
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
	
	public static void main(String[] args) {
		Lcp_724_Find_Pivot_Index lcp = new Lcp_724_Find_Pivot_Index();
		int[] input = null;
		int output = -1;
		
		// 3
		input = new int[] { 1, 7, 3, 6, 5, 6 };
		output = lcp.pivotIndex(input);
		System.out.println(output);
		
		// -1
		input = new int[] { 1, 2, 3 };
		output = lcp.pivotIndex(input);
		System.out.println(output);
		
		// 0
		input = new int[] { 2, 1, -1 };
		output = lcp.pivotIndex(input);
		System.out.println(output);
		
		// -1
		input = new int[] { -1, -1, -1, -1, -1, -1 };
		output = lcp.pivotIndex(input);
		System.out.println(output);
	}
	
}
