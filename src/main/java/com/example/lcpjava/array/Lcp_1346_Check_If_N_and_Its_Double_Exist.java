package com.example.lcpjava.array;

import java.util.HashSet;
import java.util.Set;

public class Lcp_1346_Check_If_N_and_Its_Double_Exist {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int left <- 0
	 * int right <- 1
	 * int length <- array length
	 * 
	 * if left is equal to zero or is equal to one
	 * 		return false
	 * end if
	 * 
	 * while left lower than length
	 * 		if array[left] is equal to array[right] multiple two || array[right] is equal to array[left] multiple two
	 * 			return true
	 * 		else
	 * 			right++
	 * 		end if
	 * 		if left plus two is equal to length
	 * 			return false
	 * 		end if
	 * 		if right is equal to length
	 * 			left++
	 * 			right <- left + 1
	 * 		end if
	 * end while
	 * 
	 * return false
	 * */
	public boolean checkIfExist_1(int[] arr) {
		int left = 0;
		int right = 1;
		int length = arr.length;
		
		if (length == 0 || length == 1) { return false; }
		
		while (left < length) {																						// T : O(n)
			if (arr[left] == arr[right] * 2 || arr[right] == arr[left] * 2) {
				return true;
			} else {
				right++;
			}
			if ((left + 2) == length) { return false; }
			if (right == length) {
				left++;
				right = left + 1;
			}
		}
		
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Set<Integer> container
	 * 
	 * for int i <- 0 to array end
	 * 		if container contains arr[i] multiple two || arr[i] mod two is equal to zero and container contains arr[i] divide two
	 * 			return true
	 * 		end if
	 * 		container add arr[i]
	 * end for
	 * 
	 * return false
	 * */
	public boolean checkIfExist(int[] arr) {
		Set<Integer> container = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {																		// T : O(n)
			if (container.contains(arr[i] * 2) || (arr[i] % 2 == 0 && container.contains(arr[i] / 2))) {			// T : O(1)
				return true;
			}
			container.add(arr[i]);																					// T : O(1); S : O(n)
		}
		return false;
	}
	
	public static void main(String[] args) {
		Lcp_1346_Check_If_N_and_Its_Double_Exist lcp = new Lcp_1346_Check_If_N_and_Its_Double_Exist();
		int[] input = null;
		boolean output = false;
		
		// true
		input = new int[] { 10, 2, 5, 3 };
		output = lcp.checkIfExist(input);
		System.out.println(output);
		
		// true
		input = new int[] { 7, 1, 14, 11 };
		output = lcp.checkIfExist(input);
		System.out.println(output);
		
		// false
		input = new int[] { 3, 1, 7, 11 };
		output = lcp.checkIfExist(input);
		System.out.println(output);
		
		// false
		input = new int[] { };
		output = lcp.checkIfExist(input);
		System.out.println(output);
		
		// false
		input = new int[] { 1 };
		output = lcp.checkIfExist(input);
		System.out.println(output);
	}
	
}
