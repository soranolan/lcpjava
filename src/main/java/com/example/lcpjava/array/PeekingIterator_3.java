package com.example.lcpjava.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.example.lcpjava.common.ListNode;

public class PeekingIterator_3 implements Iterator<Integer> {
	
	ListNode head;
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public PeekingIterator_3(Iterator<Integer> iterator) {
		head = new ListNode(-1);
		ListNode tail = head;
		
		while (iterator.hasNext()) {																				// T : O(n)
			tail.next = new ListNode(iterator.next());
			tail = tail.next;
		}
		
		head = head.next;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public Integer peek() {
		if (!hasNext()) { throw new NoSuchElementException(); }
		return head.val;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	@Override
	public Integer next() {
		if (!hasNext()) { throw new NoSuchElementException(); }
		int result = head.val;
		head = head.next;
		return result;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	@Override
	public boolean hasNext() {
		return head != null;
	}
	
}
