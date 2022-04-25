package com.example.lcpjava.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator_2 implements Iterator<Integer> {
	
	Integer nextValue;
	
	Iterator<Integer> it;
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public PeekingIterator_2(Iterator<Integer> iterator) {
		it = iterator;
		nextValue = it.hasNext() ? it.next() : null;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public Integer peek() {
		if (!hasNext()) { throw new NoSuchElementException(); }
		return nextValue;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	@Override
	public Integer next() {
		if (!hasNext()) { throw new NoSuchElementException(); }
		
		int result = nextValue;
		nextValue = it.hasNext() ? it.next() : null;
		return result;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	@Override
	public boolean hasNext() {
		return nextValue != null;
	}
	
}
