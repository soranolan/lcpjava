package com.example.lcpjava.array;

public class Lcp_831_Masking_Personal_Information {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/masking-personal-information/discuss/1755830/Java-orTwitter-or-Solution-or-String
	 * https://leetcode.com/problems/masking-personal-information/discuss/128955/C%2B%2BJavaPython-Easy-and-Concise
	 * */
	public String maskPII(String s) {
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		int atIndex = findMouse(s);																					// T : O(n)
		boolean isMail = atIndex > -1;
		
		if (isMail) {
			int first = s.charAt(0);
			if (65 <= first && first <= 90) { first += 32; }
			sb.append((char) first);
			
			sb.append("*****");
			
			int last = s.charAt(atIndex - 1);
			if (65 <= last && last <= 90) { last += 32; }
			sb.append((char) last);
			
			for (int i = atIndex; i < s.length(); i++) {															// T : O(n)
				int c = s.charAt(i);
				if (65 <= c && c <= 90) { c += 32; }
				sb.append((char) c);
			}
		} else {
			StringBuilder onlyDigits = new StringBuilder();															// S : O(n)
			String[] countryCode = new String[] { "***-***-", "+*-***-***-", "+**-***-***-", "+***-***-***-" };
			
			for (int i = 0; i < s.length(); i++) {																	// T : O(n)
				char c = s.charAt(i);
				if (Character.isDigit(c)) { onlyDigits.append(c); }
			}
			
			sb.append(countryCode[onlyDigits.length() - 10]);
			
			for (int i = onlyDigits.length() - 4; i < onlyDigits.length(); i++) { sb.append(onlyDigits.charAt(i)); }
		}
		
		return sb.toString();
	}
	
	private int findMouse(String s) {
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			if (s.charAt(i) == '@') { return i; }
		}
		return -1;
	}
	
}
