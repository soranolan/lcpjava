package com.example.lcpjava.array;

public class Lcp_1013_Partition_Array_Into_Three_Parts_With_Equal_Sum {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/solutions/260895/java-python-3-two-o-n-time-o-1-space-codes-w-brief-explanation-and-analysis/
	 * */
	public boolean canThreePartsEqualSum_1(int[] arr) {
		// check if array can divide into three parts
		int average = 0;
		for (int num : arr) { average += num; }
		if (average % 3 != 0) { return false; }
		average /= 3;
		
		int count = 0;
		int partition = 0;
		for (int num : arr) {
			partition += num;
			if (partition == average) {
				count++;
				partition = 0;
			}
		}
		
		return count >= 3;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/solutions/260895/java-python-3-two-o-n-time-o-1-space-codes-w-brief-explanation-and-analysis/
	 * */
	public boolean canThreePartsEqualSum(int[] arr) {
		// check if array can divide into three parts
		int average = 0;
		for (int num : arr) { average += num; }
		if (average % 3 != 0) { return false; }
		average /= 3;
		
		int n = arr.length;
		int left = 0;
		int right = n - 1;
		int leftPart = arr[0];
		int rightPart = arr[right];
		
		while (left + 1 < right) {
			if (leftPart == average && rightPart == average) { return true; }
			if (leftPart != average) {
				left++;
				leftPart += arr[left];
			}
			if (rightPart != average) {
				right--;
				rightPart += arr[right];
			}
		}
		
		return false;
	}
	
}
