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
	 * for int i <- 0; if i is lower than array length; i++
	 * 		int num <- array[i]
	 * 		if max is equal to num
	 * 			index <- i
	 * 			continue
	 * 		end if
	 * 		if max is lower than num times two
	 * 			return minus one
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
	 * for int i <- 0; if i is lower than array length; i++
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
	 * return if max is greater than or equal to second times two then index else minus one
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
	
}
