package com.example.lcpjava.binarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_669_TreeNode;

class Lcp_669_Trim_a_Binary_Search_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_669_Trim_a_Binary_Search_Tree lcp = new Lcp_669_Trim_a_Binary_Search_Tree();
		
		Lcp_669_TreeNode expected = new Lcp_669_TreeNode(1);
		Lcp_669_TreeNode er1 = new Lcp_669_TreeNode(2);
		
		expected.right = er1;
		
		Lcp_669_TreeNode root = new Lcp_669_TreeNode(1);
		Lcp_669_TreeNode l1 = new Lcp_669_TreeNode(0);
		Lcp_669_TreeNode r1 = new Lcp_669_TreeNode(2);
		
		root.left = l1;
		root.right = r1;
		
		int low = 1;
		int high = 2;
		
		Lcp_669_TreeNode test = lcp.trimBST(root, low, high);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_669_Trim_a_Binary_Search_Tree lcp = new Lcp_669_Trim_a_Binary_Search_Tree();
		
		Lcp_669_TreeNode expected = new Lcp_669_TreeNode(3);
		Lcp_669_TreeNode el1 = new Lcp_669_TreeNode(2);
		Lcp_669_TreeNode el1l1 = new Lcp_669_TreeNode(1);
		
		expected.left = el1;
		el1.left = el1l1;
		
		Lcp_669_TreeNode root = new Lcp_669_TreeNode(3);
		Lcp_669_TreeNode l1 = new Lcp_669_TreeNode(0);
		Lcp_669_TreeNode l1r1 = new Lcp_669_TreeNode(2);
		Lcp_669_TreeNode l1r1l1 = new Lcp_669_TreeNode(1);
		Lcp_669_TreeNode r1 = new Lcp_669_TreeNode(4);
		
		root.left = l1;
		l1.right = l1r1;
		l1r1.left = l1r1l1;
		root.right = r1;
		
		int low = 1;
		int high = 3;
		
		Lcp_669_TreeNode test = lcp.trimBST(root, low, high);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
