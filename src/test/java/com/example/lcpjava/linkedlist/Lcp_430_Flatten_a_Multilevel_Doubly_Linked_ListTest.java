package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_430_Flatten_a_Multilevel_Doubly_Linked_ListTest {
	
	@Test
	void test_case_1() {
		Lcp_430_Flatten_a_Multilevel_Doubly_Linked_List lcp = new Lcp_430_Flatten_a_Multilevel_Doubly_Linked_List();
		
		Node expected = new Node(1);
		Node expected2 = new Node(2);
		Node expected3 = new Node(3);
		Node expected4 = new Node(7);
		Node expected5 = new Node(8);
		Node expected6 = new Node(11);
		Node expected7 = new Node(12);
		Node expected8 = new Node(9);
		Node expected9 = new Node(10);
		Node expected10 = new Node(4);
		Node expected11 = new Node(5);
		Node expected12 = new Node(6);
		
		expected.next = expected2;
		expected2.next = expected3;
		expected3.next = expected4;
		expected4.next = expected5;
		expected5.next = expected6;
		expected6.next = expected7;
		expected7.next = expected8;
		expected8.next = expected9;
		expected9.next = expected10;
		expected10.next = expected11;
		expected11.next = expected12;
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		
		node11.next = node12;
		
		
		node3.child = node7;
		node8.child = node11;
		
		Node test = lcp.flatten(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
