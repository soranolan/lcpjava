package com.example.lcpjava.array;

public class Lcp_838_Push_Dominoes {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public String pushDominoes(String dominoes) {
		int n = dominoes.length();
		if (n < 2) { return dominoes; }
		
		char[] arr = dominoes.toCharArray();																		// S : O(n)
		int current = 0;
		
		while (current < n) {
			if (arr[current] == '.') {
				current++;
			} else if (arr[current] == 'L') {
				int running = current - 1;
				
				// move backward (left) and change to L, e.g., ...L
				while (running >= 0 && arr[running] == '.') { arr[running--] = 'L'; }
				
				current++;
			} else {
				int running = current + 1;
				
				// move forward (right) and seek for L or R
				while (running < n && arr[running] == '.') { running++; }
				
				// if is L, fall to the middle, e.g., R...L
				if (running < n && arr[running] == 'L') {
					int left = current + 1;
					int right = running - 1;
					
					while (left < right) {
						arr[left] = 'R';
						arr[right] = 'L';
						left++;
						right--;
					}
					
					current = running + 1;
				} else {
					while (current < running) { arr[current++] = 'R'; }
				}
			}
		}
		
		return new String(arr);
	}
	
}
