package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_112_TreeNode;

class Lcp_112_Path_SumTest {
	
	@Test
	void test_case_1() {
		Lcp_112_Path_Sum lcp = new Lcp_112_Path_Sum();
		
		Lcp_112_TreeNode root = new Lcp_112_TreeNode(5);
		Lcp_112_TreeNode l1 = new Lcp_112_TreeNode(4);
		Lcp_112_TreeNode l1l1 = new Lcp_112_TreeNode(11);
		Lcp_112_TreeNode l1l1l1 = new Lcp_112_TreeNode(7);
		Lcp_112_TreeNode l1l1r1 = new Lcp_112_TreeNode(2);
		Lcp_112_TreeNode r1 = new Lcp_112_TreeNode(8);
		Lcp_112_TreeNode r1l1 = new Lcp_112_TreeNode(13);
		Lcp_112_TreeNode r1r1 = new Lcp_112_TreeNode(4);
		Lcp_112_TreeNode r1r1r1 = new Lcp_112_TreeNode(1);
		
		root.left = l1;
		root.right = r1;
		l1.left = l1l1;
		l1l1.left = l1l1l1;
		l1l1.right = l1l1r1;
		r1.left = r1l1;
		r1.right = r1r1;
		r1r1.right = r1r1r1;
		
		boolean test = lcp.hasPathSum(root, 22);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		Lcp_112_Path_Sum lcp = new Lcp_112_Path_Sum();
		
		Lcp_112_TreeNode root = new Lcp_112_TreeNode(1);
		Lcp_112_TreeNode l1 = new Lcp_112_TreeNode(2);
		Lcp_112_TreeNode r1 = new Lcp_112_TreeNode(3);
		
		root.left = l1;
		root.right = r1;
		
		boolean test = lcp.hasPathSum(root, 5);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		Lcp_112_Path_Sum lcp = new Lcp_112_Path_Sum();
		
		boolean test = lcp.hasPathSum(null, 0);
		
		assertThat(test).isFalse();
	}
	
}
