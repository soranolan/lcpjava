package com.example.lcpjava.array;

public class Lcp_941_Valid_Mountain_Array {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * boolean increasing <- false
	 * boolean decreasing <- false
	 * int length <- array length
	 * 
	 * if array is null || length is lower than three
	 * 		return false
	 * end if
	 * 
	 * for int i <- 0; if i is lower than length minus one; i++
	 * 		if array[i] is lower than array[i plus one]
	 * 			if decreasing is true
	 * 				return false
	 * 			end if
	 * 			increasing <- true
	 * 		else if array[i] is greater than array[i plus one]
	 * 			if increasing is false
	 * 				return false
	 * 			end if
	 * 			decreasing <- true
	 * 		else
	 * 			return false
	 * 		end if
	 * end for
	 * 
	 * return increasing && decreasing
	 * */
	public boolean validMountainArray_1(int[] arr) {
		boolean increasing = false;
		boolean decreasing = false;
		int length = arr.length;
		if (arr == null || length < 3) { return false; }
		
		for (int i = 0; i < length - 1; i++) {																		// T : O(n)
			if (arr[i] < arr[i + 1]) {
				if (decreasing) { return false; }
				increasing = true;
			} else if (arr[i] > arr[i + 1]) {
				if (!increasing) { return false; }
				decreasing = true;
			} else {
				return false;
			}
		}
		
		return increasing && decreasing;
	}
	
	/**
	 * time  : O(m + n)
	 * space : O(1)
	 * 
	 * int length <- array length
	 * int i <- 0
	 * 
	 * while i plus one is lower than length && array[i] is lower than array[i plus one]
	 * 		i++
	 * end while
	 * 
	 * if i is equal to zero || i is equal to length minus one
	 * 		return false
	 * end if
	 * 
	 * while i plus one is lower than length && array[i] is greater than array[i plus one]
	 * 		i++
	 * end while
	 * 
	 * return if i is equal to length minus one
	 * */
	public boolean validMountainArray_2(int[] arr) {
		int length = arr.length;
		int i = 0;
		
		while (i + 1 < length && arr[i] < arr[i + 1]) { i++; }														// T : O(n)
		
		if (i == 0 || i == length - 1) { return false; }
		
		while (i + 1 < length && arr[i] > arr[i + 1]) { i++; }														// T : O(n)
		
		return i == length - 1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int length <- array length
	 * if array is null || length is lower than three || array[0] is greater than or equal to array[1]
	 * 		return false
	 * end if
	 * 
	 * boolean increasing <- true
	 * 
	 * for int i <- 2; if i is lower than array length; i++
	 * 		if increasing is true
	 * 			if array[i minus one] is equal to array[i]
	 * 				return false
	 * 			else if array[i minus one] is greater than array[i]
	 * 				increasing <- false
	 * 			end if
	 * 		else
	 * 			if array[i minus one] <= array[i]
	 * 				return false
	 * 			end if
	 * 		end if
	 * end for
	 * 
	 * return !increasing
	 * */
	public boolean validMountainArray(int[] arr) {
		int length = arr.length;
		if (arr == null || length < 3 || arr[0] >= arr[1]) { return false; }
		
		boolean increasing = true;
		for (int i = 2; i < arr.length; i++) {																		// T : O(n)
			if (increasing) {
				if (arr[i - 1] == arr[i]) {
					return false;
				} else if (arr[i - 1] > arr[i]) {
					increasing = false;
				}
			} else {
				if (arr[i - 1] <= arr[i]) {
					return false;
				}
			}
		}
		
		return !increasing;
	}
	
	public static void main(String[] args) {
		Lcp_941_Valid_Mountain_Array lcp = new Lcp_941_Valid_Mountain_Array();
		int[] input = null;
		boolean output = false;
		
		// false
		input = new int[] { 2, 1 };
		output = lcp.validMountainArray(input);
		System.out.println(output);
		
		// false
		input = new int[] { 3, 5, 5 };
		output = lcp.validMountainArray(input);
		System.out.println(output);
		
		// true
		input = new int[] { 0, 3, 2, 1 };
		output = lcp.validMountainArray(input);
		System.out.println(output);
		
		// false
		input = new int[] { 2, 0, 2 };
		output = lcp.validMountainArray(input);
		System.out.println(output);
	}
	
}
