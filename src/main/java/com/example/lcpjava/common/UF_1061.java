package com.example.lcpjava.common;

public class UF_1061 {
	
	public int[] root;
	
	public int[] rank;
	
	public UF_1061() {  }
	
	public UF_1061(int size) {
		root = new int[size];
		rank = new int[size];
		
		int weight = 25;																							// Lexicographically
		for (int i = 0; i < size; i++) {
			root[i] = i;
			rank[i] = weight--;
		}
	}
	
	public int find(int x) {
		if (x == root[x]) { return x; }
		return root[x] = find(root[x]);
	}
	
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
