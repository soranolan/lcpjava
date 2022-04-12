package com.example.lcpjava.common;

import java.util.ArrayList;
import java.util.List;

public class Lcp_133_Node {
	
	public int val;
	
	public List<Lcp_133_Node> neighbors;
	
	public Lcp_133_Node() {
		this.val = 0;
		this.neighbors = new ArrayList<Lcp_133_Node>();
	}
	
	public Lcp_133_Node(int val) {
		this.val = val;
		this.neighbors = new ArrayList<Lcp_133_Node>();
	}
	
	public Lcp_133_Node(int val, ArrayList<Lcp_133_Node> neighbors) {
		this.val = val;
		this.neighbors = neighbors;
	}
	
}
