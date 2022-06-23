package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_137_Single_Number_IITest {
	
	private Lcp_137_Single_Number_II lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_137_Single_Number_II();
	}
	
	@Test
	void test_case_1() {
		int expected = 3;
		int[] nums = { 2, 2, 3, 2 };
		int test = lcp.singleNumber(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 99;
		int[] nums = { 0, 1, 0, 1, 0, 1, 99 };
		int test = lcp.singleNumber(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
