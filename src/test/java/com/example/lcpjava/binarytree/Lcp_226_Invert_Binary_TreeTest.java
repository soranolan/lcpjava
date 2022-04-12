package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;

class Lcp_226_Invert_Binary_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_226_Invert_Binary_Tree lcp = new Lcp_226_Invert_Binary_Tree();
		
		TreeNode expect = new TreeNode(4);
		TreeNode el1 = new TreeNode(7);
		TreeNode el1l1 = new TreeNode(9);
		TreeNode el1r1 = new TreeNode(6);
		TreeNode er1 = new TreeNode(2);
		TreeNode er1l1 = new TreeNode(3);
		TreeNode er1r1 = new TreeNode(1);
		
		expect.left = el1;
		el1.left = el1l1;
		el1.right = el1r1;
		expect.right = er1;
		er1.left = er1l1;
		er1.right = er1r1;
		
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode l1l1 = new TreeNode(1);
		TreeNode l1r1 = new TreeNode(3);
		TreeNode r1 = new TreeNode(7);
		TreeNode r1l1 = new TreeNode(6);
		TreeNode r1r1 = new TreeNode(9);
		
		root.left = l1;
		l1.left = l1l1;
		l1.right = l1r1;
		root.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		TreeNode test = lcp.invertTree(root);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_226_Invert_Binary_Tree lcp = new Lcp_226_Invert_Binary_Tree();
		
		TreeNode expect = new TreeNode(2);
		TreeNode el1 = new TreeNode(3);
		TreeNode er1 = new TreeNode(1);
		
		expect.left = el1;
		expect.right = er1;
		
		TreeNode root = new TreeNode(2);
		TreeNode l1 = new TreeNode(1);
		TreeNode r1 = new TreeNode(3);
		
		root.left = l1;
		root.right = r1;
		
		TreeNode test = lcp.invertTree(root);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_226_Invert_Binary_Tree lcp = new Lcp_226_Invert_Binary_Tree();
		
		TreeNode test = lcp.invertTree(null);
		
		assertThat(test).isNull();
	}
	
}
