package com.example.lcpjava.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_1046_Last_Stone_Weight {
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * if stones length is equal to one
	 * 		return stones[0]
	 * end if
	 * 
	 * Queue<Integer> maxHeap <- new PriorityQueue<>(Collections reverseOrder())
	 * for int stone in stones
	 * 		maxHeap offer(stone)
	 * end for
	 * 
	 * while maxHeap size is greater than one
	 * 		int heavy <- maxHeap poll
	 * 		int light <- maxHeap poll
	 * 		
	 * 		if heavy is equal to light
	 * 			continue
	 * 		end if
	 * 		
	 * 		maxHeap offer(heavy minus light)
	 * end while
	 * 
	 * if maxHeap is empty
	 * 		return zero
	 * end if
	 * 
	 * return maxHeap poll
	 * */
	public int lastStoneWeight_1(int[] stones) {
		if (stones.length == 1) { return stones[0]; }
		
		Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());									// S : O(n)
		for (int stone : stones) {																					// T : O(n)
			maxHeap.offer(stone);																					// T : O(log n)
		}
		
		while (maxHeap.size() > 1) {																				// T : O(n ^ 2 / 2 + n / 2)
			int heavy = maxHeap.poll();																				// T : O(log n)
			int light = maxHeap.poll();																				// T : O(log n)
			
			if (heavy == light) { continue; }
			
			maxHeap.offer(heavy - light);																			// T : O(log n)
		}
		
		if (maxHeap.isEmpty()) { return 0; }																		// T : O(1)
		
		return maxHeap.poll();																						// T : O(log n)
	}
	
	/**
	 * time  : O(1000)
	 * space : O(1001)
	 * 
	 * if stones length is equal to one
	 * 		return stones[0]
	 * end if
	 * 
	 * int[] bucket <- new int[1001]
	 * for int stone in stones
	 * 		bucket[stone]++
	 * end for
	 * 
	 * int heavy <- bucket length minus one
	 * int light <- 0
	 * 
	 * while heavy is greater than zero
	 * 		if bucket[heavy] is equal to zero
	 * 			heavy--
	 * 			continue
	 * 		end if
	 * 		
	 * 		bucket[heavy] <- bucket[heavy] modulo two
	 * 		if bucket[heavy] is equal to zero
	 * 			continue
	 * 		end if
	 * 		
	 * 		light <- heavy minus one
	 * 		
	 * 		while light is greater than zero && bucket[light] is equal to zero
	 * 			light--
	 * 		end while
	 * 		
	 * 		if light is equal to zero
	 * 			return heavy
	 * 		end if
	 * 		
	 * 		bucket[heavy minus light]++
	 * 		bucket[light]--
	 * 		heavy--
	 * end while
	 * 
	 * return zero
	 * */
	public int lastStoneWeight_2(int[] stones) {
		if (stones.length == 1) { return stones[0]; }
		
		int[] bucket = new int[1000 + 1];																			// S : O(1001)
		for (int stone : stones) { bucket[stone]++; }																// T : O(1001)
		
		int heavy = bucket.length - 1;
		int light = 0;
		
		while (heavy > 0) {																							// T : O(1000)
			if (bucket[heavy] == 0) {
				heavy--;
				continue;
			}
			
			bucket[heavy] %= 2;
			if (bucket[heavy] == 0) { continue; }
			
			light = heavy - 1;
			
			while (light > 0 && bucket[light] == 0) { light--; }
			
			if (light == 0) { return heavy; }
			
			bucket[heavy - light]++;
			bucket[light]--;
			heavy--;
		}
		
		return 0;
	}
	
	/**
	 * time  : O(max(stone))
	 * space : O(max(stone))
	 * 
	 * if stones length is equal to one
	 * 		return stones[0]
	 * end if
	 * 
	 * int heavy <- 0
	 * int light <- 0
	 * for int stone in stones
	 * 		heavy <- Math max(stone, heavy)
	 * end for
	 * 
	 * int[] bucket <- new int[heavy plus one]
	 * for int stone in stones
	 * 		bucket[stone]++
	 * end for
	 * 
	 * while heavy is greater than zero
	 * 		bucket[heavy] <- bucket[heavy] modulo two
	 * 		if bucket[heavy] is equal to zero
	 * 			heavy--
	 * 			continue
	 * 		end if
	 * 		
	 * 		light <- heavy minus one
	 * 		
	 * 		while light is greater than zero && bucket[light] is equal to zero
	 * 			light--
	 * 		end while
	 * 		
	 * 		if light is equal to zero
	 * 			return heavy
	 * 		end if
	 * 		
	 * 		bucket[heavy minus light]++
	 * 		bucket[light]--
	 * 		heavy <- Math max(light, heavy minus light)
	 * end while
	 * 
	 * return zero
	 * */
	public int lastStoneWeight(int[] stones) {
		if (stones.length == 1) { return stones[0]; }
		
		int heavy = 0;
		int light = 0;
		for (int stone : stones) { heavy = Math.max(stone, heavy); }												// T : O(n)
		
		int[] bucket = new int[heavy + 1];																			// S : O(max(stone))
		for (int stone : stones) { bucket[stone]++; }																// T : O(n)
		
		while (heavy > 0) {																							// T : O(max(stone))
			bucket[heavy] %= 2;
			if (bucket[heavy] == 0) {
				heavy--;
				continue;
			}
			
			light = heavy - 1;
			
			while (light > 0 && bucket[light] == 0) { light--; }
			
			if (light == 0) { return heavy; }
			
			bucket[heavy - light]++;
			bucket[light]--;
			heavy = Math.max(light, heavy - light);
		}
		
		return 0;
	}
	
}
