package com.example.lcpjava.array;

public class Lcp_1089_Duplicate_Zeros {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int length <- arr.length
	 * int zeroCounts <- 0
	 * 
	 * for number in array
	 * 		if number is zero
	 * 			zeroCounts++
	 * 		end if
	 * end for
	 * 
	 * int left <- length - 1
	 * int right <- length + zeroCounts - 1
	 * 
	 * while left not equal right
	 * 		if right is lower than length
	 * 			right <-> left
	 * 		end if
	 * 		right--
	 * 		if left is zero
	 * 			if right is lower than length
	 * 				right <-> left
	 * 			end if
	 * 			right--
	 * 		end if
	 * 		left--
	 * end while
	 * */
	public void duplicateZeros(int[] arr) {
		int length = arr.length;
		int zeroCounts = 0;
		for (int i = 0; i < length; i++) {
			if (arr[i] == 0) { zeroCounts++; }
		}
		int left = length - 1;
		int right = length + zeroCounts - 1;
		
		while (left != right) {
			assign(left, right, length, arr);
			right--;
			if (arr[left] == 0) {
				assign(left, right, length, arr);
				right--;
			}
			left--;
		}
		
		for (int num : arr) { System.out.print(num + " "); }
		System.out.println();
	}
	
	private void assign(int left, int right, int length, int[] arr) {
		if (right < length) { arr[right] = arr[left]; }
	}
	
	public static void main(String[] args) {
		Lcp_1089_Duplicate_Zeros lcp = new Lcp_1089_Duplicate_Zeros();
		
		// 1 0 0 2 3 0 0 4
		int[] input = { 1, 0, 2, 3, 0, 4, 5, 0 };
		lcp.duplicateZeros(input);
		
		// 1 2 3
		input = new int[] { 1, 2, 3 };
		lcp.duplicateZeros(input);
		
		// 0 0 0 0 0 0 0
		input = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		lcp.duplicateZeros(input);
	}
	
}
