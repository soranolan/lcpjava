package com.example.lcpjava.array;

public class Lcp_1299_Replace_Elements_with_Greatest_Element_on_Right_Side {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int max <- -1
	 * int length <- array length
	 * 
	 * for int i <- length minus one; if i is greater than or equal to zero; i--
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
	
}
