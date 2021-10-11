package com.example.lcpjava.array;

public class Lcp_747_Largest_Number_At_Least_Twice_of_Others {
	
	/**
	 * time  : O(n)
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
	 * 		if max is equal to array[i]
	 * 			index <- i
	 * 			continue
	 * 		end if
	 * 		if max is lower than array[i] multiply two
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
			if (max == nums[i]) {
				index = i;
				continue;
			}
			if (max < nums[i] * 2) { return -1; }
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
	 * 		if max is lower than array[i]
	 * 			second <- max
	 * 			max <- array[i]
	 * 			index <- i
	 * 		else if second is lower than array[i]
	 * 			second <- array[i]
	 * 		end if
	 * end for
	 * 
	 * return max > second * 2 ? index : -1
	 * */
	public int dominantIndex(int[] nums) {
		int max = -1;
		int second = -1;
		int index = -1;
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			if (max < nums[i]) {
				second = max;
				max = nums[i];
				index = i;
			} else if (second < nums[i]) {
				second = nums[i];
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
