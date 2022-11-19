package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Lcp_587_Erect_the_Fence {
	
	/**
	 * time  : O(m * n)
	 * space : O(m)
	 * 
	 * Jarvis Algorithm
	 * 
	 * Solution Tab
	 * 
	 * Time Limit Exceeded
	 * */
	public int[][] outerTrees_1(int[][] trees) {
		Set<int[]> hull = new HashSet<>();																			// S : O(m)
		int n = trees.length;
		if (n < 4) {
			for (int[] p : trees) { hull.add(p); }
			return hull.toArray(new int[hull.size()][]);
		}
		
		int leftMostIndex = 0;
		for (int i = 0; i < n; i++) {																				// T : O(n)
			if (trees[i][0] < trees[leftMostIndex][0]) { leftMostIndex = i; }
		}
		
		int p = leftMostIndex;
		p = action(trees, hull, n, p);																				// T : O(n)
		
		while (p != leftMostIndex) {																				// T : O(m)
			p = action(trees, hull, n, p);																			// T : O(n)
		}
		
		return hull.toArray(new int[hull.size()][]);
	}
	
	private int action(int[][] trees, Set<int[]> hull, int n, int p) {
		int q = (p + 1) % n;
		
		// find the outer most point
		for (int i = 0; i < n; i++) {
			if (orientation(trees[p], trees[i], trees[q]) < 0) {
				q = i;
			}
		}
		
		// find the point between
		for (int i = 0; i < n; i++) {
			if (i != p && i != q && orientation(trees[p], trees[i], trees[q]) == 0 && inBetween(trees[p], trees[i], trees[q])) {
				hull.add(trees[i]);
			}
		}
		
		hull.add(trees[q]);
		p = q;
		return p;
	}
	
	private int orientation(int[] p, int[] q, int[] r) {
		return (q[1] - p[1]) * (r[0] - q[0]) - (r[1] - q[1]) * (q[0] - p[0]);
	}
	
	private boolean inBetween(int[] p, int[] i, int[] q) {
		boolean x = p[0] <= i[0] && i[0] <= q[0] || q[0] <= i[0] && i[0] <= p[0];
		boolean y = p[1] <= i[1] && i[1] <= q[1] || q[1] <= i[1] && i[1] <= p[1];
		return x && y;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * Graham Scan
	 * 
	 * Solution Tab
	 * https://leetcode.com/problems/erect-the-fence/discuss/1442266/A-Detailed-Explanation-with-Diagrams-(Graham-Scan)
	 * https://leetcode.com/problems/erect-the-fence/discuss/1442266/A-Detailed-Explanation-with-Diagrams-(Graham-Scan)/1071580
	 * */
	public int[][] outerTrees_2(int[][] trees) {
		if (trees.length <= 3) { return trees; }
		
		// T : O(n log n)
		Arrays.sort(trees, (offer, previous) -> offer[0] == previous[0] ? offer[1] - previous[1] : offer[0] - previous[0]);
		
		List<int[]> lower = new ArrayList<>();																		// S : O(n)
		List<int[]> upper = new ArrayList<>();																		// S : O(n)
		
		for (int[] tree : trees) {																					// T : O(n)
			while (lower.size() >= 2 && orientation(lower.get(lower.size() - 2), lower.get(lower.size() - 1), tree) > 0) {
				lower.remove(lower.size() - 1);
			}
			
			while (upper.size() >= 2 && orientation(upper.get(upper.size() - 2), upper.get(upper.size() - 1), tree) < 0) {
				upper.remove(upper.size() - 1);
			}
			
			lower.add(tree);
			upper.add(tree);
		}
		
		Set<int[]> set = new HashSet<>();																			// S : O(m)
		for (int[] l : lower) { set.add(l); }
		for (int[] u : upper) { set.add(u); }
		
		int[][] result = new int[set.size()][2];
		int index = 0;
		for (int[] s : set) { result[index++] = s; }
		return result;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * Monotone Chain
	 * 
	 * Solution Tab
	 * https://leetcode.com/problems/erect-the-fence/discuss/103306/C%2B%2B-and-Python-easy-wiki-solution
	 * https://leetcode.com/problems/erect-the-fence/discuss/103306/C++-and-Python-easy-wiki-solution/617487
	 * */
	public int[][] outerTrees(int[][] trees) {
		int n = trees.length;
		
		// T : O(n log n)
		Arrays.sort(trees, (offer, previous) -> previous[0] == offer[0] ? previous[1] - offer[1] : previous[0] - offer[0]);
		
		Stack<int[]> hull = new Stack<>();																			// S : O(n)
		
		for (int i = 0; i < n; i++) {																				// T : O(n)
			while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), trees[i]) > 0) {
				hull.pop();
			}
			hull.push(trees[i]);
		}
		hull.pop();
		
		for (int i = n - 1; i >= 0; i--) {																			// T : O(n)
			while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), trees[i]) > 0) {
				hull.pop();
			}
			hull.push(trees[i]);
		}
		
		Set<int[]> set = new HashSet<>(hull);
		return set.toArray(new int[set.size()][]);
	}
	
}
