package com.example.lcpjava.linkedlist;

import com.example.lcpjava.common.Lcp_707_Node;

/** Singly */
public class MyLinkedList_1 {
	
	public Lcp_707_Node head;
	
	public Lcp_707_Node tail;
	
	public MyLinkedList_1() { }
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public int get(int index) {
		int size = size();																							// T : O(n)
		if (index < 0 || index >= size) { return -1; }
		return getNode(index).val;																					// T : O(n)
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public void addAtHead(int val) {
		addAtIndex(0, val);
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public void addAtTail(int val) {
		addAtIndex(size(), val);
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public void addAtIndex(int index, int val) {
		int size = size();																							// T : O(n)
		if (index < 0 || index > size) { return; }
		
		Lcp_707_Node current = new Lcp_707_Node(val);
		if (head == null && tail == null) {
			head = current;
			tail = current;
			return;
		}
		
		if (index == 0) {
			current.next = head;
			head = current;
			return;
		}
		
		if (index == size) {
			tail.next = current;
			tail = current;
			return;
		}
		
		Lcp_707_Node previous = getNode(index - 1);																	// T : O(n)
		Lcp_707_Node next = previous.next;
		previous.next = current;
		current.next = next;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public void deleteAtIndex(int index) {
		int size = size();																							// T : O(n)
		if (index < 0 || index >= size) { return; }
		
		if (index == 0) {
			head = head.next;
			return;
		}
		
		if (index == (size - 1)) {
			Lcp_707_Node previous = getNode(index - 1);																// T : O(n)
			previous.next = null;
			tail = previous;
			return;
		}
		
		Lcp_707_Node target = getNode(index);;																		// T : O(n)
		Lcp_707_Node previous = getNode(index - 1);																	// T : O(n)
		previous.next = target.next;
	}
	
	// ========================================================================
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public int size() {
		int size = 0;
		Lcp_707_Node temp = head;
		
		while (temp != null) {																						// T : O(n)
			size++;
			temp = temp.next;
		}
		
		return size;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	private Lcp_707_Node getNode(int index) {
		Lcp_707_Node temp = head;
		for (int i = 0; i < index; i++) { temp = temp.next; }														// T : O(n)
		return temp;
	}
	
}
