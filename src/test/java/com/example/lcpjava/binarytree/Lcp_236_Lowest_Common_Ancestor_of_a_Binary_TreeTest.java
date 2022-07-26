package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_236_Lowest_Common_Ancestor_of_a_Binary_TreeTest {
	
	private Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		TreeNode root = tool.preorder(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
		TreeNode p = root.left;
		TreeNode q = root.right;
		
		TreeNode test = lcp.lowestCommonAncestor(root, p, q);
		
		assertThat(test).isEqualTo(root);
	}
	
	@Test
	void test_case_2() {
		TreeNode root = tool.preorder(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
		TreeNode p = root.left;
		TreeNode q = root.left.right.right;
		
		TreeNode test = lcp.lowestCommonAncestor(root, p, q);
		
		assertThat(test).isEqualTo(p);
	}
	
	@Test
	void test_case_3() {
		TreeNode root = tool.preorder(new Integer[] { 1, 2, null });
		TreeNode p = root;
		TreeNode q = root.left;
		
		TreeNode test = lcp.lowestCommonAncestor(root, p, q);
		
		assertThat(test).isEqualTo(p);
	}
	
}
