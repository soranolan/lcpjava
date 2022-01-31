package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Lcp_652_Find_Duplicate_SubtreesTest {
	
	@Test
	void test_case_1() {
		Lcp_652_Find_Duplicate_Subtrees lcp = new Lcp_652_Find_Duplicate_Subtrees();
		
		List<TreeNode> expected = new ArrayList<>();
		
		TreeNode eroot = new TreeNode(1);
		TreeNode el1 = new TreeNode(2);
		TreeNode el1l1 = new TreeNode(4);
		TreeNode er1 = new TreeNode(3);
		TreeNode er1l1 = new TreeNode(2);
		TreeNode er1l1l1 = new TreeNode(4);
		TreeNode er1r1 = new TreeNode(4);
		
		eroot.left = el1;
		el1.left = el1l1;
		eroot.right = er1;
		er1.left = er1l1;
		er1l1.left = er1l1l1;
		er1.right = er1r1;
		
		expected.add(el1);
		expected.add(el1l1);
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode l1l1 = new TreeNode(4);
		TreeNode r1 = new TreeNode(3);
		TreeNode r1l1 = new TreeNode(2);
		TreeNode r1l1l1 = new TreeNode(4);
		TreeNode r1r1 = new TreeNode(4);
		
		root.left = l1;
		l1.left = l1l1;
		root.right = r1;
		r1.left = r1l1;
		r1l1.left = r1l1l1;
		r1.right = r1r1;
		
		List<TreeNode> test = lcp.findDuplicateSubtrees(root);
		
		assertThat(test).hasSameSizeAs(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_652_Find_Duplicate_Subtrees lcp = new Lcp_652_Find_Duplicate_Subtrees();
		
		List<TreeNode> expected = new ArrayList<>();
		
		TreeNode eroot = new TreeNode(2);
		TreeNode el1 = new TreeNode(1);
		TreeNode er1 = new TreeNode(1);
		
		eroot.left = el1;
		eroot.right = er1;
		
		expected.add(el1);
		
		TreeNode root = new TreeNode(2);
		TreeNode l1 = new TreeNode(1);
		TreeNode r1 = new TreeNode(1);
		
		root.left = l1;
		root.right = r1;
		
		List<TreeNode> test = lcp.findDuplicateSubtrees(root);
		
		assertThat(test).hasSameSizeAs(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_652_Find_Duplicate_Subtrees lcp = new Lcp_652_Find_Duplicate_Subtrees();
		
		List<TreeNode> expected = new ArrayList<>();
		
		TreeNode eroot = new TreeNode(2);
		TreeNode el1 = new TreeNode(2);
		TreeNode el1l1 = new TreeNode(3);
		TreeNode er1 = new TreeNode(2);
		TreeNode er1l1 = new TreeNode(3);
		
		eroot.left = el1;
		el1.left = el1l1;
		eroot.right = er1;
		er1.left = er1l1;
		
		expected.add(el1);
		expected.add(el1l1);
		
		TreeNode root = new TreeNode(2);
		TreeNode l1 = new TreeNode(2);
		TreeNode l1l1 = new TreeNode(3);
		TreeNode r1 = new TreeNode(2);
		TreeNode r1l1 = new TreeNode(3);
		
		root.left = l1;
		l1.left = l1l1;
		root.right = r1;
		r1.left = r1l1;
		
		List<TreeNode> test = lcp.findDuplicateSubtrees(root);
		
		assertThat(test).hasSameSizeAs(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_652_Find_Duplicate_Subtrees lcp = new Lcp_652_Find_Duplicate_Subtrees();
		
		List<TreeNode> expected = new ArrayList<>();
		
		TreeNode eroot = new TreeNode(0);
		TreeNode el1 = new TreeNode(0);
		TreeNode el1l1 = new TreeNode(0);
		TreeNode er1 = new TreeNode(0);
		TreeNode er1r1 = new TreeNode(0);
		TreeNode er1r1r1 = new TreeNode(0);
		
		eroot.left = el1;
		el1.left = el1l1;
		eroot.right = er1;
		er1.right = er1r1;
		er1r1.right = er1r1r1;
		
		expected.add(er1r1r1);
		
		TreeNode root = new TreeNode(0);
		TreeNode l1 = new TreeNode(0);
		TreeNode l1l1 = new TreeNode(0);
		TreeNode r1 = new TreeNode(0);
		TreeNode r1r1 = new TreeNode(0);
		TreeNode r1r1r1 = new TreeNode(0);
		
		root.left = l1;
		l1.left = l1l1;
		root.right = r1;
		r1.right = r1r1;
		r1r1.right = r1r1r1;
		
		List<TreeNode> test = lcp.findDuplicateSubtrees(root);
		
		assertThat(test).hasSameSizeAs(expected);
	}
	
}
