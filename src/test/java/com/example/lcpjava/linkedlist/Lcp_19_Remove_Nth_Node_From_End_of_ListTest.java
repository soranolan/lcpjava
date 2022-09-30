package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.ListNode;
import com.example.lcpjava.tool.BuildList;

class Lcp_19_Remove_Nth_Node_From_End_of_ListTest {
	
	private Lcp_19_Remove_Nth_Node_From_End_of_List lcp;
	
	private BuildList tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_19_Remove_Nth_Node_From_End_of_List();
		tool = new BuildList();
	}
	
	@Test
	void test_case_1() {
		ListNode expected = tool.singly(new int[] { 1, 2, 3, 5 });
		ListNode head = tool.singly(new int[] { 1, 2, 3, 4, 5 });
		int n = 2;
		ListNode test = lcp.removeNthFromEnd(head, n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		ListNode head = tool.singly(new int[] { 1 });
		int n = 1;
		ListNode test = lcp.removeNthFromEnd(head, n);
		
		assertThat(test).isNull();
	}
	
	@Test
	void test_case_3() {
		ListNode expected = tool.singly(new int[] { 1 });
		ListNode head = tool.singly(new int[] { 1, 2 });
		int n = 1;
		ListNode test = lcp.removeNthFromEnd(head, n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		ListNode expected = tool.singly(new int[] { 2 });
		ListNode head = tool.singly(new int[] { 1, 2 });
		int n = 2;
		ListNode test = lcp.removeNthFromEnd(head, n);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
