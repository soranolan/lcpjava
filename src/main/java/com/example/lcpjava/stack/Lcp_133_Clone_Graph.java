package com.example.lcpjava.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lcp_133_Clone_Graph {
	
	/**
	 * time  : O(m * n)
	 * space : O(n)
	 * 
	 * if node is equal to null
	 * 		return node
	 * end if
	 * 
	 * Stack<Node> stack <- new Stack
	 * Map<Node, Node> visited <- new HashMap
	 * 
	 * stack push(node)
	 * visited put(node, new Node(node val))
	 * 
	 * while stack is not empty
	 * 		Node top <- stack pop()
	 * 		for Node neighbor from top neighbors
	 * 			if visited does not containsKey(neighbor)
	 * 				stack push(neighbor)
	 * 				visited put(neighbor, new Node(neighbor val))
	 * 			end if
	 * 			visited get(top) neighbors add(visited get(neighbor))
	 * 		end for
	 * end while
	 * 
	 * return visited get(node)
	 * */
	public Node cloneGraph_1(Node node) {
		if (node == null) { return node; }
		
		Stack<Node> stack = new Stack<Node>();
		Map<Node, Node> visited = new HashMap<Node, Node>();														// S : O(n)
		
		stack.push(node);
		visited.put(node, new Node(node.val));
		
		while (!stack.isEmpty()) {																					// T : O(n)
			Node top = stack.pop();
			for (Node neighbor : top.neighbors) {																	// T : O(m)
				if (!visited.containsKey(neighbor)) {
					stack.push(neighbor);
					visited.put(neighbor, new Node(neighbor.val));
				}
				visited.get(top).neighbors.add(visited.get(neighbor));
			}
		}
		
		return visited.get(node);
	}
	
	/**
	 * time  : O(n)
	 * 			O(Edge plus Vertex)
	 * space : O(n)
	 * 
	 * Map<Integer, Node> memo <- new HashMap<>()
	 * return DFS(node, memo)
	 * */
	public Node cloneGraph(Node node) {
		Map<Integer, Node> memo = new HashMap<>();
		return DFS(node, memo);
	}
	
	/**
	 * if node is equal to null
	 * 		return node
	 * end if
	 * 
	 * int val <- node val
	 * if memo containsKey(val)
	 * 		return memo get(val)
	 * end if
	 * 
	 * Node newNode <- new Node(val)
	 * memo put(val, newNode)
	 * 
	 * for Node neighbor in node neighbors
	 * 		newNode neighbors add(DFS(neighbor, memo))
	 * end for
	 * 
	 * return newNode
	 * */
	public Node DFS(Node node, Map<Integer, Node> memo) {
		if (node == null) { return node; }
		
		int val = node.val;
		if (memo.containsKey(val)) { return memo.get(val); }
		
		Node newNode = new Node(val);
		memo.put(val, newNode);
		
		for (Node neighbor : node.neighbors) { newNode.neighbors.add(DFS(neighbor, memo)); }
		
		return newNode;
	}
	
}
