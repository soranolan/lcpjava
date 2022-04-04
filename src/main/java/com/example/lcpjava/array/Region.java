package com.example.lcpjava.array;

import java.util.HashSet;
import java.util.Set;

public class Region {
	
	public Set<Integer> infected;
	
	public Set<Integer> uninfected;
	
	public int wallsRequired;
	
	public boolean isUnderControlled;
	
	public Region() {
		infected = new HashSet<>();
		uninfected = new HashSet<>();
		wallsRequired = 0;
		isUnderControlled = false;
	}
	
	@Override
	public String toString() {
		return "Region [infected=" + infected + ", uninfected=" + uninfected + ", wallsRequired=" + wallsRequired + ", isUnderControlled=" + isUnderControlled + "]";
	}
	
}
