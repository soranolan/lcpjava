package com.example.lcpjava.common;

import java.util.Objects;

public class Lcp_430_Node {
	
	public int val;
	
	public Lcp_430_Node prev;
	
	public Lcp_430_Node next;
	
	public Lcp_430_Node child;
	
	public Lcp_430_Node(int val) {
		this.val = val;
		this.prev = null;
		this.next = null;
		this.child = null;
	}
	
	// TODO without previous and child node in order to prevent stack over flow under unit test, quite weird
	@Override
	public int hashCode() {
		return Objects.hash(next, val);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lcp_430_Node other = (Lcp_430_Node) obj;
		return Objects.equals(next, other.next) && val == other.val;
	}
	
	@Override
	public String toString() {
		return "Lcp_430_Node [val=" + val + ", next=" + next + "]";
	}
	
}
