package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_2_Add_Two_NumbersTest {
	
	@Test
	void test_case_1() {
		Lcp_2_Add_Two_Numbers lcp = new Lcp_2_Add_Two_Numbers();
		
		ListNode expect = new ListNode(7);
		ListNode expect2 = new ListNode(0);
		ListNode expect3 = new ListNode(8);
		
		expect.next = expect2;
		expect2.next = expect3;
		
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
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_2_Add_Two_Numbers lcp = new Lcp_2_Add_Two_Numbers();
		
		ListNode expect = new ListNode(0);
		
		ListNode l1_1 = new ListNode(0);
		
		ListNode l2_1 = new ListNode(0);
		
		ListNode test = lcp.addTwoNumbers(l1_1, l2_1);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_2_Add_Two_Numbers lcp = new Lcp_2_Add_Two_Numbers();
		
		ListNode expect = new ListNode(8);
		ListNode expect2 = new ListNode(9);
		ListNode expect3 = new ListNode(9);
		ListNode expect4 = new ListNode(9);
		ListNode expect5 = new ListNode(0);
		ListNode expect6 = new ListNode(0);
		ListNode expect7 = new ListNode(0);
		ListNode expect8 = new ListNode(1);
		
		expect.next = expect2;
		expect2.next = expect3;
		expect3.next = expect4;
		expect4.next = expect5;
		expect5.next = expect6;
		expect6.next = expect7;
		expect7.next = expect8;
		
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
		
		assertThat(test).isEqualTo(expect);
	}
	
}
