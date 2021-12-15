package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Lcp_145_Binary_Tree_Postorder_TraversalTest {
	
	@Test
	void test_case_1() {
		Lcp_145_Binary_Tree_Postorder_Traversal lcp = new Lcp_145_Binary_Tree_Postorder_Traversal();
		
		List<Integer> expected = Arrays.stream(new Integer[] { 3, 2, 1 }).collect(Collectors.toList());
		
		TreeNode root = new TreeNode(1);
		TreeNode r1 = new TreeNode(2);
		TreeNode r1l1 = new TreeNode(3);
		
		root.right = r1;
		r1.left = r1l1;
		
		List<Integer> test = lcp.postorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_145_Binary_Tree_Postorder_Traversal lcp = new Lcp_145_Binary_Tree_Postorder_Traversal();
		
		List<Integer> expected = Arrays.stream(new Integer[] {  }).collect(Collectors.toList());
		
		List<Integer> test = lcp.postorderTraversal(null);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_145_Binary_Tree_Postorder_Traversal lcp = new Lcp_145_Binary_Tree_Postorder_Traversal();
		
		List<Integer> expected = Arrays.stream(new Integer[] { 1 }).collect(Collectors.toList());
		
		TreeNode root = new TreeNode(1);
		
		List<Integer> test = lcp.postorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_145_Binary_Tree_Postorder_Traversal lcp = new Lcp_145_Binary_Tree_Postorder_Traversal();
		
		List<Integer> expected = Arrays.stream(new Integer[] { 2, 1 }).collect(Collectors.toList());
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		
		root.left = l1;
		
		List<Integer> test = lcp.postorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_5() {
		Lcp_145_Binary_Tree_Postorder_Traversal lcp = new Lcp_145_Binary_Tree_Postorder_Traversal();
		
		List<Integer> expected = Arrays.stream(new Integer[] { 2, 1 }).collect(Collectors.toList());
		
		TreeNode root = new TreeNode(1);
		TreeNode r1 = new TreeNode(2);
		
		root.right = r1;
		
		List<Integer> test = lcp.postorderTraversal(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
