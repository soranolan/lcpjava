package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_449_Serialize_and_Deserialize_BSTTest {
	
	@Test
	void test_case_1() {
		Lcp_449_Serialize_and_Deserialize_BST lcp = new Lcp_449_Serialize_and_Deserialize_BST();
		
		TreeNode root = new BuildTree().preorder(new Integer[] { 2, 1, 3 });
		String data = lcp.serialize(root);
		TreeNode test = lcp.deserialize(data);
		
		assertThat(test).isEqualTo(root);
	}
	
	@Test
	void test_case_2() {
		Lcp_449_Serialize_and_Deserialize_BST lcp = new Lcp_449_Serialize_and_Deserialize_BST();
		
		TreeNode root = new BuildTree().preorder(new Integer[] {  });
		String data = lcp.serialize(root);
		TreeNode test = lcp.deserialize(data);
		
		assertThat(test).isEqualTo(root);
	}
	
}
