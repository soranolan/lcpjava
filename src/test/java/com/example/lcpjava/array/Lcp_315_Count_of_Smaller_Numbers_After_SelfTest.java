package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_315_Count_of_Smaller_Numbers_After_SelfTest {
	
	private Lcp_315_Count_of_Smaller_Numbers_After_Self lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_315_Count_of_Smaller_Numbers_After_Self();
	}
	
	@Test
	void test_case_1() {
		List<Integer> expected = Arrays.asList(new Integer[] { 2, 1, 1, 0 });
		int[] nums = { 5, 2, 6, 1 };
		List<Integer> test = lcp.countSmaller(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<Integer> expected = Arrays.asList(new Integer[] { 0 });
		int[] nums = { -1 };
		List<Integer> test = lcp.countSmaller(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		List<Integer> expected = Arrays.asList(new Integer[] { 0, 0 });
		int[] nums = { -1, -1 };
		List<Integer> test = lcp.countSmaller(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
