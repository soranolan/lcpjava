package com.example.lcpjava.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lcp_382_Linked_List_Random_Node {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<Integer> bucket
	 * 
	 * ListNode temp <- head
	 * 
	 * while temp is not equal to null
	 * 		bucket add(temp val)
	 * 		temp <- temp next
	 * end while
	 * */
	List<Integer> bucket;																							// S : O(n)
	public void Solution_1(ListNode head) {
		bucket = new ArrayList<>();
		ListNode temp = head;
		while (temp != null) {																						// T : O(n)
			bucket.add(temp.val);																					// T : O(1)
			temp = temp.next;
		}
	}
	
	/**
	 * Random random <- new Random
	 * 
	 * int index <- random nextInt(bucket size)
	 * 
	 * return bucket get(index)
	 * */
	public int getRandom_1() {
		Random random = new Random();
		int index = random.nextInt(bucket.size());
		return bucket.get(index);																					// T : O(1)
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Reservoir Sampling
	 * https://www.youtube.com/watch?v=A1iwzSew5QY
	 * https://leetcode.com/problems/linked-list-random-node/discuss/85662/java-solution-with-cases-explain
	 * */
	ListNode newHead;
	public void Solution(ListNode head) {
		newHead = head;
	}
	
	/**
	 * Random random <- new Random
	 * ListNode temp <- newHead
	 * int count <- zero
	 * int result <- temp val
	 * 
	 * while temp is not equal to null
	 * 		if random nextInt(count plus one) is equal to count
	 * 			result <- temp val
	 * 		end if
	 * 		
	 * 		count++
	 * 		temp <- temp next
	 * end while
	 * 
	 * return result
	 * */
	public int getRandom() {
		Random random = new Random();
		ListNode temp = newHead;
		int count = 0;
		int result = temp.val;
		
		while (temp != null) {																						// T : O(n)
			if (random.nextInt(count + 1) == count) { result = temp.val; }
			count++;
			temp = temp.next;
		}
		
		return result;
	}
	
}
