package com.example.lcpjava.binarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.lcpjava.common.TreeNode;
import com.example.lcpjava.tool.BuildTree;

class Lcp_1305_All_Elements_in_Two_Binary_Search_TreesTest {
	
	@Test
	void test_case_1() {
		Lcp_1305_All_Elements_in_Two_Binary_Search_Trees lcp = new Lcp_1305_All_Elements_in_Two_Binary_Search_Trees();
		BuildTree tool = new BuildTree();
		
		List<Integer> expected = Arrays.asList(new Integer[] { 0, 1, 1, 2, 3, 4 });
		TreeNode root1 = tool.preorder(new Integer[] { 2, 1, 4 });
		TreeNode root2 = tool.preorder(new Integer[] { 1, 0, 3 });
		List<Integer> test = lcp.getAllElements(root1, root2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1305_All_Elements_in_Two_Binary_Search_Trees lcp = new Lcp_1305_All_Elements_in_Two_Binary_Search_Trees();
		BuildTree tool = new BuildTree();
		
		List<Integer> expected = Arrays.asList(new Integer[] { 1, 1, 8, 8 });
		TreeNode root1 = tool.preorder(new Integer[] { 1, null, 8 });
		TreeNode root2 = tool.preorder(new Integer[] { 8, 1, null });
		List<Integer> test = lcp.getAllElements(root1, root2);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
