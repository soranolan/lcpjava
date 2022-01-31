package com.example.lcpjava.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Lcp_1394_Find_Lucky_Integer_in_an_Array {
	
	/**
	 * time  : O(n + m)
	 * space : O(m)
	 * 
	 * Map<Integer, Integer> memo <- new HashMap
	 * 
	 * for int number in array
	 * 		int count <- memo getOrDefault(number, zero) plus one
	 * 		memo put(number, count)
	 * end for
	 * 
	 * int lucky <- minus one
	 * 
	 * for int number in memo keySet()
	 * 		int count <- memo get(number)
	 * 		
	 * 		if number is not equal to count
	 * 			continue
	 * 		end if
	 * 		
	 * 		if number is greater than lucky
	 * 			lucky <- number
	 * 		end if
	 * end for
	 * 
	 * return number
	 * */
	public int findLucky_1(int[] arr) {
		Map<Integer, Integer> memo = new HashMap<>();																// S : O(m)
		
		for (int num : arr) {																						// T : O(n)
			int count = memo.getOrDefault(num, 0) + 1;																// T : O(1)
			memo.put(num, count);																					// T : O(1)
		}
		
		int lucky = -1;
		
		for (int num : memo.keySet()) {																				// T : O(m)
			int count = memo.get(num);																				// T : O(1)
			if (num != count) { continue; }
			if (num > lucky) { lucky = num; }
		}
		
		return lucky;
	}
	
	/**
	 * time  : O(n)
	 * space : O(501)
	 * 
	 * Prefer this one
	 * 
	 * int[] bucket <- new int[501]
	 * 
	 * for int number in array
	 * 		bucket[number]++
	 * end for
	 * 
	 * for int i <- 500; if i is greater than zero; i--
	 * 		if i is equal to bucket[i]
	 * 			return i
	 * 		end if
	 * end for
	 * 
	 * return minus one
	 * */
	public int findLucky_2(int[] arr) {
		int[] bucket = new int[500 + 1];																			// S : O(501)
		
		for (int num : arr) { bucket[num]++; }																		// T : O(n)
		
		for (int i = 500; i > 0; i--) {																				// T : O(500)
			if (i == bucket[i]) { return i; }
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * warning : will change the input array
	 * 
	 * 
	 * for int number in array
	 * 		number <- number & HEX(FFFF)
	 * 		
	 * 		if number is lower than or equal to array length
	 * 			array[number minus one] <- array[number minus one] plus HEX(10000)
	 * 		end if
	 * end for
	 * 
	 * for int i <- array length; if i is greater than zero; i--
	 * 		if (array[i minus one] >> 16) is equal to i
	 * 			return i
	 * 		end if
	 * end for
	 * 
	 * return minus one
	 * */
	public int findLucky(int[] arr) {
		for (int num : arr) {																						// T : O(n)
			num &= 0xFFFF;																							// why?
			if (num <= arr.length) { arr[num - 1] += 0x10000; }
		}
		
		for (int i = arr.length; i > 0; i--) {																		// T : O(n)
			if ((arr[i - 1] >> 16) == i) { return i; }
		}
		
		return -1;
	}
	
}
