package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_707_Node;

class Lcp_707_Design_Linked_ListTest {
	
	@Test
	void test_case_1() {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtHead(2);
		obj.deleteAtIndex(1);
		obj.addAtHead(2);
		obj.addAtHead(7);
		obj.addAtHead(3);
		obj.addAtHead(2);
		obj.addAtHead(5);
		obj.addAtTail(5);
		
		int val = obj.get(5);
		assertThat(val).isEqualTo(2);
		
		obj.deleteAtIndex(6);
		obj.deleteAtIndex(4);
		
		Integer[] expected = { 5, 2, 3, 7, 2 };
		List<Integer> test = new ArrayList<>();
		
		Lcp_707_Node current = obj.head;
		while (current != null) {
			test.add(current.val);
			current = current.next;
		}
		
		assertThat(test).isEqualTo(Arrays.asList(expected));
	}
	
	@Test
	void test_case_2() {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtHead(1);
		obj.deleteAtIndex(0);
		
		Lcp_707_Node test = obj.head;
		assertThat(test).isNull();
	}
	
}
