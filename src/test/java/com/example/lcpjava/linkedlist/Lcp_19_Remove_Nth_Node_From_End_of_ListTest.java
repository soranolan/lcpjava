package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.ListNode;

class Lcp_19_Remove_Nth_Node_From_End_of_ListTest {
	
	@Test
	void test_case_1() {
		Lcp_19_Remove_Nth_Node_From_End_of_List lcp = new Lcp_19_Remove_Nth_Node_From_End_of_List();
		
		ListNode expected = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		expected.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		int n = 2;
		
		ListNode test = lcp.removeNthFromEnd(expected, n);
		
		node3.next = node5;
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_19_Remove_Nth_Node_From_End_of_List lcp = new Lcp_19_Remove_Nth_Node_From_End_of_List();
		
		ListNode expected = new ListNode(1);
		
		int n = 1;
		
		ListNode test = lcp.removeNthFromEnd(expected, n);
		
		assertThat(test).isNull();
	}
	
	@Test
	void test_case_3() {
		Lcp_19_Remove_Nth_Node_From_End_of_List lcp = new Lcp_19_Remove_Nth_Node_From_End_of_List();
		
		ListNode expected = new ListNode(1);
		ListNode node2 = new ListNode(2);
		
		expected.next = node2;
		
		int n = 1;
		
		ListNode test = lcp.removeNthFromEnd(expected, n);
		
		expected.next = null;
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_19_Remove_Nth_Node_From_End_of_List lcp = new Lcp_19_Remove_Nth_Node_From_End_of_List();
		
		ListNode node1 = new ListNode(1);
		ListNode expected = new ListNode(2);
		
		node1.next = expected;
		
		int n = 2;
		
		ListNode test = lcp.removeNthFromEnd(node1, n);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
