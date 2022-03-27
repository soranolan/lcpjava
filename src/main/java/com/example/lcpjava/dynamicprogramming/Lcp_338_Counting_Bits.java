package com.example.lcpjava.dynamicprogramming;

public class Lcp_338_Counting_Bits {
	
	/**
	 * time  : O(n * m)
	 * space : O(n)
	 * 
	 * int[] result <- new int[n plus one]
	 * 
	 * for int i <- 0; if i is lower than or equal to n; i++
	 * 		String binary <- Integer to binary String(i)
	 * 		int count <- getCount(binary)
	 * 		result[i] <- count
	 * end for
	 * 
	 * return result
	 * */
	public int[] countBits_1(int n) {
		int[] result = new int[n + 1];																				// S : O(n + 1)
		
		for (int i = 0; i <= n; i++) {																				// T : O(n)
			String binary = Integer.toBinaryString(i);																// S : O(n)
			int count = getCount(binary);
			result[i] = count;
		}
		
		return result;
	}
	
	/**
	 * int count <- 0
	 * 
	 * for int i <- 0; if i is lower than binary length; i++
	 * 		if binary charAt(i) is equal to '1'
	 * 			count++
	 * 		end if
	 * end for
	 * 
	 * return count
	 * */
	public int getCount(String binary) {
		int count = 0;
		
		for (int i = 0; i < binary.length(); i++) {																	// T : O(17)
			if (binary.charAt(i) == '1') {
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * time  : O(n log m)
	 * space : O(n)
	 * 
	 * int[] result <- new int[n plus one]
	 * 
	 * for int i <- 1; if i is lower than or equal to n; i++
	 * 		int msb <- mostSignificantBit(i)
	 * 		result[i] <- result[i minus msb] plus one
	 * end for
	 * 
	 * return result
	 * */
	public int[] countBits_2(int n) {
		int[] result = new int[n + 1];																				// S : O(n + 1)
		
		for (int i = 1; i <= n; i++) {																				// T : O(n)
			int msb = mostSignificantBit(i);
			result[i] = result[i - msb] + 1;
		}
		
		return result;
	}
	
	/**
	 * int count <- 0
	 * 
	 * while number <- number right shift one bit is greater than zero
	 * 		count++
	 * end while
	 * 
	 * return one left shift count bit
	 * */
	public int mostSignificantBit(int number) {
		int count = 0;
		
		while ((number >>= 1) > 0) {																				// T : O(log m)
			count++;
		}
		
		return 1 << count;
	}
	
	/**
	 * https://leetcode.com/problems/counting-bits/discuss/79557/How-we-handle-this-question-on-interview-Thinking-process-%2B-DP-solution
	 * 
	 * index	00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15
	 * count	 0  1  1  2  1  2  2  3  1  2  2  3  2  3  3  4
	 * 
	 * dp[0] = 0
	 * 
	 * dp[1] = dp[1-1] + 1
	 * 
	 * dp[2] = dp[2-2] + 1
	 * dp[3] = dp[3-2] + 1
	 * 
	 * dp[4] = dp[4-4] + 1
	 * dp[5] = dp[5-4] + 1
	 * dp[6] = dp[6-4] + 1
	 * dp[7] = dp[7-4] + 1
	 * 
	 * dp[8] = dp[8-8] + 1
	 * */
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int[] result <- new int[n plus one]
	 * int offset <- 1
	 * 
	 * for int i <- 1; if i is lower than or equal to n; i++
	 * 		if offset times two is equal to i
	 * 			offset <- offset times two
	 * 		end if
	 * 		
	 * 		result[i] <- result[i minus offset] plus one
	 * end for
	 * 
	 * return result
	 * */
	public int[] countBits_3(int n) {
		int[] result = new int[n + 1];																				// S : O(n)
		int offset = 1;
		
		for (int i = 1; i <= n; i++) {																				// T : O(n)
			if (offset * 2 == i) { offset *= 2; }
			result[i] = result[i - offset] + 1;
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int[] result <- new int[n plus one]
	 * 
	 * int[] mask <- first 16 result
	 * 
	 * for int i <- 0; if i is lower than or equal to n; i++
	 * 		int number <- i
	 * 		
	 * 		while number is greater than zero
	 * 			result[i] <- result[i] plus mask[number last four bits]
	 * 			number right shift four bits
	 * 		end while
	 * end for
	 * 
	 * return result
	 * */
	public int[] countBits(int n) {
		int[] result = new int[n + 1];																				// S : O(n + 1)
		
		int[] mask = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };											// S : O(16)
		
		for (int i = 0; i <= n; i++) {																				// T : O(n)
			int number = i;
			
			while (number > 0) {																					// T : O(5)
				result[i] += mask[number & 0x0F];
				number >>= 4;
			}
		}
		
		return result;
	}
	
}
