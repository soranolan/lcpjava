package com.example.lcpjava.array;

public class Lcp_393_UTF_8_Validation {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Solution Tab
	 * */
	public boolean validUtf8_1(int[] data) {
		int numberOfBytesToProcess = 0;
		int mask1 = 1 << 7;
		int mask2 = 1 << 6;
		
		for (int i = 0; i < data.length; i++) {
			if (numberOfBytesToProcess == 0) {
				int mask = 1 << 7;
				while ((mask & data[i]) != 0) {
					numberOfBytesToProcess++;
					mask >>= 1;
				}
				
				// 0xxx xxxx
				if (numberOfBytesToProcess == 0) { continue; }
				
				// 1111 1000 or 1000 0000
				if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) { return false; }
			} else {
				// 10xx xxxx
				if (!((data[i] & mask1) != 0 && (mask2 & data[i]) == 0)) { return false; }
			}
			
			numberOfBytesToProcess--;
		}
		
		// 4bytes but not full data 4 3 2
		return numberOfBytesToProcess == 0;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/utf-8-validation/discuss/87462/Concise-C%2B%2B-implementation
	 * */
	public boolean validUtf8(int[] data) {
		int numberOfBytesToProcess = 0;
		
		for (int num : data) {
			if (numberOfBytesToProcess == 0) {
				if ((num >> 5) == 0b110) { numberOfBytesToProcess = 1; }
				else if ((num >> 4) == 0b1110) { numberOfBytesToProcess = 2; }
				else if ((num >> 3) == 0b11110) { numberOfBytesToProcess = 3; }
				else if ((num >> 7) == 0b0) { numberOfBytesToProcess = 0; }
				else { return false; }
			} else {
				if ((num >> 6) != 0b10) { return false; }
				numberOfBytesToProcess--;
			}
		}
		
		return numberOfBytesToProcess == 0;
	}
	
}
