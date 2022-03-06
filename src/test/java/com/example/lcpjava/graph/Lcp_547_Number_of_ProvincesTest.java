package com.example.lcpjava.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_547_Number_of_ProvincesTest {
	
	@Test
	void test_case_1() {
		Lcp_547_Number_of_Provinces lcp = new Lcp_547_Number_of_Provinces();
		
		int expected = 2;
		int[][] input = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int test = lcp.findCircleNum(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_547_Number_of_Provinces lcp = new Lcp_547_Number_of_Provinces();
		
		int expected = 3;
		int[][] input = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		int test = lcp.findCircleNum(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
