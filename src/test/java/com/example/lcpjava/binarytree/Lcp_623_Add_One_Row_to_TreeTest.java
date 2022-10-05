package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_623_Add_One_Row_to_TreeTest {
	
	private Lcp_623_Add_One_Row_to_Tree lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_623_Add_One_Row_to_Tree();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		TreeNode expected = tool.preorder(new Integer[] { 4, 1, 1, 2, null, null, 6, 3, 1, 5, null });
		TreeNode root = tool.preorder(new Integer[] { 4, 2, 6, 3, 1, 5, null });
		int val = 1;
		int depth = 2;
		TreeNode test = lcp.addOneRow(root, val, depth);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		TreeNode expected = tool.preorder(new Integer[] { 4, 2, null, 1, 1, 3, null, null, 1 });
		TreeNode root = tool.preorder(new Integer[] { 4, 2, null, 3, 1 });
		int val = 1;
		int depth = 3;
		TreeNode test = lcp.addOneRow(root, val, depth);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		TreeNode expected = tool.preorder(new Integer[] { 2, 1, null });
		TreeNode root = tool.preorder(new Integer[] { 1 });
		int val = 2;
		int depth = 1;
		TreeNode test = lcp.addOneRow(root, val, depth);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
