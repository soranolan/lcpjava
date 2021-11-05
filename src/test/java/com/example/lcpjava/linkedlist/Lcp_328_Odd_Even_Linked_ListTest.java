package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_328_Odd_Even_Linked_ListTest {
	
	@Test
	void test_case_1() {
		Lcp_328_Odd_Even_Linked_List lcp = new Lcp_328_Odd_Even_Linked_List();
		
		ListNode expected = new ListNode(1);
		ListNode expected2 = new ListNode(3);
		ListNode expected3 = new ListNode(5);
		ListNode expected4 = new ListNode(2);
		ListNode expected5 = new ListNode(4);
		
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
		
		ListNode test = lcp.oddEvenList(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_328_Odd_Even_Linked_List lcp = new Lcp_328_Odd_Even_Linked_List();
		
		ListNode expected = new ListNode(2);
		ListNode expected2 = new ListNode(3);
		ListNode expected3 = new ListNode(6);
		ListNode expected4 = new ListNode(7);
		ListNode expected5 = new ListNode(1);
		ListNode expected6 = new ListNode(5);
		ListNode expected7 = new ListNode(4);
		
		expected.next = expected2;
		expected2.next = expected3;
		expected3.next = expected4;
		expected4.next = expected5;
		expected5.next = expected6;
		expected6.next = expected7;
		
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(7);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		ListNode test = lcp.oddEvenList(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
