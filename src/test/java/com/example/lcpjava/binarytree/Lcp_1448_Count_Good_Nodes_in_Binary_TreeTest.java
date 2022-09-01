package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

public class Lcp_1448_Count_Good_Nodes_in_Binary_TreeTest {
	
	private Lcp_1448_Count_Good_Nodes_in_Binary_Tree lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1448_Count_Good_Nodes_in_Binary_Tree();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		int expected = 4;
		TreeNode root = tool.preorder(new Integer[] { 3, 1, 4, 3, null, 1, 5 });
		int test = lcp.goodNodes(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 3;
		TreeNode root = tool.preorder(new Integer[] { 3, 3, null, 4, 2 });
		int test = lcp.goodNodes(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 1;
		TreeNode root = tool.preorder(new Integer[] { 1 });
		int test = lcp.goodNodes(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		int expected = 4;
		TreeNode root = tool.preorder(new Integer[] { 2, null, 4, 10, 8, null, null, 4, null });
		int test = lcp.goodNodes(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
