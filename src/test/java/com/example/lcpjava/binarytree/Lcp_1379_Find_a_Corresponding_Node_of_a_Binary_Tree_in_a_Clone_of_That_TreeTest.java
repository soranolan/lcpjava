package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_TreeTest {
	
	@Test
	void test_case_1() {
		Lcp_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree lcp = new Lcp_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree();
		BuildTree tool = new BuildTree();
		
		TreeNode original = tool.preorder(new Integer[] { 7, 4, 3, null, null, 6, 19 });
		TreeNode cloned = tool.preorder(new Integer[] { 7, 4, 3, null, null, 6, 19 });
		TreeNode target = original.right;
		TreeNode test = lcp.getTargetCopy(original, cloned, target);
		
		assertThat(test).isEqualTo(target);
	}
	
	@Test
	void test_case_2() {
		Lcp_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree lcp = new Lcp_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree();
		BuildTree tool = new BuildTree();
		
		TreeNode original = tool.preorder(new Integer[] { 7 });
		TreeNode cloned = tool.preorder(new Integer[] { 7 });
		TreeNode target = original;
		TreeNode test = lcp.getTargetCopy(original, cloned, target);
		
		assertThat(test).isEqualTo(target);
	}
	
	@Test
	void test_case_3() {
		Lcp_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree lcp = new Lcp_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree();
		BuildTree tool = new BuildTree();
		
		TreeNode original = tool.preorder(new Integer[] { 8, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1 });
		TreeNode cloned = tool.preorder(new Integer[] { 8, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1 });
		TreeNode target = original.right.right.right;
		TreeNode test = lcp.getTargetCopy(original, cloned, target);
		
		assertThat(test).isEqualTo(target);
	}
	
}
