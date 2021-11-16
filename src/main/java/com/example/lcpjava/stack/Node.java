package com.example.lcpjava.stack;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	public int val;
	
	public int min;
	
	public Node next;
	
	public List<Node> neighbors;
	
	public Node(int val, int min, Node next) {
		this.val = val;
		this.min = min;
		this.next = next;
	}
	
	public Node() {
		this.val = 0;
		this.neighbors = new ArrayList<Node>();
	}
	
	public Node(int val) {
		this.val = val;
		this.neighbors = new ArrayList<Node>();
	}
	
	public Node(int val, ArrayList<Node> neighbors) {
		this.val = val;
		this.neighbors = neighbors;
	}
	
}
