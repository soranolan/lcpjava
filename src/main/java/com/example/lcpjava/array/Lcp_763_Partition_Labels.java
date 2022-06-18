package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_763_Partition_Labels {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public List<Integer> partitionLabels(String s) {
		// last appearance of each character
		int[] last = new int[26];																					// S : O(26)
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			last[s.charAt(i) - 'a'] = i;
		}
		
		List<Integer> result = new ArrayList<>();
		int partitionStart = 0;
		int partitionEnd = 0;
		
		for (int i = 0; i < s.length(); i++) {																		// T : O(n)
			partitionEnd = Math.max(partitionEnd, last[s.charAt(i) - 'a']);
			
			if (i == partitionEnd) {
				result.add(partitionEnd - partitionStart + 1);
				partitionStart = partitionEnd + 1;
			}
		}
		
		return result;
	}
	
}
