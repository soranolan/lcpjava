package com.example.lcpjava.tool;

import java.util.LinkedList;
import java.util.Queue;

import com.example.lcpjava.common.TreeNode;

public class BuildTree {
	
	public TreeNode preorder(Integer[] nodes) {
		TreeNode root = new TreeNode(nodes[0]);
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		int index = 1;
		
		while (!queue.isEmpty() && index < nodes.length) {
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
	
}
