package com.example.lcpjava.common;

public class UF_684 {
	
	public int[] root;
	
	public int[] rank;
	
	public UF_684() {  }
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public UF_684(int size) {
		root = new int[size];
		rank = new int[size];
		for (int i = 0; i < size; i++) { root[i] = i; }
	}
	
	/**
	 * time  : O(α(n))
	 * space : O(1)
	 * 
	 * Path Compression
	 * */
	public int find(int x) {
		if (x == root[x]) { return x; }
		
		return root[x] = find(root[x]);
	}
	
	/**
	 * time  : O(α(n))
	 * space : O(1)
	 * 
	 * Union by Rank
	 * */
	public boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if (rootX == rootY) { return false; }
		
		if (rank[rootX] > rank[rootY]) {
			root[rootY] = rootX;
		} else if (rank[rootX] < rank[rootY]) {
			root[rootX] = rootY;
		} else {
			root[rootY] = rootX;
			rank[rootX] += 1;
		}
		
		return true;
	}
	
}
