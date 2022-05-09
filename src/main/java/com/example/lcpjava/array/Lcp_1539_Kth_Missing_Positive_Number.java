package com.example.lcpjava.array;

public class Lcp_1539_Kth_Missing_Positive_Number {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * boolean[] bucket <- new boolean[2000 plus one]
	 * 
	 * for int num in arr
	 * 		bucket[num] <- true
	 * end for
	 * 
	 * for int i <- 1; if i is lower than or equal to 2000; i++
	 * 		if bucket[i] is false
	 * 			k--
	 * 			
	 * 			if k is equal to zero
	 * 				return i
	 * 			end if
	 * 		end if
	 * end for
	 * 
	 * return minus one;
	 * */
	public int findKthPositive_1(int[] arr, int k) {
		boolean[] bucket = new boolean[2000 + 1];																	// S : O(2 * n)
		
		for (int num : arr) { bucket[num] = true; }																	// T : O(n)
		
		for (int i = 1; i <= 2000; i++) {																			// T : O(2 * n)
			if (!bucket[i]) {
				if (--k == 0) { return i; }
			}
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/kth-missing-positive-number/discuss/876751/Java-1-liner-O(n)-simplest-easy-to-understand-beats-100
	 * 
	 * for int num in arr
	 * 		if num is greater than k
	 * 			return k
	 * 		end if
	 * 		
	 * 		k++
	 * end for
	 * 
	 * return k
	 * */
	public int findKthPositive_2(int[] arr, int k) {
		for (int num : arr) {																						// T : O(n)
			if (num > k) { return k; }
			k++;
		}
		return k;
	}
	
	/**
	 * https://leetcode.com/problems/kth-missing-positive-number/discuss/779999/JavaC%2B%2BPython-O(logN)
	 * 
	 * array = [2,3,4,7,11]
	 * k = 5
	 * 
	 * missing numbers count = array[index] - (index + 1)
	 *                         [ 2, 3, 4, 7, 11 ]
	 *                         [ 1, 1, 1, 3,  6 ]
	 * 
	 *                           0  1  2  3  4   5
	 * missing numbers array = [ 1, 5, 6, 8, 9, 10 ]
	 * 
	 * index = 4
	 * missing number        = array[index] - (missing numbers - k + 1)
	 *                       = 11 - (6 - 5 + 1)
	 *                       = 9
	 *                       = array[index] - (array[index] - (index + 1) - k + 1)
	 *                       = array[index] - (array[index] - index - 1 - k + 1)
	 *                       = array[index] - (array[index] - index - k)
	 *                       = array[index] - array[index] + index + k
	 *                       = index + k
	 * */
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * 
	 * int start <- 0
	 * int end <- arr length
	 * 
	 * while start is lower than end
	 * 		int mid <- start plus (end minus start) divide by two
	 * 		int pivot <- arr[mid] minus (mid plus one)
	 * 		
	 * 		if pivot is lower than k
	 * 			start <- mid plus one
	 * 		else
	 * 			end <- mid
	 * 		end if
	 * end while
	 * 
	 * return start plus k
	 * */
	public int findKthPositive(int[] arr, int k) {
		int start = 0;
		int end = arr.length;
		
		while (start < end) {																						// T : O(log n)
			int mid = start + (end - start) / 2;
			int pivot = arr[mid] - (mid + 1);
			
			if (pivot < k) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		return start + k;
	}
	
}
