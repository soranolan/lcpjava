package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_217_Contains_DuplicateTest {
	
	@Test
	void test_case_1() {
		Lcp_217_Contains_Duplicate lcp = new Lcp_217_Contains_Duplicate();
		
		int[] input = { 1, 2, 3, 1 };
		boolean test = lcp.containsDuplicate(input);
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		Lcp_217_Contains_Duplicate lcp = new Lcp_217_Contains_Duplicate();
		
		int[] input = { 1, 2, 3, 4 };
		boolean test = lcp.containsDuplicate(input);
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		Lcp_217_Contains_Duplicate lcp = new Lcp_217_Contains_Duplicate();
		
		int[] input = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
		boolean test = lcp.containsDuplicate(input);
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_4() {
		Lcp_217_Contains_Duplicate lcp = new Lcp_217_Contains_Duplicate();
		
		int[] input = { -24500, -24500 };
		boolean test = lcp.containsDuplicate(input);
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_5() {
		Lcp_217_Contains_Duplicate lcp = new Lcp_217_Contains_Duplicate();
		
		int[] input = { 237384, 237384 };
		boolean test = lcp.containsDuplicate(input);
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_6() {
		Lcp_217_Contains_Duplicate lcp = new Lcp_217_Contains_Duplicate();
		
		int[] input = { 170, -368, 148, 672, 397, -629, -788, 192, 170, 309, -615, -237 };
		boolean test = lcp.containsDuplicate(input);
		assertThat(test).isTrue();
	}
	
}
