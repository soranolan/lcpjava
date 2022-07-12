package com.example.lcpjava.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Lcp_473_Matchsticks_to_Square {
	
	/**
	 * Time Limit Exceeded
	 * */
	public boolean makesquare_1(int[] matchsticks) {
		return backtrack(0, 0, 0, 0, 0, matchsticks);
	}
	
	private boolean backtrack(int left, int right, int top, int down, int start, int[] matchsticks) {
		if (left == right && right == top && top == down && start >= matchsticks.length) { return true; }
		
		for (int i = start; i < matchsticks.length; i++) {
			if (backtrack(left + matchsticks[i], right, top, down, start + 1, matchsticks)) { return true; }
			if (backtrack(left, right + matchsticks[i], top, down, start + 1, matchsticks)) { return true; }
			if (backtrack(left, right, top + matchsticks[i], down, start + 1, matchsticks)) { return true; }
			if (backtrack(left, right, top, down + matchsticks[i], start + 1, matchsticks)) { return true; }
		}
		
		return false;
	}
	
	/**
	 * time  : O(4 ^ n)
	 * space : O(n)
	 * 
	 * Solution
	 * */
	public boolean makesquare_2(int[] matchsticks) {
		int perimeter = 0;
		for (int matchstick : matchsticks) { perimeter += matchstick; }
		
		int possibleLength = perimeter / 4;
		if (possibleLength * 4 != perimeter) { return false; }
		
		int[] square = new int[4];
		
		matchsticks = IntStream.of(matchsticks).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
		
		return backtrack(0, possibleLength, square, matchsticks);
	}
	
	private boolean backtrack(int index, int possibleLength, int[] square, int[] matchsticks) {
		if (index == matchsticks.length) { return square[0] == square[1] && square[1] == square[2] && square[2] == square[3]; }
		
		int currentMatchstick = matchsticks[index];
		
		for (int i = 0; i < 4; i++) {
			if (square[i] + currentMatchstick <= possibleLength) {
				square[i] += currentMatchstick;
				
				if (backtrack(index + 1, possibleLength, square, matchsticks)) { return true; }
				
				square[i] -= currentMatchstick;
			}
		}
		
		return false;
	}
	
	/**
	 * time  : O(n * (2 ^ n))
	 * space : O(n + (2 ^ n))
	 * 
	 * Solution
	 * */
	public boolean makesquare_3(int[] nums) {
		int length = nums.length;
		int perimeter = 0;
		for (int i = 0; i < length; i++) { perimeter += nums[i]; }
		
		int possibleLength = perimeter / 4;
		if (possibleLength * 4 != perimeter) { return false; }
		
		Map<Map<Integer, Integer>, Boolean> memo = new HashMap<>();
		
		return recursive((1 << length) - 1, possibleLength, 0, nums, memo);
	}
	
	private boolean recursive(int mask, int possibleLength, int sidesFormed, int[] nums, Map<Map<Integer, Integer>, Boolean> memo) {
		int usedLength = 0;
		int length = nums.length;
		
		Map<Integer, Integer> key = new HashMap<>();
		key.put(mask, sidesFormed);
		
		// find used
		for (int i = length - 1; i >= 0; i--) {
			if ((mask & (1 << i)) == 0) {
				usedLength += nums[length - 1 - i];
			}
		}
		
		if (usedLength > 0 && usedLength % possibleLength == 0) { sidesFormed++; }
		
		if (sidesFormed == 3) { return true; }
		
		if (memo.containsKey(key)) { return memo.get(key); }
		
		boolean answer = false;
		int c = usedLength / possibleLength;
		
		// Remaining length in the current partially formed side.
		int remaining = possibleLength * (c + 1) - usedLength;
		
		// Try out all remaining options (that are valid)
		for (int i = length - 1; i >= 0; i--) {
			if (nums[length - 1 - i] <= remaining && (mask & (1 << i)) > 0) {
				if (recursive(mask ^ (1 << i), possibleLength, sidesFormed, nums, memo)) {
					answer = true;
					break;
				}
			}
		}
		
		memo.put(key, answer);
		return answer;
	}
	
	/**
	 * Accepted Solutions Runtime Distribution
	 * */
	public boolean makesquare(int[] matchsticks) {
		// ascending
		Arrays.sort(matchsticks);
		
		// descending
		for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
			int temp = matchsticks[i];
			matchsticks[i] = matchsticks[j];
			matchsticks[j] = temp;
		}
		
		int perimeter = 0;
		for (int matchstick : matchsticks) { perimeter += matchstick; }
		
		int possibleLength = perimeter / 4;
		if (matchsticks.length < 4 || perimeter % 4 != 0 || matchsticks[0] > possibleLength) { return false; }
		
		boolean[] usedMatchstick = new boolean[matchsticks.length];
		
		return recursive(0, 0, possibleLength, 0, matchsticks, usedMatchstick);
	}
	
	public boolean recursive(int start, int currentSum, int possibleLength, int sidesFormed, int[] nums, boolean[] usedMatchstick) {
		if (sidesFormed == 3) { return true; }
		
		if (currentSum == possibleLength) { return recursive(0, 0, possibleLength, sidesFormed + 1, nums, usedMatchstick); }
		
		for (int i = start; i < nums.length; i++) {
			if (usedMatchstick[i]) { continue; }
			
			// if previous is equal to current, then previous skip, current skip
			if (i > 0 && nums[i] == nums[i - 1] && !usedMatchstick[i - 1]) { continue; }
			
			if (currentSum + nums[i] > possibleLength) { continue; }
			
			usedMatchstick[i] = true;
			
			if (recursive(i + 1, currentSum + nums[i], possibleLength, sidesFormed, nums, usedMatchstick)) { return true; }
			
			usedMatchstick[i] = false;
		}
		
		return false;
	}
	
}
