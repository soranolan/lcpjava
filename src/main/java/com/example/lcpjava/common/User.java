package com.example.lcpjava.common;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	public int userId;
	
	public Set<Integer> followee;
	
	public User() {  }
	
	public User(int userId) {
		this.userId = userId;
		followee = new HashSet<>();
		followee.add(userId);
	}
	
}
