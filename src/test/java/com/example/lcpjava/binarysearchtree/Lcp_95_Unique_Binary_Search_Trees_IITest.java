package com.example.lcpjava.binarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_95_Unique_Binary_Search_Trees_IITest {
	
	private Lcp_95_Unique_Binary_Search_Trees_II lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_95_Unique_Binary_Search_Trees_II();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		List<TreeNode> expected = new ArrayList<>();
		Integer[][] nodes = { { 1, null, 2, null, 3 }, { 1, null, 3, 2, null }, { 2, 1, 3 }, { 3, 1, null, null, 2 }, { 3, 2, null, 1, null } };
		for (Integer[] node : nodes) { expected.add(tool.preorder(node)); }
		
		int n = 3;
		List<TreeNode> test = lcp.generateTrees(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<TreeNode> expected = new ArrayList<>();
		expected.add(tool.preorder(new Integer[] { 1 }));
		
		int n = 1;
		List<TreeNode> test = lcp.generateTrees(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
