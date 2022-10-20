package com.example.lcpjava.array;

public class Lcp_12_Integer_to_Roman {
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public String intToRoman_1(int num) {
		StringBuilder sb = new StringBuilder();
		
		if (num >= 1000) {
			compute(num / 1000, "M", "", "", sb);
			num %= 1000;
		}
		
		if (num >= 100) {
			compute(num / 100, "C", "D", "M", sb);
			num %= 100;
		}
		
		if (num >= 10) {
			compute(num / 10, "X", "L", "C", sb);
			num %= 10;
		}
		
		if (num >= 1) {
			compute(num, "I", "V", "X", sb);
		}
		
		return sb.toString();
	}
	
	private void compute(int digit, String lower, String mid, String upper, StringBuilder sb) {
		if (digit == 9) {
			sb.append(lower).append(upper);
		} else if (digit == 8) {
			sb.append(mid).append(lower).append(lower).append(lower);
		} else if (digit == 7) {
			sb.append(mid).append(lower).append(lower);
		} else if (digit == 6) {
			sb.append(mid).append(lower);
		} else if (digit == 5) {
			sb.append(mid);
		} else if (digit == 4) {
			sb.append(lower).append(mid);
		} else if (digit == 3) {
			sb.append(lower).append(lower).append(lower);
		} else if (digit == 2) {
			sb.append(lower).append(lower);
		} else {
			sb.append(lower);
		}
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/integer-to-roman/discuss/6310/My-java-solution-easy-to-understand
	 * */
	public String intToRoman(int num) {
		String[] symbols = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };	// S : O(13)
		int[] values = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };							// S : O(13)
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < values.length && num > 0; i++) {														// T : O(13)
			while (num >= values[i]) {																				// T : O(3)
				sb.append(symbols[i]);
				num -= values[i];
			}
		}
		
		return sb.toString();
	}
	
}
