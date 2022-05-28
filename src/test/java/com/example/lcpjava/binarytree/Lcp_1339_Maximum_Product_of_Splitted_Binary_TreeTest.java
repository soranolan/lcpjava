package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_1339_Maximum_Product_of_Splitted_Binary_TreeTest {
	
	private Lcp_1339_Maximum_Product_of_Splitted_Binary_Tree lcp;
	
	private BuildTree tool;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1339_Maximum_Product_of_Splitted_Binary_Tree();
		tool = new BuildTree();
	}
	
	@Test
	void test_case_1() {
		int expected = 110;
		TreeNode root = tool.preorder(new Integer[] { 1, 2, 3, 4, 5, 6, null });
		int test = lcp.maxProduct(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 90;
		TreeNode root = tool.preorder(new Integer[] { 1, null, 2, 3, 4, null, null, 5, 6 });
		int test = lcp.maxProduct(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
