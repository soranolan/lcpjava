package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lcp_448_Find_All_Numbers_Disappeared_in_an_Array {
	
	/**
	 * time  : O(m + n)
	 * space : O(n)
	 * 
	 * int length <- array length
	 * Set<Integer> container <- empty HashSet
	 * List<Integer> result <- empty ArrayList
	 * 
	 * for number in array
	 * 		container add number
	 * end for
	 * 
	 * for int i <- 1; if i is lower than or equal to length; i++
	 * 		if container not contain i
	 * 			result add i
	 * 		end if
	 * end for
	 * 
	 * return result
	 * */
	public List<Integer> findDisappearedNumbers_1(int[] nums) {
		int length = nums.length;
		Set<Integer> container = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		
		for (int num : nums) {																						// T : O(n)
			container.add(num);																						// T : O(1); S : O(n)
		}
		
		for (int i = 1; i <= length; i++) {																			// T : O(n)
			if (!container.contains(i)) {																			// T : O(1)
				result.add(i);																						// T : amortized O(1)
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(m + n)
	 * space : O(1) assume the returned list does not count as extra space
	 * 
	 * Cyclic sort
	 * 
	 * List<Integer> result <- empty ArrayList
	 * int length <- array length
	 * int i <- 0
	 * 
	 * while i is lower than array length
	 * 		int temp <- array[i]
	 * 		if temp is not equal to (i plus one) && temp is not equal to array[temp minus one]
	 * 			array[i] <- array[temp minus one]
	 * 			array[temp minus one] <- temp
	 * 		else
	 * 			i++
	 * 		end if
	 * end while
	 * 
	 * for int j <- 0; if j is lower than length; j++
	 * 		if array[j] is not equal to (j plus one)
	 * 			result add (j plus one)
	 * 		end if
	 * end for
	 * 
	 * return result
	 * */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int length = nums.length;
		int i = 0;
		
		while (i < length) {																						// T : O(n)
			int temp = nums[i];
			if (temp != (i + 1) && temp != nums[temp - 1]) {
				nums[i] = nums[temp - 1];
				nums[temp - 1] = temp;
			} else {
				i++;
			}
		}
		
		for (int j = 0; j < length; j++) {																			// T : O(n)
			if (nums[j] != (j + 1)) {
				result.add(j + 1);																					// T : amortized O(1)
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Lcp_448_Find_All_Numbers_Disappeared_in_an_Array lcp = new Lcp_448_Find_All_Numbers_Disappeared_in_an_Array();
		int [] input = null;
		List<Integer> output = null;
		
		// 5 6
		input = new int[] { 4,3,2,7,8,2,3,1 };
		output = lcp.findDisappearedNumbers(input);
		System.out.println(output);
		
		// 2
		input = new int[] { 1, 1 };
		output = lcp.findDisappearedNumbers(input);
		System.out.println(output);
	}
	
}
