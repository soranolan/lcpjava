package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PeekingIterator_1 implements Iterator<Integer> {
	
	public List<Integer> bucket;																					// S : O(n)
	
	public int pointer;
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public PeekingIterator_1(Iterator<Integer> iterator) {
		bucket = new ArrayList<>();
		while (iterator.hasNext()) { bucket.add(iterator.next()); }													// T : O(n)
		pointer = 0;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public Integer peek() {
		if (!hasNext()) { throw new NoSuchElementException(); }
		return bucket.get(pointer);
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	@Override
	public Integer next() {
		int result = peek();
		pointer++;
		return result;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	@Override
	public boolean hasNext() {
		return pointer < bucket.size();
	}
	
}
