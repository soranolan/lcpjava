package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_2196_Create_Binary_Tree_From_DescriptionsTest {
	
	private Lcp_2196_Create_Binary_Tree_From_Descriptions lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	public void beforeEach() {
		lcp = new Lcp_2196_Create_Binary_Tree_From_Descriptions();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		TreeNode expected = tool.preorder(new Integer[] { 50, 20, 80, 15, 17, 19, null });
		int[][] descriptions = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } };
		TreeNode test = lcp.createBinaryTree(descriptions);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		TreeNode expected = tool.preorder(new Integer[] { 1, 2, null, null, 3, 4, null });
		int[][] descriptions = { { 1, 2, 1 }, { 2, 3, 0 }, { 3, 4, 1 } };
		TreeNode test = lcp.createBinaryTree(descriptions);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
