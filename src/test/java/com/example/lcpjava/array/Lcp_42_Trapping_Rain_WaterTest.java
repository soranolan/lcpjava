package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_42_Trapping_Rain_WaterTest {
	
	@Test
	void test_case_1() {
		Lcp_42_Trapping_Rain_Water lcp = new Lcp_42_Trapping_Rain_Water();
		
		int expected = 6;
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int test = lcp.trap(height);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_42_Trapping_Rain_Water lcp = new Lcp_42_Trapping_Rain_Water();
		
		int expected = 9;
		int[] height = { 4, 2, 0, 3, 2, 5 };
		int test = lcp.trap(height);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
