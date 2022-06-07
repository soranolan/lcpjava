package com.example.lcpjava.array;

public class Lcp_88_Merge_Sorted_Array {
	
	/**
	 * time  : O(m + n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/merge-sorted-array/discuss/29522/This-is-my-AC-code-may-help-you
	 * */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int n1Right = m - 1;
		int n2Right = n - 1;
		int mergeRight = m + n - 1;
		
		while (n1Right >= 0 && n2Right >= 0) {																		// T : O(m + n)
			if (nums1[n1Right] < nums2[n2Right]) {
				nums1[mergeRight] = nums2[n2Right];
				n2Right--;
			} else {
				nums1[mergeRight] = nums1[n1Right];
				n1Right--;
			}
			mergeRight--;
		}
		
		while (n2Right >= 0) {																						// T : O(n)
			nums1[mergeRight] = nums2[n2Right];
			n2Right--;
			mergeRight--;
		}
	}
	
}
