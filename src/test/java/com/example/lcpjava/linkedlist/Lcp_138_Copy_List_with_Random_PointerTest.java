package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_138_Node;

class Lcp_138_Copy_List_with_Random_PointerTest {
	
	@Test
	void test_case_1() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Lcp_138_Node expected = new Lcp_138_Node(7);
		Lcp_138_Node expected2 = new Lcp_138_Node(13);
		Lcp_138_Node expected3 = new Lcp_138_Node(11);
		Lcp_138_Node expected4 = new Lcp_138_Node(10);
		Lcp_138_Node expected5 = new Lcp_138_Node(1);
		
		expected.next = expected2;
		expected2.next = expected3;
		expected3.next = expected4;
		expected4.next = expected5;
		
		expected2.random = expected;
		expected3.random = expected5;
		expected4.random = expected3;
		expected5.random = expected;
		
		Lcp_138_Node node1 = new Lcp_138_Node(7);
		Lcp_138_Node node2 = new Lcp_138_Node(13);
		Lcp_138_Node node3 = new Lcp_138_Node(11);
		Lcp_138_Node node4 = new Lcp_138_Node(10);
		Lcp_138_Node node5 = new Lcp_138_Node(1);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		node2.random = node1;
		node3.random = node5;
		node4.random = node3;
		node5.random = node1;
		
		Lcp_138_Node test = lcp.copyRandomList(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Lcp_138_Node expected = new Lcp_138_Node(1);
		Lcp_138_Node expected2 = new Lcp_138_Node(2);
		
		expected.next = expected2;
		
		expected.random = expected2;
		expected2.random = expected2;
		
		Lcp_138_Node node1 = new Lcp_138_Node(1);
		Lcp_138_Node node2 = new Lcp_138_Node(2);
		
		node1.next = node2;
		
		node1.random = node2;
		node2.random = node2;
		
		Lcp_138_Node test = lcp.copyRandomList(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Lcp_138_Node expected = new Lcp_138_Node(3);
		Lcp_138_Node expected2 = new Lcp_138_Node(3);
		Lcp_138_Node expected3 = new Lcp_138_Node(3);
		
		expected.next = expected2;
		expected2.next = expected3;
		
		expected2.random = expected;
		
		Lcp_138_Node node1 = new Lcp_138_Node(3);
		Lcp_138_Node node2 = new Lcp_138_Node(3);
		Lcp_138_Node node3 = new Lcp_138_Node(3);
		
		node1.next = node2;
		node2.next = node3;
		
		node2.random = node1;
		
		Lcp_138_Node test = lcp.copyRandomList(node1);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Lcp_138_Node test = lcp.copyRandomList(null);
		
		assertThat(test).isNull();
	}
	
}
