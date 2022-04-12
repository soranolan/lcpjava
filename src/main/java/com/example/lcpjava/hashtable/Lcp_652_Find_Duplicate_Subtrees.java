package com.example.lcpjava.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.lcpjava.common.TreeNode;

public class Lcp_652_Find_Duplicate_Subtrees {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<TreeNode> result <- new ArrayList
	 * Set<String> firstTime <- new HashSet
	 * Set<String> secondTime <- new HashSet
	 * 
	 * postOrder(root, firstTime, secondTime, result)
	 * 
	 * return result
	 * */
	public List<TreeNode> findDuplicateSubtrees_1(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		Set<String> firstTime = new HashSet<>();																	// S : O(n)
		Set<String> secondTime = new HashSet<>();																	// S : O(n)
		
		postOrder_1(root, firstTime, secondTime, result);
		
		return result;
	}
	
	/**
	 * if current is equal to null
	 * 		return "N"
	 * end if
	 * 
	 * String left <- postOrder(current left, firstTime, secondTime, result)
	 * String right <- postOrder(current right, firstTime, secondTime, result)
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * sb append(current val) append(",") append(left) append(",") append(right)
	 * String key <- sb to string
	 * 
	 * if firstTime contains(key) && secondTime does not containsKey(key)
	 * 		secondTime add(key)
	 * 		result add(current)
	 * else
	 * 		firstTime add(key)
	 * end if
	 * 
	 * return key
	 * */
	public String postOrder_1(TreeNode current, Set<String> firstTime, Set<String> secondTime, List<TreeNode> result) {
		if (current == null) { return "N"; }
		
		String left = postOrder_1(current.left, firstTime, secondTime, result);
		String right = postOrder_1(current.right, firstTime, secondTime, result);
		
		StringBuilder sb = new StringBuilder();
		sb.append(current.val).append(",").append(left).append(",").append(right);									// T : O(length of characters)
		String key = sb.toString();
		
		if (firstTime.contains(key) && !secondTime.contains(key)) {													// T : O(1)
			secondTime.add(key);																					// T : O(1)
			result.add(current);																					// T : O(1)
		} else {
			firstTime.add(key);																						// T : O(1)
		}
		
		return key;
	}
	
	/**
	 * time  : O(n ^ 2) string concatenation takes O(n) time
	 * space : O(n ^ 2)
	 * 
	 * List<TreeNode> result <- new ArrayList
	 * Map<String, Integer> visited <- new HashMap
	 * 
	 * postOrder(root, visited, result)
	 * 
	 * return result
	 * */
	public List<TreeNode> findDuplicateSubtrees_2(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		Map<String, Integer> visited = new HashMap<>();																// S : O(n)
		
		postOrder_2(root, visited, result);
		
		return result;
	}
	
