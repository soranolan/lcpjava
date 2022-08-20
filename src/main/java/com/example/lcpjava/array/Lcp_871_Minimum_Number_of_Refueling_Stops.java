package com.example.lcpjava.array;

import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_871_Minimum_Number_of_Refueling_Stops {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n ^ 2)
	 * 
	 * Solution Tab
	 * 
	 * https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/1267000/C%2B%2B-3-approaches-FULL-STORY-LIKE-Explanation-(-O(n2)-Dp-greater-O(n)-dp-greater-O(nlogn)-using-max-heap-)
	 * */
	public int minRefuelStops_1(int target, int startFuel, int[][] stations) {
		int n = stations.length;
		int[][] distance = new int[n + 1][n + 1];																	// S : O((n + 1) * (n + 1))
		
		for (int i = 0; i <= n; i++) {																				// T : O(n + 1)
			distance[i][0] = startFuel;
		}
		
		for (int atStation = 1; atStation <= n; atStation++) {														// T : O(n)
			for (int stopCount = 1; stopCount <= atStation; stopCount++) {											// T : O(n)
				// if chose not adding fuel, then is the same with previous distance
				distance[atStation][stopCount] = distance[atStation - 1][stopCount];
				
				int position = stations[atStation - 1][0];
				int fuel = stations[atStation - 1][1];
				int previousDistance = distance[atStation - 1][stopCount - 1];
				
				// if want to add fuel, check if we can reach it
				if (previousDistance >= position) {
					distance[atStation][stopCount] = Math.max(distance[atStation][stopCount], previousDistance + fuel);
				}
			}
		}
		
		for (int minimumStops = 0; minimumStops <= n; minimumStops++) {												// T : O(n + 1)
			if (distance[n][minimumStops] >= target) {
				return minimumStops;
			}
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * Solution Tab
	 * 
	 * https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/149839/DP-O(N2)-and-Priority-Queue-O(NlogN)
	 * */
	public int minRefuelStops_2(int target, int startFuel, int[][] stations) {
		int n = stations.length;
		int[] distance = new int[n + 1];																			// S : O(n + 1)
		distance[0] = startFuel;
		
		for (int atStation = 0; atStation < n; atStation++) {														// T : O(n)
			for (int stopCount = atStation; stopCount >= 0; stopCount--) {											// T : O(n)
				int position = stations[atStation][0];
				int fuel = stations[atStation][1];
				int previousDistance = distance[stopCount];
				
				if (previousDistance >= position) {
					distance[stopCount + 1] = Math.max(distance[stopCount + 1], previousDistance + fuel);
				}
			}
		}
		
		for (int minimumStops = 0; minimumStops <= n; minimumStops++) {												// T : O(n)
			if (distance[minimumStops] >= target) {
				return minimumStops;
			}
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * Solution Tab
	 * 
	 * https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/294025/Java-Simple-Code-Greedy
	 * */
	public int minRefuelStops_3(int target, int startFuel, int[][] stations) {
		Queue<Integer> maxHeap = new PriorityQueue<>((offer, previous) -> previous - offer);						// S : O(n)
		
		int minimumStops = 0;
		int index = 0;
		int n = stations.length;
		int distance = startFuel;
		
		while (distance < target) {
			while (index < n && stations[index][0] <= distance) {													// T : O(n)
				maxHeap.offer(stations[index++][1]);																// T : O(log n)
			}
			
			if (maxHeap.isEmpty()) { return -1; }																	// T : O(1)
			
			distance += maxHeap.poll();																				// T : O(log n)
			minimumStops++;
		}
		
		return minimumStops;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * will change input
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public int minRefuelStops_4(int target, int startFuel, int[][] stations) {
		int minimumStops = 0;
		int n = stations.length;
		int distance = startFuel;
		
		while (distance < target) {
			int currentPosition = -1;
			int currentFuel = 0;
			
			for (int i = 0; i < n; i++) {
				int position = stations[i][0];
				int fuel = stations[i][1];
				
				if (distance >= position && fuel > currentFuel) {
					currentPosition = i;
					currentFuel = fuel;
				}
			}
			
			if (currentFuel == 0) { break; }
			
			minimumStops++;
			distance += currentFuel;
			
			stations[currentPosition][0] = Integer.MAX_VALUE;
		}
		
		return distance >= target ? minimumStops : -1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int minimumStops = 0;
		int n = stations.length;
		int distance = startFuel;
		boolean[] visited = new boolean[n + 1];
		
		while (distance < target) {
			int currentPosition = -1;
			int currentFuel = 0;
			
			for (int i = 0; i < n; i++) {
				int position = stations[i][0];
				int fuel = stations[i][1];
				
				if (!visited[i] && distance >= position && fuel > currentFuel) {
					currentPosition = i;
					currentFuel = fuel;
				}
			}
			
			if (currentFuel == 0) { break; }
			
			minimumStops++;
			distance += currentFuel;
			
			visited[currentPosition] = true;
		}
		
		return distance >= target ? minimumStops : -1;
	}
	
}
