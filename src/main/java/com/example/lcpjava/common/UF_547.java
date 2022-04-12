package com.example.lcpjava.common;

public class UF_547 extends UnionFind {
	
	public int provinces;
	
	public UF_547() {  }
	
	public UF_547(int size) {
		super(size);
		provinces = size;
	}
	
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
		
		provinces--;
	}
	
	public int provinces() {
		return provinces;
	}
	
}
