package com.example.lcpjava.hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.example.lcpjava.common.AuthenticationToken;

public class AuthenticationManager_2 {
	
	public int timeToLive;
	
	public Map<String, AuthenticationToken> cache;																	// S : O(n)
	
	public Queue<AuthenticationToken> queue;																		// S : O(n)
	
	public AuthenticationManager_2(int timeToLive) {
		this.timeToLive = timeToLive;
		cache = new HashMap<>();
		queue = new LinkedList<>();
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public void generate(String tokenId, int currentTime) {
		AuthenticationToken token = new AuthenticationToken(tokenId, currentTime + timeToLive);
		cache.put(tokenId, token);																					// T : O(1)
		queue.offer(token);																							// T : O(1)
	}
	
	/**
	 * time  : O(α(n))
	 * space : O(1)
	 * */
	public void renew(String tokenId, int currentTime) {
		removeExpiredToken(currentTime);																			// T : O(α(n))
		
		AuthenticationToken token = cache.get(tokenId);																// T : O(1)
		if (token == null) { return; }
		token.inValid = true;																						// queue may contains same token id but different expired time
		
		generate(tokenId, currentTime);																				// T : O(1)
	}
	
	/**
	 * time  : O(α(n))
	 * space : O(1)
	 * */
	public int countUnexpiredTokens(int currentTime) {
		removeExpiredToken(currentTime);																			// T : O(α(n))
		return cache.size();																						// T : O(1)
	}
	
	/**
	 * time  : O(α(n))
	 * space : O(1)
	 * */
	public void removeExpiredToken(int currentTime) {
		while (!queue.isEmpty()) {
			AuthenticationToken token = queue.peek();																// T : O(1)
			if (token.inValid) {
				queue.poll();																						// T : O(1)
				continue;
			}
			
			if (token.expiredTime > currentTime) { break; }
			
			cache.remove(token.tokenId);																			// T : O(1)
			queue.poll();																							// T : O(1)
		}
	}
	
}
