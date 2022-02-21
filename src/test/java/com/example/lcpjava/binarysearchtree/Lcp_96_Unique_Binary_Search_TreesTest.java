package com.example.lcpjava.binarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_96_Unique_Binary_Search_TreesTest {
	
	@Test
	void test_case_1() {
		Lcp_96_Unique_Binary_Search_Trees lcp = new Lcp_96_Unique_Binary_Search_Trees();
		
		int expected = 5;
		int input = 3;
		int test = lcp.numTrees(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_96_Unique_Binary_Search_Trees lcp = new Lcp_96_Unique_Binary_Search_Trees();
		
		int expected = 1;
		int input = 1;
		int test = lcp.numTrees(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
