package com.example.lcpjava.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/throne-inheritance/discuss/866400/Textbook-DFS-Problem-with-convoluted-wording
 * */
public class ThroneInheritance_1 {
	
	private String kingName;
	
	private Map<String, List<String>> parent2Child;																	// S : O(n)
	
	private Set<String> deathNote;																					// S : O(m)
	
	/**
	 * time  : O(1)
	 * space : O(n + m)
	 * */
	public ThroneInheritance_1(String kingName) {
		this.kingName = kingName;
		
		parent2Child = new HashMap<>();
		parent2Child.put(kingName, new ArrayList<>());																// T : O(1)
		
		deathNote = new HashSet<>();
	}
	
	/**
	 * time  : O(α(n))
	 * space : O(1)
	 * */
	public void birth(String parentName, String childName) {
		List<String> child = parent2Child.get(parentName);															// T : O(1)
		child.add(childName);																						// T : O(α(n))
		
		parent2Child.put(parentName, child);																		// T : O(1)
		parent2Child.put(childName, new ArrayList<>());																// T : O(1)
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public void death(String name) {
		deathNote.add(name);																						// T : O(1)
	}
	
	/**
	 * time  : O(child)
	 * space : O(height)
	 * */
	public List<String> getInheritanceOrder() {
		List<String> inheritanceOrder = new ArrayList<>();
		
		successor(kingName, inheritanceOrder);
		
		return inheritanceOrder;
	}
	
	/**
	 * time  : O(child)
	 * space : O(height)
	 * */
	private void successor(String name, List<String> inheritanceOrder) {
		if (!deathNote.contains(name)) { inheritanceOrder.add(name); }												// T : O(1)
		
		List<String> child = parent2Child.get(name);																// T : O(1)
		
		for (String childName : child) { successor(childName, inheritanceOrder); }									// T : O(child)
	}
	
}
