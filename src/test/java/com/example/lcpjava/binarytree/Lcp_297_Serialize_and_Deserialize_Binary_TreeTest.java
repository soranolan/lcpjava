package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.Lcp_297_TreeNode;

class Lcp_297_Serialize_and_Deserialize_Binary_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_297_Serialize_and_Deserialize_Binary_Tree lcp = new Lcp_297_Serialize_and_Deserialize_Binary_Tree();
		
		Lcp_297_TreeNode expect = new Lcp_297_TreeNode(1);
		Lcp_297_TreeNode el1 = new Lcp_297_TreeNode(2);
		Lcp_297_TreeNode er1 = new Lcp_297_TreeNode(3);
		Lcp_297_TreeNode er1l1 = new Lcp_297_TreeNode(4);
		Lcp_297_TreeNode er1r1 = new Lcp_297_TreeNode(5);
		
		expect.left = el1;
		expect.right = er1;
		er1.left = er1l1;
		er1.right = er1r1;
		
		Lcp_297_TreeNode root = new Lcp_297_TreeNode(1);
		Lcp_297_TreeNode l1 = new Lcp_297_TreeNode(2);
		Lcp_297_TreeNode r1 = new Lcp_297_TreeNode(3);
		Lcp_297_TreeNode r1l1 = new Lcp_297_TreeNode(4);
		Lcp_297_TreeNode r1r1 = new Lcp_297_TreeNode(5);
		
		root.left = l1;
		root.right = r1;
		r1.left = r1l1;
		r1.right = r1r1;
		
		String data = lcp.serialize(root);
		Lcp_297_TreeNode test = lcp.deserialize(data);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_297_Serialize_and_Deserialize_Binary_Tree lcp = new Lcp_297_Serialize_and_Deserialize_Binary_Tree();
		
		Lcp_297_TreeNode test = lcp.deserialize(null);
		
		assertThat(test).isNull();
	}
	
}
