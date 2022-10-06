package com.example.lcpjava.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.lcpjava.common.Lcp_981_Pair;

/**
 * Solution Tab
 * */
public class TimeMap_2 {
	
	Map<String, List<Lcp_981_Pair>> memo;
	
	/**
	 * time  : O(1)
	 * space : O(key + value + timestamp)
	 * */
	public TimeMap_2() {
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
	 * time  : O(log n)
	 * space : O(1)
	 * */
	public String get(String key, int timestamp) {
		if (!memo.containsKey(key)) { return ""; }																	// T : O(1)
		
		String result = "";
		List<Lcp_981_Pair> bucket = memo.get(key);																	// T : O(1)
		
		if (bucket.get(0).timestamp > timestamp) { return result; }													// T : O(1)
		if (bucket.get(bucket.size() - 1).timestamp <= timestamp) { return bucket.get(bucket.size() - 1).value; }	// T : O(1)
		
		int index = lowerBound(bucket, timestamp);																	// T : O(log n)
		
		return bucket.get(index).value;
	}
	
	private int lowerBound(List<Lcp_981_Pair> bucket, int target) {
		int start = 0;
		int end = bucket.size();
		
		while (start < end) {
			int mid = start + (end - start) / 2;
			int pivot = bucket.get(mid).timestamp;
			
			if (pivot > target) {
				end = mid - 1;
			} else {
				start = mid;
			}
		}
		
		return start;
	}
	
}
