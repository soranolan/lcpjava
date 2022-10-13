package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.ListNode;
import com.example.lcpjava.tool.BuildList;

class Lcp_237_Delete_Node_in_a_Linked_ListTest {
	
	private Lcp_237_Delete_Node_in_a_Linked_List lcp;
	
	private BuildList tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_237_Delete_Node_in_a_Linked_List();
		tool = new BuildList();
	}
	
	@Test
	void test_case_1() {
		ListNode expected = tool.singly(new int[] { 4, 1, 9 });
		ListNode head = tool.singly(new int[] { 4, 5, 1, 9 });
		ListNode node = head.next;
		lcp.deleteNode(node);
		
		assertThat(head).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		ListNode expected = tool.singly(new int[] { 4, 5, 9 });
		ListNode head = tool.singly(new int[] { 4, 5, 1, 9 });
		ListNode node = head.next.next;
		lcp.deleteNode(node);
		
		assertThat(head).isEqualTo(expected);
	}
	
}
