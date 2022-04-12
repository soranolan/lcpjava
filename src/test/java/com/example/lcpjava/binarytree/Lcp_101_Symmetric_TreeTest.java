package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;

class Lcp_101_Symmetric_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_101_Symmetric_Tree lcp = new Lcp_101_Symmetric_Tree();
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode l1l1 = new TreeNode(3);
		TreeNode l1r1 = new TreeNode(4);
		TreeNode r1 = new TreeNode(2);
		TreeNode r1l1 = new TreeNode(4);
		TreeNode r1r1 = new TreeNode(3);
		
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
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode l1r1 = new TreeNode(3);
		TreeNode r1 = new TreeNode(2);
		TreeNode r1r1 = new TreeNode(3);
		
		root.left = l1;
		root.right = r1;
		l1.right = l1r1;
		r1.right = r1r1;
		
		boolean test = lcp.isSymmetric(root);
		
		assertThat(test).isFalse();
	}
	
}
