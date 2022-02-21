package com.example.lcpjava.binarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_669_Trim_a_Binary_Search_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_669_Trim_a_Binary_Search_Tree lcp = new Lcp_669_Trim_a_Binary_Search_Tree();
		
		TreeNode expected = new TreeNode(1);
		TreeNode er1 = new TreeNode(2);
		
		expected.right = er1;
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(0);
		TreeNode r1 = new TreeNode(2);
		
		root.left = l1;
		root.right = r1;
		
		int low = 1;
		int high = 2;
		
		TreeNode test = lcp.trimBST(root, low, high);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_669_Trim_a_Binary_Search_Tree lcp = new Lcp_669_Trim_a_Binary_Search_Tree();
		
		TreeNode expected = new TreeNode(3);
		TreeNode el1 = new TreeNode(2);
		TreeNode el1l1 = new TreeNode(1);
		
		expected.left = el1;
		el1.left = el1l1;
		
		TreeNode root = new TreeNode(3);
		TreeNode l1 = new TreeNode(0);
		TreeNode l1r1 = new TreeNode(2);
		TreeNode l1r1l1 = new TreeNode(1);
		TreeNode r1 = new TreeNode(4);
		
		root.left = l1;
		l1.right = l1r1;
		l1r1.left = l1r1l1;
		root.right = r1;
		
		int low = 1;
		int high = 3;
		
		TreeNode test = lcp.trimBST(root, low, high);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
