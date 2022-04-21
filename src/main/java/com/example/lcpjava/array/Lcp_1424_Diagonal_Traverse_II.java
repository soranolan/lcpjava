package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_1424_Diagonal_Traverse_II {
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * Queue<int[]> heap <- new PriorityQueue<>()
	 * 
	 * order by : if is same diagonal then return the greater row index else return the lower diagonal
	 * 
	 * for int row <- 0; if row is lower than nums size; row++
	 * 		List<Integer> numList <- nums get(row)
	 * 		
	 * 		for int col <- 0; if col is lower than numList size; col++
	 * 			heap offer(int array [ row plus col, row, numList get(col)])
	 * 		end for
	 * end for
	 * 
	 * int index <- 0
	 * int[] result <- new int[heap size]
	 * while heap is not empty
	 * 		result[index] <- heap poll[2]
	 * 		index++
	 * end while
	 * 
	 * return result
	 * */
	public int[] findDiagonalOrder_1(List<List<Integer>> nums) {
		Queue<int[]> heap = new PriorityQueue<>(
				(offer, previous) -> offer[0] == previous[0] ? previous[1] - offer[1] : offer[0] - previous[0]);	// S : O(n)
		
		for (int row = 0; row < nums.size(); row++) {																// T : O(n)
			List<Integer> numList = nums.get(row);
			
			for (int col = 0; col < numList.size(); col++) {
				heap.offer(new int[] { row + col, row, numList.get(col) });											// T : O(log n)
			}
		}
		
		int index = 0;
		int[] result = new int[heap.size()];																		// S : O(n)
		while (!heap.isEmpty()) { result[index++] = heap.poll()[2]; }												// T : O(n)
		
		return result;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * List<int[]> tuples <- new ArrayList<>()
	 * 
	 * for int row <- 0; if row is lower than nums size; row++
	 * 		List<Integer> numList <- nums get(row)
	 * 		
	 * 		for int col <- 0; if col is lower than numList size; col++
	 * 			tuples add(int array [ row plus col, row, numList get(col)])
	 * 		end for
	 * end for
	 * 
	 * tuples order by : if is same diagonal then return the greater row index else return the lower diagonal
	 * 
	 * int index <- 0
	 * int[] result <- new int[tuples size]
	 * for int[] tuple in tuples
	 * 		result[index] <- tuple[2]
	 * 		index++
	 * end for
	 * 
	 * return result
	 * */
	public int[] findDiagonalOrder_2(List<List<Integer>> nums) {
		List<int[]> tuples = new ArrayList<>();																		// S : O(n)
		
		for (int row = 0; row < nums.size(); row++) {																// T : O(n)
			List<Integer> numList = nums.get(row);
			
			for (int col = 0; col < numList.size(); col++) {
				tuples.add(new int[] { row + col, row, numList.get(col) });
			}
		}
		
		tuples.sort(
				(offer, previous) -> offer[0] == previous[0] ? previous[1] - offer[1] : offer[0] - previous[0]);	// T : O(n log n)
		
		int index = 0;
		int[] result = new int[tuples.size()];																		// S : O(n)
		for (int[] tuple : tuples) { result[index++] = tuple[2]; }													// T : O(n)
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/diagonal-traverse-ii/discuss/597794/Python-One-pass
	 * 
	 * List<List<Integer>> temp <- new ArrayList
	 * int count <- 0
	 * 
	 * for int row <- 0; if row is lower than nums size; row++
	 * 		List<Integer> numList <- nums get(row)
	 * 		
	 * 		for int col <- 0; if col is lower than numList size; col++
	 * 			int sum <- row plus col
	 * 			
	 * 			if sum is equal to temp size
	 * 				temp add empty array list
	 * 			end if
	 * 			
	 * 			temp get(sum) add(numList get(col))
	 * 			count++
	 * 		end for
	 * end for
	 * 
	 * int index <- 0
	 * int[] result <- new int[count]
	 * for int row <- 0; if row is lower than temp size; row++
	 * 		List<Integer> numList <- temp get(row)
	 * 		
	 * 		reverse numList
	 * 		
	 * 		for int col <- 0; if col is lower than numList size; col++
	 * 			result[index] <- numList get(col)
	 * 			index++
	 * 		end for
	 * end for
	 * 
	 * return result
	 * */
	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		List<List<Integer>> temp = new ArrayList<>();																// S : O(n)
		int count = 0;
		
		for (int row = 0; row < nums.size(); row++) {																// T : O(n)
			List<Integer> numList = nums.get(row);
			
			for (int col = 0; col < numList.size(); col++) {
				int sum = row + col;
				if (sum == temp.size()) { temp.add(new ArrayList<>()); }
				
				temp.get(sum).add(numList.get(col));
				count++;
			}
		}
		
		int index = 0;
		int[] result = new int[count];
		for (int row = 0; row < temp.size(); row++) {																// T : O(n)
			List<Integer> numList = temp.get(row);
			Collections.reverse(numList);																			// T : O(m)
			
			for (int col = 0; col < numList.size(); col++) {
				result[index++] = numList.get(col);
			}
		}
		
		return result;
	}
	
}
