package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_1302_Deepest_Leaves_SumTest {
	
	@Test
	void test_case_1() {
		Lcp_1302_Deepest_Leaves_Sum lcp = new Lcp_1302_Deepest_Leaves_Sum();
		BuildTree tool = new BuildTree();
		
		int expected = 15;
		TreeNode root = tool.preorder(new Integer[] { 1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8 });
		int test = lcp.deepestLeavesSum(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1302_Deepest_Leaves_Sum lcp = new Lcp_1302_Deepest_Leaves_Sum();
		BuildTree tool = new BuildTree();
		
		int expected = 19;
		TreeNode root = tool.preorder(new Integer[] { 6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5 });
		int test = lcp.deepestLeavesSum(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
