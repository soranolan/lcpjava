package com.example.lcpjava.binarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_230_Kth_Smallest_Element_in_a_BSTTest {
	
	@Test
	void test_case_1() {
		Lcp_230_Kth_Smallest_Element_in_a_BST lcp = new Lcp_230_Kth_Smallest_Element_in_a_BST();
		
		int expected = 1;
		
		TreeNode root = new TreeNode(3);
		TreeNode l1 = new TreeNode(1);
		TreeNode l1r1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(4);
		
		root.left = l1;
		root.right = r1;
		l1.right = l1r1;
		
		int k = 1;
		
		int test = lcp.kthSmallest(root, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_230_Kth_Smallest_Element_in_a_BST lcp = new Lcp_230_Kth_Smallest_Element_in_a_BST();
		
		int expected = 3;
		
		TreeNode root = new TreeNode(5);
		TreeNode l1 = new TreeNode(3);
		TreeNode l1l1 = new TreeNode(2);
		TreeNode l1l1l1 = new TreeNode(1);
		TreeNode l1r1 = new TreeNode(4);
		TreeNode r1 = new TreeNode(6);
		
		root.left = l1;
		root.right = r1;
		l1.left = l1l1;
		l1.right = l1r1;
		l1l1.left = l1l1l1;
		
		int k = 3;
		
		int test = lcp.kthSmallest(root, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
