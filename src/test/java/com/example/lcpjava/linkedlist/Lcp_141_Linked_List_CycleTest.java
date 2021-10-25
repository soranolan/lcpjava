package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_141_Linked_List_CycleTest {
	
	@Test
	void test_case_1() {
		Lcp_141_Linked_List_Cycle lcp = new Lcp_141_Linked_List_Cycle();
		
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		
		boolean test = lcp.hasCycle(node1);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		Lcp_141_Linked_List_Cycle lcp = new Lcp_141_Linked_List_Cycle();
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		
		node1.next = node2;
		node2.next = node1;
		
		boolean test = lcp.hasCycle(node1);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_3() {
		Lcp_141_Linked_List_Cycle lcp = new Lcp_141_Linked_List_Cycle();
		
		ListNode node1 = new ListNode(1);
		
		boolean test = lcp.hasCycle(node1);
		
		assertThat(test).isFalse();
	}
	
}
