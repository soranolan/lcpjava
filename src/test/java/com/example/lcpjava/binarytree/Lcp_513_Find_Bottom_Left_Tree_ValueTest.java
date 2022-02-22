package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_513_Find_Bottom_Left_Tree_ValueTest {
	
	@Test
	void test_case_1() {
		Lcp_513_Find_Bottom_Left_Tree_Value lcp = new Lcp_513_Find_Bottom_Left_Tree_Value();
		
		int expected = 1;
		
		TreeNode root = new TreeNode(2);
		TreeNode l1 = new TreeNode(1);
		TreeNode r1 = new TreeNode(3);
		
		root.left = l1;
		root.right = r1;
		
		int test = lcp.findBottomLeftValue(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_513_Find_Bottom_Left_Tree_Value lcp = new Lcp_513_Find_Bottom_Left_Tree_Value();
		
		int expected = 7;
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode l1l1 = new TreeNode(4);
		TreeNode r1 = new TreeNode(3);
		TreeNode r1l1 = new TreeNode(5);
		TreeNode r1l1l1 = new TreeNode(7);
		TreeNode r1r1 = new TreeNode(6);
		
		root.left = l1;
		l1.left = l1l1;
		root.right = r1;
		r1.left = r1l1;
		r1l1.left = r1l1l1;
		r1.right = r1r1;
		
		int test = lcp.findBottomLeftValue(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
