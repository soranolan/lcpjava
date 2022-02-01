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
	 * stack								|		heap						
	 * int[] arr			s_0x0001		|		arr[0] = 2			h_0x0001
	 * 										|									
	 * 										|		arr[1] = 2			h_0x0002
	 * 										|		arr[1] = 65538		h_0x0002
	 * 										|									
	 * 										|		arr[2] = 3			h_0x0003
	 * 										|		arr[3] = 4			h_0x0004
	 * int num = 2			s_0x0002		|									
	 * int num = 65538		s_0x0002		|									
	 * 
	 * for int number in array
	 * 		number <- number & HEX(FFFF)
	 * 		
	 * 		if number is lower than or equal to array length
	 * 			array[number minus one] <- array[number minus one] plus HEX(10000)
	 * 		end if
	 * end for
	 * 
	 * for int i <- array length minus one; if i is greater than or equal to zero; i--
	 * 		if (array[i] right shift 16 bit) is equal to (i plus one)
	 * 			return i plus one
	 * 		end if
	 * end for
	 * 
	 * return minus one
	 * */
	public int findLucky(int[] arr) {
		for (int i = 0; i < arr.length; i++) {																		// T : O(n)
			int num = arr[i];
			num &= 0xFFFF;																							// reset stack value
			if (num <= arr.length) { arr[num - 1] += 0x10000; }
		}
		
		for (int i = arr.length - 1; i >= 0; i--) {																	// T : O(n)
			if ((arr[i] >> 16) == (i + 1)) { return (i + 1); }
		}
		
		return -1;
	}
	
}
