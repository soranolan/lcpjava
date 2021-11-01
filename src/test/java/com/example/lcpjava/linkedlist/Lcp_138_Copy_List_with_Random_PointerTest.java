package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_138_Copy_List_with_Random_PointerTest {
	
	@Test
	void test_case_1() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Node expect = new Node(7);
		Node expect2 = new Node(13);
		Node expect3 = new Node(11);
		Node expect4 = new Node(10);
		Node expect5 = new Node(1);
		
		expect.next = expect2;
		expect2.next = expect3;
		expect3.next = expect4;
		expect4.next = expect5;
		
		expect2.random = expect;
		expect3.random = expect5;
		expect4.random = expect3;
		expect5.random = expect;
		
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
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Node expect = new Node(1);
		Node expect2 = new Node(2);
		
		expect.next = expect2;
		
		expect.random = expect2;
		expect2.random = expect2;
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		
		node1.next = node2;
		
		node1.random = node2;
		node2.random = node2;
		
		Node test = lcp.copyRandomList(node1);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Node expect = new Node(3);
		Node expect2 = new Node(3);
		Node expect3 = new Node(3);
		
		expect.next = expect2;
		expect2.next = expect3;
		
		expect2.random = expect;
		
		Node node1 = new Node(3);
		Node node2 = new Node(3);
		Node node3 = new Node(3);
		
		node1.next = node2;
		node2.next = node3;
		
		node2.random = node1;
		
		Node test = lcp.copyRandomList(node1);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_4() {
		Lcp_138_Copy_List_with_Random_Pointer lcp = new Lcp_138_Copy_List_with_Random_Pointer();
		
		Node test = lcp.copyRandomList(null);
		
		assertThat(test).isNull();
	}
	
}
