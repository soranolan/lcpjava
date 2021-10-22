package com.example.lcpjava.array;

public class Lcp_88_Merge_Sorted_Array {
	
	/**
	 * time  : O(m + n)
	 * space : O(1)
	 * 
	 * int n1Right <- m minus one
	 * int n2Right <- n minus one
	 * int mergeRight <- m plus n minus one
	 * 
	 * while n1Right greater than and equal to zero && n2Right greater than and equal to zero
	 * 		if nums1[n1Right] lower than nums2[n2Right]
	 * 			nums1[mergeRight] <- nums2[n2Right]
	 * 			n2Right--
	 * 		else
	 * 			nums1[mergeRight] <- nums1[n1Right]
	 * 			n1Right--
	 * 		end if
	 * 		mergeRight--
	 * end while
	 * 
	 * handle nums1 is empty
	 * while n2Right greater than and equal to zero
	 * 		nums1[mergeRight] <- nums2[n2Right]
	 * end while
	 * */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int n1Right = m - 1;
		int n2Right = n - 1;
		int mergeRight = m + n - 1;
		
		while (n1Right >= 0 && n2Right >= 0) {																		// T : O(n)
			if (nums1[n1Right] < nums2[n2Right]) {
				assign(n2Right, mergeRight, nums1, nums2);
				n2Right--;
			} else {
				nums1[mergeRight] = nums1[n1Right];
				n1Right--;
			}
			mergeRight--;
		}
		
		while (n2Right >= 0) {																						// T : O(n)
			assign(n2Right, mergeRight, nums1, nums2);
			n2Right--;
			mergeRight--;
		}
		
		for (int num : nums1) { System.out.print(num + " "); }
		System.out.println();
	}
	
	private void assign(int n2Right, int mergeRight, int[] nums1, int[] nums2) {
		nums1[mergeRight] = nums2[n2Right];
	}
	
}
