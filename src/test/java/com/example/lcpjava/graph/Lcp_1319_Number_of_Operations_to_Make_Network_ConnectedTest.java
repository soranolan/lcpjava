package com.example.lcpjava.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1319_Number_of_Operations_to_Make_Network_ConnectedTest {
	
	@Test
	void test_case_1() {
		Lcp_1319_Number_of_Operations_to_Make_Network_Connected lcp = new Lcp_1319_Number_of_Operations_to_Make_Network_Connected();
		
		int expected = 1;
		int n = 4;
		int[][] input = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		int test = lcp.makeConnected(n, input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1319_Number_of_Operations_to_Make_Network_Connected lcp = new Lcp_1319_Number_of_Operations_to_Make_Network_Connected();
		
		int expected = 2;
		int n = 6;
		int[][] input = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
		int test = lcp.makeConnected(n, input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1319_Number_of_Operations_to_Make_Network_Connected lcp = new Lcp_1319_Number_of_Operations_to_Make_Network_Connected();
		
		int expected = -1;
		int n = 6;
		int[][] input = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 } };
		int test = lcp.makeConnected(n, input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
