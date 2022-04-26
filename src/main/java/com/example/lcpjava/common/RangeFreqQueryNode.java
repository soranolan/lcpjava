package com.example.lcpjava.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RangeFreqQueryNode {
	
	public int start;
	
	public int end;
	
	public RangeFreqQueryNode left;
	
	public RangeFreqQueryNode right;
	
	public Map<Integer, Integer> segment;
	
	public RangeFreqQueryNode() {  }
	
	public RangeFreqQueryNode(int start, int end) {
		this.start = start;
		this.end = end;
		segment = new HashMap<>();
	}
	
	@Override
	public String toString() {
		return "RangeFreqQueryNode [start=" + start + ", end=" + end + ", left=" + left + ", right=" + right + ", segment=" + segment + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(end, left, right, segment, start);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RangeFreqQueryNode other = (RangeFreqQueryNode) obj;
		return end == other.end && Objects.equals(left, other.left) && Objects.equals(right, other.right) && Objects.equals(segment, other.segment) && start == other.start;
	}
	
}
