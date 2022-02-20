package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_969_Pancake_Sorting {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * List<Integer> result <- new ArrayList
	 * 
	 * for int unsorted <- array length; if unsorted is greater than zero; unsorted--
	 * 		int index <- findMaxIndex(unsorted, array)
	 * 		
	 * 		flip(index, array)
	 * 		flip(unsorted minus one, array)
	 * 		
	 * 		result add(index plus one)
	 * 		result add(unsorted)
	 * end for
	 * 
	 * return result
	 * */
	public List<Integer> pancakeSort(int[] arr) {
		List<Integer> result = new ArrayList<>();																	// S : O(n * 2)
		
		for (int unsorted = arr.length; unsorted > 0; unsorted--) {													// T : O(n)
			int index = findMaxIndex(unsorted, arr);																// T : O(n)
			
			flip(index, arr);																						// flip to head
			flip(unsorted - 1, arr);																				// flip to tail
			
			result.add(index + 1);																					// T : O(1)
			result.add(unsorted);																					// T : O(1)
		}
		
		return result;
	}
	
	/**
	 * int index <- 0
	 * int max <- 0
	 * 
	 * for int i <- 0; if i is lower than end; i++
	 * 		if array[i] is lower than max
	 * 			continue
	 * 		end if
	 * 		
	 * 		max <- array[i]
	 * 		index <- i
	 * end for
	 * 
	 * return index
	 * */
	public int findMaxIndex(int end, int[] arr) {
		int index = 0;
		int max = 0;
		
		for (int i = 0; i < end; i++) {																				// T : O(n)
			if (arr[i] < max) { continue; }
			
			max = arr[i];
			index = i;
		}
		
		return index;
	}
	
	/**
	 * int start <- 0
	 * 
	 * while start is lower than end
	 * 		int temp <- array[start]
	 * 		
	 * 		array[start] <- array[end]
	 * 		array[end] <- temp
	 * 		
	 * 		start++
	 * 		end--
	 * end while
	 * */
	public void flip(int end, int[] arr) {
		int start = 0;
		
		while (start < end) {																						// T : O(n)
			int temp = arr[start];
			
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
	}
	
}
