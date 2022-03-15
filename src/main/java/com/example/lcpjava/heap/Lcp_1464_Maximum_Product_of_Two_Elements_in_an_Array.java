package com.example.lcpjava.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_1464_Maximum_Product_of_Two_Elements_in_an_Array {
	
	/**
	 * time  : O(n log 2)
	 * space : O(2)
	 * 
	 * Queue<Integer> minHeap <- new PriorityQueue
	 * 
	 * for int number in array
	 * 		minHeap offer(number)
	 * 		
	 * 		if minHeap size is greater than two
	 * 			minHeap poll
	 * 		end if
	 * end for
	 * 
	 * int first <- minHeap poll minus one
	 * int second <- minHeap poll minus one
	 * return first times second
	 * */
	public int maxProduct_1(int[] nums) {
		Queue<Integer> minHeap = new PriorityQueue<>();																// S : O(2)
		
		for (int num : nums) {																						// T : O(n)
			minHeap.offer(num);																						// T : O(log 2)
			
			if (minHeap.size() > 2) {																				// T : O(1)
				minHeap.poll();																						// T : O(log 2)
			}
		}
		
		int first = minHeap.poll() - 1;																				// T : O(log 2)
		int second = minHeap.poll() - 1;																			// T : O(log 2)
		return first * second;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int max <- 0
	 * int left <- 0
	 * int right <- array length minus one
	 * 
	 * while left is lower than right
	 * 		max <- Math max(max, (array[left] minus one) times (array[right] minus one))
	 * 		
	 * 		if array[left] is lower than array[right]
	 * 			left++
	 * 		else
	 * 			right--
	 * 		end if
	 * end while
	 * 
	 * return max
	 * */
	public int maxProduct_2(int[] nums) {
		int max = 0;
		int left = 0;
		int right = nums.length - 1;
		
		while (left < right) {																						// T : O(n)
			max = Math.max(max, (nums[left] - 1) * (nums[right] - 1));
			
			if (nums[left] < nums[right]) {
				left++;
			} else {
				right--;
			}
		}
		
		return max;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int first <- 0
	 * int second <- 0
	 * 
	 * for int number in array
	 * 		if number is greater than first
	 * 			second <- first
	 * 			first <- number
	 * 		else
	 * 			second <- Math max(second, number)
	 * 		end if
	 * end for
	 * 
	 * return (first minus one) times (second minus one)
	 * */
	public int maxProduct(int[] nums) {
		int first = 0;
		int second = 0;
		
		for (int num : nums) {																						// T : O(n)
			if (num > first) {
				second = first;
				first = num;
			} else {
				second = Math.max(second, num);
			}
		}
		
		return (first - 1) * (second - 1);
	}
	
}
