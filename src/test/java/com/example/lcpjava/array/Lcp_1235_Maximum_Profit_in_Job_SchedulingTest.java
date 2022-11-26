package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1235_Maximum_Profit_in_Job_SchedulingTest {
	
	private Lcp_1235_Maximum_Profit_in_Job_Scheduling lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1235_Maximum_Profit_in_Job_Scheduling();
	}
	
	@Test
	void test_case_1() {
		int expected = 120;
		int[] startTime = { 1, 2, 3, 3 };
		int[] endTime = { 3, 4, 5, 6 };
		int[] profit = { 50, 10, 40, 70 };
		int test = lcp.jobScheduling(startTime, endTime, profit);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 150;
		int[] startTime = { 1, 2, 3, 4, 6 };
		int[] endTime = { 3, 5, 10, 6, 9 };
		int[] profit = { 20, 20, 100, 70, 60 };
		int test = lcp.jobScheduling(startTime, endTime, profit);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 6;
		int[] startTime = { 1, 1, 1 };
		int[] endTime = { 2, 3, 4 };
		int[] profit = { 5, 6, 4 };
		int test = lcp.jobScheduling(startTime, endTime, profit);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
