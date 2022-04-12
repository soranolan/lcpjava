package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_116_Node;

class Lcp_116_Populating_Next_Right_Pointers_in_Each_NodeTest {
	
	@Test
	void test_case_1() {
		Lcp_116_Populating_Next_Right_Pointers_in_Each_Node lcp = new Lcp_116_Populating_Next_Right_Pointers_in_Each_Node();
		
		Lcp_116_Node expect = new Lcp_116_Node(1);
		Lcp_116_Node el1 = new Lcp_116_Node(2);
		Lcp_116_Node el1l1 = new Lcp_116_Node(4);
		Lcp_116_Node el1r1 = new Lcp_116_Node(5);
		Lcp_116_Node er1 = new Lcp_116_Node(3);
		Lcp_116_Node er1l1 = new Lcp_116_Node(6);
		Lcp_116_Node er1r1 = new Lcp_116_Node(7);
		
		expect.left = el1;
		el1.left = el1l1;
		el1.right = el1r1;
		expect.right = er1;
		er1.left = er1l1;
		er1.right = er1r1;
		
		el1.next = er1;
		el1l1.next = el1r1;
		el1r1.next = er1l1;
		er1l1.next = er1r1;
		
		Lcp_116_Node root = new Lcp_116_Node(1);
		Lcp_116_Node l1 = new Lcp_116_Node(2);
		Lcp_116_Node l1l1 = new Lcp_116_Node(4);
		Lcp_116_Node l1r1 = new Lcp_116_Node(5);
		Lcp_116_Node r1 = new Lcp_116_Node(3);
		Lcp_116_Node r1l1 = new Lcp_116_Node(6);
		Lcp_116_Node r1r1 = new Lcp_116_Node(7);
		
		root.left = l1;
		l1.left = l1l1;
		l1.right = l1r1;
		root.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		Lcp_116_Node test = lcp.connect(root);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_116_Populating_Next_Right_Pointers_in_Each_Node lcp = new Lcp_116_Populating_Next_Right_Pointers_in_Each_Node();
		
		Lcp_116_Node test = lcp.connect(null);
		
		assertThat(test).isNull();
	}
	
}
