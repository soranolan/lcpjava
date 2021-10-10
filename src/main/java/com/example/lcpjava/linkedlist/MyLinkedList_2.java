package com.example.lcpjava.linkedlist;

/** Singly */
public class MyLinkedList_2 {
	
	class Node {
		public int val;
		public Node next;
		Node(int val) { this.val = val; }
	}
	
	public Node head;
	
	public Node tail;
	
	public MyLinkedList_2() { }
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public int get(int index) {
		int count = 0;
		Node current = head;
		
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
		Node current = new Node(val);
		
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
		Node current = new Node(val);
		
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
		
		Node current = new Node(val);
		Node previous = getNode(index - 1);																			// T : O(n)
		Node next = previous.next;
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
		
		Node previous = getNode(index - 1);																			// T : O(n)
		if (index == (size - 1)) {
			previous.next = null;
			tail = previous;
			return;
		}
		
		Node target = getNode(index);																				// T : O(n)
		previous.next = target.next;
	}
	
	// ========================================================================
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public int size() {
		int size = 0;
		Node temp = head;
		
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
	private Node getNode(int index) {
		Node temp = head;
		for (int i = 0; i < index; i++) { temp = temp.next; }														// T : O(n)
		return temp;
	}
	
}
