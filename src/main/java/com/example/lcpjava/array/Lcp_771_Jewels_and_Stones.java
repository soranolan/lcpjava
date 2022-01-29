package com.example.lcpjava.array;

import java.util.HashSet;
import java.util.Set;

public class Lcp_771_Jewels_and_Stones {
	
	/**
	 * time  : O(n * m)
	 * space : O(n + m)
	 * 
	 * int sum <- 0
	 * 
	 * for char jewel in jewels to char array
	 * 		for char stone in stones to char array
	 * 			if jewel is equal to stone
	 * 				sum++
	 * 			end if
	 * 		end for
	 * end for
	 * 
	 * return sum
	 * */
	public int numJewelsInStones_1(String jewels, String stones) {
		int sum = 0;
		
		for (char jewel : jewels.toCharArray()) {																	// T : O(n)
			for (char stone : stones.toCharArray()) {																// T : O(m)
				if (jewel == stone) { sum++; }
			}
		}
		
		return sum;
	}
	
	/**
	 * time  : O(n + m)
	 * space : O(n + m)
	 * 
	 * int sum <- 0
	 * Set<Character> jewelSet <- new HashSet
	 * 
	 * for char jewel in jewels to char array
	 * 		jewelSet add(jewel)
	 * end for
	 * 
	 * for char stone in stones to char array
	 * 		if jewelSet contains(stone)
	 * 			sum++
	 * 		end if
	 * end for
	 * 
	 * return sum
	 * */
	public int numJewelsInStones_2(String jewels, String stones) {
		int sum = 0;
		Set<Character> jewelSet = new HashSet<>();																	// S : O(n)
		
		for (char jewel : jewels.toCharArray()) { jewelSet.add(jewel); }											// T : O(n)
		
		for (char stone : stones.toCharArray()) {																	// T : O(m)
			if (jewelSet.contains(stone)) { sum++; }																// T : O(1)
		}
		
		return sum;
	}
	
	/**
	 * time  : O(n + m)
	 * space : O(n + m)
	 * 
	 * int sum <- 0
	 * boolean[] bucket <- new boolean['z' minus 'A' plus one]
	 * 
	 * for char jewel in jewels to char array
	 * 		bucket[jewel minus 'A'] <- true
	 * end for
	 * 
	 * for char stone in stones to char array
	 * 		if bucket[stone minus 'A'] is true
	 * 			sum++
	 * 		end if
	 * end for
	 * 
	 * return sum
	 * */
	public int numJewelsInStones_3(String jewels, String stones) {
		int sum = 0;
		boolean[] bucket = new boolean[122 - 65 + 1];																// S : O(58)
		
		for (char jewel : jewels.toCharArray()) { bucket[jewel - 'A'] = true; }										// T : O(n)
		
		for (char stone : stones.toCharArray()) {																	// T : O(m)
			if (bucket[stone - 'A']) { sum++; }
		}
		
		return sum;
	}
	
	/**
	 * time  : O(n + m)
	 * space : O(n + m)
	 * 
	 * int sum <- 0
	 * long bucket <- 0L
	 * 
	 * for char jewel in jewels to char array
	 * 		int value <- jewel minus 'A'
	 * 		long bits <- 1L << value
	 * 		bucket <- bucket | bits
	 * end for
	 * 
	 * for char stone in stones to char array
	 * 		int value <- stone minus 'A'
	 * 		long bits <- 1L << value
	 * 		
	 * 		if (bucket & bits) is not equal to zero
	 * 			sum++
	 * 		end if
	 * end for
	 * 
	 * return sum
	 * */
	public int numJewelsInStones(String jewels, String stones) {
		int sum = 0;
		long bucket = 0L;
		
		for (char jewel : jewels.toCharArray()) {																	// T : O(n)
			int value = jewel - 'A';
			long bits = 1L << value;
			bucket |= bits;
		}
		
		for (char stone : stones.toCharArray()) {																	// T : O(m)
			int value = stone - 'A';
			long bits = 1L << value;
			if ((bucket & bits) != 0) { sum++; }
		}
		
		return sum;
	}
	
}
