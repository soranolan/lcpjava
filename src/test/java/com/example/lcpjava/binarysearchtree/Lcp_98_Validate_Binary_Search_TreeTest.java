package com.example.lcpjava.binarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_98_Validate_Binary_Search_TreeTest {
	
	private Lcp_98_Validate_Binary_Search_Tree lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_98_Validate_Binary_Search_Tree();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		TreeNode root = tool.preorder(new Integer[] { 2, 1, 3 });
		boolean test = lcp.isValidBST(root);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		TreeNode root = tool.preorder(new Integer[] { 5, 1, 4, null, null, 3, 6 });
		boolean test = lcp.isValidBST(root);
		
		assertThat(test).isFalse();
	}
	
}
