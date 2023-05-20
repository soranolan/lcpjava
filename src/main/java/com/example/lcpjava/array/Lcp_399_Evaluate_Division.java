package com.example.lcpjava.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.lcpjava.common.UF_399;

public class Lcp_399_Evaluate_Division {
	
	/**
	 * time  : O(2 * n * m)
	 * space : O(2 * n)
	 * 
	 * prefer
	 * 
	 * https://leetcode.com/problems/evaluate-division/solutions/1992891/java-dfs-solution-with-comments-evaluate-division/
	 * https://leetcode.com/problems/evaluate-division/solutions/3018674/explained-dfs-solution-with-time-and-space-complexity/
	 * */
	public double[] calcEquation_1(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> graph = buildGraph(equations, values);										// T : O(n)
		
		int querySize = queries.size();
		double[] result = new double[querySize];
		for (int i = 0; i < querySize; i++) {																		// T : O(m : queries)
			List<String> query = queries.get(i);
			String x = query.get(0);
			String y = query.get(1);
			Set<String> visited = new HashSet<>();																	// S : O(n * 2)
			result[i] = dfs(x, y, visited, graph);																	// T : O(vertices : n * 2, every equation can have maximum 2 unique variables)
		}
		
		return result;
	}
	
	private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
		Map<String, Map<String, Double>> graph = new HashMap<>();													// S : O(n * 2)
		
		for (int i = 0; i < equations.size(); i++) {																// T : O(n : equations)
			List<String> equation = equations.get(i);
			String x = equation.get(0);
			String y = equation.get(1);
			
			if (!graph.containsKey(x)) { graph.put(x, new HashMap<>()); }
			graph.get(x).put(y, values[i]);
			if (!graph.containsKey(y)) { graph.put(y, new HashMap<>()); }
			graph.get(y).put(x, 1 / values[i]);
		}
		
		return graph;
	}
	
	private double dfs(String x, String y, Set<String> visited, Map<String, Map<String, Double>> graph) {
		if (!graph.containsKey(x) || !graph.containsKey(y)) { return -1.0; }
		
		if (graph.get(x).containsKey(y)) {
			return graph.get(x).get(y);
		}
		
		visited.add(x);
		
		for (Map.Entry<String, Double> entry : graph.get(x).entrySet()) {
			if (visited.contains(entry.getKey())) { continue; }
			
			double value = dfs(entry.getKey(), y, visited, graph);
			
			if (value != -1.0) { return entry.getValue() * value; }
		}
		
		return -1.0;
	}
	
	/**
	 * time  : O(queries * equations * 2)
	 * space : O(equations)
	 * 
	 * hard to bug free
	 * 
	 * https://leetcode.com/problems/evaluate-division/solutions/278276/java-union-find-and-dfs-query-o-1/
	 * https://leetcode.com/problems/evaluate-division/solutions/119928/best-and-elegant-union-find-in-python-with-analysis/
	 * https://leetcode.com/problems/evaluate-division/solutions/183185/java-unionfind-vs-dfs-time-complexity-analysis/
	 * */
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		double[] result = new double[queries.size()];
		
		UF_399 uf = new UF_399();
		
		for (int i = 0; i < values.length; i++) {
			uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
		}
		
		for (int i = 0; i < queries.size(); i++) {
			String x = queries.get(i).get(0);
			String y = queries.get(i).get(1);
			
			if (!uf.parents.containsKey(x) || !uf.parents.containsKey(y) || uf.find(x) != uf.find(y)) {
				result[i] = -1.0;
			} else {
				result[i] = uf.values.get(x) / uf.values.get(y);
			}
		}
		
		return result;
	}
	
}
