package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.ListNode;
import com.example.lcpjava.tool.BuildList;

class Lcp_234_Palindrome_Linked_ListTest {
	
	private Lcp_234_Palindrome_Linked_List lcp;
	
	private BuildList tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_234_Palindrome_Linked_List();
		tool = new BuildList();
	}
	
	@Test
	void test_case_1() {
		ListNode head = tool.singly(new int[] { 1, 2, 2, 1 });
		boolean test = lcp.isPalindrome(head);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		ListNode head = tool.singly(new int[] { 1, 2 });
		boolean test = lcp.isPalindrome(head);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		ListNode head = tool.singly(new int[] { 1, 2, 3, 4, 2, 1 });
		boolean test = lcp.isPalindrome(head);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_4() {
		ListNode head = tool.singly(new int[] { 1 });
		boolean test = lcp.isPalindrome(head);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_5() {
		ListNode head = tool.singly(new int[] { 1, 0, 1 });
		boolean test = lcp.isPalindrome(head);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_6() {
		ListNode head = tool.singly(new int[] { 1, 0, 0 });
		boolean test = lcp.isPalindrome(head);
		
		assertThat(test).isFalse();
	}
	
}
