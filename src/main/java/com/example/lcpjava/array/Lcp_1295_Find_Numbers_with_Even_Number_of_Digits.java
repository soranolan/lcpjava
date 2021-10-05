package com.example.lcpjava.array;

public class Lcp_1295_Find_Numbers_with_Even_Number_of_Digits {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int even <- 0
	 * 
	 * for number in array
	 * 		if number is greater than 9 and lower than 100
	 * 		or number is greater than 999 and lower than 10000
	 * 		or number is 100000
	 * 			even++
	 * 		end if
	 * end for
	 * 
	 * return even
	 * */
	public int findNumbers(int[] nums) {
		int even = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] > 9 && nums[i] < 100) || (nums[i] > 999 && nums[i] < 10000) || nums[i] == 100000) { even++; }
		}
		return even;
	}
	
	public static void main(String[] args) {
		Lcp_1295_Find_Numbers_with_Even_Number_of_Digits lcp = new Lcp_1295_Find_Numbers_with_Even_Number_of_Digits();
		
		// 2
		int[] input = { 12, 345, 2, 6, 7896 };
		int output = lcp.findNumbers(input);
		System.out.println(output);
		
		// 1
		input = new int[] { 555, 901, 482, 1771 };
		output = lcp.findNumbers(input);
		System.out.println(output);
	}
	
}
