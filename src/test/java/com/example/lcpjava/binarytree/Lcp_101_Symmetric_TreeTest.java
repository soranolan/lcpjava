package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_101_TreeNode;

class Lcp_101_Symmetric_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_101_Symmetric_Tree lcp = new Lcp_101_Symmetric_Tree();
		
		Lcp_101_TreeNode root = new Lcp_101_TreeNode(1);
		Lcp_101_TreeNode l1 = new Lcp_101_TreeNode(2);
		Lcp_101_TreeNode l1l1 = new Lcp_101_TreeNode(3);
		Lcp_101_TreeNode l1r1 = new Lcp_101_TreeNode(4);
		Lcp_101_TreeNode r1 = new Lcp_101_TreeNode(2);
		Lcp_101_TreeNode r1l1 = new Lcp_101_TreeNode(4);
		Lcp_101_TreeNode r1r1 = new Lcp_101_TreeNode(3);
		
		root.left = l1;
		root.right = r1;
		l1.left = l1l1;
		l1.right = l1r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		boolean test = lcp.isSymmetric(root);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		Lcp_101_Symmetric_Tree lcp = new Lcp_101_Symmetric_Tree();
		
		Lcp_101_TreeNode root = new Lcp_101_TreeNode(1);
		Lcp_101_TreeNode l1 = new Lcp_101_TreeNode(2);
		Lcp_101_TreeNode l1r1 = new Lcp_101_TreeNode(3);
		Lcp_101_TreeNode r1 = new Lcp_101_TreeNode(2);
		Lcp_101_TreeNode r1r1 = new Lcp_101_TreeNode(3);
		
		root.left = l1;
		root.right = r1;
		l1.right = l1r1;
		r1.right = r1r1;
		
		boolean test = lcp.isSymmetric(root);
		
		assertThat(test).isFalse();
	}
	
}
