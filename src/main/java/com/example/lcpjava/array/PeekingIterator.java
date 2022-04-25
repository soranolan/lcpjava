package com.example.lcpjava.array;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
	
	public PeekingIterator(Iterator<Integer> iterator) {
		
	}
	
	public Integer peek() {
		return -1;
	}
	
	@Override
	public Integer next() {
		return -1;
	}
	
	@Override
	public boolean hasNext() {
		return false;
	}
	
}
