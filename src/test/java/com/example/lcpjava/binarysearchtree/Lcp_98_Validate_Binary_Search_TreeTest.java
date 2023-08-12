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
		// Arrange
		TreeNode root = tool.preorder(new Integer[] { 2, 1, 3 });
		
		// Act
		boolean test = lcp.isValidBST(root);
		
		// Assert
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		// Arrange
		TreeNode root = tool.preorder(new Integer[] { 5, 1, 4, null, null, 3, 6 });
		
		// Act
		boolean test = lcp.isValidBST(root);
		
		// Assert
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		// Arrange
		TreeNode root = tool.preorder(new Integer[] { 5, 4, 6, null, null, 3, 7 });
		
		// Act
		boolean test = lcp.isValidBST(root);
		
		// Assert
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_4() {
		// Arrange
		TreeNode root = tool.preorder(new Integer[] { 3, 1, 5, 0, 2, 4, 6 });
		
		// Act
		boolean test = lcp.isValidBST(root);
		
		// Assert
		assertThat(test).isTrue();
	}
	
}
