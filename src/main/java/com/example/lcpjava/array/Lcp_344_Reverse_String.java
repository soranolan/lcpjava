package com.example.lcpjava.array;

public class Lcp_344_Reverse_String {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int left <- 0
	 * int right <- array length
	 * 
	 * while left is lower than right
	 * 		char temp <- array[left]
	 * 		array[left] <- array[right minus one]
	 * 		array[right minus one] <- temp
	 * 		left++
	 * 		right--
	 * end while
	 * */
	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length;
		while (left < right) {																						// T : O(n)
			char temp = s[left];
			s[left] = s[right - 1];
			s[right - 1] = temp;
			left++;
			right--;
		}
		
		for (char c : s) { System.out.print(c + " "); }
		System.out.println();
	}
	
}
