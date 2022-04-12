package com.example.lcpjava.linkedlist;

import com.example.lcpjava.common.Lcp_707_Node;

/** Singly */
public class MyLinkedList_2 {
	
	public Lcp_707_Node head;
	
	public Lcp_707_Node tail;
	
	public MyLinkedList_2() { }
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public int get(int index) {
		int count = 0;
		Lcp_707_Node current = head;
		
		while (current != null) {																					// T : O(n)
			if (count == index) { return current.val; }
			current = current.next;
			count++;
		}
		
		return -1;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public void addAtHead(int val) {
		Lcp_707_Node current = new Lcp_707_Node(val);
		
		if (head == null) {
			head = current;
			tail = current;
			return;
		}
		
		current.next = head;
		head = current;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public void addAtTail(int val) {
		Lcp_707_Node current = new Lcp_707_Node(val);
		
		if (tail == null) {
			head = current;
			tail = current;
			return;
		}
		
		tail.next = current;
		tail = current;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public void addAtIndex(int index, int val) {
		int size = size();																							// T : O(n)
		if (index < 0 || index > size) { return; }
		
		if (index == 0) {
			addAtHead(val);																							// T : O(1)
			return;
		}
		
		if (index == size) {
			addAtTail(val);																							// T : O(1)
			return;
		}
		
		Lcp_707_Node current = new Lcp_707_Node(val);
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
		
		Lcp_707_Node previous = getNode(index - 1);																	// T : O(n)
		if (index == (size - 1)) {
			previous.next = null;
			tail = previous;
			return;
		}
		
		Lcp_707_Node target = getNode(index);																		// T : O(n)
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
