package com.example.lcpjava.array;

public class Lcp_383_Ransom_Note {
	
	/**
	 * time  : O(n)
	 * space : O(52)
	 * */
	public boolean canConstruct_1(String ransomNote, String magazine) {
		int[] ransom = new int[26];																					// S : O(26)
		for (int i = 0; i < ransomNote.length(); i++) {																// T : O(n)
			ransom[ransomNote.charAt(i) - 'a']++;
		}
		
		int[] maga = new int[26];																					// S : O(26)
		for (int i = 0; i < magazine.length(); i++) {																// T : O(n)
			maga[magazine.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < 26; i++) {																				// T : O(26)
			if (ransom[i] > maga[i]) { return false; }
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(26)
	 * */
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] maga = new int[26];																					// S : O(26)
		for (int i = 0; i < magazine.length(); i++) {																// T : O(n)
			maga[magazine.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < ransomNote.length(); i++) {																// T : O(n)
			maga[ransomNote.charAt(i) - 'a']--;
			
			if (maga[ransomNote.charAt(i) - 'a'] < 0) { return false; }
		}
		
		return true;
	}
	
}
