package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_1465_Maximum_Area_of_a_Piece_of_Cake_After_Horizontal_and_Vertical_Cuts {
	
	/**
	 * time  : O(h log h + v log v)
	 * space : O(h + v)
	 * */
	public int maxArea_1(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);																				// T : O(h log h)
		Arrays.sort(verticalCuts);																					// T : O(v log v)
		
		int[] hcs = new int[horizontalCuts.length + 1];																// S : O(h + 1)
		for (int i = 1; i < hcs.length; i++) { hcs[i] = horizontalCuts[i - 1]; }									// T : O(h - 1)
		for (int i = 0; i < hcs.length - 1; i++) { hcs[i] = hcs[i + 1] - hcs[i]; }									// T : O(h - 1)
		hcs[hcs.length - 1] = h - hcs[hcs.length - 1];
		
		int[] vcs = new int[verticalCuts.length + 1];																// S : O(v + 1)
		for (int i = 1; i < vcs.length; i++) { vcs[i] = verticalCuts[i - 1]; }										// T : O(v - 1)
		for (int i = 0; i < vcs.length - 1; i++) { vcs[i] = vcs[i + 1] - vcs[i]; }									// T : O(v - 1)
		vcs[vcs.length - 1] = w - vcs[vcs.length - 1];
		
		int mhc = 0;
		int mvc = 0;
		
		for (int hc : hcs) { mhc = Math.max(mhc, hc); }																// T : O(h + 1)
		for (int vc : vcs) { mvc = Math.max(mvc, vc); }																// T : O(v + 1)
		
		return (int) ((long) mhc * (long) mvc % (long) (1e9 + 7));
	}
	
	/**
	 * time  : O(h log h + v log v)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/discuss/661644/C%2B%2BJava-Maximum-Gap-Between-Cuts
	 * Accepted Solutions Runtime Distribution
	 * */
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);																				// T : O(h log h)
		Arrays.sort(verticalCuts);																					// T : O(v log v)
		
		int maxH = findMax(h, horizontalCuts);																		// T : O(h)
		int maxV = findMax(w, verticalCuts);																		// T : O(v)
		
		return (int) ((long) maxH * (long) maxV % (long) (1e9 + 7));
	}
	
	private int findMax(int size, int[] cuts) {
		int cutsLength = cuts.length;
		int maxDistance = Math.max(cuts[0], size - cuts[cutsLength - 1]);
		
		for (int i = 0; i < cutsLength - 1; i++) { maxDistance = Math.max(maxDistance, cuts[i + 1] - cuts[i]); }	// T : O(cuts length)
		
		return maxDistance;
	}
	
}
