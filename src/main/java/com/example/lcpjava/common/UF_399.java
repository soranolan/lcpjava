package com.example.lcpjava.common;

import java.util.HashMap;
import java.util.Map;

public class UF_399 {
	
	public Map<String, String> parents;
	
	public Map<String, Double> values;
	
	public UF_399() {
		parents = new HashMap<>();
		values = new HashMap<>();
	}
	
	/**
	 * time  : O(1)
	 * */
	public void add(String x) {
		if (parents.containsKey(x)) { return; }
		
		parents.put(x, x);
		values.put(x, 1.0);
	}
	
	/**
	 * time  : O(n)
	 * */
	public String find(String x) {
		String parent = parents.get(x);
		if (parent == null) { parent = x; }
		
		if (x != parent) {
			String grandParent = find(parent);
			parents.put(x, grandParent);
			values.put(x, values.get(x) * values.get(parent));
		}
		
		return parents.get(x) == null ? x : parents.get(x);
	}
	
	/**
	 * time  : O(n)
	 * */
	public void union(String x, String y, double value) {
		add(x);
		add(y);
		
		String parentX = find(x);
		String parnetY = find(y);
		
		parents.put(parentX, parnetY);
		values.put(parentX, value * values.get(y) / values.get(x));
	}
	
}
