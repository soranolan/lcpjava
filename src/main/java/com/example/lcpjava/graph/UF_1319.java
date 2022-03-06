package com.example.lcpjava.graph;

public class UF_1319 extends UnionFind {
	
	int groups;
	
	public UF_1319() {  }
	
	public UF_1319(int size) {
		super(size);
		groups = size;
	}
	
	/**
	 * time  : O(£\(n))
	 * space : O(1)
	 * */
	@Override
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
		
		groups--;
	}
	
	public int groups() {
		return groups;
	}
	
}
