package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_430_Flatten_a_Multilevel_Doubly_Linked_ListTest {
	
	@Test
	void test_case_1() {
		Lcp_430_Flatten_a_Multilevel_Doubly_Linked_List lcp = new Lcp_430_Flatten_a_Multilevel_Doubly_Linked_List();
		
		Node expect = new Node(1);
		Node expect2 = new Node(2);
		Node expect3 = new Node(3);
		Node expect4 = new Node(7);
		Node expect5 = new Node(8);
		Node expect6 = new Node(11);
		Node expect7 = new Node(12);
		Node expect8 = new Node(9);
		Node expect9 = new Node(10);
		Node expect10 = new Node(4);
		Node expect11 = new Node(5);
		Node expect12 = new Node(6);
		
		expect.next = expect2;
		expect2.next = expect3;
		expect3.next = expect4;
		expect4.next = expect5;
		expect5.next = expect6;
		expect6.next = expect7;
		expect7.next = expect8;
		expect8.next = expect9;
		expect9.next = expect10;
		expect10.next = expect11;
		expect11.next = expect12;
		
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
		
		assertThat(test).isEqualTo(expect);
	}
	
}
