package com.example.lcpjava.dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_70_Climbing_StairsTest {
	
	@Test
	void test_case_1() {
		Lcp_70_Climbing_Stairs lcp = new Lcp_70_Climbing_Stairs();
		
		int expected = 2;
		int input = 2;
		int test = lcp.climbStairs(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_70_Climbing_Stairs lcp = new Lcp_70_Climbing_Stairs();
		
		int expected = 3;
		int input = 3;
		int test = lcp.climbStairs(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
