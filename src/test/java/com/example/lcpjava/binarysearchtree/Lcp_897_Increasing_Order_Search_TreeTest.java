package com.example.lcpjava.binarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_897_Increasing_Order_Search_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_897_Increasing_Order_Search_Tree lcp = new Lcp_897_Increasing_Order_Search_Tree();
		BuildTree buildTree = new BuildTree();
		
		TreeNode expected = buildTree.preorder(new Integer[] { 1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9 });
		TreeNode root = buildTree.preorder(new Integer[] { 5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9 });
		TreeNode test = lcp.increasingBST(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_897_Increasing_Order_Search_Tree lcp = new Lcp_897_Increasing_Order_Search_Tree();
		BuildTree buildTree = new BuildTree();
		
		TreeNode expected = buildTree.preorder(new Integer[] { 1, null, 5, null, 7 });
		TreeNode root = buildTree.preorder(new Integer[] { 5, 1, 7 });
		TreeNode test = lcp.increasingBST(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
