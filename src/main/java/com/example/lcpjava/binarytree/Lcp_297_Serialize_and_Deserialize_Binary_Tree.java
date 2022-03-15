package com.example.lcpjava.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Lcp_297_Serialize_and_Deserialize_Binary_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return null
	 * end if
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * Queue<TreeNode> queue <- new LinkedList
	 * queue offer(root)
	 * 
	 * while queue is not empty
	 * 		TreeNode current <- queue poll
	 * 		if current is equal to null
	 * 			sb append("N,")
	 * 			continue
	 * 		end if
	 * 		
	 * 		sb append(current val) append(",")
	 * 		queue offer(current left)
	 * 		queue offer(current right)
	 * end while
	 * 
	 * return sb to string
	 * */
	public String serialize_1(TreeNode root) {
		if (root == null) { return null; }
		
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		Queue<TreeNode> queue = new LinkedList<>();																	// S : O(n)
		queue.offer(root);																							// T : O(1)
		
		while (!queue.isEmpty()) {																					// T : O(n)
			TreeNode current = queue.poll();																		// T : O(1)
			if (current == null) {
				sb.append("N,");																					// T : O(1)
				continue;
			}
			
			sb.append(current.val).append(",");																		// T : O(1)
			queue.offer(current.left);																				// T : O(1)
			queue.offer(current.right);																				// T : O(1)
		}
		
		return sb.toString();
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return null
	 * end if
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * 
	 * preorder(root, sb)
	 * 
	 * return sb to string
	 * */
	public String serialize(TreeNode root) {
		if (root == null) { return null; }
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		preorder(root, sb);
		return sb.toString();
	}
	
	/**
	 * if current is equal to null
	 * 		sb append("N,")
	 * 		return
	 * end if
	 * 
	 * sb append(current val) append(",")
	 * preorder(current left, sb)
	 * preorder(current right, sb)
	 * */
	public void preorder(TreeNode current, StringBuilder sb) {
		if (current == null) {
			sb.append("N,");																						// T : O(1)
			return;
		}
		
		sb.append(current.val).append(",");																			// T : O(1)
		preorder(current.left, sb);
		preorder(current.right, sb);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if data is equal to null
	 * 		return null
	 * end if
	 * 
	 * String[] values <- data split(",")
	 * TreeNode root <- new TreeNode(Integer valueOf(values[0]))
	 * 
	 * Queue<TreeNode> queue <- new LinkedList
	 * queue offer(root)
	 * 
	 * for int i <- 1; if i is lower than values length; i++
	 * 		TreeNode parent <- queue poll
	 * 		if parent is not equal to "N"
	 * 			TreeNode left <- new TreeNode(Integer valueOf(values[i]))
	 * 			parent left <- left
	 * 			queue offer(left)
	 * 		end if
	 * 		
	 * 		i++
	 * 		
	 * 		if parent is not equal to "N"
	 * 			TreeNode right <- new TreeNode(Integer valueOf(values[i]))
	 * 			parent right <- right
	 * 			queue offer(right)
	 * 		end if
	 * end for
	 * 
	 * return root
	 * */
	public TreeNode deserialize_1(String data) {
		if (data == null) { return null; }
		
		String[] values = data.split(",");																			// T : O(n)
		TreeNode root = new TreeNode(Integer.valueOf(values[0]));
		
		Queue<TreeNode> queue = new LinkedList<>();																	// S : O(n)
		queue.offer(root);																							// T : O(1)
		
		for (int i = 1; i < values.length; i++) {																	// T : O(n)
			TreeNode parent = queue.poll();																			// T : O(1)
			if (!"N".equals(values[i])) {
				TreeNode left = new TreeNode(Integer.valueOf(values[i]));
				parent.left = left;
				queue.offer(left);																					// T : O(1)
			}
			i++;
			if (!"N".equals(values[i])) {
				TreeNode right = new TreeNode(Integer.valueOf(values[i]));
				parent.right = right;
				queue.offer(right);																					// T : O(1)
			}
		}
		
		return root;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if data is equal to null
	 * 		return null
	 * end if
	 * 
	 * Queue<String> queue <- new LinkedList
	 * String[] values <- data split(",")
	 * 
	 * for String value in values
	 * 		queue offer(value)
	 * end for
	 * 
	 * return rebuild(queue)
	 * */
	public TreeNode deserialize_2(String data) {
		if (data == null) { return null; }
		Queue<String> queue = new LinkedList<>();																	// S : O(n)
		String[] values = data.split(",");																			// T : O(n)
		for (String value : values) { queue.offer(value); }															// T : O(n)
		return rebuild_1(queue);
	}
	
	/**
	 * if queue is empty
	 * 		return null
	 * end if
	 * 
	 * String value <- queue poll
	 * if "N" is equal to value
	 * 		return null
	 * end if
	 * 
	 * TreeNode current <- new TreeNode(Integer valueOf(value))
	 * current left <- rebuild(queue)
	 * current right <- rebuild(queue)
	 * 
	 * return current
	 * */
	public TreeNode rebuild_1(Queue<String> queue) {
		if (queue.isEmpty()) { return null; }																		// T : O(1)
		String value = queue.poll();																				// T : O(1)
		if ("N".equals(value)) { return null; }
		
		TreeNode current = new TreeNode(Integer.valueOf(value));
		current.left = rebuild_1(queue);
		current.right = rebuild_1(queue);
		
		return current;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if data is equal to null
	 * 		return null
	 * end if
	 * 
	 * index <- 0
	 * 
	 * String[] values <- data split(",")
	 * 
	 * return rebuild(values length, values)
	 * */
	int index;
	public TreeNode deserialize_3(String data) {
		if (data == null) { return null; }
		index = 0;
		String[] values = data.split(",");																			// T : O(n)
		return rebuild_2(values.length, values);
	}
	
	/**
	 * if index is equal to size
	 * 		return null
	 * end if
	 * 
	 * String value <- values[index]
	 * if "N" is equal to value
	 * 		return null
	 * end if
	 * 
	 * TreeNode current <- new TreeNode(Integer valueOf(value))
	 * 
	 * index++
	 * current left <- rebuild(size, values)
	 * 
	 * index++
	 * current right <- rebuild(size, values)
	 * 
	 * return current
	 * */
	public TreeNode rebuild_2(int size, String[] values) {
		if (index == size) { return null; }
		String value = values[index];
		if ("N".equals(value)) { return null; }
		
		TreeNode current = new TreeNode(Integer.valueOf(value));
		
		index++;
		current.left = rebuild_2(size, values);
		
		index++;
		current.right = rebuild_2(size, values);
		
		return current;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if data is equal to null
	 * 		return null
	 * end if
	 * 
	 * index <- 0
	 * 
	 * return rebuild(data)
	 * */
	public TreeNode deserialize(String data) {
		if (data == null) { return null; }
		index = 0;
		return rebuild(data);
	}
	
	/**
	 * if data charAt(index) is equal to 'N'
	 * 		index <- index plus two
	 * 		return null
	 * end if
	 * 
	 * boolean isMinus <- false
	 * if data charAt(index) is equal to '-'
	 * 		isMinus <- true
	 * 		index++
	 * end if
	 * 
	 * int number <- 0
	 * while data charAt(index) is not equal to ','
	 * 		number <- (number times ten) plus (data charAt(index) minus '0')
	 * 		index++
	 * end while
	 * index++
	 * 
	 * if isMinus
	 * 		number <- minus number
	 * end if
	 * 
	 * TreeNode current <- new TreeNode(number)
	 * current left <- rebuild(data)
	 * current right <- rebuild(data)
	 * 
	 * return current
	 * */
	public TreeNode rebuild(String data) {
		if (data.charAt(index) == 'N') {																			// T : O(1)
			index += 2;
			return null;
		}
		
		boolean isMinus = false;
		if (data.charAt(index) == '-') {																			// T : O(1)
			isMinus = true;
			index++;
		}
		
		int number = 0;
		while (data.charAt(index) != ',') {																			// T : O(n)
			number = number * 10 + data.charAt(index) - '0';														// T : O(1)
			index++;
		}
		index++;
		
		if (isMinus) { number = -number; }
		
		TreeNode current = new TreeNode(number);
		current.left = rebuild(data);
		current.right = rebuild(data);
		
		return current;
	}
	
}
