package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.lcpjava.common.Lcp_315_Value2Index;

public class Lcp_315_Count_of_Smaller_Numbers_After_Self {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * 
	 * Time Limit Exceeded
	 * */
	public List<Integer> countSmaller_1(int[] nums) {
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {																		// T : O(n)
			int count = 0;
			
			for (int j = i + 1; j < nums.length; j++) {																// T : O(n - 1)
				if (nums[i] > nums[j]) { count++; }
			}
			
			result.add(count);
		}
		
		return result;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/445769/merge-sort-CLEAR-simple-EXPLANATION-with-EXAMPLES-O(n-lg-n)
	 * https://www.youtube.com/watch?v=e5ik2UGjHBk
	 * https://stackoverflow.com/questions/10342890/merge-sort-time-and-space-complexity
	 * */
	public List<Integer> countSmaller(int[] nums) {
		int length = nums.length;
		int[] count = new int[length];																				// S : O(n)
		
		Lcp_315_Value2Index[] value2IndexArr = new Lcp_315_Value2Index[length];										// S : O(2 * n)
		for (int i = 0; i < length; i++) { value2IndexArr[i] = new Lcp_315_Value2Index(nums[i], i); }				// T : O(n)
		
		mergeSort(value2IndexArr, 0, length - 1, count);
		
		List<Integer> result = new LinkedList<Integer>();
		for (int num : count) { result.add(num); }
		return result;
	}
	
	private void mergeSort(Lcp_315_Value2Index[] value2IndexArr, int start, int end, int[] count) {
		if (start >= end) { return; }
		
		int mid = start + (end - start) / 2;
		
		mergeSort(value2IndexArr, start, mid, count);
		mergeSort(value2IndexArr, mid + 1, end, count);
		merge(value2IndexArr, start, end, count);
	}
	
	private void merge(Lcp_315_Value2Index[] value2IndexArr, int start, int end, int[] count) {
		int mid = start + (end - start) / 2;
		
		int leftSubArrStart = start;
		int rightSubArrStart = mid + 1;
		
		int numElemsRightArrayLessThanLeftArray = 0;
		List<Lcp_315_Value2Index> merged = new LinkedList<>();
		
		while (leftSubArrStart < mid + 1 && rightSubArrStart <= end) {
			// left is greater than right
			if (value2IndexArr[leftSubArrStart].val > value2IndexArr[rightSubArrStart].val) {
				// just count right part, don't update left part result
				numElemsRightArrayLessThanLeftArray++;
				
				// merge
				merged.add(value2IndexArr[rightSubArrStart]);
				
				rightSubArrStart++;
				
			// left is lower than right
			} else {
				// add right part count
				count[value2IndexArr[leftSubArrStart].index] += numElemsRightArrayLessThanLeftArray;
				
				// merge
				merged.add(value2IndexArr[leftSubArrStart]);
				
				leftSubArrStart++;
			}
		}
		
		// if left part is not empty
		while (leftSubArrStart < mid + 1) {
			count[value2IndexArr[leftSubArrStart].index] += numElemsRightArrayLessThanLeftArray;
			merged.add(value2IndexArr[leftSubArrStart]);
			leftSubArrStart++;
		}
		
		// if right part is not empty
		while (rightSubArrStart <= end) {
			merged.add(value2IndexArr[rightSubArrStart]);
			rightSubArrStart++;
		}
		
		// update merge result
		int index = start;
		for (Lcp_315_Value2Index merge : merged) {
			value2IndexArr[index] = merge;
			index++;
		}
	}
	
	/**
	 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code
	 * */
	
}
