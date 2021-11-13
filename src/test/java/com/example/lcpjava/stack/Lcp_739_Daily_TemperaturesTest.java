package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_739_Daily_TemperaturesTest {
	
	@Test
	void test_case_1() {
		Lcp_739_Daily_Temperatures lcp = new Lcp_739_Daily_Temperatures();
		
		int[] expected = { 1, 1, 4, 2, 1, 1, 0, 0 };
		
		int[] input = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] test = lcp.dailyTemperatures(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_739_Daily_Temperatures lcp = new Lcp_739_Daily_Temperatures();
		
		int[] expected = { 1, 1, 1, 0 };
		
		int[] input = { 30, 40, 50, 60 };
		int[] test = lcp.dailyTemperatures(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_739_Daily_Temperatures lcp = new Lcp_739_Daily_Temperatures();
		
		int[] expected = { 1, 1, 0 };
		
		int[] input = { 30, 60, 90 };
		int[] test = lcp.dailyTemperatures(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
