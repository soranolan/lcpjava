package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_94_Binary_Tree_Inorder_TraversalTest {
	
	private Lcp_94_Binary_Tree_Inorder_Traversal lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_94_Binary_Tree_Inorder_Traversal();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		List<Integer> expected = Arrays.asList(new Integer[] { 1, 3, 2 });
		TreeNode root = tool.preorder(new Integer[] { 1, null, 2, 3, null });
		List<Integer> test = lcp.inorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<Integer> expected = new ArrayList<>();
		TreeNode root = null;
		List<Integer> test = lcp.inorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		List<Integer> expected = Arrays.asList(new Integer[] { 1 });
		TreeNode root = tool.preorder(new Integer[] { 1 });
		List<Integer> test = lcp.inorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		List<Integer> expected = Arrays.asList(new Integer[] { 2, 1 });
		TreeNode root = tool.preorder(new Integer[] { 1, 2, null });
		List<Integer> test = lcp.inorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_5() {
		List<Integer> expected = Arrays.asList(new Integer[] { 1, 2 });
		TreeNode root = tool.preorder(new Integer[] { 1, null, 2 });
		List<Integer> test = lcp.inorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
