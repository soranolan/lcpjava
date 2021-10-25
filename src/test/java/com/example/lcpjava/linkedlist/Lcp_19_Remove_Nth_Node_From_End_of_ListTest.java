package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_19_Remove_Nth_Node_From_End_of_ListTest {
	
	@Test
	void test_case_1() {
		Lcp_19_Remove_Nth_Node_From_End_of_List lcp = new Lcp_19_Remove_Nth_Node_From_End_of_List();
		
		ListNode expect = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		expect.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		int n = 2;
		
		ListNode test = lcp.removeNthFromEnd(expect, n);
		
		node3.next = node5;
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_19_Remove_Nth_Node_From_End_of_List lcp = new Lcp_19_Remove_Nth_Node_From_End_of_List();
		
		ListNode expect = new ListNode(1);
		
		int n = 1;
		
		ListNode test = lcp.removeNthFromEnd(expect, n);
		
		assertThat(test).isNull();
	}
	
	@Test
	void test_case_3() {
		Lcp_19_Remove_Nth_Node_From_End_of_List lcp = new Lcp_19_Remove_Nth_Node_From_End_of_List();
		
		ListNode expect = new ListNode(1);
		ListNode node2 = new ListNode(2);
		
		expect.next = node2;
		
		int n = 1;
		
		ListNode test = lcp.removeNthFromEnd(expect, n);
		
		expect.next = null;
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_4() {
		Lcp_19_Remove_Nth_Node_From_End_of_List lcp = new Lcp_19_Remove_Nth_Node_From_End_of_List();
		
		ListNode node1 = new ListNode(1);
		ListNode expect = new ListNode(2);
		
		node1.next = expect;
		
		int n = 2;
		
		ListNode test = lcp.removeNthFromEnd(node1, n);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
