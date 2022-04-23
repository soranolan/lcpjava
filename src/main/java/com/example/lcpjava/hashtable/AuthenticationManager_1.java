package com.example.lcpjava.hashtable;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager_1 {
	
	public int timeToLive;
	
	public Map<String, Integer> cache;																				// S : O(n)
	
	public AuthenticationManager_1(int timeToLive) {
		this.timeToLive = timeToLive;
		cache = new HashMap<>();
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public void generate(String tokenId, int currentTime) {
		cache.put(tokenId, currentTime + timeToLive);																// T : O(1)
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public void renew(String tokenId, int currentTime) {
		if (!cache.containsKey(tokenId)) { return; }																// T : O(1)
		
		int tokenTime = cache.get(tokenId);																			// T : O(1)
		if (tokenTime <= currentTime) { return; }
		
		generate(tokenId, currentTime);																				// T : O(1)
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public int countUnexpiredTokens(int currentTime) {
		int count = 0;
		
		for (int time : cache.values()) {																			// T : O(n)
			if (time > currentTime) { count++; }
		}
		
		return count;
	}
	
}
