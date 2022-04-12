package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.ListNode;

class Lcp_234_Palindrome_Linked_ListTest {
	
	@Test
	void test_case_1() {
		Lcp_234_Palindrome_Linked_List lcp = new Lcp_234_Palindrome_Linked_List();
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		boolean test = lcp.isPalindrome(node1);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		Lcp_234_Palindrome_Linked_List lcp = new Lcp_234_Palindrome_Linked_List();
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		
		node1.next = node2;
		
		boolean test = lcp.isPalindrome(node1);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		Lcp_234_Palindrome_Linked_List lcp = new Lcp_234_Palindrome_Linked_List();
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(1);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		boolean test = lcp.isPalindrome(node1);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_4() {
		Lcp_234_Palindrome_Linked_List lcp = new Lcp_234_Palindrome_Linked_List();
		
		ListNode node1 = new ListNode(1);
		
		boolean test = lcp.isPalindrome(node1);
		
		assertThat(test).isTrue();
	}
	
}
