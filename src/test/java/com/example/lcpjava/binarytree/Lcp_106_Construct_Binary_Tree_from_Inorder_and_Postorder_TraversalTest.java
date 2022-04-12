package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;

class Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_TraversalTest {
	
	@Test
	void test_case_1() {
		Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal lcp = new Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		
		TreeNode expected = new TreeNode(3);
		TreeNode l1 = new TreeNode(9);
		TreeNode r1 = new TreeNode(20);
		TreeNode r1l1 = new TreeNode(15);
		TreeNode r1r1 = new TreeNode(7);
		
		expected.left = l1;
		expected.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
		
		TreeNode test = lcp.buildTree(inorder, postorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal lcp = new Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		
		TreeNode expected = new TreeNode(-1);
		
		int[] inorder = { -1 };
		int[] postorder = { -1 };
		
		TreeNode test = lcp.buildTree(inorder, postorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal lcp = new Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		
		TreeNode expected = new TreeNode(3);
		TreeNode l1 = new TreeNode(9);
		TreeNode l1l1 = new TreeNode(8);
		TreeNode r1 = new TreeNode(20);
		TreeNode r1l1 = new TreeNode(15);
		TreeNode r1r1 = new TreeNode(7);
		
		expected.left = l1;
		expected.right = r1;
		l1.left = l1l1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		int[] inorder = { 8, 9, 3, 15, 20, 7 };
		int[] postorder = { 8, 9, 15, 7, 20, 3 };
		
		TreeNode test = lcp.buildTree(inorder, postorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal lcp = new Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		
		TreeNode expected = new TreeNode(3);
		
		int[] inorder = { 3 };
		int[] postorder = { 3 };
		
		TreeNode test = lcp.buildTree(inorder, postorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
