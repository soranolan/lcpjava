package com.example.lcpjava.narytree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.N_Ary_TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_589_N_ary_Tree_Preorder_TraversalTest {
	
	private Lcp_589_N_ary_Tree_Preorder_Traversal lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_589_N_ary_Tree_Preorder_Traversal();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		List<Integer> expected = Arrays.asList(new Integer[] { 1, 3, 5, 6, 2, 4 });
		N_Ary_TreeNode root = tool.n_ary_levelorder(new Integer[] { 1, null, 3, 2, 4, null, 5, 6 });
		List<Integer> test = lcp.preorder(root);
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<Integer> expected = Arrays.asList(new Integer[] { 1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10 });
		N_Ary_TreeNode root = tool.n_ary_levelorder(new Integer[] { 1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14 });
		List<Integer> test = lcp.preorder(root);
		assertThat(test).isEqualTo(expected);
	}
	
}
