package com.example.lcpjava.bitmanipulation;

public class Lcp_191_Number_of_1_Bits {
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * */
	public int hammingWeight_1(int n) {
		int count = 0;
		
		while (n != 0) {																							// T : O(log n)
			if ((n & 1) == 1) { count++; }
			n >>>= 1;																								// >> still signed
		}
		
		return count;
	}
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * */
	public int hammingWeight_2(int n) {
		int count = 0;
		
		while (n != 0) {																							// T : O(log n)
			count += (n & 1);
			n >>>= 1;																								// >> still signed
		}
		
		return count;
	}
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * */
	public int hammingWeight_3(int n) {
		int count = 0;
		
		while (n != 0) {																							// T : O(log n)
			n = n & (n - 1);
			count++;
		}
		
		return count;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * 
	 * Hacker's Delight
	 * 
	 * divide and conquer
	 * 
	 * Integer.bitCount() also uses the same algorithm
	 * 
	 * https://leetcode.com/problems/number-of-1-bits/discuss/55099/Simple-Java-Solution-Bit-Shifting
	 * https://stackoverflow.com/questions/109023/how-to-count-the-number-of-set-bits-in-a-32-bit-integer
	 * https://en.wikipedia.org/wiki/Hamming_weight
	 * 
	 * best for the follow up ?
	 * */
	/**
	 * n = 1057		0000 0000 0000 0000 0000 0100 0010 000,1	<<< input
	 * 1057 >>> 1	0000 0000 0000 0000 0000 0010 0001 0000
	 * &
	 * 0x55			0101 0101 0101 0101 0101 0101 0101 0101
	 * =
	 * 16			0000 0000 0000 0000 0000 0000 0001 0000
	 * 
	 * n = 1041		0000 0000 0000 0000 0000 0100 0001 00,01	<<<
	 * &
	 * 0x33			0011 0011 0011 0011 0011 0011 0011 0011
	 * =
	 * 17			0000 0000 0000 0000 0000 0000 0001 0001
	 * 
	 * 1041 >>> 2	0000 0000 0000 0000 0000 0001 0000 0100
	 * &
	 * 0x33			0011 0011 0011 0011 0011 0011 0011 0011
	 * =
	 * 256			0000 0000 0000 0000 0000 0001 0000 0000
	 * 
	 * n = 273		0000,0000,0000,0000,0000,0001,0001,0001		<<<
	 * 273 >>> 4	0000 0000 0000 0000 0000 0000 0001 0001
	 * 290			0000 0000 0000 0000 0000 0001 0010 0010
	 * &
	 * 0x0f			0000 1111 0000 1111 0000 1111 0000 1111
	 * =
	 * 258			0000 0000,0000 0000,0000 0001,0000 0010		<<<
	 * 
	 * 258 >>> 8	0000 0000 0000 0000 0000 0000 0000 0001
	 * 259			0000 0000 0000 0000,0000 0001 0000 0011		<<<
	 * 
	 * 259 >>> 16	0000 0000 0000 0000 0000 0000 0000 0000
	 * 
	 * 259			0000 0000 0000 0000 0000 0001 0000 0011
	 * &
	 * 0x3f			0000 0000 0000 0000 0000 0000 0011 1111		<<< due to 32 bit ?
	 * =
	 * 3			0000 0000 0000 0000 0000 0000 0000 0011		<<< answer
	 * */
	public int hammingWeight(int n) {
		// count adjacent 1 bits and stored in 2 bit
		n = n - ((n >>> 1) & 0x55555555);																			// 0101 0101 0101 0101 0101 0101 0101 0101
		
		// count adjacent 2 bits and stored in 4 bit
		n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);															// 0011 0011 0011 0011 0011 0011 0011 0011
		
		// count adjacent 4 bits and stored in 8 bit
		n = (n + (n >>> 4)) & 0x0f0f0f0f;																			// 0000 1111 0000 1111 0000 1111 0000 1111
		
		// count adjacent 8 bits and stored in 8 bit
		n = n + (n >>> 8);
		
		// count adjacent 16 bits and stored in 8 bit
		n = n + (n >>> 16);
		
		return n & 0x3f;																							// 0011 1111
	}
	
}
