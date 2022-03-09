package com.example.lcpjava.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_684_Redundant_ConnectionTest {
	
	@Test
	void test_case_1() {
		Lcp_684_Redundant_Connection lcp = new Lcp_684_Redundant_Connection();
		
		int[] expected = { 2, 3 };
		int[][] input = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		int[] test = lcp.findRedundantConnection(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_684_Redundant_Connection lcp = new Lcp_684_Redundant_Connection();
		
		int[] expected = { 1, 4 };
		int[][] input = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
		int[] test = lcp.findRedundantConnection(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
