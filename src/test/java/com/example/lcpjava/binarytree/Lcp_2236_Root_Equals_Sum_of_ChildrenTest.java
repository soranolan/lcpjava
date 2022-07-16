package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_2236_Root_Equals_Sum_of_ChildrenTest {
	
	private Lcp_2236_Root_Equals_Sum_of_Children lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_2236_Root_Equals_Sum_of_Children();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		TreeNode root = tool.preorder(new Integer[] { 10, 4, 6 });
		boolean test = lcp.checkTree(root);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		TreeNode root = tool.preorder(new Integer[] { 5, 3, 1 });
		boolean test = lcp.checkTree(root);
		
		assertThat(test).isFalse();
	}
	
}
