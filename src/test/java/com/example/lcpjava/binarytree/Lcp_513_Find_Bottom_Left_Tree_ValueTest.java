package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_513_TreeNode;

class Lcp_513_Find_Bottom_Left_Tree_ValueTest {
	
	@Test
	void test_case_1() {
		Lcp_513_Find_Bottom_Left_Tree_Value lcp = new Lcp_513_Find_Bottom_Left_Tree_Value();
		
		int expected = 1;
		
		Lcp_513_TreeNode root = new Lcp_513_TreeNode(2);
		Lcp_513_TreeNode l1 = new Lcp_513_TreeNode(1);
		Lcp_513_TreeNode r1 = new Lcp_513_TreeNode(3);
		
		root.left = l1;
		root.right = r1;
		
		int test = lcp.findBottomLeftValue(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_513_Find_Bottom_Left_Tree_Value lcp = new Lcp_513_Find_Bottom_Left_Tree_Value();
		
		int expected = 7;
		
		Lcp_513_TreeNode root = new Lcp_513_TreeNode(1);
		Lcp_513_TreeNode l1 = new Lcp_513_TreeNode(2);
		Lcp_513_TreeNode l1l1 = new Lcp_513_TreeNode(4);
		Lcp_513_TreeNode r1 = new Lcp_513_TreeNode(3);
		Lcp_513_TreeNode r1l1 = new Lcp_513_TreeNode(5);
		Lcp_513_TreeNode r1l1l1 = new Lcp_513_TreeNode(7);
		Lcp_513_TreeNode r1r1 = new Lcp_513_TreeNode(6);
		
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
