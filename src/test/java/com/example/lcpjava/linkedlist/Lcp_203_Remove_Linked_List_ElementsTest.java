package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_203_Remove_Linked_List_ElementsTest {
	
	@Test
	void test_case_1() {
		Lcp_203_Remove_Linked_List_Elements lcp = new Lcp_203_Remove_Linked_List_Elements();
		
		ListNode expect = new ListNode(1);
		ListNode expect2 = new ListNode(2);
		ListNode expect3 = new ListNode(3);
		ListNode expect4 = new ListNode(4);
		ListNode expect5 = new ListNode(5);
		
		expect.next = expect2;
		expect2.next = expect3;
		expect3.next = expect4;
		expect4.next = expect5;
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		int val = 6;
		
		ListNode test = lcp.removeElements(node1, val);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_203_Remove_Linked_List_Elements lcp = new Lcp_203_Remove_Linked_List_Elements();
		
		int val = 1;
		
		ListNode test = lcp.removeElements(null, val);
		
		assertThat(test).isNull();
	}
	
	@Test
	void test_case_3() {
		Lcp_203_Remove_Linked_List_Elements lcp = new Lcp_203_Remove_Linked_List_Elements();
		
		ListNode node1 = new ListNode(7);
		ListNode node2 = new ListNode(7);
		ListNode node3 = new ListNode(7);
		ListNode node4 = new ListNode(7);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		int val = 7;
		
		ListNode test = lcp.removeElements(node1, val);
		
		assertThat(test).isNull();
	}
	
}
