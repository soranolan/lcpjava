package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_113_Path_Sum_IITest {
	
	private Lcp_113_Path_Sum_II lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_113_Path_Sum_II();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		List<List<Integer>> expected = Arrays
												.stream(new Integer[][] { { 5, 4, 11, 2 }, { 5, 8, 4, 5 } })
												.map(Arrays::stream)
												.map(value -> value.collect(Collectors.toList()))
												.collect(Collectors.toList());
		TreeNode root = tool.preorder(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 });
		int targetSum = 22;
		List<List<Integer>> test = lcp.pathSum(root, targetSum);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<List<Integer>> expected = new ArrayList<>();
		TreeNode root = tool.preorder(new Integer[] { 1, 2, 3 });
		int targetSum = 5;
		List<List<Integer>> test = lcp.pathSum(root, targetSum);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		List<List<Integer>> expected = new ArrayList<>();
		TreeNode root = tool.preorder(new Integer[] { 1, 2, null });
		int targetSum = 0;
		List<List<Integer>> test = lcp.pathSum(root, targetSum);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
