package com.example.lcpjava.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_1334_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
	
	/**
	 * [0,1,3],
	 * [1,2,1],
	 * [1,3,4],
	 * [2,3,1]
	 * 
	 * 0 : [1,3]
	 * 1 : [0,3] [2,1] [3,4]
	 * 2 : [1,1] [3,1]
	 * 3 : [1,4] [2,1]
	 */
	/**
	 * time  : O(n!)
	 * space : O(n!)
	 * 
	 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/discuss/490555/The-Reason-of-DFS-Not-Working-(Explain-Graph-and-Example)
	 * 
	 * 
	 * build graph by edges
	 * 
	 * int minCityCount <- n
	 * 
	 * int cityId <- minus one
	 * 
	 * for int fromCity <- 0; if fromCity is lower than n; fromCity++
	 * 		new distance / visited array
	 * 		
	 * 		fill array with maximum value
	 * 		
	 * 		set current city with one as visited
	 * 		
	 * 		traverse graph
	 * 		
	 * 		count distance array to ensure city count
	 * 		
	 * 		if city count is lower than or equal to minimum city count
	 * 			minCityCount <- cityCount
	 * 			cityId <- fromCity
	 * 		end if
	 * end for
	 * 
	 * return cityId
	 * */
	public int findTheCity_1(int n, int[][] edges, int distanceThreshold) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		
		for (int[] edge : edges) {
			int fromCity = edge[0];
			int toCity = edge[1];
			int weight = edge[2];
			
			if (!graph.containsKey(fromCity)) { graph.put(fromCity, new ArrayList<>()); }
			if (!graph.containsKey(toCity)) { graph.put(toCity, new ArrayList<>()); }
			
			graph.get(fromCity).add(new int[] { toCity, weight });
			graph.get(toCity).add(new int[] { fromCity, weight });
		}
		
		int minCityCount = n;
		int cityId = -1;
		
		for (int fromCity = 0; fromCity < n; fromCity++) {
			int[] distanceArr = new int[n];
			Arrays.fill(distanceArr, Integer.MAX_VALUE);
			distanceArr[fromCity] = 1;
			
			traverse(fromCity, 0, distanceThreshold, graph, distanceArr);
			
			int cityCount = 0;
			for (int i = 0; i < n; i++) {
				if (distanceArr[i] != Integer.MAX_VALUE) {
					cityCount++;
				}
			}
			
			if (cityCount <= minCityCount) {
				minCityCount = cityCount;
				cityId = fromCity;
			}
		}
		
		return cityId;
	}
	
	/**
	 * if graph does not contain fromCity
	 * 		return
	 * end if
	 * 
	 * for int[] edge in graph get(fromCity)
	 * 		int toCity <- edge[zero]
	 * 		int weight <- edge[one]
	 * 		int newDistance <- distance plus weight
	 * 		
	 * 		if newDistance is greater than distance threshold
	 * 			continue
	 * 		end if
	 * 		
	 * 		if newDistance is lower than distance array[toCity]
	 * 			distance array[toCity] <- newDistance
	 * 			traverse(toCity, newDistance, distance threshold, graph, distance array)
	 * 		end if
	 * end for
	 * */
	private void traverse(int fromCity, int distance, int distanceThreshold, Map<Integer, List<int[]>> graph, int[] distanceArr) {
		if (!graph.containsKey(fromCity)) { return; }
		
		for (int[] edge : graph.get(fromCity)) {
			int toCity = edge[0];
			int weight = edge[1];
			int newDistance = distance + weight;
			
			if (newDistance > distanceThreshold) { continue; }
			if (newDistance < distanceArr[toCity]) {
				distanceArr[toCity] = newDistance;
				traverse(toCity, newDistance, distanceThreshold, graph, distanceArr);
			}
		}
	}
	
	/**
	 * time  : O(edge + node)
	 * space : O(node)
	 * 
	 * Time Limit Exceeded
	 * 
	 * Math is the king!
	 * 
	 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/discuss/493629/Java-Floyd-SPFA-Dijkstra-and-Bellman
	 * */
	public int findTheCity_2(int n, int[][] edges, int distanceThreshold) {
		int[][] distance = new int[n][n];
		
		for (int[] row : distance) { Arrays.fill(row, 10001); }
		
		for (int[] edge : edges) {
			int fromCity = edge[0];
			int toCity = edge[1];
			int weight = edge[2];
			
			distance[fromCity][toCity] = weight;
			distance[toCity][fromCity] = weight;
		}
		
		for (int i = 0; i < n; i++) { distance[i][i] = 0; }
		
		for (int i = 0; i < n; i++) { bellmanFord(distanceThreshold, edges, distance[i]); }
		
		int minCityCount = n;
		int cityId = -1;
		
		for (int fromCity = 0; fromCity < n; fromCity++) {
			int cityCount = 0;
			
			for (int toCity = 0; toCity < n; toCity++) {
				if (fromCity == toCity) { continue; }
				if (distance[fromCity][toCity] <= distanceThreshold) { cityCount++; }
			}
			
			if (cityCount <= minCityCount) {
				minCityCount = cityCount;
				cityId = fromCity;
			}
		}
		
		return cityId;
	}
	
	private void bellmanFord(int n, int[][] edges, int[] distance) {
		for (int k = 1; k < n; k++) {
			for (int[] edge : edges) {
				int fromCity = edge[0];
				int toCity = edge[1];
				int weight = edge[2];
				
				if (distance[fromCity] > distance[toCity] + weight) { distance[fromCity] = distance[toCity] + weight; }
				if (distance[toCity] > distance[fromCity] + weight) { distance[toCity] = distance[fromCity] + weight; }
			}
		}
	}
	
	/**
	 * time  : O(edge + node)
	 * space : O(node)
	 * */
	public int findTheCity_3(int n, int[][] edges, int distanceThreshold) {
		List<List<int[]>> graph = new ArrayList<>(n);
		for (int i = 0; i < n; i++) { graph.add(new ArrayList<>()); }
		for (int[] edge : edges) {
			int fromCity = edge[0];
			int toCity = edge[1];
			int weight = edge[2];
			
			graph.get(fromCity).add(new int[] { toCity, weight });
			graph.get(toCity).add(new int[] { fromCity, weight });
		}
		
		int[][] distance = new int[n][n];
		
		for (int[] row : distance) { Arrays.fill(row, 10001); }
		
		for (int i = 0; i < n; i++) { distance[i][i] = 0; }
		
		for (int i = 0; i < n; i++) { spfa(n, graph, distance[i], i); }
		
		int minCityCount = n;
		int cityId = -1;
		
		for (int fromCity = 0; fromCity < n; fromCity++) {
			int cityCount = 0;
			
			for (int toCity = 0; toCity < n; toCity++) {
				if (fromCity == toCity) { continue; }
				if (distance[fromCity][toCity] <= distanceThreshold) { cityCount++; }
			}
			
			if (cityCount <= minCityCount) {
				minCityCount = cityCount;
				cityId = fromCity;
			}
		}
		
		return cityId;
	}
	
	private void spfa(int n, List<List<int[]>> graph, int[] distance, int source) {
		int[] updateTimes = new int[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		
		while (!queue.isEmpty()) {
			int fromCity = queue.poll();
			
			for (int[] edge : graph.get(fromCity)) {
				int toCity = edge[0];
				int weight = edge[1];
				
				if (distance[toCity] > distance[fromCity] + weight) {
					distance[toCity] = distance[fromCity] + weight;
					updateTimes[toCity]++;
					queue.offer(toCity);
					if (updateTimes[toCity] > n) { System.out.println("wrong"); }
				}
			}
		}
	}
	
	/**
	 * time  : O((edge + node) * log node)
	 * space : O(edge + node)
	 * */
	public int findTheCity_4(int n, int[][] edges, int distanceThreshold) {
		List<List<int[]>> graph = new ArrayList<>(n);
		for (int i = 0; i < n; i++) { graph.add(new ArrayList<>()); }
		for (int[] edge : edges) {
			int fromCity = edge[0];
			int toCity = edge[1];
			int weight = edge[2];
			
			graph.get(fromCity).add(new int[] { toCity, weight });
			graph.get(toCity).add(new int[] { fromCity, weight });
		}
		
		int[][] distance = new int[n][n];
		
		for (int[] row : distance) { Arrays.fill(row, 10001); }
		
		for (int i = 0; i < n; i++) { distance[i][i] = 0; }
		
		for (int i = 0; i < n; i++) { dijkstra(n, graph, distance[i], i); }
		
		int minCityCount = n;
		int cityId = -1;
		
		for (int fromCity = 0; fromCity < n; fromCity++) {
			int cityCount = 0;
			
			for (int toCity = 0; toCity < n; toCity++) {
				if (fromCity == toCity) { continue; }
				if (distance[fromCity][toCity] <= distanceThreshold) { cityCount++; }
			}
			
			if (cityCount <= minCityCount) {
				minCityCount = cityCount;
				cityId = fromCity;
			}
		}
		
		return cityId;
	}
	
	private void dijkstra(int n, List<List<int[]>> graph, int[] distance, int source) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((offer, previous) -> (offer[1] - previous[1]));
		minHeap.add(new int[] { source, 0 });
		
		while (!minHeap.isEmpty()) {
			int[] fromEdge = minHeap.poll();
			int fromCity = fromEdge[0];
			int fromWeight = fromEdge[1];
			if (fromWeight > distance[fromCity]) { continue; }
			
			for (int[] toEdge : graph.get(fromCity)) {
				int toCity = toEdge[0];
				int toWeight = toEdge[1];
				if (distance[toCity] > fromWeight + toWeight) {
					distance[toCity] = fromWeight + toWeight;
					minHeap.offer(new int[] { toCity, distance[toCity] });
				}
			}
		}
	}
	
	/**
	 * time  : O(n ^ 3)
	 * space : O(n ^ 2)
	 * */
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int[][] distance = new int[n][n];
		
		for (int[] row : distance) { Arrays.fill(row, 10001); }
		
		for (int[] edge : edges) {
			int fromCity = edge[0];
			int toCity = edge[1];
			int weight = edge[2];
			
			distance[fromCity][toCity] = weight;
			distance[toCity][fromCity] = weight;
		}
		
		for (int i = 0; i < n; i++) { distance[i][i] = 0; }
		
		floydWarshall(n, distance);
		
		int minCityCount = n;
		int cityId = -1;
		
		for (int fromCity = 0; fromCity < n; fromCity++) {
			int cityCount = 0;
			
			for (int toCity = 0; toCity < n; toCity++) {
				if (fromCity == toCity) { continue; }
				if (distance[fromCity][toCity] <= distanceThreshold) { cityCount++; }
			}
			
			if (cityCount <= minCityCount) {
				minCityCount = cityCount;
				cityId = fromCity;
			}
		}
		
		return cityId;
	}
	
	private void floydWarshall(int n, int[][] distance) {
		for (int satelliteCity = 0; satelliteCity < n; satelliteCity++) {
			for (int fromCity = 0; fromCity < n; fromCity++) {
				for (int toCity = 0; toCity < n; toCity++) {
					distance[fromCity][toCity] = Math.min(distance[fromCity][toCity], distance[fromCity][satelliteCity] + distance[satelliteCity][toCity]);
				}
			}
		}
	}
	
}
