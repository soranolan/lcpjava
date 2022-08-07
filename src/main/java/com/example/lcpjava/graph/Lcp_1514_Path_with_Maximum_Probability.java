package com.example.lcpjava.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.example.lcpjava.common.Lcp_1514_Pair;

public class Lcp_1514_Path_with_Maximum_Probability {
	
	/**
	 * time  : O(n ^ 3)
	 * space : O(n ^ 2)
	 * 
	 * Floyd–Warshall algorithm
	 * 
	 * https://leetcode.com/problems/path-with-maximum-probability/discuss/731626/Java-Detailed-Explanation-BFS
	 * */
	public double maxProbability_1(int n, int[][] edges, double[] succProb, int start, int end) {
		double[][] distance = new double[n][n];																		// S : O(n ^ 2)
		
		for (int i = 0; i < edges.length; i++) {																	// T : O(e)
			int nodeA = edges[i][0];
			int nodeB = edges[i][1];
			
			distance[nodeA][nodeB] = succProb[i];
			distance[nodeB][nodeA] = succProb[i];
		}
		
		for (int i = 0; i < n; i++) {																				// T : O(n)
			for (int j = 0; j < n; j++) {																			// T : O(n)
				for (int k = 0; k < n; k++) {																		// T : O(n)
					distance[i][j] = Math.max(distance[i][j], distance[i][k] * distance[k][j]);
				}
			}
		}
		
		return distance[start][end];
	}
	
	/**
	 * time  : O(n * e)
	 * space : O(n + e)
	 * 
	 * Bellman–Ford algorithm
	 * 
	 * https://leetcode.com/problems/path-with-maximum-probability/discuss/731767/JavaPython-3-2-codes%3A-Bellman-Ford-and-Dijkstra's-algorithm-w-brief-explanation-and-analysis.
	 * */
	public double maxProbability_2(int n, int[][] edges, double[] succProb, int start, int end) {
		Map<Integer, List<int[]>> node2Index = new HashMap<>();														// S : O(8 * e)
		
		for (int i = 0; i < edges.length; i++) {																	// T : O(e)
			int nodeA = edges[i][0];
			int nodeB = edges[i][1];
			
			node2Index.computeIfAbsent(nodeA, list -> new ArrayList<>()).add(new int[] { nodeB, i });
			node2Index.computeIfAbsent(nodeB, list -> new ArrayList<>()).add(new int[] { nodeA, i });
		}
		
		double[] probability = new double[n];																		// S : O(n)
		probability[start] = 1D;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			
			for (int[] pair : node2Index.getOrDefault(currentNode, Collections.emptyList())) {
				int nextNode = pair[0];
				int index = pair[1];
				
				if (probability[currentNode] * succProb[index] > probability[nextNode]) {
					probability[nextNode] = probability[currentNode] * succProb[index];
					queue.offer(nextNode);
				}
			}
		}
		
		return probability[end];
	}
	
	/**
	 * time  : O((n + e) * log e)
	 * space : O(n + e)
	 * 
	 * Dijkstra's algorithm
	 * 
	 * Accepted Solutions Runtime Distribution
	 * 
	 * https://leetcode.com/problems/path-with-maximum-probability/discuss/1690471/Analyze-why-Dijkstra's-algorithm-is-appropriate
	 * */
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		List<List<Lcp_1514_Pair>> graph = new ArrayList<>();
		
		for (int i = 0; i < n; i++) { graph.add(new ArrayList<>()); }												// T : O(n)
		
		for (int i = 0; i < edges.length; i++) {																	// T : O(e)
			int from = edges[i][0];
			int to = edges[i][1];
			double distance = succProb[i];
			
			graph.get(from).add(new Lcp_1514_Pair(to, distance));
			graph.get(to).add(new Lcp_1514_Pair(from, distance));
		}
		
		double[] distanceRecord = new double[n];																	// S : O(n)
		distanceRecord[start] = 1D;
		
		Queue<Lcp_1514_Pair> maxHeap = new PriorityQueue<>((offer, previous) -> Double.compare(previous.distance, offer.distance));
		maxHeap.offer(new Lcp_1514_Pair(start, 1D));
		
		while (!maxHeap.isEmpty()) {
			Lcp_1514_Pair current = maxHeap.poll();
			int currentNode = current.node;
			double currentDistance = current.distance;
			
			if (currentNode == end) { return currentDistance; }
			
			for (Lcp_1514_Pair next : graph.get(currentNode)) {
				double newDistance = currentDistance * next.distance;
				
				if (newDistance > distanceRecord[next.node]) {
					distanceRecord[next.node] = newDistance;
					maxHeap.offer(new Lcp_1514_Pair(next.node, newDistance));
				}
			}
		}
		
		return distanceRecord[end];
	}
	
}
