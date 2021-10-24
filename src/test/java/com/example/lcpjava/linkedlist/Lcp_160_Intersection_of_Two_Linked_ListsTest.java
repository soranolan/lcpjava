package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.linkedlist.Lcp_160_Intersection_of_Two_Linked_Lists.ListNode;


class Lcp_160_Intersection_of_Two_Linked_ListsTest {
	
	@Test
	void test_case_1() {
		Lcp_160_Intersection_of_Two_Linked_Lists lcp = new Lcp_160_Intersection_of_Two_Linked_Lists();
		
		ListNode A1 = lcp.new ListNode(4);
		ListNode A2 = lcp.new ListNode(1);
		
		ListNode B1 = lcp.new ListNode(5);
		ListNode B2 = lcp.new ListNode(6);
		ListNode B3 = lcp.new ListNode(1);
		
		ListNode expect = lcp.new ListNode(8);
		ListNode C2 = lcp.new ListNode(4);
		ListNode C3 = lcp.new ListNode(5);
		
		A1.next = A2;
		A2.next = expect;
		
		B1.next = B2;
		B2.next = B3;
		B3.next = expect;
		
		expect.next = C2;
		C2.next = C3;
		
		ListNode test = lcp.getIntersectionNode(A1, B1);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_160_Intersection_of_Two_Linked_Lists lcp = new Lcp_160_Intersection_of_Two_Linked_Lists();
		
		ListNode A1 = lcp.new ListNode(1);
		ListNode A2 = lcp.new ListNode(9);
		ListNode A3 = lcp.new ListNode(1);
		
		ListNode B1 = lcp.new ListNode(3);
		
		ListNode expect = lcp.new ListNode(2);
		ListNode C2 = lcp.new ListNode(4);
		
		A1.next = A2;
		A2.next = A3;
		A3.next = expect;
		
		B1.next = expect;
		
		expect.next = C2;
		
		ListNode test = lcp.getIntersectionNode(A1, B1);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_160_Intersection_of_Two_Linked_Lists lcp = new Lcp_160_Intersection_of_Two_Linked_Lists();
		
		ListNode A1 = lcp.new ListNode(2);
		ListNode A2 = lcp.new ListNode(6);
		ListNode A3 = lcp.new ListNode(4);
		
		ListNode B1 = lcp.new ListNode(1);
		ListNode B2 = lcp.new ListNode(5);
		
		A1.next = A2;
		A2.next = A3;
		
		B1.next = B2;
		
		ListNode test = lcp.getIntersectionNode(A1, B1);
		
		assertThat(test).isNull();
	}
	
}
