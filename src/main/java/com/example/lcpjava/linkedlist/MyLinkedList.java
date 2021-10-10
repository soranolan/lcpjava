package com.example.lcpjava.linkedlist;

public class MyLinkedList {
	
	class Node {
		public int val;
		public Node prev;
		public Node next;
		Node(int val) { this.val = val; }
	}
	
	public Node head;
	
	public Node tail;
	
	public MyLinkedList() { }
	
	public int get(int index) {
		int count = 0;
		Node current = head;
		
		while (current != null) {
			if (count == index) { return current.val; }
			current = current.next;
			count++;
		}
		
		return -1;
	}
	
	public void addAtHead(int val) {
		Node current = new Node(val);
		
		if (head == null) {
			head = current;
			tail = current;
			return;
		}
		
		current.next = head;
		head.prev = current;
		head = current;
	}
	
	public void addAtTail(int val) {
		Node current = new Node(val);
		
		if (tail == null) {
			head = current;
			tail = current;
			return;
		}
		
		tail.next = current;
		current.prev = tail;
		tail = current;
	}
	
	public void addAtIndex(int index, int val) {
		if (index == 0) {
			addAtHead(val);
			return;
		}
		
		int count = 0;
		Node temp = head;
		
		while (temp != null) {
			if (count == index) {
				Node current = new Node(val);
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
			addAtTail(val);
			return;
		}
	}
	
	public void deleteAtIndex(int index) {
		if (index < 0) { return; }
		if (index == 0) {
			head = head.next;
			if (head != null) { head.prev = null; }
			return;
		}
		
		int count = 1;
		Node temp = head.next;
		
		while (temp != null) {
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
