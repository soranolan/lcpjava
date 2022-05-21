package com.example.lcpjava.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.lcpjava.common.TreeNode;

public class Lcp_1305_All_Elements_in_Two_Binary_Search_Trees {
	
	/**
	 * time  : O(n log n)
	 * space : O(height)
	 * 
	 * store value in one list, then sort it
	 * */
	public List<Integer> getAllElements_1(TreeNode root1, TreeNode root2) {
		List<Integer> elements = new ArrayList<>();
		
		DFS(root1, elements);																						// T : O(n)
		DFS(root2, elements);																						// T : O(n)
		
		Collections.sort(elements);																					// T : O(n log n)
		
		return elements;
	}
	
	private void DFS(TreeNode current, List<Integer> elements) {
		if (current == null) { return; }
		
		elements.add(current.val);
		
		DFS(current.left, elements);
		DFS(current.right, elements);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * store value in two list (inorder), then merge it
	 * */
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> elements = new ArrayList<>();
		List<Integer> elements1 = new ArrayList<>();																// S : O(n)
		List<Integer> elements2= new ArrayList<>();																	// S : O(n)
		
		inorder(root1, elements1);																					// T : O(n)
		inorder(root2, elements2);																					// T : O(n)
		
		int left = 0;
		int right = 0;
		
		while (left < elements1.size() && right < elements2.size()) {												// T : O(n)
			int L = elements1.get(left);
			int R = elements2.get(right);
			
			if (L < R) {
				elements.add(L);
				left++;
			} else {
				elements.add(R);
				right++;
			}
		}
		
		while (left < elements1.size()) { elements.add(elements1.get(left++)); }									// T : O(n)
		
		while (right < elements2.size()) { elements.add(elements2.get(right++)); }									// T : O(n)
		
		return elements;
	}
	
	private void inorder(TreeNode current, List<Integer> elements) {
		if (current == null) { return; }
		
		DFS(current.left, elements);
		elements.add(current.val);
		DFS(current.right, elements);
	}
	
}
