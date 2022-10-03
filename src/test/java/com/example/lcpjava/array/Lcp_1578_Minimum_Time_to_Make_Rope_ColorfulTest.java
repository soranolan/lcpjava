package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1578_Minimum_Time_to_Make_Rope_ColorfulTest {
	
	private Lcp_1578_Minimum_Time_to_Make_Rope_Colorful lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1578_Minimum_Time_to_Make_Rope_Colorful();
	}
	
	@Test
	void test_case_1() {
		int expected = 3;
		String colors = "abaac";
		int[] neededTime = { 1, 2, 3, 4, 5 };
		int test = lcp.minCost(colors, neededTime);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 0;
		String colors = "abc";
		int[] neededTime = { 1, 2, 3 };
		int test = lcp.minCost(colors, neededTime);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 2;
		String colors = "aabaa";
		int[] neededTime = { 1, 2, 3, 4, 1 };
		int test = lcp.minCost(colors, neededTime);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
