package com.example.lcpjava.array;

import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_1094_Car_Pooling {
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/car-pooling/discuss/870498/Java-or-Priority-Queue
	 * 
	 * 
	 * Queue<int[]> minHeap <- new PriorityQueue<>((offer, previous) -> offer[0] minus previous[0])
	 * 
	 * for int[] trip in trips
	 * 		int passengers <- trip[0]
	 * 		int from <- trip[1]
	 * 		int to <- trip[2]
	 * 		
	 * 		minHeap offer(array [from, passengers])
	 * 		minHeap offer(array [to, minus passengers])
	 * end for
	 * 
	 * int sum <- 0
	 * 
	 * while minHeap is not empty
	 * 		int[] current <- minHeap poll
	 * 		sum <- sum plus current[1]
	 * 		
	 * 		while minHeap is not empty && minHeap peek station is equal to current station
	 * 			sum <- sum plus minHeap poll passengers
	 * 		end while
	 * 		
	 * 		if sum is greater than capacity
	 * 			return false
	 * 		end if
	 * end while
	 * 
	 * return true
	 * */
	public boolean carPooling_1(int[][] trips, int capacity) {
		Queue<int[]> minHeap = new PriorityQueue<>((offer, previous) -> offer[0] - previous[0]);					// S : O(n * 2)
		
		for (int[] trip : trips) {																					// T : O(n)
			int passengers = trip[0];
			int from = trip[1];
			int to = trip[2];
			
			minHeap.offer(new int[] { from, passengers });															// T : O(log n)
			minHeap.offer(new int[] { to, -passengers });															// T : O(log n)
		}
		
		int sum = 0;
		while (!minHeap.isEmpty()) {																				// T : O(n)
			int[] current = minHeap.poll();																			// T : O(1)
			sum += current[1];
			
			while (!minHeap.isEmpty() && minHeap.peek()[0] == current[0]) { sum += minHeap.poll()[1]; }
			
			if (sum > capacity) { return false; }
		}
		
		return true;
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(n)
	 * 
	 * int max <- 0
	 * 
	 * for int[] trip in trips
	 * 		max <- Math max(max, trip[2])
	 * end for
	 * 
	 * int[] bucket <- new int[max plus one]
	 * 
	 * for int[] trip in trips
	 * 		int passengers <- trip[0]
	 * 		int from <- trip[1]
	 * 		int to <- trip[2]
	 * 		
	 * 		for int station <- from; if station is lower than to; station++
	 * 			bucket[station] <- bucket[station] plus passengers
	 * 			
	 * 			if bucket[station] is greater than capacity
	 * 				return false
	 * 			end if
	 * 		end for
	 * end for
	 * 
	 * return true
	 * */
	public boolean carPooling_2(int[][] trips, int capacity) {
		int max = 0;
		for (int[] trip : trips) { max = Math.max(max, trip[2]); }													// T : O(n)
		int[] bucket = new int[max + 1];																			// S : O(n + 1)
		
		for (int[] trip : trips) {																					// T : O(n)
			int passengers = trip[0];
			int from = trip[1];
			int to = trip[2];
			
			for (int station = from; station < to; station++) {														// T : O(m)
				bucket[station] += passengers;
				if (bucket[station] > capacity) { return false; }
			}
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/car-pooling/discuss/1670309/C%2B%2BJavaPython-DONOT-SORT-oror-O(N)-95-Faster-oror-Image-Explanation
	 * 
	 * 
	 * int max <- 0
	 * 
	 * for int[] trip in trips
	 * 		max <- Math max(max, trip[2])
	 * end for
	 * 
	 * int[] bucket <- new int[max plus one]
	 * 
	 * for int[] trip in trips
	 * 		int passengers <- trip[0]
	 * 		int from <- trip[1]
	 * 		int to <- trip[2]
	 * 		
	 * 		bucket[from] <- bucket[from] plus passengers
	 * 		bucket[to] <- bucket[to] minus passengers
	 * end for
	 * 
	 * int sum <- 0
	 * for int passengers in bucket
	 * 		sum <- sum plus passengers
	 * 		
	 * 		if sum is greater than capacity
	 * 			return false
	 * 		end if
	 * end for
	 * 
	 * return true
	 * */
	public boolean carPooling(int[][] trips, int capacity) {
		int max = 0;
		for (int[] trip : trips) { max = Math.max(max, trip[2]); }													// T : O(n)
		int[] bucket = new int[max + 1];																			// S : O(n + 1)
		
		for (int[] trip : trips) {																					// T : O(n)
			int passengers = trip[0];
			int from = trip[1];
			int to = trip[2];
			
			bucket[from] += passengers;
			bucket[to] -= passengers;
		}
		
		int sum = 0;
		for (int passengers : bucket) {																				// T : O(n)
			sum += passengers;
			if (sum > capacity) { return false; }
		}
		
		return true;
	}
	
}
