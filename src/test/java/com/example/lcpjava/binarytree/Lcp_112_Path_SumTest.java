package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_112_Path_SumTest {
	
	@Test
	void test_case_1() {
		Lcp_112_Path_Sum lcp = new Lcp_112_Path_Sum();
		
		TreeNode root = new TreeNode(5);
		TreeNode l1 = new TreeNode(4);
		TreeNode l1l1 = new TreeNode(11);
		TreeNode l1l1l1 = new TreeNode(7);
		TreeNode l1l1r1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(8);
		TreeNode r1l1 = new TreeNode(13);
		TreeNode r1r1 = new TreeNode(4);
		TreeNode r1r1r1 = new TreeNode(1);
		
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
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		
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
