package com.example.lcpjava.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lcp_1386_Cinema_Seat_Allocation {
	
	/**
	 * time  : O(n)
	 * space : O(m)
	 * 
	 * https://leetcode.com/problems/cinema-seat-allocation/discuss/546705/JAVA-Explained-comments.-Simple.-HashMap.
	 * 
	 * Time Limit Exceeded
	 * */
	public int maxNumberOfFamilies_1(int n, int[][] reservedSeats) {
		Map<Integer, Set<Integer>> reservedMap = new HashMap<>();													// S : O(m)
		
		for (int[] seats : reservedSeats) {																			// T : O(m)
			if (!reservedMap.containsKey(seats[0])) { reservedMap.put(seats[0], new HashSet<>()); }
			reservedMap.get(seats[0]).add(seats[1]);
		}
		
		int result = 0;
		
		for (int row = 1; row <= n; row++) {																		// T : O(n)
			if (!reservedMap.containsKey(row)) {
				result += 2;
				continue;
			}
			
			boolean leftSide = false;
			boolean rightSide = false;
			Set<Integer> reserved = reservedMap.get(row);
			
			if (!reserved.contains(2) && !reserved.contains(3) && !reserved.contains(4) && !reserved.contains(5)) {
				result++;
				leftSide = true;
			}
			if (!reserved.contains(6) && !reserved.contains(7) && !reserved.contains(8) && !reserved.contains(9)) {
				result++;
				rightSide = true;
			}
			if (!leftSide && !rightSide && !reserved.contains(4) && !reserved.contains(5) && !reserved.contains(6) && !reserved.contains(7)) {
				result++;
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(m)
	 * space : O(m)
	 * 
	 * Bit Manipulation
	 * 
	 * https://leetcode.com/problems/cinema-seat-allocation/discuss/546451/Java-Straightforward-solution-(bitwise)
	 * */
	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		Map<Integer, Integer> reservedMap = new HashMap<>();														// S : O(m)
		for (int[] seats : reservedSeats) {																			// T : O(m)
			reservedMap.put(seats[0], reservedMap.getOrDefault(seats[0], 0) | (1 << seats[1]));
		}
		
		int result = (n - reservedMap.size()) * 2;
		for (int row : reservedMap.keySet()) {																		// T : O(m)
			int count = 0;
			int reserved = reservedMap.get(row);
			
			if ((reserved & 60) == 0) { count++; }																	// 0000 0000 0011 1100
			if ((reserved & 960) == 0) { count++; }																	// 0000 0011 1100 0000
			if (count == 0 && (reserved & 240) == 0) { count++; }													// 0000 0000 1111 0000
			
			result += count;
		}
		
		return result;
	}
	
}
