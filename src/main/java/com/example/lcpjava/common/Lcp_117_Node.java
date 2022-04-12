package com.example.lcpjava.common;

public class Lcp_117_Node {
	
	public int val;
	
	public Lcp_117_Node left;
	
	public Lcp_117_Node right;
	
	public Lcp_117_Node next;
	
	public Lcp_117_Node() {
		
	}
	
	public Lcp_117_Node(int val) {
		this.val = val;
	}
	
	public Lcp_117_Node(int val, Lcp_117_Node left, Lcp_117_Node right, Lcp_117_Node next) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.next = next;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + val;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lcp_117_Node other = (Lcp_117_Node) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (val != other.val)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Lcp_117_Node [val=" + val + ", left=" + left + ", right=" + right + ", next=" + next + "]";
	}
	
}
