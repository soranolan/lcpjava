package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.ListNode;

class Lcp_142_Linked_List_Cycle_IITest {
	
	@Test
	void test_case_1() {
		Lcp_142_Linked_List_Cycle_II lcp = new Lcp_142_Linked_List_Cycle_II();
		
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		
		ListNode test = lcp.detectCycle(node1);
		
		assertThat(test).isEqualTo(node2);
	}
	
	@Test
	void test_case_2() {
		Lcp_142_Linked_List_Cycle_II lcp = new Lcp_142_Linked_List_Cycle_II();
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		
		node1.next = node2;
		node2.next = node1;
		
		ListNode test = lcp.detectCycle(node1);
		
		assertThat(test).isEqualTo(node1);
	}
	
	@Test
	void test_case_3() {
		Lcp_142_Linked_List_Cycle_II lcp = new Lcp_142_Linked_List_Cycle_II();
		
		ListNode node1 = new ListNode(1);
		
		ListNode test = lcp.detectCycle(node1);
		
		assertThat(test).isNull();
	}
	
}
