package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_746_Min_Cost_Climbing_StairsTest {
	
	@Test
	void test_case_1() {
		Lcp_746_Min_Cost_Climbing_Stairs lcp = new Lcp_746_Min_Cost_Climbing_Stairs();
		
		int expected = 15;
		int[] input = { 10, 15, 20 };
		int test = lcp.minCostClimbingStairs(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_746_Min_Cost_Climbing_Stairs lcp = new Lcp_746_Min_Cost_Climbing_Stairs();
		
		int expected = 6;
		int[] input = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		int test = lcp.minCostClimbingStairs(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
