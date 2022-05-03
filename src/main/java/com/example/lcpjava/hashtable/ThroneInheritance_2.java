package com.example.lcpjava.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.lcpjava.common.RoyalFamily;

/**
 * https://leetcode.com/problems/throne-inheritance/discuss/877922/java-solution-N-ary
 * */
public class ThroneInheritance_2 {
	
	private String kingName;
	
	private Map<String, RoyalFamily> parent2Child;																	// S : O(n)
	
	/**
	 * time  : O(1)
	 * space : O(n)
	 * */
	public ThroneInheritance_2(String kingName) {
		this.kingName = kingName;
		parent2Child = new HashMap<>();
		
		RoyalFamily king = new RoyalFamily(kingName);
		parent2Child.put(kingName, king);																			// T : O(1)
	}
	
	/**
	 * time  : O(α(n))
	 * space : O(1)
	 * */
	public void birth(String parentName, String childName) {
		RoyalFamily child = new RoyalFamily(childName);
		RoyalFamily parent = parent2Child.get(parentName);															// T : O(1)
		parent.childs.add(child);																					// T : O(α(n))
		parent2Child.put(childName, child);																			// T : O(1)
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public void death(String name) {
		parent2Child.get(name).isDead = true;																		// T : O(1)
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
		RoyalFamily rf = parent2Child.get(name);																	// T : O(1)
		if (!rf.isDead) { inheritanceOrder.add(name); }																// T : O(1)
		
		for (RoyalFamily child : rf.childs) { successor(child.name, inheritanceOrder); }							// T : O(child)
	}
	
}
