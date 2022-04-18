package com.example.lcpjava.brainteaser;

public class Lcp_292_Nim_Game {
	
	/**
	 * we are the first one to pick, no matter which number we pick, if the other player add it to four, then we lose.
	 * e.g. four stones situation
	 * 		1 vs 3
	 * 		2 vs 2
	 * 		3 vs 1
	 * 
	 * n = 1 true
	 * n = 2 true
	 * n = 3 true
	 * n = 4 false
	 * n = 5 true
	 * n = 6 true
	 * n = 7 true
	 * n = 8 false
	 * */
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public boolean canWinNim_1(int n) {
		return (n % 4 != 0);
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/nim-game/discuss/73837/O(1)-Efficient-Single-line-Java-using-Bit-Checking
	 * */
	public boolean canWinNim(int n) {
		return (n & 0b11) != 0;
	}
	
}
