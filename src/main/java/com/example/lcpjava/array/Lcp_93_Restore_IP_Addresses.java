package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_93_Restore_IP_Addresses {
	
	/**
	 * time  : O((m ^ n) * n)
	 * space : O(m * n)
	 * 
	 * https://leetcode.com/problems/restore-ip-addresses/solutions/30949/my-code-in-java/comments/250284
	 * Accepted Solutions Runtime Distribution
	 * https://leetcode.com/problems/restore-ip-addresses/solutions/2868540/restore-ip-addresses/
	 * */
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int m = 0;
		int n = 0;
		
		backtrack(m, n, sb, s, result);
		
		return result;
	}
	
	private void backtrack(int index, int partition, StringBuilder sb, String s, List<String> result) {
		int n = s.length();
		
		if (index > n || partition > 4) { return; }
		if (index == n && partition == 4) {
			result.add(sb.toString());
			return;
		}
		
		for (int range = 1; range <= 3; range++) {																	// T : O(m)
			if (index + range > n) { break; }
			
			int address = Integer.valueOf(s.substring(index, index + range));										// T : O(m)
			
			if (range == 1 || (s.charAt(index) != '0' && (range < 3 || address <= 255))) {
				sb.append(address);
				
				if (partition < 3) { sb.append("."); }
				
				backtrack(index + range, partition + 1, sb, s, result);
				
				// remove dot
				if (partition < 3) { sb.deleteCharAt(sb.length() - 1); }
				
				// remove address
				sb.delete(sb.length() - range, sb.length());
			}
		}
	}
	
}
