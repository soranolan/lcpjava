package com.example.lcpjava.linkedlist;

import com.example.lcpjava.common.Lcp_707_Node;

/** Doubly */
public class MyLinkedList_3 {
	
	public Lcp_707_Node head;
	
	public Lcp_707_Node tail;
	
	public MyLinkedList_3() { }
	
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
		head.prev = current;
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
		current.prev = tail;
		tail = current;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public void addAtIndex(int index, int val) {
		if (index == 0) {
			addAtHead(val);																							// T : O(1)
			return;
		}
		
		int count = 0;
		Lcp_707_Node temp = head;
		
		while (temp != null) {																						// T : O(n)
			if (count == index) {
				Lcp_707_Node current = new Lcp_707_Node(val);
				current.next = temp;
				current.prev = temp.prev;
				temp.prev.next = current;
				temp.prev = current;
				return;
			}
			temp = temp.next;
			count++;
		}
		
		if (count == index) {
			addAtTail(val);																							// T : O(1)
			return;
		}
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public void deleteAtIndex(int index) {
		if (index < 0) { return; }
		if (index == 0) {
			head = head.next;
			if (head != null) { head.prev = null; }
			return;
		}
		
		int count = 1;
		Lcp_707_Node temp = head.next;
		
		while (temp != null) {																						// T : O(n)
			if (count != index) {
				temp = temp.next;
				count++;
				continue;
			}
			if (temp.next != null) {
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				temp.next = null;
				temp.prev = null;
				return;
			} else {
				tail = tail.prev;
				tail.next = null;
				return;
			}
		}
	}
	
}
