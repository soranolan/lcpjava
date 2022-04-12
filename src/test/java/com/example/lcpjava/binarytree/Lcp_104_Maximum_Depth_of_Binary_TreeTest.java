package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_104_TreeNode;

class Lcp_104_Maximum_Depth_of_Binary_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_104_Maximum_Depth_of_Binary_Tree lcp = new Lcp_104_Maximum_Depth_of_Binary_Tree();
		
		int expected = 3;
		
		Lcp_104_TreeNode root = new Lcp_104_TreeNode(3);
		Lcp_104_TreeNode l1 = new Lcp_104_TreeNode(9);
		Lcp_104_TreeNode r1 = new Lcp_104_TreeNode(20);
		Lcp_104_TreeNode r1l1 = new Lcp_104_TreeNode(15);
		Lcp_104_TreeNode r1r1 = new Lcp_104_TreeNode(7);
		
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
		
		Lcp_104_TreeNode root = new Lcp_104_TreeNode(1);
		Lcp_104_TreeNode r1 = new Lcp_104_TreeNode(2);
		
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
		
		Lcp_104_TreeNode root = new Lcp_104_TreeNode(0);
		
		int test = lcp.maxDepth(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
