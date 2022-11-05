package com.example.lcpjava.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lcp_2244_Minimum_Rounds_to_Complete_All_Tasks {
	
	/**
	 * 3 * k
	 * 3 * k + 1
	 * 3 * k + 2
	 * 
	 * 1	=>			=>	-1
	 * 2	=>			=>	2			=>	count / 3 + 1
	 * 3	=>			=>	3			=>	count / 3
	 * 4	=>	3k + 1	=>	2 2			=>	count / 3 + 1
	 * 5	=>	3k + 2	=>	3 2			=>	count / 3 + 1
	 * 6	=>	3k		=>	3 3			=>	count / 3
	 * 7	=>	3k + 1	=>	3 2 2		=>	count / 3 + 1
	 * 8	=>	3k + 2	=>	3 3 2		=>	count / 3 + 1
	 * 9	=>	3k		=>	3 3 3		=>	count / 3
	 * 10	=>	3k + 1	=>	3 3 2 2		=>	count / 3 + 1
	 * 11	=>	3k + 2	=>	3 3 3 2		=>	count / 3 + 1
	 * 12	=>	3k		=>	3 3 3 3		=>	count / 3
	 * 13	=>	3k + 1	=>	3 3 3 2 2	=>	count / 3 + 1
	 * */
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Solution Tab
	 * */
	public int minimumRounds_1(int[] tasks) {
		Map<Integer, Integer> difficulty2Count = new HashMap<>();													// S : O(n)
		for (int task : tasks) {																					// T : O(n)
			difficulty2Count.put(task, difficulty2Count.getOrDefault(task, 0) + 1);
		}
		
		int minRounds = 0;
		
		for (int count : difficulty2Count.values()) {																// T : O(n)
			if (count == 1) { return -1; }
			
			if (count % 3 == 0) {
				minRounds += (count / 3);
			} else {
				// count % 3 = 1 or count % 3 = 2
				minRounds += (count / 3 + 1);
			}
		}
		
		return minRounds;
	}
	
	/**
	 * 1		=>							=>	-1
	 * 
	 * 2		=>							=>	1
	 * 3		=>							=>	1
	 * 
	 * 4		=>							=>	2
	 * 5		=>							=>	2
	 * 6		=>							=>	2
	 * 
	 * 7		=>							=>	3
	 * 8		=>							=>	3
	 * 9		=>							=>	3
	 * 
	 * 10		=>							=>	4
	 * 11		=>							=>	4
	 * 12		=>							=>	4
	 * 
	 * 13		=>							=>	5
	 * 
	 * 3k		=>							=>	k
	 * 3k + 1	=>	3 * (k - 1) + 2 + 2		=>	k + 1
	 * 3k + 2	=>	3 * k + 2				=>	k + 1
	 * 
	 * (count + 2) /3
	 * */
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/discuss/1955622/JavaC%2B%2BPython-Sum-up-(freq-%2B-2)-3
	 * */
	public int minimumRounds_2(int[] tasks) {
		Map<Integer, Integer> difficulty2Count = new HashMap<>();													// S : O(n)
		for (int task : tasks) {																					// T : O(n)
			difficulty2Count.put(task, difficulty2Count.getOrDefault(task, 0) + 1);
		}
		
		int minRounds = 0;
		
		for (int count : difficulty2Count.values()) {																// T : O(n)
			if (count == 1) { return -1; }
			
			minRounds += ((count + 2) / 3);
		}
		
		return minRounds;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(1)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public int minimumRounds(int[] tasks) {
		Arrays.sort(tasks);																							// T : O(n log n)
		
		int n = tasks.length;
		int minRounds = 0;
		int count = 1;
		
		for (int i = 1; i < n; i++) {																				// T : O(n - 1)
			if (tasks[i - 1] == tasks[i]) {
				count++;
			} else {
				if (count == 1) { return -1; }
				
				minRounds += ((count + 2) / 3);
				
				count = 1;
			}
		}
		
		if (count == 1) { return -1; }
		
		minRounds += ((count + 2) / 3);
		
		return minRounds;
	}
	
}
