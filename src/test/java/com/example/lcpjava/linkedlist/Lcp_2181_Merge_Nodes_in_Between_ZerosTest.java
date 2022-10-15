package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.ListNode;
import com.example.lcpjava.tool.BuildList;

class Lcp_2181_Merge_Nodes_in_Between_ZerosTest {
	
	private Lcp_2181_Merge_Nodes_in_Between_Zeros lcp;
	
	private BuildList tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_2181_Merge_Nodes_in_Between_Zeros();
		tool = new BuildList();
	}
	
	@Test
	void test_case_1() {
		ListNode expected = tool.singly(new int[] { 4, 11 });
		ListNode head = tool.singly(new int[] { 0, 3, 1, 0, 4, 5, 2, 0 });
		ListNode test = lcp.mergeNodes(head);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		ListNode expected = tool.singly(new int[] { 1, 3, 4 });
		ListNode head = tool.singly(new int[] { 0, 1, 0, 3, 0, 2, 2, 0 });
		ListNode test = lcp.mergeNodes(head);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
