package com.example.lcpjava.array;

public class Lcp_747_Largest_Number_At_Least_Twice_of_Others {
	
	/**
	 * time  : O(m + n)
	 * space : O(1)
	 * 
	 * int max <- 0
	 * int index <- -1
	 * 
	 * for number in array
	 * 		if max is lower than number
	 * 			max <- number
	 * 		end if
	 * end for
	 * 
	 * for int i <- 0 to array end
	 * 		int num <- array[i]
	 * 		if max is equal to num
	 * 			index <- i
	 * 			continue
	 * 		end if
	 * 		if max is lower than num multiply two
	 * 			return -1
	 * 		end if
	 * end for
	 * 
	 * return index
	 * */
	public int dominantIndex_1(int[] nums) {
		int max = 0;
		int index = -1;
		
		for (int num : nums) {																						// T : O(n)
			if (max < num) { max = num; }
		}
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			int num = nums[i];
			if (max == num) {
				index = i;
				continue;
			}
			if (max < num * 2) { return -1; }
		}
		
		return index;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int max <- -1
	 * int second <- -1
	 * int index <- -1
	 * 
	 * for int i <- 0 to array end
	 * 		int num <- array[i]
	 * 		if max is lower than num
	 * 			second <- max
	 * 			max <- num
	 * 			index <- i
	 * 		else if second is lower than num
	 * 			second <- num
	 * 		end if
	 * end for
	 * 
	 * return if max is greater than or equal to second multiply two then index else -1
	 * */
	public int dominantIndex(int[] nums) {
		int max = -1;
		int second = -1;
		int index = -1;
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			int num = nums[i];
			if (max < num) {
				second = max;
				max = num;
				index = i;
			} else if (second < num) {
				second = num;
			}
		}
		
		return max >= second * 2 ? index : -1;
	}
	
	public static void main(String[] args) {
		Lcp_747_Largest_Number_At_Least_Twice_of_Others lcp = new Lcp_747_Largest_Number_At_Least_Twice_of_Others();
		int[] input = null;
		int output = -1;
		
		// 1
		input = new int[] { 3, 6, 1, 0 };
		output = lcp.dominantIndex(input);
		System.out.println(output);
		
		// -1
		input = new int[] { 1, 2, 3, 4 };
		output = lcp.dominantIndex(input);
		System.out.println(output);
		
		// 0
		input = new int[] { 1 };
		output = lcp.dominantIndex(input);
		System.out.println(output);
	}
	
}
