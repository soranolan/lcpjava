package com.example.lcpjava.array;

import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_378_Kth_Smallest_Element_in_a_Sorted_Matrix {
	
	/**
	 * time  : O(n * n * log k)
	 * space : O(k)
	 * */
	public int kthSmallest_1(int[][] matrix, int k) {
		int n = matrix.length;
		Queue<Integer> maxHeap = new PriorityQueue<>((offer, previous) -> previous - offer);						// S : O(k)
		
		for (int row = 0; row < n; row++) {																			// T : O(n)
			for (int col = 0; col < n; col++) {																		// T : O(n)
				maxHeap.offer(matrix[row][col]);																	// T : O(log k)
				if (maxHeap.size() > k) { maxHeap.poll(); }
			}
		}
		
		return maxHeap.poll();
	}
	
	/**
	 * time  : O(k * log(min(k, n)))
	 * space : O(k)
	 * 
	 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/1322101/C%2B%2BJavaPython-MaxHeap-MinHeap-Binary-Search-Picture-Explain-Clean-and-Concise
	 * */
	public int kthSmallest_2(int[][] matrix, int k) {
		int n = matrix.length;
		Queue<int[]> minHeap = new PriorityQueue<>((offer, previous) -> offer[2] - previous[2]);
		
		for (int row = 0; row < n; row++) {																			// T : O(n)
			minHeap.offer(new int[] { row, 0, matrix[row][0] });
		}
		
		int result = -1;
		
		for (int col = 1; col <= k; col++) {																		// T : O(k)
			int[] pair = minHeap.poll();
			int currentRow = pair[0];
			int currentCol = pair[1];
			
			result = pair[2];
			
			if (currentCol + 1 < n) { minHeap.offer(new int[] { currentRow, currentCol + 1, matrix[currentRow][currentCol + 1] }); }
		}
		
		return result;
	}
	
	/**
	 * time  : O(log d * (n + n))
	 * space : O(1)
	 * 
	 * d : end - start <= 2 * 10 ^ 9 from constraints
	 * 
	 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/1322101/C%2B%2BJavaPython-MaxHeap-MinHeap-Binary-Search-Picture-Explain-Clean-and-Concise
	 * */
	public int kthSmallest(int[][] matrix, int k) {
		int result = -1;
		int n = matrix.length;
		int start = matrix[0][0];
		int end = matrix[n - 1][n - 1];
		
		while (start <= end) {																						// T : O(log(end - start))
			int mid = start + (end - start) / 2;
			int count = countLessOrEqual(mid, matrix);
			
			if (count >= k) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return result;
	}
	
	private int countLessOrEqual(int mid, int[][] matrix) {
		int count = 0;
		int n = matrix.length;
		int col = n - 1;
		
		for (int row = 0; row < n; row++) {																			// T : O(n)
			while (col >= 0 && matrix[row][col] > mid) {															// T : O(n)
				col--;
			}
			count += (col + 1);
		}
		
		return count;
	}
	
	/**
	 * TODO from paper
	 * 
	 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85170/O(n)-from-paper.-Yes-O(rows).
	 * */
	
}
