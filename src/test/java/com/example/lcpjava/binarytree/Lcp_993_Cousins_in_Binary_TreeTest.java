package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_993_TreeNode;

class Lcp_993_Cousins_in_Binary_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_993_Cousins_in_Binary_Tree lcp = new Lcp_993_Cousins_in_Binary_Tree();
		
		Lcp_993_TreeNode root = new Lcp_993_TreeNode(1);
		Lcp_993_TreeNode l1 = new Lcp_993_TreeNode(2);
		Lcp_993_TreeNode l1l1 = new Lcp_993_TreeNode(4);
		Lcp_993_TreeNode r1 = new Lcp_993_TreeNode(3);
		
		root.left = l1;
		l1.left = l1l1;
		root.right = r1;
		
		int x = 4;
		int y = 3;
		
		boolean test = lcp.isCousins(root, x, y);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_2() {
		Lcp_993_Cousins_in_Binary_Tree lcp = new Lcp_993_Cousins_in_Binary_Tree();
		
		Lcp_993_TreeNode root = new Lcp_993_TreeNode(1);
		Lcp_993_TreeNode l1 = new Lcp_993_TreeNode(2);
		Lcp_993_TreeNode l1r1 = new Lcp_993_TreeNode(4);
		Lcp_993_TreeNode r1 = new Lcp_993_TreeNode(3);
		Lcp_993_TreeNode r1r1 = new Lcp_993_TreeNode(5);
		
		root.left = l1;
		l1.right = l1r1;
		root.right = r1;
		r1.right = r1r1;
		
		int x = 5;
		int y = 4;
		
		boolean test = lcp.isCousins(root, x, y);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_3() {
		Lcp_993_Cousins_in_Binary_Tree lcp = new Lcp_993_Cousins_in_Binary_Tree();
		
		Lcp_993_TreeNode root = new Lcp_993_TreeNode(1);
		Lcp_993_TreeNode l1 = new Lcp_993_TreeNode(2);
		Lcp_993_TreeNode r1 = new Lcp_993_TreeNode(3);
		Lcp_993_TreeNode l1r1 = new Lcp_993_TreeNode(4);
		
		root.left = l1;
		l1.right = l1r1;
		root.right = r1;
		
		int x = 2;
		int y = 3;
		
		boolean test = lcp.isCousins(root, x, y);
		
		assertThat(test).isFalse();
	}
	
}
