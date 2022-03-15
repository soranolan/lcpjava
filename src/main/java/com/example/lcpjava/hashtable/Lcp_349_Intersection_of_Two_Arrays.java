package com.example.lcpjava.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lcp_349_Intersection_of_Two_Arrays {
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * Set<Integer> intersection <- new HashSet
	 * int[] sorted <- null
	 * int[] unsorted <- null
	 * 
	 * if nums1 length is greater than nums2 length
	 * 		Arrays sord(nums2)
	 * 		sorted <- nums2
	 * 		unsorted <- nums1
	 * else
	 * 		Arrays sort(nums1)
	 * 		sorted <- nums1
	 * 		unsorted <- nums2
	 * end if
	 * 
	 * for number in unsorted
	 * 		if binarySearch(number) is true
	 * 			intersection add(number)
	 * 		end if
	 * end for
	 * 
	 * int[] result <- new int[intersection size]
	 * int i <- 0
	 * 
	 * for number in intersection
	 * 		result[i] <- number
	 * 		i++
	 * end for
	 * 
	 * return result
	 * */
	public int[] intersection_1(int[] nums1, int[] nums2) {
		Set<Integer> intersection = new HashSet<>();																// S : O(l)
		int[] sorted = null;																						// S : O(m)
		int[] unsorted = null;																						// S : O(n)
		
		if (nums1.length > nums2.length) {
			Arrays.sort(nums2);																						// T : O(n log n)
			sorted = nums2;
			unsorted = nums1;
		} else {
			Arrays.sort(nums1);																						// T : O(n log n)
			sorted = nums1;
			unsorted = nums2;
		}
		for (int num : unsorted) {																					// T : O(n)
			if (binarySearch(sorted, num)) { intersection.add(num); }
		}
		
		int[] result = new int[intersection.size()];																// S : O(l)
		int i = 0;
		for (Integer num : intersection) { result[i++] = num; }														// T : O(l)
		
		return result;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * Arrays sort(num1)
	 * Arrays sort(num2)
	 * 
	 * Set<Integer> intersection <- new HashSet
	 * 
	 * int left <- 0
	 * int right <- 0
	 * 
	 * while left is lower than nums1 length && right is lower than nums2 length
	 * 		if nums1[left] is equal to nums2[right]
	 * 			intersection add(nums1[left])
	 * 			left++
	 * 			right++
	 * 			continue
	 * 		end if
	 * 		
	 * 		if nums1[left] is lower than nums2[right]
	 * 			left++
	 * 			continue
	 * 		end if
	 * 		
	 * 		if nums1[left] is greater than nums2[right]
	 * 			right++
	 * 			continue
	 * 		end if
	 * end while
	 * 
	 * int[] result <- new int[intersection size]
	 * int i <- 0
	 * 
	 * for number in intersection
	 * 		result[i] <- number
	 * 		i++
	 * end for
	 * 
	 * return result
	 * */
	public int[] intersection_2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);																							// T : O(n log n) 
		Arrays.sort(nums2);																							// T : O(n log n)
		
		Set<Integer> intersection = new HashSet<>();																// S : O(l)
		
		int left = 0;
		int right = 0;
		
		while (left < nums1.length && right < nums2.length) {
			if (nums1[left] < nums2[right]) {
				left++;
				continue;
			}
			if (nums1[left] > nums2[right]) {
				right++;
				continue;
			}
			if (nums1[left] == nums2[right]) {
				intersection.add(nums1[left]);
				left++;
				right++;
				continue;
			}
		}
		
		int[] result = new int[intersection.size()];																// S : O(l)
		int i = 0;
		for (Integer num : intersection) { result[i++] = num; }														// T : O(l)
		
		return result;
	}
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * 
	 * int start <- 0
	 * int end <- sorted length minus one
	 * 
	 * while start is lower than or equal to end
	 * 		int mid <- start plus (end minus start) divided by two
	 * 		int pivot <- sorted[mid]
	 * 		
	 * 		if target is equal to pivot
	 * 			return true
	 * 		end if
	 * 		
	 * 		if target is greater than pivot
	 * 			start <- mid plus one
	 * 		end if
	 * 		
	 * 		if target is lower than pivot
	 * 			end <- mid minus one
	 * 		end if
	 * end while
	 * 
	 * return false
	 * */
	public boolean binarySearch(int[] sorted, int target) {
		int start = 0;
		int end = sorted.length - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int pivot = sorted[mid];
			if (target == pivot) { return true; }
			if (target > pivot) { start = mid + 1; }
			if (target < pivot) { end = mid - 1; }
		}
		
		return false;
	}
	
	/**
	 * time  : O(m + n)
	 * space : O(n)
	 * 
	 * Set<Integer> intersection <- new HashSet
	 * Set<Integer> num1Set <- new HashSet
	 * 
	 * for number in nums1
	 * 		num1Set add(number)
	 * end for
	 * 
	 * for number in nums2
	 * 		if num1Set contains(num2)
	 * 			intersection add(num2)
	 * 		end if
	 * end for
	 * 
	 * int[] result <- new int[intersection size]
	 * int i <- 0
	 * 
	 * for number in intersection
	 * 		result[i] <- number
	 * 		i++
	 * end for
	 * 
	 * return result
	 * */
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> intersection = new HashSet<>();																// S : O(l)
		Set<Integer> num1Set = new HashSet<>();																		// S : O(m)
		for (int num1 : nums1) { num1Set.add(num1); }																// T : O(m)
		for (int num2 : nums2) {																					// T : O(n)
			if (num1Set.contains(num2)) { intersection.add(num2); }
		}
		
		int[] result = new int[intersection.size()];																// S : O(l)
		int i = 0;
		for (Integer num : intersection) { result[i++] = num; }														// T : O(l)
		
		return result;
	}
	
}
