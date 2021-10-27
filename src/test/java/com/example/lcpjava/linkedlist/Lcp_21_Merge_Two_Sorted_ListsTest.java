package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_21_Merge_Two_Sorted_ListsTest {
	
	@Test
	void test_case_1() {
		Lcp_21_Merge_Two_Sorted_Lists lcp = new Lcp_21_Merge_Two_Sorted_Lists();
		
		ListNode expect = new ListNode(1);
		ListNode expect2 = new ListNode(1);
		ListNode expect3 = new ListNode(2);
		ListNode expect4 = new ListNode(3);
		ListNode expect5 = new ListNode(4);
		ListNode expect6 = new ListNode(4);
		
		expect.next = expect2;
		expect2.next = expect3;
		expect3.next = expect4;
		expect4.next = expect5;
		expect5.next = expect6;
		
		ListNode l1_1 = new ListNode(1);
		ListNode l1_2 = new ListNode(2);
		ListNode l1_3 = new ListNode(4);
		
		l1_1.next = l1_2;
		l1_2.next = l1_3;
		
		ListNode l2_1 = new ListNode(1);
		ListNode l2_2 = new ListNode(3);
		ListNode l2_3 = new ListNode(4);
		
		l2_1.next = l2_2;
		l2_2.next = l2_3;
		
		ListNode test = lcp.mergeTwoLists(l1_1, l2_1);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_21_Merge_Two_Sorted_Lists lcp = new Lcp_21_Merge_Two_Sorted_Lists();
		
		ListNode test = lcp.mergeTwoLists(null, null);
		
		assertThat(test).isNull();
	}
	
	@Test
	void test_case_3() {
		Lcp_21_Merge_Two_Sorted_Lists lcp = new Lcp_21_Merge_Two_Sorted_Lists();
		
		ListNode expect = new ListNode(0);
		
		ListNode l2 = new ListNode(0);
		
		ListNode test = lcp.mergeTwoLists(null, l2);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_4() {
		Lcp_21_Merge_Two_Sorted_Lists lcp = new Lcp_21_Merge_Two_Sorted_Lists();
		
		ListNode expect = new ListNode(1);
		ListNode expect2 = new ListNode(2);
		ListNode expect3 = new ListNode(3);
		ListNode expect4 = new ListNode(4);
		ListNode expect5 = new ListNode(5);
		ListNode expect6 = new ListNode(6);
		
		expect.next = expect2;
		expect2.next = expect3;
		expect3.next = expect4;
		expect4.next = expect5;
		expect5.next = expect6;
		
		ListNode l1_1 = new ListNode(1);
		ListNode l1_2 = new ListNode(2);
		
		l1_1.next = l1_2;
		
		ListNode l2_1 = new ListNode(3);
		ListNode l2_2 = new ListNode(4);
		ListNode l2_3 = new ListNode(5);
		ListNode l2_4 = new ListNode(6);
		
		l2_1.next = l2_2;
		l2_2.next = l2_3;
		l2_3.next = l2_4;
		
		ListNode test = lcp.mergeTwoLists(l1_1, l2_1);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
