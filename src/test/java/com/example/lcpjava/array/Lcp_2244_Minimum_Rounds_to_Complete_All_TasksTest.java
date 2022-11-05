package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_2244_Minimum_Rounds_to_Complete_All_TasksTest {
	
	private Lcp_2244_Minimum_Rounds_to_Complete_All_Tasks lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_2244_Minimum_Rounds_to_Complete_All_Tasks();
	}
	
	@Test
	void test_case_1() {
		int expected = 4;
		int[] tasks = { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4 };
		int test = lcp.minimumRounds(tasks);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = -1;
		int[] tasks = { 2, 3, 3 };
		int test = lcp.minimumRounds(tasks);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 2;
		int[] tasks = { 5, 5, 5, 5 };
		int test = lcp.minimumRounds(tasks);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
