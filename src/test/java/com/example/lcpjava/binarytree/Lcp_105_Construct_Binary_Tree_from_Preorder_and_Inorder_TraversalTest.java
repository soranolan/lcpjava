package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_105_Construct_Binary_Tree_from_Preorder_and_Inorder_TraversalTest {
	
	private Lcp_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		TreeNode expected = tool.preorder(new Integer[] { 3, 9, 20, null, null, 15, 7 });
		
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode test = lcp.buildTree(preorder, inorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		TreeNode expected = tool.preorder(new Integer[] { -1 });
		
		int[] preorder = { -1 };
		int[] inorder = { -1 };
		TreeNode test = lcp.buildTree(preorder, inorder);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
