package com.example.lcpjava.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.example.lcpjava.common.N_Ary_TreeNode;
import com.example.lcpjava.common.TreeNode;

public class BuildTree {
	
	public TreeNode preorder(Integer[] nodes) {
		int length = nodes.length;
		if (nodes == null || length == 0) { return null; }
		if (length % 2 == 0) { throw new AssertionError(Arrays.deepToString(nodes) + " length is even, should be odd"); }
		
		TreeNode root = new TreeNode(nodes[0]);
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		int index = 1;
		
		while (!queue.isEmpty() && index < length) {
			TreeNode current = queue.poll();
			if (current == null) { continue; }
			
			TreeNode node = null;
			Integer temp = nodes[index++];
			if (temp != null) {
				node = new TreeNode(temp);
				current.left = node;
			}
			queue.offer(node);
			
			node = null;
			temp = nodes[index++];
			if (temp != null) {
				node = new TreeNode(temp);
				current.right = node;
			}
			queue.offer(node);
		}
		
		return root;
	}
	
	public N_Ary_TreeNode n_ary_levelorder(Integer[] nodes) {
		int length = nodes.length;
		if (nodes == null || length == 0) { return null; }
		
		N_Ary_TreeNode root = new N_Ary_TreeNode(nodes[0], new ArrayList<>());
		
		Queue<N_Ary_TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		// skip the first null
		int index = 2;
		
		while (!queue.isEmpty() && index < length) {
			N_Ary_TreeNode current = queue.poll();
			List<N_Ary_TreeNode> children = current.children;
			
			// Each group of children is separated by the null value
			while (index < length && nodes[index] != null) {
				N_Ary_TreeNode child = new N_Ary_TreeNode(nodes[index++], new ArrayList<>());
				children.add(child);
				queue.offer(child);
			}
			
			index++;
		}
		
		return root;
	}
	
}
