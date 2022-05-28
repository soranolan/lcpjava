package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_268_Missing_NumberTest {
	
	private Lcp_268_Missing_Number lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_268_Missing_Number();
	}
	
	@Test
	void test_case_1() {
		int expected = 2;
		int[] nums = { 3, 0, 1 };
		int test = lcp.missingNumber(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 2;
		int[] nums = { 0, 1 };
		int test = lcp.missingNumber(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 8;
		int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int test = lcp.missingNumber(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
