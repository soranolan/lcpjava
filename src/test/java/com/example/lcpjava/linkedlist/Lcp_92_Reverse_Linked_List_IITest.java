package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.ListNode;
import com.example.lcpjava.tool.BuildList;

class Lcp_92_Reverse_Linked_List_IITest {
	
	private Lcp_92_Reverse_Linked_List_II lcp;
	
	private BuildList tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_92_Reverse_Linked_List_II();
		tool = new BuildList();
	}
	
	@Test
	void test_case_1() {
		ListNode expected = tool.singly(new int[] { 1, 4, 3, 2, 5 });
		ListNode head = tool.singly(new int[] { 1, 2, 3, 4, 5 });
		int left = 2;
		int right = 4;
		ListNode test = lcp.reverseBetween(head, left, right);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		ListNode expected = tool.singly(new int[] { 5 });
		ListNode head = tool.singly(new int[] { 5 });
		int left = 1;
		int right = 1;
		ListNode test = lcp.reverseBetween(head, left, right);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		ListNode expected = tool.singly(new int[] { 5, 3 });
		ListNode head = tool.singly(new int[] { 3, 5 });
		int left = 1;
		int right = 2;
		ListNode test = lcp.reverseBetween(head, left, right);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
