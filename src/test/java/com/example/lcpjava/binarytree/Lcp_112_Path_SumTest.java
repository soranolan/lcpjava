package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_112_Path_SumTest {
	
	private Lcp_112_Path_Sum lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_112_Path_Sum();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		TreeNode root = tool.preorder(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 });
		
		boolean test = lcp.hasPathSum(root, 22);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		TreeNode root = tool.preorder(new Integer[] { 1, 2, 3 });
		
		boolean test = lcp.hasPathSum(root, 5);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		boolean test = lcp.hasPathSum(null, 0);
		
		assertThat(test).isFalse();
	}
	
}
