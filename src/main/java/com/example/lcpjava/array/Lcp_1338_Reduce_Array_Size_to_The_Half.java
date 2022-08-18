package com.example.lcpjava.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Lcp_1338_Reduce_Array_Size_to_The_Half {
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 */
	public int minSetSize_1(int[] arr) {
		Map<Integer, Integer> number2Frequency = new HashMap<>();													// S : O(n * 2)
		for (int num : arr) {																						// T : O(n)
			number2Frequency.put(num, number2Frequency.getOrDefault(num, 0) + 1);									// T : O(1)
		}
		
		Queue<int[]> maxHeap = new PriorityQueue<>((offer, previous) -> previous[1] - offer[1]);					// S : O(n * 2)
		for (Integer num : number2Frequency.keySet()) {																// T : O(n)
			maxHeap.offer(new int[] { num, number2Frequency.get(num) });											// T : O(log n)
		}
		
		int length = arr.length;																					// n
		int half = length / 2;
		Set<Integer> removed = new HashSet<>();																		// S : O(n / 2)
		
		while (length > half && !maxHeap.isEmpty()) {																// T : O(n / 2)
			int[] pair = maxHeap.poll();																			// T : O(log n)
			int number = pair[0];
			int frequency = pair[1];
			
			removed.add(number);																					// T : O(1)
			length -= frequency;
		}
		
		return removed.size();																						// T : O(1)
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/reduce-array-size-to-the-half/discuss/1319416/C%2B%2BJavaPython-HashMap-and-Sort-then-Counting-Sort-O(N)-Clean-and-Concise
	 * https://leetcode.com/problems/reduce-array-size-to-the-half/discuss/1319437/Simple-Solution-w-Explanation-or-Delete-Elements-by-Max-Frequency-or-O(N)-Beats-100
	 * */
	public int minSetSize_2(int[] arr) {
		Map<Integer, Integer> number2Frequency = new HashMap<>();													// S : O(n * 2)
		for (int num : arr) {																						// T : O(n)
			number2Frequency.put(num, number2Frequency.getOrDefault(num, 0) + 1);									// T : O(1)
		}
		
		int length = arr.length;																					// n
		int[] frequency2Count = new int[length + 1];																// S : O(n + 1)
		for (int frequency : number2Frequency.values()) { frequency2Count[frequency]++; }							// T : O(n)
		
		int removed = 0;
		int frequency = arr.length;
		int half = length / 2;
		while (length > half) {																						// T : O(n / 2)
			while (frequency2Count[frequency] == 0) { frequency--; }
			
			frequency2Count[frequency]--;
			length -= frequency;
			removed++;
		}
		
		return removed;
	}
	
	/**
	 * time  : O(n)
	 * space : O(max - min)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public int minSetSize(int[] arr) {
		int min = 100000 + 1;
		int max = 0;
		
		for (int num : arr) {																						// T : O(n)
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		int[] number2Frequency = new int[max - min + 1];															// S : O(max - min)
		for (int num : arr) { number2Frequency[num - min]++; }														// T : O(n)
		
		int length = arr.length;
		int[] frequency2Count = new int[length + 1];																// S : O(n + 1)
		for (int frequency : number2Frequency) {																	// T : O(n)
			if (frequency > 0) {
				frequency2Count[frequency]++;
			}
		}
		
		int removed = 0;
		int frequency = arr.length;
		int half = length / 2;
		while (length > half) {																						// T : O(n / 2)
			while (frequency2Count[frequency] == 0) { frequency--; }
			
			frequency2Count[frequency]--;
			length -= frequency;
			removed++;
		}
		
		return removed;
	}
	
}
