package com.example.lcpjava.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class Lcp_894_All_Possible_Full_Binary_TreesTest {
	
	@Test
	void test_case_1() {
		Lcp_894_All_Possible_Full_Binary_Trees lcp = new Lcp_894_All_Possible_Full_Binary_Trees();
		
		int input = 7;
		List<TreeNode> test = lcp.allPossibleFBT(input);
		
		assertThat(test).hasSize(5);
	}
	
	@Test
	void test_case_2() {
		Lcp_894_All_Possible_Full_Binary_Trees lcp = new Lcp_894_All_Possible_Full_Binary_Trees();
		
		int input = 3;
		List<TreeNode> test = lcp.allPossibleFBT(input);
		
		assertThat(test).hasSize(1);
	}
	
}
