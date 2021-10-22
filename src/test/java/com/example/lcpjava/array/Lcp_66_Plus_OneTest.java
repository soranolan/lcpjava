package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_66_Plus_OneTest {
	
	@Test
	void test_case_1() {
		Lcp_66_Plus_One lcp = new Lcp_66_Plus_One();
		
		int[] expect = { 1, 2, 4 };
		int[] input = { 1, 2, 3 };
		int[] test = lcp.plusOne(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_66_Plus_One lcp = new Lcp_66_Plus_One();
		
		int[] expect = { 4, 3, 2, 2 };
		int[] input = { 4, 3, 2, 1 };
		int[] test = lcp.plusOne(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_66_Plus_One lcp = new Lcp_66_Plus_One();
		
		int[] expect = { 1 };
		int[] input = { 0 };
		int[] test = lcp.plusOne(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_4() {
		Lcp_66_Plus_One lcp = new Lcp_66_Plus_One();
		
		int[] expect = { 1, 0 };
		int[] input = { 9 };
		int[] test = lcp.plusOne(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
