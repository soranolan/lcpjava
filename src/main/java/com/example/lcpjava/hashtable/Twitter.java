package com.example.lcpjava.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.example.lcpjava.common.Tweet;
import com.example.lcpjava.common.User;

/**
 * https://leetcode.com/problems/design-twitter/discuss/82825/Java-OO-Design-with-most-efficient-function-getNewsFeed
 * */
public class Twitter {
	
	private Map<Integer, User> userInfo;																			// S : O(user)
	
	private Map<Integer, List<Tweet>> tweetInfo;																	// S : O(tweet)
	
	private int time;
	
	/**
	 * time  : O(1)
	 * space : O(user + tweet)
	 * */
	public Twitter() {
		userInfo = new HashMap<>();
		tweetInfo = new HashMap<>();
		time = 0;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public void postTweet(int userId, int tweetId) {
		createAccount(userId);																						// T : O(1)
		
		if (!tweetInfo.containsKey(userId)) { tweetInfo.put(userId, new ArrayList<>()); }							// T : O(1)
		
		Tweet tweet = new Tweet(tweetId, time++);
		tweetInfo.get(userId).add(tweet);																			// T : O(1)
	}
	
	/**
	 * time  : O(followee * tweet)
	 * space : O(1)
	 * */
	public List<Integer> getNewsFeed(int userId) {
		Queue<Tweet> minHeap = new PriorityQueue<>((offer, previous) -> offer.time - previous.time);				// S : O(10)
		findTweet(userId, minHeap);																					// T : O(followee * tweet)
		
		int size = minHeap.size();																					// T : O(1)
		List<Integer> newsFeed = new ArrayList<>(size);																// S : O(10)
		for (int i = 0; i < size; i++) { newsFeed.add(-1); }														// T : O(10)
		for (int i = size - 1; i >= 0; i--) { newsFeed.set(i, minHeap.poll().tweetId); }							// T : O(10)
		
		return newsFeed;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public void follow(int followerId, int followeeId) {
		createAccount(followerId);																					// T : O(1)
		createAccount(followeeId);																					// T : O(1)
		
		userInfo.get(followerId).followee.add(followeeId);															// T : O(1)
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public void unfollow(int followerId, int followeeId) {
		createAccount(followerId);																					// T : O(1)
		createAccount(followeeId);																					// T : O(1)
		
		userInfo.get(followerId).followee.remove(followeeId);														// T : O(1)
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	private void createAccount(int userId) {
		if (userInfo.containsKey(userId)) { return; }																// T : O(1)
		
		userInfo.put(userId, new User(userId));																		// T : O(1)
	}
	
	/**
	 * time  : O(followee * tweet)
	 * space : O(1)
	 * */
	private void findTweet(int userId, Queue<Tweet> minHeap) {
		if (!userInfo.containsKey(userId)) { return; }																// T : O(1)
		
		for (Integer followee : userInfo.get(userId).followee) {													// T : O(followee)
			addTweet(followee, minHeap);																			// T : O(tweet)
		}
	}
	
	/**
	 * time  : O(tweet)
	 * space : O(1)
	 * */
	private void addTweet(int userId, Queue<Tweet> minHeap) {
		if (!tweetInfo.containsKey(userId)) { return; }																// T : O(1)
		
		for (Tweet tweet : tweetInfo.get(userId)) {																	// T : O(tweet)
			minHeap.offer(tweet);
			while (minHeap.size() > 10) { minHeap.poll(); }
		}
	}
	
}
