package com.example.lcpjava.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet_1 {
	
	Map<Integer, Integer> map;
	
	List<Integer> list;
	
	Random random;
	
	public RandomizedSet_1() {
		map = new HashMap<>();
		list = new ArrayList<>();
		random = new Random();
	}
	
	public boolean insert(int val) {
		if (map.containsKey(val)) { return false; }																	// T : O(1)
		
		map.put(val, list.size());																					// T : O(1)
		list.add(val);																								// T : amortized O(1)
		
		return true;
	}
	
	public boolean remove(int val) {
		if (!map.containsKey(val)) { return false; }																// T : O(1)
		
		int lastIndex = list.size() - 1;																			// T : O(1)
		int targetIndex = map.get(val);																				// T : O(1)
		int lastValue = list.get(lastIndex);																		// T : O(1)
		
		list.set(targetIndex, lastValue);																			// T : O(1)
		map.put(lastValue, targetIndex);																			// T : O(1)
		
		map.remove(val);																							// T : O(1)
		list.remove(lastIndex);																						// T : O(1)
		return true;
	}
	
	public int getRandom() {
		return list.get(random.nextInt(list.size()));																// T : O(1)
	}
	
}
