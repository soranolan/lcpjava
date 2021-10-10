package com.example.lcpjava.linkedlist;

/** Singly */
public class MyLinkedList_1 {
	
	class Node {
		public int val;
		public Node next;
		Node(int val) { this.val = val; }
	}
	
	public Node head;
	
	public Node tail;
	
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
		
		Node current = new Node(val);
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
		
		if (index == (size - 1)) {
			Node previous = getNode(index - 1);																		// T : O(n)
			previous.next = null;
			tail = previous;
			return;
		}
		
		Node target = getNode(index);;																				// T : O(n)
		Node previous = getNode(index - 1);																			// T : O(n)
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
