package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_814_Binary_Tree_PruningTest {
	
	private Lcp_814_Binary_Tree_Pruning lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_814_Binary_Tree_Pruning();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		TreeNode expected = tool.preorder(new Integer[] { 1, null, 0, null, 1 });
		TreeNode root = tool.preorder(new Integer[] { 1, null, 0, 0, 1 });
		TreeNode test = lcp.pruneTree(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		TreeNode expected = tool.preorder(new Integer[] { 1, null, 1, null, 1 });
		TreeNode root = tool.preorder(new Integer[] { 1, 0, 1, 0, 0, 0, 1 });
		TreeNode test = lcp.pruneTree(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		TreeNode expected = tool.preorder(new Integer[] { 1, 1, 0, 1, 1, null, 1 });
		TreeNode root = tool.preorder(new Integer[] { 1, 1, 0, 1, 1, 0, 1, 0, null });
		TreeNode test = lcp.pruneTree(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		TreeNode root = tool.preorder(new Integer[] { 0 });
		TreeNode test = lcp.pruneTree(root);
		
		assertThat(test).isNull();
	}
	
	@Test
	void test_case_5() {
		TreeNode expected = tool.preorder(new Integer[] { 0, 1, null });
		TreeNode root = tool.preorder(new Integer[] { 0, 1, 0 });
		TreeNode test = lcp.pruneTree(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
