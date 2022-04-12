package com.example.lcpjava.common;

import java.util.Objects;

public class Lcp_138_Node {
	
	public int val;
	
	public Lcp_138_Node next;
	
	public Lcp_138_Node random;
	
	public Lcp_138_Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
	
	// TODO without random node in order to prevent stack over flow under unit test, quite weird
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
		Lcp_138_Node other = (Lcp_138_Node) obj;
		return Objects.equals(next, other.next) && val == other.val;
	}
	
	@Override
	public String toString() {
		return "Lcp_138_Node [val=" + val + ", next=" + next + "]";
	}
	
}
