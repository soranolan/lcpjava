package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.ListNode;
import com.example.lcpjava.tool.BuildList;

class Lcp_206_Reverse_Linked_ListTest {
	
	private Lcp_206_Reverse_Linked_List lcp;
	
	private BuildList tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_206_Reverse_Linked_List();
		tool = new BuildList();
	}
	
	@Test
	void test_case_1() {
		ListNode expected = tool.singly(new int[] { 5, 4, 3, 2, 1 });
		ListNode head = tool.singly(new int[] { 1, 2, 3, 4, 5 });
		ListNode test = lcp.reverseList(head);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		ListNode expected = tool.singly(new int[] { 2, 1 });
		ListNode head = tool.singly(new int[] { 1, 2 });
		ListNode test = lcp.reverseList(head);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		ListNode test = lcp.reverseList(null);
		
		assertThat(test).isNull();
	}
	
}
