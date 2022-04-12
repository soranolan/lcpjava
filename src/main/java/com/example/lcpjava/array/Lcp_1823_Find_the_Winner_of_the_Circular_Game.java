package com.example.lcpjava.array;

import java.util.LinkedList;
import java.util.Queue;

import com.example.lcpjava.common.Lcp_1823_Node;

public class Lcp_1823_Find_the_Winner_of_the_Circular_Game {
	
	/**
	 * time  : O(n * k)
	 * space : O(n)
	 * 
	 * Queue<Integer> queue <- new LinkedList
	 * 
	 * for int i <- 1; if i is lower than or equal to n; i++
	 * 		queue offer(i)
	 * end for
	 * 
	 * int count <- 1
	 * 
	 * while queue size is greater than one
	 * 		int num <- queue poll
	 * 		
	 * 		if count is lower than k
	 * 			queue offer(num)
	 * 			count++
	 * 		else
	 * 			count <- 1
	 * 		end if
	 * end while
	 * 
	 * return queue poll
	 * */
	public int findTheWinner_1(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();																	// S : O(n)
		for (int i = 1; i <= n; i++) { queue.offer(i); }															// T : O(n)
		
		int count = 1;
		
		while (queue.size() > 1) {																					// T : O(n)
			int num = queue.poll();
			
			if (count < k) {																						// T : O(k)
				queue.offer(num);
				count++;
			} else {
				count = 1;
			}
		}
		
		return queue.poll();
	}
	
	/**
	 * time  : O(n * k)
	 * space : O(k)
	 * 
	 * Maintain in a circular list
	 * https://leetcode.com/problems/find-the-winner-of-the-circular-game/discuss/1157717/Java-full-solution-and-explanation
	 * 
	 * Node tail <- buildCircularList(n)
	 * 
	 * for int i <- 0; if i is lower than n; i++
	 * 		for int j <- 0; if j is lower than k; j++
	 * 			tail <- tail next
	 * 		end for
	 * 		
	 * 		tail next prev <- tail prev
	 * 		tail prev next <- tail next
	 * end for
	 * 
	 * return tail next num
	 * */
	public int findTheWinner_2(int n, int k) {
		Lcp_1823_Node tail = buildCircularList(n);
		
		for (int i = 0; i < n; i++) {																				// T : O(n)
			for (int j = 0; j < k; j++) { tail = tail.next; }														// T : O(k)
			
			tail.next.prev = tail.prev;
			tail.prev.next = tail.next;
		}
		
		return tail.next.num;
	}
	
	/**
	 * Node head <- new Node(1)
	 * Node tail <- head
	 * 
	 * for int i <- 2; if i is lower than or equal to n; i++
	 * 		Node current <- new Node(i)
	 * 		tail next <- current
	 * 		current prev <- tail
	 * 		tail <- current
	 * end for
	 * 
	 * head prev <- tail
	 * tail next <- head
	 * 
	 * return tail
	 * */
	public Lcp_1823_Node buildCircularList(int n) {
		Lcp_1823_Node head = new Lcp_1823_Node(1);
		Lcp_1823_Node tail = head;
		
		for (int i = 2; i <= n; i++) {																				// T : O(n - 1)
			Lcp_1823_Node current = new Lcp_1823_Node(i);
			tail.next = current;
			current.prev = tail;
			tail = current;
		}
		
		head.prev = tail;
		tail.next = head;
		
		return tail;
	}
	
	/**
	 * Josephus problem
	 * 
	 * https://zh.wikipedia.org/wiki/%E7%BA%A6%E7%91%9F%E5%A4%AB%E6%96%AF%E9%97%AE%E9%A2%98
	 * https://leetcode.com/problems/find-the-winner-of-the-circular-game/discuss/1157717/Java-full-solution-and-explanation
	 * 
	 * 1,2,3,4
	 * 1,3
	 * 1
	 * 
	 * f(2 * n) = 2 * f(n) - 1
	 * 
	 * 1,2,3,4,5
	 * 1,3,5
	 * 3,5
	 * 3
	 * 
	 * f(2 * n + 1) = 2 * f(n) + 1
	 * */
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Math is the king!
	 * */
	public int findTheWinner_3(int n, int k) {
		return recursion(n, k) + 1;
	}
	
	public int recursion(int n, int k) {
		if (n == 1) {
			return 0;
		} else {
			return (recursion(n - 1, k) + k) % n;
		}
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Math is the king!
	 * */
	public int findTheWinner(int n, int k) {
		int result = 0;
		
		for (int i = 1; i <= n; i++) {
			result = (result + k) % i;
		}
		
		return result + 1;
	}
	
}
