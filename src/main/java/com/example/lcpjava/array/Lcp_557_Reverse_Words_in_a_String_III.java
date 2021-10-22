package com.example.lcpjava.array;

public class Lcp_557_Reverse_Words_in_a_String_III {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * char[] c <- s to char array
	 * int length <- c length
	 * int left <- 0
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		if c[i] is not equal to space
	 * 			continue
	 * 		end if
	 * 		
	 * 		int right <- i minus one
	 * 		reverse c from left to right
	 * 		left <- i plus one
	 * end for
	 * 
	 * reverse c from left to length minus one
	 * 
	 * return new String c
	 * */
	public String reverseWords(String s) {
		char[] c = s.toCharArray();
		int length = c.length;
		int left = 0;
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			if (c[i] != ' ') { continue; }
			
			int right = i - 1;
			reverse(c, left, right);
			left = i + 1;
		}
		
		reverse(c, left, length - 1);
		
		return new String(c);																						// S : O(n)
	}
	
	/**
	 * while left is lower than right
	 * 		char temp <- c[left]
	 * 		c[left] <- c[right]
	 * 		c[right] <- temp
	 * 		left++
	 * 		right--
	 * 	end while
	 * */
	public void reverse(char[] c, int left, int right) {
		while (left < right) {
			char temp = c[left];
			c[left] = c[right];
			c[right] = temp;
			left++;
			right--;
		}
	}
	
}
