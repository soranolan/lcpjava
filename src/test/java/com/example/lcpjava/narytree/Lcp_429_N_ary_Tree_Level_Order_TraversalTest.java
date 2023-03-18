package com.example.lcpjava.narytree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.N_Ary_TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_429_N_ary_Tree_Level_Order_TraversalTest {
	
	private Lcp_429_N_ary_Tree_Level_Order_Traversal lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_429_N_ary_Tree_Level_Order_Traversal();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		List<List<Integer>> expected = Arrays.stream(new Integer[][] { { 1 }, { 3, 2, 4 }, { 5, 6 } }).map(Arrays::asList).collect(Collectors.toList());
		N_Ary_TreeNode root = tool.n_ary_levelorder(new Integer[] { 1, null, 3, 2, 4, null, 5, 6 });
		List<List<Integer>> test = lcp.levelOrder(root);
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<List<Integer>> expected = Arrays.stream(new Integer[][] { { 1 }, { 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13 }, { 14 } }).map(Arrays::asList).collect(Collectors.toList());
		N_Ary_TreeNode root = tool.n_ary_levelorder(new Integer[] { 1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14 });
		List<List<Integer>> test = lcp.levelOrder(root);
		assertThat(test).isEqualTo(expected);
	}
	
}
