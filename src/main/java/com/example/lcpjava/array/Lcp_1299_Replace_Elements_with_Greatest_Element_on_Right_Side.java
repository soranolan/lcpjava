package com.example.lcpjava.array;

public class Lcp_1299_Replace_Elements_with_Greatest_Element_on_Right_Side {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int max <- -1
	 * int length <- array length
	 * 
	 * for int i <- length - 1 to array head
	 * 		int temp <- array[i]
	 * 		array[i] <- max
	 * 		if temp is greater than max
	 * 			max <- temp
	 * 		end if
	 * end for
	 * 
	 * return array
	 * */
	public int[] replaceElements(int[] arr) {
		int max = -1;
		int length = arr.length;
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			int temp = arr[i];
			arr[i] = max;
			if (temp > max) { max = temp; }
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		Lcp_1299_Replace_Elements_with_Greatest_Element_on_Right_Side lcp = new Lcp_1299_Replace_Elements_with_Greatest_Element_on_Right_Side();
		int[] input = null;
		int[] output = null;
		
		// 18 6 6 6 1 -1
		input = new int[] { 17, 18, 5, 4, 6, 1 };
		output = lcp.replaceElements(input);
		for (int num : output) { System.out.print(num + " "); }
		System.out.println();
		
		// -1
		input = new int[] { 400 };
		output = lcp.replaceElements(input);
		for (int num : output) { System.out.print(num + " "); }
		System.out.println();
	}
	
}
