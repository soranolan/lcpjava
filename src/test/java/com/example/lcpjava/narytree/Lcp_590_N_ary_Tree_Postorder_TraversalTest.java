package com.example.lcpjava.narytree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.N_Ary_TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_590_N_ary_Tree_Postorder_TraversalTest {
	
	private Lcp_590_N_ary_Tree_Postorder_Traversal lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_590_N_ary_Tree_Postorder_Traversal();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		List<Integer> expected = Arrays.asList(new Integer[] { 5, 6, 3, 2, 4, 1 });
		N_Ary_TreeNode root = tool.n_ary_levelorder(new Integer[] { 1, null, 3, 2, 4, null, 5, 6 });
		List<Integer> test = lcp.postorder(root);
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<Integer> expected = Arrays.asList(new Integer[] { 2, 6, 14, 11, 7, 3, 12, 8, 4, 13, 9, 10, 5, 1 });
		N_Ary_TreeNode root = tool.n_ary_levelorder(new Integer[] { 1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14 });
		List<Integer> test = lcp.postorder(root);
		assertThat(test).isEqualTo(expected);
	}
	
}
