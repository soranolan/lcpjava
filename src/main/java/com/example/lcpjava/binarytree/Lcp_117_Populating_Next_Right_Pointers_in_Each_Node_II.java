package com.example.lcpjava.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.example.lcpjava.common.Lcp_117_Node;

public class Lcp_117_Populating_Next_Right_Pointers_in_Each_Node_II {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return null
	 * end if
	 * 
	 * Queue<Node> queue <- new LinkedList
	 * 
	 * if root right is not equal to null
	 * 		queue offer(root right)
	 * end if
	 * 
	 * if root left is not equal to null
	 * 		queue offer(root left)
	 * end if
	 * 
	 * while queue is not empty
	 * 		Node nextNode <- null
	 * 		int size <- queue size
	 * 		
	 * 		while size is greater than zero
	 * 			size--
	 * 			Node current <- queue poll
	 * 			current next <- nextNode
	 * 			nextNode <- current
	 * 			
	 * 			if current right is not equal to null
	 * 				queue offer(current right)
	 * 			end if
	 * 			
	 * 			if current left is not equal to null
	 * 				queue offer(current left)
	 * 			end if
	 * 		end while
	 * end while
	 * 
	 * return root
	 * */
	public Lcp_117_Node connect_1(Lcp_117_Node root) {
		if (root == null) { return null; }
		
		Queue<Lcp_117_Node> queue = new LinkedList<>();																// S : O(n)
		if (root.right != null) { queue.offer(root.right); }														// T : O(1)
		if (root.left != null) { queue.offer(root.left); }															// T : O(1)
		
		while (!queue.isEmpty()) {																					// T : O(n)
			Lcp_117_Node nextNode = null;
			int size = queue.size();																				// T : O(1)
			while (size > 0) {
				size--;
				Lcp_117_Node current = queue.poll();																// T : O(1)
				current.next = nextNode;
				nextNode = current;
				if (current.right != null) { queue.offer(current.right); }											// T : O(1)
				if (current.left != null) { queue.offer(current.left); }											// T : O(1)
			}
		}
		
		return root;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * DFS(root)
	 * return root
	 * */
	public Lcp_117_Node connect_2(Lcp_117_Node root) {
		DFS(root);
		return root;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * if current left is not equal to null
	 * 		current left next <- if current right is not equal to null then current right else findNext(current)
	 * end if
	 * 
	 * if current right is not equal to null
	 * 		current right next <- findNext(current)
	 * end if
	 * 
	 * if current right is not equal to null
	 * 		DFS(current right)
	 * end if
	 * 
	 * if current left is not equal to null
	 * 		DFS(current left)
	 * end if
	 * */
	public void DFS(Lcp_117_Node current) {
		if (current == null) { return; }
		if (current.left != null) { current.left.next = (current.right != null) ? current.right : findNext(current); }
		if (current.right != null) { current.right.next = findNext(current); }
		if (current.right != null) { DFS(current.right); }
		if (current.left != null) { DFS(current.left); }
	}
	
	/**
	 * Node temp <- current
	 * 
	 * while temp next is not equal to null
	 * 		temp <- temp next
	 * 		
	 * 		if temp left is not equal to null
	 * 			return temp left
	 * 		end if
	 * 		
	 * 		if temp right is not equal to null
	 * 			return temp right
	 * 		end if
	 * end while
	 * 
	 * return null
	 * */
	public Lcp_117_Node findNext(Lcp_117_Node current) {
		Lcp_117_Node temp = current;
		while (temp.next != null) {
			temp = temp.next;
			if (temp.left != null) { return temp.left; }
			if (temp.right != null) { return temp.right; }
		}
		return null;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Node head <- new Node(0)
	 * Node tail <- head
	 * Node current <- root
	 * 
	 * while current is not equal to null
	 * 		if current left is not equal to null
	 * 			tail next <- current left
	 * 			tail <- tail next
	 * 		end if
	 * 		
	 * 		if current right is not equal to null
	 * 			tail next <- current right
	 * 			tail <- tail next
	 * 		end if
	 * 		
	 * 		current <- current next
	 * 		
	 * 		if current is equal to null
	 * 			current <- head next
	 * 			head next <- null
	 * 			tail <- head
	 * 		end if
	 * end while
	 * 
	 * return root
	 * */
	public Lcp_117_Node connect(Lcp_117_Node root) {
		Lcp_117_Node head = new Lcp_117_Node(0);
		Lcp_117_Node tail = head;
		Lcp_117_Node current = root;
		
		while (current != null) {
			if (current.left != null) {
				tail.next = current.left;
				tail = tail.next;
			}
			
			if (current.right != null) {
				tail.next = current.right;
				tail = tail.next;
			}
			
			current = current.next;
			if (current == null) {
				current = head.next;																				// root <- root left node
				head.next = null;
				tail = head;
			}
		}
		
		return root;
	}
	
}
