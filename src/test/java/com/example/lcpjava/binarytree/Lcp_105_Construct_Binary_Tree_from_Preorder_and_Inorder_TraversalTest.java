package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_105_TreeNode;

class Lcp_105_Construct_Binary_Tree_from_Preorder_and_Inorder_TraversalTest {
	
	@Test
	void test_case_1() {
		Lcp_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal lcp = new Lcp_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
		
		Lcp_105_TreeNode expected = new Lcp_105_TreeNode(3);
		Lcp_105_TreeNode l1 = new Lcp_105_TreeNode(9);
		Lcp_105_TreeNode r1 = new Lcp_105_TreeNode(20);
		Lcp_105_TreeNode r1l1 = new Lcp_105_TreeNode(15);
		Lcp_105_TreeNode r1r1 = new Lcp_105_TreeNode(7);
		
		expected.left = l1;
		expected.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		
		Lcp_105_TreeNode test = lcp.buildTree(preorder, inorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal lcp = new Lcp_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
		
		Lcp_105_TreeNode expected = new Lcp_105_TreeNode(-1);
		
		int[] preorder = { -1 };
		int[] inorder = { -1 };
		
		Lcp_105_TreeNode test = lcp.buildTree(preorder, inorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
