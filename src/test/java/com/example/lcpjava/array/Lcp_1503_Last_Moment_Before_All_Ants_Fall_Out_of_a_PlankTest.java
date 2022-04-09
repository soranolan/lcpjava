package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_PlankTest {
	
	@Test
	void test_case_1() {
		Lcp_1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank lcp = new Lcp_1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank();
		
		int expected = 4;
		int n = 4;
		int[] left = { 4, 3 };
		int[] right = { 0, 1 };
		int test = lcp.getLastMoment(n, left, right);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank lcp = new Lcp_1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank();
		
		int expected = 7;
		int n = 7;
		int[] left = {};
		int[] right = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int test = lcp.getLastMoment(n, left, right);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank lcp = new Lcp_1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank();
		
		int expected = 7;
		int n = 7;
		int[] left = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int[] right = {};
		int test = lcp.getLastMoment(n, left, right);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
