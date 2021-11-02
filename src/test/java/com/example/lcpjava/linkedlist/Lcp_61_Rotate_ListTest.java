package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_61_Rotate_ListTest {
	
	@Test
	void test_case_1() {
		Lcp_61_Rotate_List lcp = new Lcp_61_Rotate_List();
		
		ListNode expect = new ListNode(4);
		ListNode expect2 = new ListNode(5);
		ListNode expect3 = new ListNode(1);
		ListNode expect4 = new ListNode(2);
		ListNode expect5 = new ListNode(3);
		
		expect.next = expect2;
		expect2.next = expect3;
		expect3.next = expect4;
		expect4.next = expect5;
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		int k = 2;
		
		ListNode test = lcp.rotateRight(node1, k);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_61_Rotate_List lcp = new Lcp_61_Rotate_List();
		
		ListNode expect = new ListNode(2);
		ListNode expect2 = new ListNode(0);
		ListNode expect3 = new ListNode(1);
		
		expect.next = expect2;
		expect2.next = expect3;
		
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		
		node1.next = node2;
		node2.next = node3;
		
		int k = 4;
		
		ListNode test = lcp.rotateRight(node1, k);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
