package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_102_TreeNode;

class Lcp_102_Binary_Tree_Level_Order_TraversalTest {
	
	@Test
	void test_case_1() {
		Lcp_102_Binary_Tree_Level_Order_Traversal lcp = new Lcp_102_Binary_Tree_Level_Order_Traversal();
		
		List<List<Integer>> expected = Arrays.stream(new Integer[][] { { 3 }, { 9, 20 }, { 15, 7 } }).map(Arrays::asList).collect(Collectors.toList());
		
		Lcp_102_TreeNode root = new Lcp_102_TreeNode(3);
		Lcp_102_TreeNode l1 = new Lcp_102_TreeNode(9);
		Lcp_102_TreeNode r1 = new Lcp_102_TreeNode(20);
		Lcp_102_TreeNode r1l1 = new Lcp_102_TreeNode(15);
		Lcp_102_TreeNode r1r1 = new Lcp_102_TreeNode(7);
		
		root.left = l1;
		root.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		List<List<Integer>> test = lcp.levelOrder(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_102_Binary_Tree_Level_Order_Traversal lcp = new Lcp_102_Binary_Tree_Level_Order_Traversal();
		
		List<List<Integer>> expected = Arrays.stream(new Integer[][] { { 1 } }).map(Arrays::asList).collect(Collectors.toList());
		
		Lcp_102_TreeNode root = new Lcp_102_TreeNode(1);
		
		List<List<Integer>> test = lcp.levelOrder(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_102_Binary_Tree_Level_Order_Traversal lcp = new Lcp_102_Binary_Tree_Level_Order_Traversal();
		
		List<List<Integer>> expected = Arrays.stream(new Integer[][] { }).map(Arrays::asList).collect(Collectors.toList());
		
		List<List<Integer>> test = lcp.levelOrder(null);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_102_Binary_Tree_Level_Order_Traversal lcp = new Lcp_102_Binary_Tree_Level_Order_Traversal();
		
		List<List<Integer>> expected = Arrays.stream(new Integer[][] { { 1 }, { 2 } }).map(Arrays::asList).collect(Collectors.toList());
		
		Lcp_102_TreeNode root = new Lcp_102_TreeNode(1);
		Lcp_102_TreeNode l1 = new Lcp_102_TreeNode(2);
		
		root.left = l1;
		
		List<List<Integer>> test = lcp.levelOrder(root);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
