package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_226_TreeNode;

class Lcp_226_Invert_Binary_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_226_Invert_Binary_Tree lcp = new Lcp_226_Invert_Binary_Tree();
		
		Lcp_226_TreeNode expect = new Lcp_226_TreeNode(4);
		Lcp_226_TreeNode el1 = new Lcp_226_TreeNode(7);
		Lcp_226_TreeNode el1l1 = new Lcp_226_TreeNode(9);
		Lcp_226_TreeNode el1r1 = new Lcp_226_TreeNode(6);
		Lcp_226_TreeNode er1 = new Lcp_226_TreeNode(2);
		Lcp_226_TreeNode er1l1 = new Lcp_226_TreeNode(3);
		Lcp_226_TreeNode er1r1 = new Lcp_226_TreeNode(1);
		
		expect.left = el1;
		el1.left = el1l1;
		el1.right = el1r1;
		expect.right = er1;
		er1.left = er1l1;
		er1.right = er1r1;
		
		Lcp_226_TreeNode root = new Lcp_226_TreeNode(4);
		Lcp_226_TreeNode l1 = new Lcp_226_TreeNode(2);
		Lcp_226_TreeNode l1l1 = new Lcp_226_TreeNode(1);
		Lcp_226_TreeNode l1r1 = new Lcp_226_TreeNode(3);
		Lcp_226_TreeNode r1 = new Lcp_226_TreeNode(7);
		Lcp_226_TreeNode r1l1 = new Lcp_226_TreeNode(6);
		Lcp_226_TreeNode r1r1 = new Lcp_226_TreeNode(9);
		
		root.left = l1;
		l1.left = l1l1;
		l1.right = l1r1;
		root.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		Lcp_226_TreeNode test = lcp.invertTree(root);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_226_Invert_Binary_Tree lcp = new Lcp_226_Invert_Binary_Tree();
		
		Lcp_226_TreeNode expect = new Lcp_226_TreeNode(2);
		Lcp_226_TreeNode el1 = new Lcp_226_TreeNode(3);
		Lcp_226_TreeNode er1 = new Lcp_226_TreeNode(1);
		
		expect.left = el1;
		expect.right = er1;
		
		Lcp_226_TreeNode root = new Lcp_226_TreeNode(2);
		Lcp_226_TreeNode l1 = new Lcp_226_TreeNode(1);
		Lcp_226_TreeNode r1 = new Lcp_226_TreeNode(3);
		
		root.left = l1;
		root.right = r1;
		
		Lcp_226_TreeNode test = lcp.invertTree(root);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_226_Invert_Binary_Tree lcp = new Lcp_226_Invert_Binary_Tree();
		
		Lcp_226_TreeNode test = lcp.invertTree(null);
		
		assertThat(test).isNull();
	}
	
}
