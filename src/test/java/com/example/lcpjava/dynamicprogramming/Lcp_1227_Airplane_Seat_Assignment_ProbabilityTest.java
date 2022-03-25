package com.example.lcpjava.dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1227_Airplane_Seat_Assignment_ProbabilityTest {
	
	@Test
	void test_case_1() {
		Lcp_1227_Airplane_Seat_Assignment_Probability lcp = new Lcp_1227_Airplane_Seat_Assignment_Probability();
		
		double expected = 1D;
		int input = 1;
		double test = lcp.nthPersonGetsNthSeat(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1227_Airplane_Seat_Assignment_Probability lcp = new Lcp_1227_Airplane_Seat_Assignment_Probability();
		
		double expected = 0.5D;
		int input = 2;
		double test = lcp.nthPersonGetsNthSeat(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
