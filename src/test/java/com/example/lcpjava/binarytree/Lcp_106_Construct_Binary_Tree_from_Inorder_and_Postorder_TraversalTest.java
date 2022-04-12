package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_106_TreeNode;

class Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_TraversalTest {
	
	@Test
	void test_case_1() {
		Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal lcp = new Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		
		Lcp_106_TreeNode expected = new Lcp_106_TreeNode(3);
		Lcp_106_TreeNode l1 = new Lcp_106_TreeNode(9);
		Lcp_106_TreeNode r1 = new Lcp_106_TreeNode(20);
		Lcp_106_TreeNode r1l1 = new Lcp_106_TreeNode(15);
		Lcp_106_TreeNode r1r1 = new Lcp_106_TreeNode(7);
		
		expected.left = l1;
		expected.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
		
		Lcp_106_TreeNode test = lcp.buildTree(inorder, postorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal lcp = new Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		
		Lcp_106_TreeNode expected = new Lcp_106_TreeNode(-1);
		
		int[] inorder = { -1 };
		int[] postorder = { -1 };
		
		Lcp_106_TreeNode test = lcp.buildTree(inorder, postorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal lcp = new Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		
		Lcp_106_TreeNode expected = new Lcp_106_TreeNode(3);
		Lcp_106_TreeNode l1 = new Lcp_106_TreeNode(9);
		Lcp_106_TreeNode l1l1 = new Lcp_106_TreeNode(8);
		Lcp_106_TreeNode r1 = new Lcp_106_TreeNode(20);
		Lcp_106_TreeNode r1l1 = new Lcp_106_TreeNode(15);
		Lcp_106_TreeNode r1r1 = new Lcp_106_TreeNode(7);
		
		expected.left = l1;
		expected.right = r1;
		l1.left = l1l1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		int[] inorder = { 8, 9, 3, 15, 20, 7 };
		int[] postorder = { 8, 9, 15, 7, 20, 3 };
		
		Lcp_106_TreeNode test = lcp.buildTree(inorder, postorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal lcp = new Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		
		Lcp_106_TreeNode expected = new Lcp_106_TreeNode(3);
		
		int[] inorder = { 3 };
		int[] postorder = { 3 };
		
		Lcp_106_TreeNode test = lcp.buildTree(inorder, postorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