	/**
	 * if current is equal to null
	 * 		return "N"
	 * end if
	 * 
	 * String left <- "L" concatenate postOrder(current left, visited, result)
	 * String right <- "R" concatenate postOrder(current right, visited, result)
	 * String key <- "C" concatenate current val concatenate left concatenate right
	 * 
	 * int count <- visited getOrDefault(key, zero) plus one
	 * 
	 * if count is equal to two
	 * 		result add(current)
	 * end if
	 * 
	 * visited put(key, count)
	 * 
	 * return key
	 * */
	public String postOrder_2(TreeNode current, Map<String, Integer> visited, List<TreeNode> result) {
		if (current == null) { return "N"; }
		
		String left = "L" + postOrder_2(current.left, visited, result);												// T : O(n)
		String right = "R" + postOrder_2(current.right, visited, result);											// T : O(n)
		String key = "C" + current.val + left + right;																// T : O(n)
		
		int count = visited.getOrDefault(key, 0) + 1;
		if (count == 2) { result.add(current); }																	// T : O(1)
		visited.put(key, count);																					// T : O(1)
		
		return key;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<TreeNode> result <- new ArrayList
	 * Map<String, Integer> countMap <- new HashMap
	 * 
	 * postOrder(root, countMap, result)
	 * 
	 * return result
	 * */
	public List<TreeNode> findDuplicateSubtrees_3(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		Map<String, Integer> countMap = new HashMap<>();															// S : O(n)
		
		postOrder_3(root, countMap, result);
		
		return result;
	}
	
	/**
	 * if current is equal to null
	 * 		return "N"
	 * end if
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * sb append("C") append(current val)
	 * 
	 * if current left is not equal to null || current right is not equal to null
	 * 		String left <- postOrder(current left, countMap, result)
	 * 		String right <- postOrder(current right, countMap, result)
	 * 		sb append(left) append(right)
	 * end if
	 * 
	 * String key <- sb to string
	 * 
	 * int count <- countMap getOrDefault(key, zero) plus one
	 * countMap put(key, count)
	 * 
	 * if count is equal to two
	 * 		result add(current)
	 * end if
	 * 
	 * return key
	 * */
	public String postOrder_3(TreeNode current, Map<String, Integer> countMap, List<TreeNode> result) {
		if (current == null) { return "N"; }
		
		StringBuilder sb = new StringBuilder();
		sb.append("C").append(current.val);																			// T : O(length of characters)
		
		if (current.left != null || current.right != null) {
			String left = postOrder_3(current.left, countMap, result);
			String right = postOrder_3(current.right, countMap, result);
			sb.append(left).append(right);																			// T : O(length of characters)
		}
		
		String key = sb.toString();
		
		int count = countMap.getOrDefault(key, 0) + 1;
		countMap.put(key, count);																					// T : O(1)
		if (count == 2) { result.add(current); }																	// T : O(1)
		
		return key;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<TreeNode> result <- new ArrayList
	 * Map<String, Integer> serialMap <- new HashMap
	 * Map<Integer, Integer> countMap <- new HashMap
	 * 
	 * postOrder(root, serialMap, countMap, result)
	 * 
	 * return result
	 * */
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		Map<String, Integer> serialMap = new HashMap<>();															// S : O(n)
		Map<Integer, Integer> countMap = new HashMap<>();															// S : O(n)
		
		postOrder(root, serialMap, countMap, result);
		
		return result;
	}
	
	/**
	 * if current is equal to null
	 * 		return zero
	 * end if
	 * 
	 * int left <- postOrder(current left, serialMap, countMap, result)
	 * int right <- postOrder(current right, serialMap, countMap, result)
	 * int root <- current val
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * sb append(root) append(left) append(right)
	 * String key <- sb to string
	 * 
	 * int serialId <- serialMap getOrDefault(key, defaultId)
	 * if serialId is equal to defaultId
	 * 		defaultId++
	 * end if
	 * serialMap put(key, serialId)
	 * 
	 * int count <- countMap getOrDefault(serialId, zero) plus one
	 * countMap put(serialId, count)
	 * if count is equal to two
	 * 		result add(current)
	 * end if
	 * 
	 * return serialId
	 * */
	int defaultId = 1;
	private int postOrder(TreeNode current, Map<String, Integer> serialMap, Map<Integer, Integer> countMap, List<TreeNode> result) {
		if (current == null) { return 0; }
		
		int left = postOrder(current.left, serialMap, countMap, result);
		int right = postOrder(current.right, serialMap, countMap, result);
		int root = current.val;
		
		StringBuilder sb = new StringBuilder();
		sb.append(root).append(left).append(right);																	// T : O(length of characters)
		String key = sb.toString();
		
		int serialId = serialMap.getOrDefault(key, defaultId);
		if (serialId == defaultId) { defaultId++; }
		serialMap.put(key, serialId);																				// T : O(1)
		
		int count = countMap.getOrDefault(serialId, 0) + 1;
		countMap.put(serialId, count);																				// T : O(1)
		if (count == 2) { result.add(current); }																	// T : O(1)
		
		return serialId;
	}
	
}
