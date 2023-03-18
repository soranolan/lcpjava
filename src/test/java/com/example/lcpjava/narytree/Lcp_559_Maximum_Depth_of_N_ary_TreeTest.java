package com.example.lcpjava.narytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.N_Ary_TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_559_Maximum_Depth_of_N_ary_TreeTest {
	
	private Lcp_559_Maximum_Depth_of_N_ary_Tree lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_559_Maximum_Depth_of_N_ary_Tree();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		int expected = 3;
		N_Ary_TreeNode root = tool.n_ary_levelorder(new Integer[] { 1, null, 3, 2, 4, null, 5, 6 });
		int test = lcp.maxDepth(root);
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 5;
		N_Ary_TreeNode root = tool.n_ary_levelorder(new Integer[] { 1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14 });
		int test = lcp.maxDepth(root);
		assertThat(test).isEqualTo(expected);
	}
	
}
