package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.ListNode;

class Lcp_1721_Swapping_Nodes_in_a_Linked_ListTest {
	
	@Test
	void test_case_1() {
		Lcp_1721_Swapping_Nodes_in_a_Linked_List lcp = new Lcp_1721_Swapping_Nodes_in_a_Linked_List();
		
		ListNode eroot = new ListNode(1);
		ListNode enode2 = new ListNode(4);
		ListNode enode3 = new ListNode(3);
		ListNode enode4 = new ListNode(2);
		ListNode enode5 = new ListNode(5);
		
		eroot.next = enode2;
		enode2.next = enode3;
		enode3.next = enode4;
		enode4.next = enode5;
		
		ListNode root = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		root.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		int k = 2;
		
		ListNode test = lcp.swapNodes(root, k);
		
		assertThat(test).isEqualTo(eroot);
	}
	
	@Test
	void test_case_2() {
		Lcp_1721_Swapping_Nodes_in_a_Linked_List lcp = new Lcp_1721_Swapping_Nodes_in_a_Linked_List();
		
		ListNode eroot = new ListNode(7);
		ListNode enode2 = new ListNode(9);
		ListNode enode3 = new ListNode(6);
		ListNode enode4 = new ListNode(6);
		ListNode enode5 = new ListNode(8);
		ListNode enode6 = new ListNode(7);
		ListNode enode7 = new ListNode(3);
		ListNode enode8 = new ListNode(0);
		ListNode enode9 = new ListNode(9);
		ListNode enode10 = new ListNode(5);
		
		eroot.next = enode2;
		enode2.next = enode3;
		enode3.next = enode4;
		enode4.next = enode5;
		enode5.next = enode6;
		enode6.next = enode7;
		enode7.next = enode8;
		enode8.next = enode9;
		enode9.next = enode10;
		
		ListNode root = new ListNode(7);
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(6);
		ListNode node5 = new ListNode(7);
		ListNode node6 = new ListNode(8);
		ListNode node7 = new ListNode(3);
		ListNode node8 = new ListNode(0);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(5);
		
		root.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		
		int k = 5;
		
		ListNode test = lcp.swapNodes(root, k);
		
		assertThat(test).isEqualTo(eroot);
	}
	
}
