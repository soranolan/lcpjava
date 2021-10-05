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
	 * 		return fasle
	 * end if
	 * 
	 * for int left <- 0 to length - 1
	 * 		if array[left] is lower than array[left + 1]
	 * 			if decreasing is true
	 * 				return false
	 * 			end if
	 * 			increasing <- true
	 * 		else if array[left] is greater than array[left + 1]
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
		
		for (int left = 0; left < length - 1; left++) {
			if (arr[left] < arr[left + 1]) {
				if (decreasing) { return false; }
				increasing = true;
			} else if (arr[left] > arr[left + 1]) {
				if (!increasing) { return false; }
				decreasing = true;
			} else {
				return false;
			}
		}
		
		return increasing && decreasing;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int length <- array length
	 * int i <- 0
	 * 
	 * while i + 1 is lower than length && array[i] is lower than array[i + 1]
	 * 		i++
	 * end while
	 * 
	 * if i is equal to zero || i is equal to length - 1
	 * 		return false
	 * end if
	 * 
	 * while i + 1 is lower than length && array[i] is greater than array[i + 1]
	 * 		i++
	 * end while
	 * 
	 * return i == length - 1
	 * */
	public boolean validMountainArray_2(int[] arr) {
		int length = arr.length;
		int i = 0;
		
		while (i + 1 < length && arr[i] < arr[i + 1]) { i++; }
		
		if (i == 0 || i == length - 1) { return false; }
		
		while (i + 1 < length && arr[i] > arr[i + 1]) { i++; }
		
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
	 * for int left <- 2 to array end
	 * 		if increasing is true
	 * 			if array[left - 1] is equal to array[left]
	 * 				return false
	 * 			else if array[left - 1] is greater than array[left]
	 * 				increasing <- false
	 * 		else
	 * 			if array[left - 1] <= array[left]
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
		for (int left = 2; left < arr.length; left++) {
			if (increasing) {
				if (arr[left - 1] == arr[left]) {
					return false;
				} else if (arr[left - 1] > arr[left]) {
					increasing = false;
				}
			} else {
				if (arr[left - 1] <= arr[left]) {
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
