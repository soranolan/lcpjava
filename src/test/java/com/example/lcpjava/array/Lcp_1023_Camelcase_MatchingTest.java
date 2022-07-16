package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1023_Camelcase_MatchingTest {
	
	private Lcp_1023_Camelcase_Matching lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1023_Camelcase_Matching();
	}
	
	@Test
	void test_case_1() {
		List<Boolean> expected = Arrays.asList(new Boolean[] { true, false, true, true, false });
		String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" };
		String pattern = "FB";
		List<Boolean> test = lcp.camelMatch(queries, pattern);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<Boolean> expected = Arrays.asList(new Boolean[] { true, false, true, false, false });
		String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" };
		String pattern = "FoBa";
		List<Boolean> test = lcp.camelMatch(queries, pattern);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		List<Boolean> expected = Arrays.asList(new Boolean[] { false, true, false, false, false });
		String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" };
		String pattern = "FoBaT";
		List<Boolean> test = lcp.camelMatch(queries, pattern);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
