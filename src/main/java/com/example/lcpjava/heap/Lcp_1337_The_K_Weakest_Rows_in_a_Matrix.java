package com.example.lcpjava.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_1337_The_K_Weakest_Rows_in_a_Matrix {
	
	/**
	 * time  : O(n * m)
	 * space : O(n)
	 * 
	 * Map<Integer, Integer> countMap <- new HashMap
	 * 
	 * for int i <- 0; if i is lower than matrix length; i++
	 * 		int[] row <- matrix[i]
	 * 		int soldiers <- 0
	 * 		
	 * 		for int j <- 0; if j is lower than row length; j++
	 * 			int unit <- row[j]
	 * 			
	 * 			if unit is equal to zero
	 * 				continue
	 * 			end if
	 * 			
	 * 			soldiers++
	 * 		end for
	 * 		
	 * 		countMap put(i, soldiers)
	 * end for
	 * 
	 * Queue<Integer> maxHeap <- new PriorityQueue<>((offer, previous) -> {
	 * 		int o <- countMap get(offer)
	 * 		int p <- countMap get(previous)
	 * 		
	 * 		if o is equal to p
	 * 			return previous minus offer
	 * 		end if
	 * 		
	 * 		return p minus offer
	 * })
	 * 
	 * for int number in countMap keySet
	 * 		maxHeap offer(number)
	 * 		
	 * 		if maxHeap size is greater than k
	 * 			maxHeap poll
	 * 		end if
	 * end for
	 * 
	 * int[] result <- new int[k]
	 * for int i <- k minus one; if i is greater than or equal to zero; i--
	 * 		result[i] <- maxHeap poll
	 * end for
	 * 
	 * return result
	 * */
	public int[] kWeakestRows_1(int[][] mat, int k) {
		Map<Integer, Integer> countMap = new HashMap<>();															// S : O(n)
		
		for (int i = 0; i < mat.length; i++) {																		// T : O(n)
			int[] row = mat[i];
			int soldiers = 0;
			
			for (int j = 0; j < row.length; j++) {																	// T : O(m)
				int unit = row[j];
				if (unit == 0) { continue; }
				soldiers++;
			}
			
			countMap.put(i, soldiers);																				// T : O(1)
		}
		
		Queue<Integer> maxHeap = new PriorityQueue<>((offer, previous) -> {											// S : O(k)
			int o = countMap.get(offer);																			// T : O(1)
			int p = countMap.get(previous);																			// T : O(1)
			if (o == p) { return previous - offer; }
			return p - o;
		});
		
		for (int num : countMap.keySet()) {																			// T : O(n)
			maxHeap.offer(num);																						// T : O(log k)
			if (maxHeap.size() > k) {																				// T : O(1)
				maxHeap.poll();																						// T : O(log k)
			}
		}
		
		int[] result = new int[k];																					// S : O(k)
		for (int i = k - 1; i >= 0; i--) {																			// T : O(k)
			result[i] = maxHeap.poll();																				// T : O(log k)
		}
		
		return result;
	}
	
	/**
	 * time  : O(n log k + n log m)
	 * space : O(k)
	 * 
	 * Queue<int[]> maxHeap <- new PriorityQueue<>((offer, previous) -> {
	 * 		if previous[0] is not equal to offer[0]
	 * 			return previous[0] minus offer[0]
	 * 		end if
	 * 		
	 * 		return previous[1] minus offer[1]
	 * })
	 * 
	 * for int i <- 0; if i is lower than matrix length; i++
	 * 		maxHeap offer(new int array[ binarySearch(matrix[i]), i ])
	 * 		
	 * 		if maxHeap size is greater than k
	 * 			maxHeap poll
	 * 		end if
	 * end for
	 * 
	 * int[] result <- new int[k]
	 * for int i <- k minus one; if i is greater than or equal to zero; i--
	 * 		result[i] <- maxHeap poll[1]
	 * end for
	 * 
	 * return result
	 * */
	public int[] kWeakestRows_(int[][] mat, int k) {
		Queue<int[]> maxHeap = new PriorityQueue<>((offer, previous) -> {											// S : O(k)
			if (previous[0] != offer[0]) { return previous[0] - offer[0]; }
			return previous[1] - offer[1];
		});
		
		for (int i = 0; i < mat.length; i++) {																		// T : O(n)
			maxHeap.offer(																							// T : O(log k)
					new int[] { binarySearch(mat[i]), i }															// T : O(log m)
			);
			if (maxHeap.size() > k) {																				// T : O(1)
				maxHeap.poll();																						// T : O(log k)
			}
		}
		
		int[] result = new int[k];																					// S : O(k)
		for (int i = k - 1; i >= 0; i--) {																			// T : O(k)
			result[i] = maxHeap.poll()[1];																			// T : O(log k)
		}
		
		return result;
	}
	
	/**
	 * int start <- 0
	 * int end <- array length minus one
	 * 
	 * while start is lower than or equal to end
	 * 		int mid <- start plus (end minus start) divide two
	 * 		
	 * 		if array[mid] is equal to one
	 * 			start <- mid plus one
	 * 		else
	 * 			end <- mid minus one
	 * 		end if
	 * end while
	 * 
	 * return start
	 * */
	public int binarySearch(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == 1) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return start;
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(n + m)
	 * 
	 * soldierPerRow
	 * index		  0 1 2 3 4
	 * value		  2 4 1 2 5
	 * 
	 * bucket
	 * index		0 1 2 3 4 5
	 * value		0 1 2 0 1 1
	 * accumulate	0 1 3 3 4 5
	 * 
	 * result
	 * index		0 1 2
	 * value		2 0 3
	 * 
	 * 
	 * int rows <- matrix length
	 * int cols <- matrix[0] length
	 * 
	 * int[] soldierPerRow <- new int[rows]
	 * for int row <- 0; if row is lower than rows; row++
	 * 		int soldiers <- 0
	 * 		
	 * 		for int unit in matrix[row]
	 * 			if unit is not equal to one
	 * 				break
	 * 			end if
	 * 			
	 * 			soldiers++
	 * 		end for
	 * 		
	 * 		soldierPerRow[row] <- soldiers
	 * end for
	 * 
	 * int[] buckets <- new int[cols plus one]
	 * for int soldiers in soldierPerRow
	 * 		buckets[soldiers]++
	 * end for
	 * 
	 * for int i <- 1; if i is lower than or equal to cols; i++
	 * 		bucket[i] <- bucket[i] plus bucket[i minus one]
	 * end for
	 * 
	 * int[] result <- new int[k]
	 * for int i <- rows minus one; if i is greater than or equal to zero; i--
	 * 		int soldiers <- soldierPerRow[i];
	 * 		int bucket <- buckets[soldiers]
	 * 		
	 * 		if bucket minus one is lower than k
	 * 			result[bucket minus one] <- i
	 * 		end if
	 * 		
	 * 		buckets[soldiers]--
	 * end for
	 * 
	 * return result
	 * */
	public int[] kWeakestRows(int[][] mat, int k) {
		int rows = mat.length;
		int cols = mat[0].length;
		
		int[] soldierPerRow = new int[rows];																		// S : O(n)
		for (int row = 0; row < rows; row++) {																		// T : O(n)
			int soldiers = 0;
			for (int unit : mat[row]) {																				// T : O(m)
				if (unit != 1) { break; }
				soldiers++;
			}
			soldierPerRow[row] = soldiers;
		}
		
		int[] buckets = new int[cols + 1];																			// S : O(m)
		for (int soldiers : soldierPerRow) { buckets[soldiers]++; }													// T : O(n)
		
		// accumulate for k
		for (int i = 1; i <= cols; i++) { buckets[i] += buckets[i - 1]; }											// T : O(m)
		
		int[] result = new int[k];																					// S : O(k)
		for (int i = rows - 1; i >= 0; i--) {																		// T : O(n)
			int soldiers = soldierPerRow[i];
			int bucket = buckets[soldiers];
			if (bucket - 1 < k) { result[bucket - 1] = i; }
			buckets[soldiers]--;
		}
		
		return result;
	}
	
}
