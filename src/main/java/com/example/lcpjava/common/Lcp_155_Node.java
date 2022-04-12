package com.example.lcpjava.common;

public class Lcp_155_Node {
	
	public int val;
	
	public int min;
	
	public Lcp_155_Node next;
	
	public Lcp_155_Node() {
		
	}
	
	public Lcp_155_Node(int val, int min, Lcp_155_Node next) {
		this.val = val;
		this.min = min;
		this.next = next;
	}
	
}
