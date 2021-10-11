package com.example.lcpjava.array;

public class Lcp_66_Plus_One {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int length <- array length
	 * 
	 * for int right <- length - 1 to array head
	 * 		if array[right] is lower than 9
	 * 			array[right] += 1
	 * 			return array
	 * 		end if
	 * 		array[right] <- 0
	 * end for
	 * 
	 * int[] exceed <- length + 1
	 * exceed[0] <- 1
	 * 
	 * return exceed
	 * */
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		
		for (int right = length - 1; right >= 0; right--) {															// T : O(n)
			if (digits[right] < 9) {
				digits[right] += 1;
				return digits;
			}
			digits[right] = 0;
		}
		
		int[] exceed = new int[length + 1];																			// S : O(n)
		exceed[0] = 1;
		
		return exceed;
	}
	
	public static void main(String[] args) {
		Lcp_66_Plus_One lcp = new Lcp_66_Plus_One();
		int[] input = null;
		int[] output = null;
		
		// 1 2 4
		input = new int[] { 1, 2, 3 };
		output = lcp.plusOne(input);
		for (int num : output) { System.out.print(num + " "); }
		System.out.println();
		
		// 4 3 2 2
		input = new int[] { 4, 3, 2, 1 };
		output = lcp.plusOne(input);
		for (int num : output) { System.out.print(num + " "); }
		System.out.println();
		
		// 1
		input = new int[] { 0 };
		output = lcp.plusOne(input);
		for (int num : output) { System.out.print(num + " "); }
		System.out.println();
		
		// 1 0
		input = new int[] { 9 };
		output = lcp.plusOne(input);
		for (int num : output) { System.out.print(num + " "); }
		System.out.println();
	}
	
}
