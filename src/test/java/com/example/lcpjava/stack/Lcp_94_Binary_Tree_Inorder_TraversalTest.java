package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Lcp_94_Binary_Tree_Inorder_TraversalTest {
	
	@Test
	void test_case_1() {
		Lcp_94_Binary_Tree_Inorder_Traversal lcp = new Lcp_94_Binary_Tree_Inorder_Traversal();
		
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(3);
		expected.add(2);
		
		TreeNode root = new TreeNode(1);
		TreeNode r1 = new TreeNode(2);
		TreeNode r1l1 = new TreeNode(3);
		
		root.right = r1;
		r1.left = r1l1;
		
		List<Integer> test = lcp.inorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_94_Binary_Tree_Inorder_Traversal lcp = new Lcp_94_Binary_Tree_Inorder_Traversal();
		
		List<Integer> expected = new ArrayList<>();
		TreeNode root = null;
		List<Integer> test = lcp.inorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_94_Binary_Tree_Inorder_Traversal lcp = new Lcp_94_Binary_Tree_Inorder_Traversal();
		
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		
		TreeNode root = new TreeNode(1);
		
		List<Integer> test = lcp.inorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_94_Binary_Tree_Inorder_Traversal lcp = new Lcp_94_Binary_Tree_Inorder_Traversal();
		
		List<Integer> expected = new ArrayList<>();
		expected.add(2);
		expected.add(1);
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		
		root.left = l1;
		
		List<Integer> test = lcp.inorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_5() {
		Lcp_94_Binary_Tree_Inorder_Traversal lcp = new Lcp_94_Binary_Tree_Inorder_Traversal();
		
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		
		TreeNode root = new TreeNode(1);
		TreeNode r1 = new TreeNode(2);
		
		root.right = r1;
		
		List<Integer> test = lcp.inorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
