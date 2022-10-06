package com.example.lcpjava.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.lcpjava.common.Lcp_981_Pair;

public class TimeMap_1 {
	
	Map<String, List<Lcp_981_Pair>> memo;
	
	/**
	 * time  : O(1)
	 * space : O(key + value + timestamp)
	 * */
	public TimeMap_1() {
		memo = new HashMap<>();
	}
	
	/**
	 * time  : O(α(n))
	 * space : O(1)
	 * */
	public void set(String key, String value, int timestamp) {
		if (!memo.containsKey(key)) {																				// T : O(1)
			List<Lcp_981_Pair> bucket = new ArrayList<>();
			
			bucket.add(new Lcp_981_Pair(value, timestamp));															// T : O(α(n))
			
			memo.put(key, bucket);																					// T : O(1)
		} else {
			memo.get(key).add(new Lcp_981_Pair(value, timestamp));													// T : O(1)
		}
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public String get(String key, int timestamp) {
		if (!memo.containsKey(key)) { return ""; }																	// T : O(1)
		
		String result = "";
		List<Lcp_981_Pair> bucket = memo.get(key);																	// T : O(1)
		
		for (int i = bucket.size() - 1; i >= 0; i--) {																// T : O(n)
			Lcp_981_Pair p = bucket.get(i);																			// T : O(1)
			
			if (p.timestamp <= timestamp) {
				result = p.value;
				break;
			}
		}
		
		return result;
	}
	
}
