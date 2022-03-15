package com.example.lcpjava.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lcp_350_Intersection_of_Two_Arrays_II {
	
	/**
	 * time  : O(n log n)
	 * space : O(p)
	 * 
	 * Arrays sort(nums1)
	 * Arrays sort(nums2)
	 * 
	 * int left <- 0
	 * int right <- 0
	 * List<Integer> intersection <- new ArrayList
	 * 
	 * while left is lower than nums1 length && right is lower than nums2 length
	 * 		int l <- nums1[left]
	 * 		int r <- nums2[right]
	 * 		
	 * 		if l is equal to r
	 * 			intersection add(l)
	 * 			left++
	 * 			right++
	 * 		else if l is greater than r
	 * 			right++
	 * 		else
	 * 			left++
	 * 		end if
	 * end while
	 * 
	 * int[] result <- new int[intersection size]
	 * int index <- 0
	 * 
	 * for number in intersection
	 * 		result[index] <- number
	 * 		index++
	 * end for
	 * 
	 * return result
	 * */
	public int[] intersect_1(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);																							// T : O(n log n)
		Arrays.sort(nums2);																							// T : O(n log n)
		
		int left = 0;
		int right = 0;
		List<Integer> intersection = new ArrayList<>();																// S : O(p)
		
		while (left < nums1.length && right < nums2.length) {														// T : O(n)
			int l = nums1[left];
			int r = nums2[right];
			
			if (l == r) {
				intersection.add(l);
				left++;
				right++;
			} else if (l > r) {
				right++;
			} else {
				left++;
			}
		}
		
		int[] result = new int[intersection.size()];																// S : O(p)
		int index = 0;
		for (int num : intersection) { result[index++] = num; }														// T : O(p)
		
		return result;
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(n)
	 * 
	 * if nums1 length is greater than nums2 length
	 * 		return intersect(nums2, nums1)
	 * end if
	 * 
	 * Arrays sort(nums1)
	 * 
	 * List<Integer> sorted <- new ArrayList
	 * 
	 * for number in nums1
	 * 		sorted add(number)
	 * end for
	 * 
	 * List<Integer> intersection <- new ArrayList
	 * 
	 * for int number in nums2
	 * 		int index <- binarySearch(sorted, number)
	 * 		
	 * 		if index is not equal to minus one
	 * 			sorted remove(index)
	 * 			intersection add(number)
	 * 		end if
	 * end for
	 * 
	 * int[] result <- new int[intersection size]
	 * int index <- 0
	 * 
	 * for number in intersection
	 * 		result[index] <- number
	 * 		index++
	 * end for
	 * 
	 * return result
	 * */
	public int[] intersect_2(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) { return intersect(nums2, nums1); }
		
		Arrays.sort(nums1);																							// T : O(n log n)
		
		List<Integer> sorted = new ArrayList<>();																	// S : O(n)
		for (int num1 : nums1) { sorted.add(num1); }																// T : O(n)
		
		List<Integer> intersection = new ArrayList<>();																// S : O(p)
		
		for (int num : nums2) {																						// T : O(m)
			int index = binarySearch_1(sorted, num);																// T : O(log n)
			
			if (index != -1) {
				sorted.remove(index);																				// T : O(n)
				intersection.add(num);																				// T : O(1)
			}
		}
		
		int[] result = new int[intersection.size()];																// S : O(p)
		int index = 0;
		for (int num : intersection) { result[index++] = num; }														// T : O(p)
		
		return result;
	}
	
	/**
	 * int start <- 0
	 * int end <- 0
	 * 
	 * while start is lower than or equal to end
	 * 		int mid <- start plus (end minus start) divide two
	 * 		int pivot <- sorted get(mid)
	 * 		
	 * 		if target is equal to pivot
	 * 			return mid
	 * 		else if target is greater than pivot
	 * 			start <- mid plus one
	 * 		else
	 * 			end <- mid minus one
	 * 		end if
	 * end while
	 * 
	 * return minus one
	 * */
	public int binarySearch_1(List<Integer> sorted, int target) {
		int start = 0;
		int end = sorted.size() - 1;																				// T : O(1)
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int pivot = sorted.get(mid);																			// T : O(1)
			
			if (target == pivot) {
				return mid;
			} else if (target > pivot) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n log m)
	 * space : O(p)
	 * 
	 * if nums1 length is greater than nums2 length
	 * 		return intersect(nums2, nums1)
	 * end if
	 * 
	 * Arrays sort(nums1)
	 * Arrays sort(nums2)
	 * 
	 * int lowerBound <- 0
	 * List<Integer> intersection <- new ArrayList
	 * 
	 * for int number in nums1
	 * 		int index <- binarySearch(nums2, lowerBound, number)
	 * 		
	 * 		if index is greater than or equal to zero && index is lower than nums2 length && nums2[index] is equal to number
	 * 			intersection add(number)
	 * 			lowerBound <- index plus one
	 * 		end if
	 * end for
	 * 
	 * int[] result <- new int[intersection size]
	 * int index <- 0
	 * 
	 * for number in intersection
	 * 		result[index] <- number
	 * 		index++
	 * end for
	 * 
	 * return result
	 * */
	public int[] intersect_3(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) { return intersect(nums2, nums1); }
		
		Arrays.sort(nums1);																							// T : O(n log n)
		Arrays.sort(nums2);																							// T : O(m log m)
		
		int lowerBound = 0;
		List<Integer> intersection = new ArrayList<>();																// S : O(p)
		
		for (int num : nums1) {																						// T : O(n)
			int index = binarySearch(nums2, lowerBound, num);														// T : O(log m)
			
			if (index >= 0 && index < nums2.length && nums2[index] == num) {
				intersection.add(num);																				// T : O(1)
				lowerBound = index + 1;
			}
		}
		
		int[] result = new int[intersection.size()];																// S : O(p)
		int index = 0;
		for (int num : intersection) { result[index++] = num; }														// T : O(p)
		
		return result;
	}
	
	/**
	 * int start <- lowerBound
	 * int end <- array length minus one
	 * 
	 * while start is lower than or equal to end
	 * 		int mid <- start plus (end minus start) divide two
	 * 		int pivot <- array[mid]
	 * 		
	 * 		if target is greater than pivot
	 * 			start <- mid plus one
	 * 		else
	 * 			end <- mid minus one
	 * 		end if
	 * end while
	 * 
	 * return start
	 * */
	public int binarySearch(int[] arr, int lowerBound, int target) {
		int start = lowerBound;
		int end = arr.length - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int pivot = arr[mid];
			
			if (target > pivot) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return start;
	}
	
	/**
	 * time  : O(n + m)
	 * space : O(n)
	 * 
	 * if nums1 length is greater than nums2 length
	 * 		return intersect(nums2, nums1)
	 * end if
	 * 
	 * List<Integer> intersection <- new ArrayList
	 * Map<Integer, Integer> memo <- new HashMap
	 * 
	 * for int number in nums1
	 * 		if memo containsKey(number)
	 * 			memo put(number, memo get(number) plus one)
	 * 			continue
	 * 		end if
	 * 		
	 * 		memo put(number, one)
	 * end for
	 * 
	 * for int number in nums2
	 * 		if memo does not containsKey(number)
	 * 			continue
	 * 		end if
	 * 		
	 * 		int count <- memo get(number)
	 * 		if count is lower than one
	 * 			continue
	 * 		end if
	 * 		
	 * 		memo put(number, count minus one)
	 * 		intersection add(number)
	 * end for
	 * 
	 * int[] result <- new int[intersection size]
	 * int index <- 0
	 * 
	 * for number in intersection
	 * 		result[index] <- number
	 * 		index++
	 * end for
	 * 
	 * return result
	 * */
	public int[] intersect_4(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) { return intersect(nums2, nums1); }
		
		List<Integer> intersection = new ArrayList<>();																// S : O(p)
		Map<Integer, Integer> memo = new HashMap<>();																// S : O(n)
		
		for (int num1 : nums1) {																					// T : O(n)
			if (memo.containsKey(num1)) {																			// T : O(1)
				memo.put(num1, memo.get(num1) + 1);																	// T : O(1)
				continue;
			}
			memo.put(num1, 1);																						// T : O(1)
		}
		
		for (int num2 : nums2) {																					// T : O(m)
			if (!memo.containsKey(num2)) { continue; }																// T : O(1)
			
			int count = memo.get(num2);																				// T : O(1)
			if (count < 1) { continue; }
			
			memo.put(num2, count - 1);																				// T : O(1)
			intersection.add(num2);																					// T : O(1)
		}
		
		int[] result = new int[intersection.size()];																// S : O(p)
		int index = 0;
		for (int num : intersection) { result[index++] = num; }														// T : O(p)
		
		return result;
	}
	
	/**
	 * time  : O(n + m)
	 * space : O(p)
	 * 
	 * int[] memo <- new int[1001]
	 * List<Integer> intersection <- new ArrayList
	 * 
	 * for int number in nums1
	 * 		memo[number] <- memo[number] plus one
	 * end for
	 * 
	 * for int number in nums2
	 * 		if memo[number] is equal to zero
	 * 			continue
	 * 		end if
	 * 		
	 * 		intersection add(number)
	 * 		memo[number] <- memo[number] minus one
	 * end for
	 * 
	 * int[] result <- new int[intersection size]
	 * int index <- 0
	 * 
	 * for number in intersection
	 * 		result[index] <- number
	 * 		index++
	 * end for
	 * 
	 * return result
	 * */
	public int[] intersect(int[] nums1, int[] nums2) {
		int[] memo = new int[1001];																					// S : O(1001)
		List<Integer> intersection = new ArrayList<>();																// S : O(p)
		
		for (int num1 : nums1) { memo[num1]++; }																	// T : O(n)
		
		for (int num2 : nums2) {																					// T : O(m)
			if (memo[num2] == 0) { continue; }
			
			intersection.add(num2);																					// T : O(1)
			memo[num2]--;
		}
		
		int[] result = new int[intersection.size()];																// S : O(p)
		int index = 0;
		for (int num : intersection) { result[index++] = num; }														// T : O(p)
		
		return result;
	}
	
}
