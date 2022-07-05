package com.example.lcpjava.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.example.lcpjava.common.UnionFind;

public class Lcp_128_Longest_Consecutive_Sequence {
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * You must write an algorithm that runs in O(n) time.
	 * */
	public int longestConsecutive_1(int[] nums) {
		if (nums.length == 0) { return 0; }
		
		TreeSet<Integer> set = new TreeSet<>();																		// S : O(n)
		
		for (int num : nums) {																						// T : O(n)
			set.add(num);																							// T : O(log n)
		}
		
		int length = 0;
		int tempLength = 0;
		int previous = Integer.MIN_VALUE;
		
		for (int num : set) {																						// T : O(n)
			if (previous + 1 == num) {
				tempLength++;
			} else {
				length = Math.max(length, tempLength);
				tempLength = 0;
			}
			
			previous = num;
		}
		
		length = Math.max(length, tempLength);
		
		return length + 1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/longest-consecutive-sequence/discuss/166544/Union-Find-Thinking-Process
	 * */
	public int longestConsecutive_2(int[] nums) {
		UnionFind uf = new UnionFind(nums.length);																	// S : O(n)
		Map<Integer, Integer> num2Index = new HashMap<>();															// S : O(n * 2)
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			if (num2Index.containsKey(nums[i])) { continue; }														// T : O(1)
			
			if (num2Index.containsKey(nums[i] - 1)) {																// T : O(1)
				uf.union(i, num2Index.get(nums[i] - 1));															// T : O(α(n))
			}
			
			if (num2Index.containsKey(nums[i] + 1)) {																// T : O(1)
				uf.union(i, num2Index.get(nums[i] + 1));															// T : O(α(n))
			}
			
			num2Index.put(nums[i], i);																				// T : O(1)
		}
		
		int length = 0;
		int[] bucket = new int[nums.length];																		// S : O(n)
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			int root = uf.find(i);																					// T : O(α(n))
			bucket[root]++;
			length = Math.max(length, bucket[root]);
		}
		
		return length;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
	 * */
	public int longestConsecutive_3(int[] nums) {
		int length = 0;
		Map<Integer, Integer> num2Length = new HashMap<>();															// S : O(n * 2)
		
		for (int num : nums) {																						// T : O(n)
			if (!num2Length.containsKey(num)) {																		// T : O(1)
				int left = num2Length.getOrDefault(num - 1, 0);														// T : O(1)
				int right = num2Length.getOrDefault(num + 1, 0);													// T : O(1)
				
				int tempLength = left + right + 1;
				num2Length.put(num, tempLength);																	// T : O(1)
				
				length = Math.max(tempLength, length);
				
				num2Length.put(num - left, tempLength);																// T : O(1)
				num2Length.put(num + right, tempLength);															// T : O(1)
			}
		}
		
		return length;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public int longestConsecutive(int[] nums) {
		int length = 0;
		
		Set<Integer> set = new HashSet<Integer>();																	// S : O(n)
		for (int num : nums) {																						// T : O(n)
			set.add(num);																							// T : O(1)
		}
		
		for (int num : set) {																						// T : O(n)
			if (!set.contains(num - 1)) {																			// T : O(1)
				int currentNum = num;
				int tempLength = 1;
				
				while (set.contains(currentNum + 1)) {																// T : O(1)
					currentNum++;
					tempLength++;
				}
				
				length = Math.max(length, tempLength);
			}
		}
		
		return length;
	}
	
}
