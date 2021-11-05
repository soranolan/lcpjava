package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_2_Add_Two_NumbersTest {
	
	@Test
	void test_case_1() {
		Lcp_2_Add_Two_Numbers lcp = new Lcp_2_Add_Two_Numbers();
		
		ListNode expected = new ListNode(7);
		ListNode expected2 = new ListNode(0);
		ListNode expected3 = new ListNode(8);
		
		expected.next = expected2;
		expected2.next = expected3;
		
		ListNode l1_1 = new ListNode(2);
		ListNode l1_2 = new ListNode(4);
		ListNode l1_3 = new ListNode(3);
		
		l1_1.next = l1_2;
		l1_2.next = l1_3;
		
		ListNode l2_1 = new ListNode(5);
		ListNode l2_2 = new ListNode(6);
		ListNode l2_3 = new ListNode(4);
		
		l2_1.next = l2_2;
		l2_2.next = l2_3;
		
		ListNode test = lcp.addTwoNumbers(l1_1, l2_1);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_2_Add_Two_Numbers lcp = new Lcp_2_Add_Two_Numbers();
		
		ListNode expected = new ListNode(0);
		
		ListNode l1_1 = new ListNode(0);
		
		ListNode l2_1 = new ListNode(0);
		
		ListNode test = lcp.addTwoNumbers(l1_1, l2_1);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_2_Add_Two_Numbers lcp = new Lcp_2_Add_Two_Numbers();
		
		ListNode expected = new ListNode(8);
		ListNode expected2 = new ListNode(9);
		ListNode expected3 = new ListNode(9);
		ListNode expected4 = new ListNode(9);
		ListNode expected5 = new ListNode(0);
		ListNode expected6 = new ListNode(0);
		ListNode expected7 = new ListNode(0);
		ListNode expected8 = new ListNode(1);
		
		expected.next = expected2;
		expected2.next = expected3;
		expected3.next = expected4;
		expected4.next = expected5;
		expected5.next = expected6;
		expected6.next = expected7;
		expected7.next = expected8;
		
		ListNode l1_1 = new ListNode(9);
		ListNode l1_2 = new ListNode(9);
		ListNode l1_3 = new ListNode(9);
		ListNode l1_4 = new ListNode(9);
		ListNode l1_5 = new ListNode(9);
		ListNode l1_6 = new ListNode(9);
		ListNode l1_7 = new ListNode(9);
		
		l1_1.next = l1_2;
		l1_2.next = l1_3;
		l1_3.next = l1_4;
		l1_4.next = l1_5;
		l1_5.next = l1_6;
		l1_6.next = l1_7;
		
		ListNode l2_1 = new ListNode(9);
		ListNode l2_2 = new ListNode(9);
		ListNode l2_3 = new ListNode(9);
		ListNode l2_4 = new ListNode(9);
		
		l2_1.next = l2_2;
		l2_2.next = l2_3;
		l2_3.next = l2_4;
		
		ListNode test = lcp.addTwoNumbers(l1_1, l2_1);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
