package com.example.lcpjava.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lcp_599_Minimum_Index_Sum_of_Two_Lists {
	
	/**
	 * time  : O(n + m)
	 * space : O(n)
	 * 
	 * if list1 length is greater than list2 length
	 * 		return findRestaurant(list2, list1)
	 * end if
	 * 
	 * int min <- 999 plus 999 plus 1 (constraints list max length)
	 * List<String> common <- new ArrayList
	 * Map<String, Integer> memo <- new HashMap
	 * 
	 * for int i <- 0; if i is lower than list1 length; i++
	 * 		memo put(list1[i], i)
	 * end for
	 * 
	 * for int i <- 0; if i is lower than list2 length; i++
	 * 		String shopName <- list2[i]
	 * 		if memo does not containsKey(shopName)
	 * 			continue
	 * 		end if
	 * 		
	 * 		int sum <- memo get(shopName) plus i
	 * 		if sum is greater than min
	 * 			continue
	 * 		end if
	 * 		
	 * 		if sum is equal to min
	 * 			common add(shopName)
	 * 		end if
	 * 		
	 * 		if sum is lower than min
	 * 			common remove all shop name
	 * 			common add(shopName)
	 * 			min <- sum
	 * 		end if
	 * end for
	 * 
	 * String[] result <- new String[common size]
	 * int index <- 0
	 * for String shopName in common
	 * 		result[index] <- shopName
	 * 		index++
	 * end for
	 * 
	 * return result
	 * */
	public String[] findRestaurant(String[] list1, String[] list2) {
		if (list1.length > list2.length) { return findRestaurant(list2, list1); }
		
		int min = 999 + 999 + 1;
		List<String> common = new ArrayList<>();																	// S : O(p)
		Map<String, Integer> memo = new HashMap<>();																// S : O(n)
		
		for (int i = 0; i < list1.length; i++) { memo.put(list1[i], i); }											// T : O(n)
		
		for (int i = 0; i < list2.length; i++) {																	// T : O(m)
			String shopName = list2[i];
			if (!memo.containsKey(shopName)) { continue; }															// T : O(1)
			
			int sum = memo.get(shopName) + i;																		// T : O(1)
			if (sum > min) { continue; }
			
			if (sum == min) { common.add(shopName); }																// T : O(1)
			if (sum < min) {
				common.clear();																						// T : O(p)
				common.add(shopName);																				// T : O(1)
				min = sum;
			}
		}
		
		String[] result = new String[common.size()];																// S : O(p)
		int index = 0;
		for (String shopName : common) { result[index++] = shopName; }												// T : O(p)
		
		return result;
	}
	
}
