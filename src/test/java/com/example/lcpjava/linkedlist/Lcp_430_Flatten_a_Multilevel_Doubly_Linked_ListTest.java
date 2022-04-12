package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_430_Node;

class Lcp_430_Flatten_a_Multilevel_Doubly_Linked_ListTest {
	
	@Test
	void test_case_1() {
		Lcp_430_Flatten_a_Multilevel_Doubly_Linked_List lcp = new Lcp_430_Flatten_a_Multilevel_Doubly_Linked_List();
		
		Lcp_430_Node expected = new Lcp_430_Node(1);
		Lcp_430_Node expected2 = new Lcp_430_Node(2);
		Lcp_430_Node expected3 = new Lcp_430_Node(3);
		Lcp_430_Node expected4 = new Lcp_430_Node(7);
		Lcp_430_Node expected5 = new Lcp_430_Node(8);
		Lcp_430_Node expected6 = new Lcp_430_Node(11);
		Lcp_430_Node expected7 = new Lcp_430_Node(12);
		Lcp_430_Node expected8 = new Lcp_430_Node(9);
		Lcp_430_Node expected9 = new Lcp_430_Node(10);
		Lcp_430_Node expected10 = new Lcp_430_Node(4);
		Lcp_430_Node expected11 = new Lcp_430_Node(5);
		Lcp_430_Node expected12 = new Lcp_430_Node(6);
		
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
		
		Lcp_430_Node node1 = new Lcp_430_Node(1);
		Lcp_430_Node node2 = new Lcp_430_Node(2);
		Lcp_430_Node node3 = new Lcp_430_Node(3);
		Lcp_430_Node node4 = new Lcp_430_Node(4);
		Lcp_430_Node node5 = new Lcp_430_Node(5);
		Lcp_430_Node node6 = new Lcp_430_Node(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		Lcp_430_Node node7 = new Lcp_430_Node(7);
		Lcp_430_Node node8 = new Lcp_430_Node(8);
		Lcp_430_Node node9 = new Lcp_430_Node(9);
		Lcp_430_Node node10 = new Lcp_430_Node(10);
		
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		
		Lcp_430_Node node11 = new Lcp_430_Node(11);
		Lcp_430_Node node12 = new Lcp_430_Node(12);
		
		node11.next = node12;
		
		
		node3.child = node7;
		node8.child = node11;
		
		Lcp_430_Node test = lcp.flatten(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
