package com.example.lcpjava.array;

import java.util.HashMap;
import java.util.Map;

public class Lcp_167_Two_Sum_II_Input_array_is_sorted {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Map<number, index> map <- empty map
	 * int[] result <- empty array[2]
	 * 
	 * for int i <- 0 to array end
	 * 		int pair <- target minus numbers[i]
	 * 		if map contain pair
	 * 			result[0] <- map get(pair) plus one
	 * 			result[1] <- i plus one
	 * 			return result
	 * 		end if
	 * 		map put (numbers[i], i)
	 * end for
	 * 
	 * return result
	 * */
	public int[] twoSum_1(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();																// S : O(n)
		int[] result = new int[2];
		
		for (int i = 0; i < numbers.length; i++) {																	// T : O(n)
			int pair = target - numbers[i];
			if (map.containsKey(pair)) {																			// T : O(1)
				result[0] = map.get(pair) + 1;																		// T : O(1)
				result[1] = i + 1;
				return result;
			}
			map.put(numbers[i], i);																					// T : O(1)
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int length <- array length
	 * int left <- 0
	 * int right <- length minus one
	 * int[] result <- empty array[2]
	 * 
	 * while left is lower than right
	 * 		int sum <- array[left] plus array[right]
	 * 		if sum is equal to target
	 * 			result[0] <- left plus one
	 * 			result[1] <- right plus one
	 * 			return result
	 * 		end if
	 * 		if sum is lower than target
	 * 			left++
	 * 		else
	 * 			right--
	 * 		end if
	 * end while
	 * 
	 * return result
	 * */
	public int[] twoSum(int[] numbers, int target) {
		int length = numbers.length;
		int left = 0;
		int right = length - 1;
		int[] result = new int[2];
		
		while (left < right) {																						// T : O(n)
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				result[0] = left + 1;
				result[1] = right + 1;
				return result;
			}
			if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Lcp_167_Two_Sum_II_Input_array_is_sorted lcp = new Lcp_167_Two_Sum_II_Input_array_is_sorted();
		int[] input = null;
		int target = -1;
		int[] output = null;
		
		// 1 2
		input = new int[] { 2, 7, 11, 15 };
		target = 9;
		output = lcp.twoSum(input, target);
		for (int num : output) { System.out.print(num + " "); }
		System.out.println();
		
		// 1 3
		input = new int[] { 2, 3, 4 };
		target = 6;
		output = lcp.twoSum(input, target);
		for (int num : output) { System.out.print(num + " "); }
		System.out.println();
		
		// 1 2
		input = new int[] { -1, 0 };
		target = -1;
		output = lcp.twoSum(input, target);
		for (int num : output) { System.out.print(num + " "); }
		System.out.println();
	}
	
}
