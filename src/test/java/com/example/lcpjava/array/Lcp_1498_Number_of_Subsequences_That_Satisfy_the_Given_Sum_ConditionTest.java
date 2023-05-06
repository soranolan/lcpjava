package com.example.lcpjava.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1498_Number_of_Subsequences_That_Satisfy_the_Given_Sum_ConditionTest {
	
	private Lcp_1498_Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1498_Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition();
	}
	
	@Test
	void test_case_1() {
		int expected = 4;
		int[] nums = { 3, 5, 6, 7 };
		int target = 9;
		int actual = lcp.numSubseq(nums, target);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void test_case_2() {
		int expected = 6;
		int[] nums = { 3, 3, 6, 8 };
		int target = 10;
		int actual = lcp.numSubseq(nums, target);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void test_case_3() {
		int expected = 61;
		int[] nums = { 2, 3, 3, 4, 6, 7 };
		int target = 12;
		int actual = lcp.numSubseq(nums, target);
		
		assertEquals(expected, actual);
	}
	
}
