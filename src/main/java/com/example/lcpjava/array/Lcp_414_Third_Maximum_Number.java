package com.example.lcpjava.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Lcp_414_Third_Maximum_Number {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Integer max1 <- null
	 * Integer max2 <- null
	 * Integer max3 <- null
	 * 
	 * for number in array
	 * 		if number is equal to max1 or max2 or max3
	 * 			continue
	 * 		end if
	 * 		if max1 is equal to null || number is greater than max1
	 * 			max3 <- max2
	 * 			max2 <- max1
	 * 			max1 <- number
	 * 		else if max2 is equal to null || number is greater than max2
	 * 			max3 <- max2
	 * 			max2 <- number
	 * 		else if max3 is equal to null || number is greater than max3
	 * 			max3 <- number
	 * 		end if
	 * end for
	 * 
	 * return if max3 is equal to null than max1 else max3
	 * */
	public int thirdMax_1(int[] nums) {
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;
		
		for (Integer num : nums) {																					// O(n)
			if (num.equals(max1) || num.equals(max2) || num.equals(max3)) { continue; }
			if (max1 == null || num > max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			} else if (max2 == null || num > max2) {
				max3 = max2;
				max2 = num;
			} else if (max3 == null || num > max3) {
				max3 = num;
			}
		}
		
		return max3 == null ? max1 : max3;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * PriorityQueue<Integer> pq <- empty PriorityQueue
	 * Set<Integer> set <- empty HashSet
	 * 
	 * for number in array
	 * 		if set does not contain number
	 * 			set add number
	 * 			pq offer number
	 * 			if pq size is greater than three
	 * 				pq remove
	 * 			end if
	 * 		end if
	 * end for
	 * 
	 * if pq size is equal to two
	 * 		pq remove
	 * end if
	 * 
	 * return pq peek
	 * */
	public int thirdMax_2(int[] nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Set<Integer> set = new HashSet<>();
		
		for (int num : nums) {																						// T : O(n)
			if (!set.contains(num)) {																				// T : O(1)
				set.add(num);																						// T : O(1); S : O(n)
				pq.offer(num);																						// T : O(log n)
				if (pq.size() > 3) { pq.remove(); }																	// T : O(log n)
			}
		}
		
		if (pq.size() == 2) { pq.remove(); }																		// T : O(log n)
		
		return pq.peek();																							// T : O(1)
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * PriorityQueue<Integer> pq <- empty PriorityQueue
	 * 
	 * for number in array
	 * 		if pq does not contain number
	 * 			pq offer number
	 * 			if pq size is greater than three
	 * 				pq poll
	 * 			end if
	 * 		end if
	 * end for
	 * 
	 * if pq size is equal to two
	 * 		pq poll
	 * end if
	 * 
	 * return pq peek
	 * */
	public int thirdMax_3(int[] nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int num : nums) {																						// T : O(n)
			if (!pq.contains(num)) {																				// T : O(n)
				pq.offer(num);																						// T : O(log n)
				if (pq.size() > 3) { pq.poll(); }																	// T : O(log n)
			}
		}
		
		if (pq.size() == 2) { pq.poll(); }																			// T : O(log n)
		
		return pq.peek();																							// T : O(1)
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(1)
	 * 
	 * array sort
	 * 
	 * int length <- array length
	 * int count <- 0;
	 * int max3 <- array[length minus one]
	 * 
	 * for int i <- length minus one; if i is greater than zero; i--
	 * 		if array[i] is not equal to array[i minus one]
	 * 			max3 <- array[i minus one]
	 * 			count++
	 * 		end if
	 * 		if count is equal to three
	 * 			break
	 * 		end if
	 * end for
	 * 
	 * if count is equal to two
	 * 		return array[length minus one]
	 * end if
	 * 
	 * return max3
	 * */
	public int thirdMax(int[] nums) {
		Arrays.sort(nums);																							// T : O(n log n)
		
		int length = nums.length;
		int max3 = nums[length - 1];
		int count = 1;
		
		for (int i = length - 1; i > 0 ; i--) {																		// T : O(n)
			if (nums[i] != nums[i - 1]) {
				max3 = nums[i - 1];
				count++;
			}
			if (count == 3) { break; }
		}
		
		if (count == 2) { return nums[length - 1]; }
		
		return max3;
	}
	
}
