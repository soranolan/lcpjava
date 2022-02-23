package com.example.lcpjava.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lcp_454_4Sum_II {
	
	/**
	 * time  : O(n ^ 4)
	 * space : O(1)
	 * 
	 * int result <- 0
	 * 
	 * for int i in nums1
	 * 		for int j in nums2
	 * 			for int k in nums3
	 * 				for int l in nums4
	 * 					if i plus j plus k plus l is equal to zero
	 * 						result++
	 * 					end if
	 * 				end for
	 * 			end for
	 * 		end for
	 * end for
	 * 
	 * return result
	 * */
	public int fourSumCount_1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int result = 0;
		
		for (int i : nums1) {																						// T : O(n)
			for (int j : nums2) {																					// T : O(n)
				for (int k : nums3) {																				// T : O(n)
					for (int l : nums4) {																			// T : O(n)
						if (i + j + k + l == 0) { result++; }
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * i + j + k + l = 0
	 * i + j + k = -l
	 * -(i + j + k) = l
	 * */
	/**
	 * time  : O(n ^ 3)
	 * space : O(n)
	 * 
	 * int result <- 0
	 * Map<Integer, Integer> memo <- new HashMap
	 * 
	 * for int number in nums4
	 * 		memo put(number, memo getOrDefault(number, zero) plus one)
	 * end for
	 * 
	 * for int i in nums1
	 * 		for int j in nums2
	 * 			for int k in nums3
	 * 				result <- result plus memo getOrDefault((i plus j plus k) multiply minus one, zero)
	 * 			end for
	 * 		end for
	 * end for
	 * 
	 * return result
	 * */
	public int fourSumCount_2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int result = 0;
		Map<Integer, Integer> memo = new HashMap<>();																// S : O(n)
		
		for (int l : nums4) {																						// T : O(n)
			memo.put(l, memo.getOrDefault(l, 0) + 1);																// T : O(1)
		}
		
		for (int i : nums1) {																						// T : O(n)
			for (int j : nums2) {																					// T : O(n)
				for (int k : nums3) {																				// T : O(n)
					result += memo.getOrDefault((i + j + k) * -1, 0);												// T : O(1)
				}
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n ^ 2)
	 * 
	 * int result <- 0
	 * Map<Integer, Integer> memo <- new HashMap
	 * 
	 * for int k in nums3
	 * 		for int l in nums4
	 * 			int key <- k plus l
	 * 			memo put(key, memo getOrDefault(key, zero) plus one)
	 * 		end for
	 * end for
	 * 
	 * for int i in nums1
	 * 		for int j in nums2
	 * 			result <- result plus memo getOrDefault((i plus j) multiply minus one, zero)
	 * 		end for
	 * end for
	 * 
	 * return result
	 * */
	public int fourSumCount_3(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int result = 0;
		Map<Integer, Integer> memo = new HashMap<>();																// S : O(n ^ 2)
		
		for (int k : nums3) {																						// T : O(n)
			for (int l : nums4) {																					// T : O(n)
				int key = k + l;
				memo.put(key, memo.getOrDefault(key, 0) + 1);														// T : O(1)
			}
		}
		
		for (int i : nums1) {																						// T : O(n)
			for (int j : nums2) {																					// T : O(n)
				result += memo.getOrDefault((i + j) * -1, 0);														// T : O(1)
			}
		}
		
		return result;
	}
	
	/**
	 * k	n3	-32, -31, -31, -31, -31, -29, -28, -28, -27, -27, -27, -27, -27, -26, -26, -26, -25, -25, -25, -24, -24, -23, -22, -22, -21, -20, -20, -18, -18, -18, -16, -16, -15, -15, -15, -14, -14, -14, -14, -13, -13, -13, -12, -12, -12, -10, -10, -10, -9, -9, -9, -9, -8, -7, -7, -6, -6, -5, -5, -5, -5, -3, -3, -3, -2, -2, -2, -2, -2, -1, -1, -1, 0, 0, 0, 0, 0, 0, 1, 3, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10
	 * l	n4	-32, -32, -32, -31, -31, -31, -31, -31, -30, -30, -29, -29, -29, -29, -29, -28, -28, -27, -27, -26, -26, -25, -25, -25, -25, -25, -24, -24, -24, -24, -24, -23, -22, -22, -22, -21, -21, -21, -20, -20, -20, -18, -17, -17, -16, -15, -15, -15, -15, -14, -14, -13, -12, -12, -12, -12, -12, -11, -11, -11, -11, -10, -9, -6, -5, -5, -4, -4, -4, -4, -3, -1, -1, -1, -1, -1, 0, 1, 2, 2, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 9, 9, 10, 10, 10
	 * 
	 * i	n1	-32, -32, -31, -31, -31, -30, -30, -29, -29, -29, -28, -27, -27, -26, -26, -26, -25, -24, -24, -24, -24, -24, -24, -23, -23, -23, -22, -22, -22, -21, -21, -20, -20, -20, -20, -18, -18, -18, -17, -17, -16, -16, -16, -16, -16, -15, -15, -15, -15, -14, -14, -14, -13, -12, -11, -11, -11, -10, -10, -10, -10, -9, -8, -8, -7, -7, -7, -5, -5, -4, -4, -2, -2, -2, -2, -2, -2, -1, 0, 1, 2, 2, 2, 2, 3, 3, 3, 5, 5, 5, 6, 6, 6, 6, 6, 7, 8, 8, 9, 10
	 * j	n2	-32, -32, -31, -31, -30, -29, -28, -28, -28, -26, -26, -25, -25, -24, -24, -24, -24, -24, -23, -22, -22, -22, -21, -20, -20, -20, -19, -18, -18, -18, -18, -18, -17, -15, -15, -15, -15, -14, -13, -13, -13, -13, -12, -12, -10, -10, -10, -10, -10, -9, -9, -9, -9, -9, -8, -8, -8, -7, -7, -6, -6, -6, -5, -5, -5, -5, -4, -4, -4, -3, -2, -2, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 8, 8, 8, 10
	 * 
	 * 		kl vs ij
	 * max	20 vs 64	64
	 * min	-64 vs -20	-64
	 * size 128
	 * */
	/**
	 * k	n3	1, 3, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10
	 * l	n4	2, 2, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 9, 9, 10, 10, 10
	 * 
	 * i	n1	-10, -10, -10, -10, -9, -8, -8, -7, -7, -7, -5, -5, -4, -4, -2, -2, -2, -2, -2, -2, -1
	 * j	n2	-9, -9, -9, -9, -9, -8, -8, -8, -7, -7, -6, -6, -6, -5, -5, -5, -5, -4, -4, -4, -3, -2, -2
	 * 
	 * 		kl vs ij
	 * max	20 vs 19	20
	 * min	3 vs 3		3
	 * size 18
	 * */
	/**
	 * time  : O(n ^ 2)
	 * space : O(max - min)
	 * 
	 * int result <- 0
	 * 
	 * Arrays sort(nums1)
	 * Arrays sort(nums2)
	 * Arrays sort(nums3)
	 * Arrays sort(nums4)
	 * 
	 * int length <- nums1 length
	 * 
	 * int max34 <- nums3[length minus one] plus nums4[length minus one]
	 * int max12 <- minus nums1[0] minus nums2[0]
	 * int max <- Math max(max34, max12)
	 * 
	 * int min34 <- nums3[0] plus nums4[0]
	 * int min12 <- minus nums1[length minus one] minus nums2[length minus one]
	 * int min <- Math min(min34, min12)
	 * 
	 * int[] bucket <- new int[max minus min plus one]
	 * 
	 * for int k in nums3
	 * 		for int l in nums4
	 * 			bucket[k plus l minus min] <- bucket[k plus l minus min] plus one
	 * 		end for
	 * end for
	 * 
	 * for int i in nums1
	 * 		for int j in nums2
	 * 			result <- result plus bucket[(i plus j) multiply minus one minus min]
	 * 		end for
	 * end for
	 * 
	 * return result
	 * */
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int result = 0;
		
		Arrays.sort(nums1);																							// T : O(n log n)
		Arrays.sort(nums2);																							// T : O(n log n)
		Arrays.sort(nums3);																							// T : O(n log n)
		Arrays.sort(nums4);																							// T : O(n log n)
		
		int length = nums1.length;
		
		// Take the maximum of the first two's final elements combined or the last twos first elements combined (since negative smaller values are higher)
		int max34 = nums3[length - 1] + nums4[length - 1];
		int max12 = -nums1[0] - nums2[0];
		int max = Math.max(max34, max12);
		
		// Take the minimum of the first two elements in first two arrays or the last two elements in last two arrays but negated
		int min34 = nums3[0] + nums4[0];
		int min12 = -nums1[length - 1] - nums2[length - 1];
		int min = Math.min(min34, min12);
		
		int[] bucket = new int[max - min + 1];																		// T : O(max - min)
		
		for (int k : nums3) {																						// T : O(n)
			for (int l : nums4) {																					// T : O(n)
				bucket[k + l - min]++;
			}
		}
		
		for (int i : nums1) {																						// T : O(n)
			for (int j : nums2) {																					// T : O(n)
				result += bucket[(i + j) * -1 - min];
			}
		}
		
		return result;
	}
	
}
