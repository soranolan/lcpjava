package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_831_Masking_Personal_InformationTest {
	
	private Lcp_831_Masking_Personal_Information lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_831_Masking_Personal_Information();
	}
	
	@Test
	void test_case_1() {
		String expected = "l*****e@leetcode.com";
		String s = "LeetCode@LeetCode.com";
		String test = lcp.maskPII(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		String expected = "a*****b@qq.com";
		String s = "AB@qq.com";
		String test = lcp.maskPII(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		String expected = "***-***-7890";
		String s = "1(234)567-890";
		String test = lcp.maskPII(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
