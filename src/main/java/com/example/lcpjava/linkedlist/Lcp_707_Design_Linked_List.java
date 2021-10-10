package com.example.lcpjava.linkedlist;

import com.example.lcpjava.linkedlist.MyLinkedList.Node;

public class Lcp_707_Design_Linked_List {
	
	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		
//		obj.addAtHead(2);
//		obj.deleteAtIndex(1);
//		obj.addAtHead(2);
//		obj.addAtHead(7);
//		obj.addAtHead(3);
//		obj.addAtHead(2);
//		obj.addAtHead(5);
//		obj.addAtTail(5);
//		obj.get(5);
//		obj.deleteAtIndex(6);
//		obj.deleteAtIndex(4);
		
		obj.addAtHead(1);
		obj.deleteAtIndex(0);
		
		Node temp = obj.head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println(obj.get(1));
	}
	
}
