package com.example.lcpjava.heap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1046_Last_Stone_WeightTest {
	
	@Test
	void test_case_1() {
		Lcp_1046_Last_Stone_Weight lcp = new Lcp_1046_Last_Stone_Weight();
		
		int expected = 1;
		int[] input = { 2, 7, 4, 1, 8, 1 };
		int test = lcp.lastStoneWeight(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1046_Last_Stone_Weight lcp = new Lcp_1046_Last_Stone_Weight();
		
		int expected = 1;
		int[] input = { 1 };
		int test = lcp.lastStoneWeight(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1046_Last_Stone_Weight lcp = new Lcp_1046_Last_Stone_Weight();
		
		int expected = 2;
		int[] input = { 1, 3 };
		int test = lcp.lastStoneWeight(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_1046_Last_Stone_Weight lcp = new Lcp_1046_Last_Stone_Weight();
		
		int expected = 2;
		int[] input = { 3, 7, 2 };
		int test = lcp.lastStoneWeight(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
