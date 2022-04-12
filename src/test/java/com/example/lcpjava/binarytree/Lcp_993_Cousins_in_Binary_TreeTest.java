package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;

class Lcp_993_Cousins_in_Binary_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_993_Cousins_in_Binary_Tree lcp = new Lcp_993_Cousins_in_Binary_Tree();
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode l1l1 = new TreeNode(4);
		TreeNode r1 = new TreeNode(3);
		
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
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode l1r1 = new TreeNode(4);
		TreeNode r1 = new TreeNode(3);
		TreeNode r1r1 = new TreeNode(5);
		
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
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		TreeNode l1r1 = new TreeNode(4);
		
		root.left = l1;
		l1.right = l1r1;
		root.right = r1;
		
		int x = 2;
		int y = 3;
		
		boolean test = lcp.isCousins(root, x, y);
		
		assertThat(test).isFalse();
	}
	
}
