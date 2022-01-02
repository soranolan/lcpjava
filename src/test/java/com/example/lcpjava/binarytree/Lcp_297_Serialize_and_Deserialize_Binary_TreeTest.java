package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_297_Serialize_and_Deserialize_Binary_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_297_Serialize_and_Deserialize_Binary_Tree lcp = new Lcp_297_Serialize_and_Deserialize_Binary_Tree();
		
		TreeNode expect = new TreeNode(1);
		TreeNode el1 = new TreeNode(2);
		TreeNode er1 = new TreeNode(3);
		TreeNode er1l1 = new TreeNode(4);
		TreeNode er1r1 = new TreeNode(5);
		
		expect.left = el1;
		expect.right = er1;
		er1.left = er1l1;
		er1.right = er1r1;
		
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		TreeNode r1l1 = new TreeNode(4);
		TreeNode r1r1 = new TreeNode(5);
		
		root.left = l1;
		root.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		String data = lcp.serialize(root);
		TreeNode test = lcp.deserialize(data);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_297_Serialize_and_Deserialize_Binary_Tree lcp = new Lcp_297_Serialize_and_Deserialize_Binary_Tree();
		
		TreeNode test = lcp.deserialize(null);
		
		assertThat(test).isNull();
	}
	
}
