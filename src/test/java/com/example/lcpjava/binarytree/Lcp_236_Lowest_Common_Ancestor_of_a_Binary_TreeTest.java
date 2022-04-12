package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_236_TreeNode;

class Lcp_236_Lowest_Common_Ancestor_of_a_Binary_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree lcp = new Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree();
		
		Lcp_236_TreeNode root = new Lcp_236_TreeNode(3);
		Lcp_236_TreeNode l1 = new Lcp_236_TreeNode(5);
		Lcp_236_TreeNode l1l1 = new Lcp_236_TreeNode(6);
		Lcp_236_TreeNode l1r1 = new Lcp_236_TreeNode(2);
		Lcp_236_TreeNode l1r1l1 = new Lcp_236_TreeNode(7);
		Lcp_236_TreeNode l1r1r1 = new Lcp_236_TreeNode(4);
		Lcp_236_TreeNode r1 = new Lcp_236_TreeNode(1);
		Lcp_236_TreeNode r1l1 = new Lcp_236_TreeNode(0);
		Lcp_236_TreeNode r1r1 = new Lcp_236_TreeNode(8);
		
		root.left = l1;
		l1.left = l1l1;
		l1.right = l1r1;
		l1r1.left = l1r1l1;
		l1r1.right = l1r1r1;
		root.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		Lcp_236_TreeNode test = lcp.lowestCommonAncestor(root, l1, r1);
		
		assertThat(test).isEqualTo(root);
	}
	
	@Test
	void test_case_2() {
		Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree lcp = new Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree();
		
		Lcp_236_TreeNode root = new Lcp_236_TreeNode(3);
		Lcp_236_TreeNode l1 = new Lcp_236_TreeNode(5);
		Lcp_236_TreeNode l1l1 = new Lcp_236_TreeNode(6);
		Lcp_236_TreeNode l1r1 = new Lcp_236_TreeNode(2);
		Lcp_236_TreeNode l1r1l1 = new Lcp_236_TreeNode(7);
		Lcp_236_TreeNode l1r1r1 = new Lcp_236_TreeNode(4);
		Lcp_236_TreeNode r1 = new Lcp_236_TreeNode(1);
		Lcp_236_TreeNode r1l1 = new Lcp_236_TreeNode(0);
		Lcp_236_TreeNode r1r1 = new Lcp_236_TreeNode(8);
		
		root.left = l1;
		l1.left = l1l1;
		l1.right = l1r1;
		l1r1.left = l1r1l1;
		l1r1.right = l1r1r1;
		root.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		Lcp_236_TreeNode test = lcp.lowestCommonAncestor(root, l1, l1r1r1);
		
		assertThat(test).isEqualTo(l1);
	}
	
	@Test
	void test_case_3() {
		Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree lcp = new Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree();
		
		Lcp_236_TreeNode root = new Lcp_236_TreeNode(1);
		Lcp_236_TreeNode l1 = new Lcp_236_TreeNode(2);
		
		root.left = l1;
		
		Lcp_236_TreeNode test = lcp.lowestCommonAncestor(root, root, l1);
		
		assertThat(test).isEqualTo(root);
	}
	
}
