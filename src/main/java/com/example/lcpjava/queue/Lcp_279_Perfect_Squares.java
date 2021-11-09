package com.example.lcpjava.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Lcp_279_Perfect_Squares {
	
	/**
	 * time  : O(n * sqrt(n))
	 * space : O(n)
	 * 
	 * Queue<Integer> queue <- new LinkedList
	 * Set<Integer> visited <- new HashSet
	 * int result <- 0
	 * 
	 * queue offer(0)
	 * visited add(0)
	 * 
	 * while queue is not empty
	 * 		int size <- queue size
	 * 		result++
	 * 		
	 * 		while size is greater than zero
	 * 			size--
	 * 			int number <- queue poll
	 * 			
	 * 			for int i <- 1; if i multiply i is lower than or equal to n; i++
	 * 				int sum <- number plus (i multiply i)
	 * 				if visited contains sum
	 * 					continue
	 * 				end if
	 * 				if sum is equal to n
	 * 					return result
	 * 				end if
	 * 				if sum is greater than n
	 * 					break loop
	 * 				end if
	 * 				
	 * 				queue offer(sum)
	 * 				visited add(sum)
	 * 			end for
	 * 		end while
	 * end while
	 * 
	 * return result
	 * */
	public int numSquares_1(int n) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();																		// S : O(n)
		int result = 0;
		
		queue.offer(0);
		visited.add(0);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			result++;
			
			while (size > 0) {																						// T : O(n)
				size--;
				int number = queue.poll();
				
				for (int i = 1; i * i <= n; i++) {																	// T : O(sqrt(n))
					int sum = number + i * i;
					if (visited.contains(sum)) { continue; }
					if (sum == n) { return result; }
					if (sum > n) { break; }
					
					queue.offer(sum);
					visited.add(sum);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(sqrt(n))
	 * space : O(1)
	 * 
	 * Lagrange's Four Square theorem
	 * Legendre's three-square theorem
	 * 
	 * if n is perfect square
	 * 		return 1
	 * end if
	 * 
	 * while n mod four is equal to zero
	 * 		n <- n divide four
	 * end while
	 * 
	 * if n mod eight is equal to seven
	 * 		return 4
	 * end if
	 * 
	 * int sqrt <- (int) Math sqrt(n)
	 * for int i <- 1; if i is lower than or equal to sqrt; i++
	 * 		if n minus i * i is not perfect square
	 * 			continue
	 * 		end if
	 * 		return 2
	 * end for
	 * 
	 * return 3
	 * */
	public int numSquares(int n) {
		if (isSqrt(n)) { return 1; }
		
		while ((n & 3) == 0) { n >>= 2; }
		
		if ((n & 7) == 7) { return 4; }
		
		int sqrt = (int) Math.sqrt(n);
		for (int i = 1; i <= sqrt; i++) {																			// T : O(sqrt(n))
			if (!isSqrt(n - i * i)) { continue; }
			return 2;
		}
		
		return 3;
	}
	
	public boolean isSqrt(int number) {
		int sqrt = (int) Math.sqrt(number);
		if (Math.pow(sqrt, 2) == number) { return true; }
		return false;
	}
	
}
