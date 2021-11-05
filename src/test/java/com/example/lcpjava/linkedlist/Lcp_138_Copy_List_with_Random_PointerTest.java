package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_138_Copy_List_with_Random_PointerTest {
	
	@Test
	void test_case_1() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Node expected = new Node(7);
		Node expected2 = new Node(13);
		Node expected3 = new Node(11);
		Node expected4 = new Node(10);
		Node expected5 = new Node(1);
		
		expected.next = expected2;
		expected2.next = expected3;
		expected3.next = expected4;
		expected4.next = expected5;
		
		expected2.random = expected;
		expected3.random = expected5;
		expected4.random = expected3;
		expected5.random = expected;
		
		Node node1 = new Node(7);
		Node node2 = new Node(13);
		Node node3 = new Node(11);
		Node node4 = new Node(10);
		Node node5 = new Node(1);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		node2.random = node1;
		node3.random = node5;
		node4.random = node3;
		node5.random = node1;
		
		Node test = lcp.copyRandomList(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Node expected = new Node(1);
		Node expected2 = new Node(2);
		
		expected.next = expected2;
		
		expected.random = expected2;
		expected2.random = expected2;
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		
		node1.next = node2;
		
		node1.random = node2;
		node2.random = node2;
		
		Node test = lcp.copyRandomList(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Node expected = new Node(3);
		Node expected2 = new Node(3);
		Node expected3 = new Node(3);
		
		expected.next = expected2;
		expected2.next = expected3;
		
		expected2.random = expected;
		
		Node node1 = new Node(3);
		Node node2 = new Node(3);
		Node node3 = new Node(3);
		
		node1.next = node2;
		node2.next = node3;
		
		node2.random = node1;
		
		Node test = lcp.copyRandomList(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Node test = lcp.copyRandomList(null);
		
		assertThat(test).isNull();
	}
	
}
