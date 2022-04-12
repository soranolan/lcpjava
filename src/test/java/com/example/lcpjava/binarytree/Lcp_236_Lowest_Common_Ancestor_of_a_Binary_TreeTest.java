package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;

class Lcp_236_Lowest_Common_Ancestor_of_a_Binary_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree lcp = new Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree();
		
		TreeNode root = new TreeNode(3);
		TreeNode l1 = new TreeNode(5);
		TreeNode l1l1 = new TreeNode(6);
		TreeNode l1r1 = new TreeNode(2);
		TreeNode l1r1l1 = new TreeNode(7);
		TreeNode l1r1r1 = new TreeNode(4);
		TreeNode r1 = new TreeNode(1);
		TreeNode r1l1 = new TreeNode(0);
		TreeNode r1r1 = new TreeNode(8);
		
		root.left = l1;
		l1.left = l1l1;
		l1.right = l1r1;
		l1r1.left = l1r1l1;
		l1r1.right = l1r1r1;
		root.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		TreeNode test = lcp.lowestCommonAncestor(root, l1, r1);
		
		assertThat(test).isEqualTo(root);
	}
	
	@Test
	void test_case_2() {
		Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree lcp = new Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree();
		
		TreeNode root = new TreeNode(3);
		TreeNode l1 = new TreeNode(5);
		TreeNode l1l1 = new TreeNode(6);
		TreeNode l1r1 = new TreeNode(2);
		TreeNode l1r1l1 = new TreeNode(7);
		TreeNode l1r1r1 = new TreeNode(4);
		TreeNode r1 = new TreeNode(1);
		TreeNode r1l1 = new TreeNode(0);
		TreeNode r1r1 = new TreeNode(8);
		
		root.left = l1;
		l1.left = l1l1;
		l1.right = l1r1;
		l1r1.left = l1r1l1;
		l1r1.right = l1r1r1;
		root.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		TreeNode test = lcp.lowestCommonAncestor(root, l1, l1r1r1);
		
		assertThat(test).isEqualTo(l1);
	}
	
	@Test
	void test_case_3() {
		Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree lcp = new Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree();
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		
		root.left = l1;
		
		TreeNode test = lcp.lowestCommonAncestor(root, root, l1);
		
		assertThat(test).isEqualTo(root);
	}
	
}
