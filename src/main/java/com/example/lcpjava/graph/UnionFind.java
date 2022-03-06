package com.example.lcpjava.graph;

public class UnionFind {
	
	public int[] root;
	
	public int[] rank;
	
	public UnionFind() {  }
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public UnionFind(int size) {
		root = new int[size];
		rank = new int[size];
		for (int i = 0; i < size; i++) { root[i] = i; }
	}
	
	/**
	 * time  : O(£\(n))
	 * space : O(1)
	 * */
	public int find(int x) {
		if (x == root[x]) { return x; }
		
		return root[x] = find(root[x]);
	}
	
	/**
	 * time  : O(£\(n))
	 * space : O(1)
	 * */
	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if (rootX == rootY) { return; }
		
		if (rank[rootX] > rank[rootY]) {
			root[rootY] = rootX;
		} else if (rank[rootX] < rank[rootY]) {
			root[rootX] = rootY;
		} else {
			root[rootY] = rootX;
			rank[rootX] += 1;
		}
	}
	
}
