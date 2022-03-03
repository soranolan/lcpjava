package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_45_Jump_Game_IITest {
	
	@Test
	void test_case_1() {
		Lcp_45_Jump_Game_II lcp = new Lcp_45_Jump_Game_II();
		
		int expected = 2;
		int[] input = { 2, 3, 1, 1, 4 };
		int test = lcp.jump(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_45_Jump_Game_II lcp = new Lcp_45_Jump_Game_II();
		
		int expected = 2;
		int[] input = { 2, 3, 0, 1, 4 };
		int test = lcp.jump(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_45_Jump_Game_II lcp = new Lcp_45_Jump_Game_II();
		
		int expected = 1;
		int[] input = { 2, 1 };
		int test = lcp.jump(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
