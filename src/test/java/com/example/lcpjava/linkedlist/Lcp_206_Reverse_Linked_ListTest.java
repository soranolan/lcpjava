package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.ListNode;

class Lcp_206_Reverse_Linked_ListTest {
	
	@Test
	void test_case_1() {
		Lcp_206_Reverse_Linked_List lcp = new Lcp_206_Reverse_Linked_List();
		
		ListNode expected = new ListNode(5);
		ListNode expected2 = new ListNode(4);
		ListNode expected3 = new ListNode(3);
		ListNode expected4 = new ListNode(2);
		ListNode expected5 = new ListNode(1);
		
		expected.next = expected2;
		expected2.next = expected3;
		expected3.next = expected4;
		expected4.next = expected5;
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode test = lcp.reverseList(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_206_Reverse_Linked_List lcp = new Lcp_206_Reverse_Linked_List();
		
		ListNode expected = new ListNode(2);
		ListNode expected2 = new ListNode(1);
		
		expected.next = expected2;
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		
		node1.next = node2;
		
		ListNode test = lcp.reverseList(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_206_Reverse_Linked_List lcp = new Lcp_206_Reverse_Linked_List();
		
		ListNode test = lcp.reverseList(null);
		
		assertThat(test).isNull();
	}
	
}
