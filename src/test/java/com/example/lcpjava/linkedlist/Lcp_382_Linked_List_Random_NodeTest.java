package com.example.lcpjava.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Lcp_382_Linked_List_Random_NodeTest {
	
	@Test
	void test_case_1() {
		Lcp_382_Linked_List_Random_Node lcp = new Lcp_382_Linked_List_Random_Node();
		Map<Integer, Integer> memo = new HashMap<>();
		int maxCall = 10000;
		int size = 3;
		int probability = maxCall / size;
		double upper = probability * 1.05;
		double lower = probability * 0.95;
		
		ListNode root = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		root.next = node2;
		node2.next = node3;
		
		lcp.Solution(root);
		
		for (int i = 0; i < maxCall; i++) {
			int random = lcp.getRandom();
			memo.put(random, memo.getOrDefault(random, 0) + 1);
		}
		
		for (int prob : memo.values()) { assertThat(prob <= upper && prob >= lower).isTrue(); }
	}
	
}
