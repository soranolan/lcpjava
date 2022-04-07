package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_495_Teemo_AttackingTest {
	
	@Test
	void test_case_1() {
		Lcp_495_Teemo_Attacking lcp = new Lcp_495_Teemo_Attacking();
		
		int expected = 4;
		int[] timeSeries = { 1, 4 };
		int duration = 2;
		int test = lcp.findPoisonedDuration(timeSeries, duration);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_495_Teemo_Attacking lcp = new Lcp_495_Teemo_Attacking();
		
		int expected = 3;
		int[] timeSeries = { 1, 2 };
		int duration = 2;
		int test = lcp.findPoisonedDuration(timeSeries, duration);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_495_Teemo_Attacking lcp = new Lcp_495_Teemo_Attacking();
		
		int expected = 17;
		int[] timeSeries = { 1, 3, 5, 7, 9, 11, 13, 15 };
		int duration = 3;
		int test = lcp.findPoisonedDuration(timeSeries, duration);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
