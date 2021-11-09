package com.example.lcpjava.queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Lcp_752_Open_the_Lock {
	
	/**
	 * time  : O(10 ^ n)
	 * space : O(n)
	 * 
	 * Queue<String> queue <- new LinkedList
	 * Set<String> deadend <- new HashSet(Arrays.asList(deadends))
	 * Set<String> visited <- new HashSet
	 * String initial <- 0000;
	 * int moves <- 0
	 * 
	 * queue.offer(initial)
	 * visited.add(initial)
	 * 
	 * while queue is not empty
	 * 		int size <- queue size
	 * 		
	 * 		while size is greate than zero
	 * 			String lock <- queue poll
	 * 			if lock is equal to target
	 * 				return moves
	 * 			end if
	 * 			size--
	 * 			if deadend contains lock
	 * 				continue
	 * 			end if
	 * 			
	 * 			StringBuilder sb <- new StringBuilder(lock)
	 * 			for int i <- 0; if i is lower than four; i++
	 * 				char number <- sb charAt(i)
	 * 				String prefix <- sb substring(0, i)
	 * 				String postfix <- sb substring(i plus one)
	 * 				String rollUp <- prefix plus (if number is equal to '9' then 0 else number minus '0' plus one) plus postfix
	 * 				String rollDown <- prefix plus (if number is equal to '0' then 9 else number minus '0' minus one) plus postfix
	 * 				
	 * 				if visited does not contain rollUp && deadend does not contain rollUp
	 * 					queue offer(rollUp)
	 * 					visited add(rollUp)
	 * 				end if
	 * 				if visited does not contain rollDown && deadend does not contain rollDown
	 * 					queue offer(rollDown)
	 * 					visited add(rollDown)
	 * 				end if
	 * 			end for
	 * 		end while
	 * 		moves++
	 * end while
	 * 
	 * return -1
	 * */
	public int openLock_1(String[] deadends, String target) {
		Queue<String> queue = new LinkedList<>();
		Set<String> deadend = new HashSet<>(Arrays.asList(deadends));
		Set<String> visited = new HashSet<>();
		String initial = "0000";
		int moves = 0;
		
		queue.offer(initial);
		visited.add(initial);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (size > 0) {
				String lock = queue.poll();
				if (lock.equals(target)) { return moves; }
				size--;
				if (deadend.contains(lock)) { continue; }
				
				StringBuilder sb = new StringBuilder(lock);
				for (int i = 0; i < 4; i++) {
					char number = sb.charAt(i);
					String prefix = sb.substring(0, i);
					String postfix = sb.substring(i + 1);
					String rollUp = prefix + (number == '9' ? 0 : number - '0' + 1) + postfix;
					String rollDown = prefix + (number == '0' ? 9 : number - '0' - 1) + postfix;
					if (!visited.contains(rollUp) && !deadend.contains(rollUp)) {
						queue.offer(rollUp);
						visited.add(rollUp);
					}
					if (!visited.contains(rollDown) && !deadend.contains(rollDown)) {
						queue.offer(rollDown);
						visited.add(rollDown);
					}
				}
			}
			moves++;
		}
		
		return -1;
	}
	
	/**
	 * time  : O(10 ^ n / 2)
	 * space : O(n)
	 * 
	 * Set<String> left <- new HashSet
	 * Set<String> right <- new HashSet
	 * Set<String> deadend <- new HashSet<>(Arrays.asList(deadends))
	 * Set<String> temp <- null
	 * int moves <- 0
	 * 
	 * left add("0000")
	 * right add(target)
	 * 
	 * while left is not empty && right is not empty
	 * 		if left size is greater than right size
	 * 			temp <- left
	 * 			left <- right
	 * 			right <- left
	 * 		end if
	 * 		
	 * 		temp <- new HashSet
	 * 		for String lock in left
	 * 			if right contains lock
	 * 				return moves
	 * 			end if
	 * 			if deadend contains lock
	 * 				continue
	 * 			end if
	 * 			
	 * 			deadend add lock
	 * 			
	 * 			StringBuilder sb <- new StringBuilder(lock)
	 * 			for int i <- 0; if i is lower than four; i++
	 * 				char number <- sb charAt(i)
	 * 				String prefix <- sb substring(0, i)
	 * 				String postfix <- sb substring(i plus one)
	 * 				String rollUp <- prefix plus (if number is equal to '9' then 0 else number minus '0' plus one) plus postfix
	 * 				String rollDown <- prefix plus (if number is equal to '0' then 9 else number minus '0' minus one) plus postfix
	 * 				
	 * 				if deadend does not contains rollUp
	 * 					temp add rollUp
	 * 				end if
	 * 				if deadend does not contains rollDown
	 * 					temp add rollDown
	 * 				end if
	 * 			end for
	 * 		end for
	 * end while
	 * 
	 * return -1
	 * */
	public int openLock(String[] deadends, String target) {
		Set<String> left = new HashSet<>();
		Set<String> right = new HashSet<>();
		Set<String> deadend = new HashSet<>(Arrays.asList(deadends));
		Set<String> temp = null;
		int moves = 0;
		
		left.add("0000");
		right.add(target);
		
		while (!left.isEmpty() && !right.isEmpty()) {
			if (left.size() > right.size()) {
				temp = left;
				left = right;
				right = temp;
			}
			
			temp = new HashSet<>();
			for (String lock : left) {
				if (right.contains(lock)) { return moves; }
				if (deadend.contains(lock)) { continue; }
				
				deadend.add(lock);
				
				StringBuilder sb = new StringBuilder(lock);
				for (int i = 0; i < 4; i++) {
					char number = sb.charAt(i);
					String prefix = sb.substring(0, i);
					String postfix = sb.substring(i + 1);
					String rollUp = prefix + (number == '9' ? 0 : number - '0' + 1) + postfix;
					String rollDown = prefix + (number == '0' ? 9 : number - '0' - 1) + postfix;
					
					if (!deadend.contains(rollUp)) { temp.add(rollUp); }
					if (!deadend.contains(rollDown)) { temp.add(rollDown); }
				}
			}
			
			left = temp;
			moves++;
		}
		
		return -1;
	}
	
}
