package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_104_Maximum_Depth_of_Binary_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_104_Maximum_Depth_of_Binary_Tree lcp = new Lcp_104_Maximum_Depth_of_Binary_Tree();
		
		int expected = 3;
		
		TreeNode root = new TreeNode(3);
		TreeNode l1 = new TreeNode(9);
		TreeNode r1 = new TreeNode(20);
		TreeNode r1l1 = new TreeNode(15);
		TreeNode r1r1 = new TreeNode(7);
		
		root.left = l1;
		root.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		int test = lcp.maxDepth(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_104_Maximum_Depth_of_Binary_Tree lcp = new Lcp_104_Maximum_Depth_of_Binary_Tree();
		
		int expected = 2;
		
		TreeNode root = new TreeNode(1);
		TreeNode r1 = new TreeNode(2);
		
		root.right = r1;
		
		int test = lcp.maxDepth(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_104_Maximum_Depth_of_Binary_Tree lcp = new Lcp_104_Maximum_Depth_of_Binary_Tree();
		
		int expected = 0;
		
		int test = lcp.maxDepth(null);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_104_Maximum_Depth_of_Binary_Tree lcp = new Lcp_104_Maximum_Depth_of_Binary_Tree();
		
		int expected = 1;
		
		TreeNode root = new TreeNode(0);
		
		int test = lcp.maxDepth(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
