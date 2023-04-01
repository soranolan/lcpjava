package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Lcp_704_Binary_SearchTest {
	
	private Lcp_704_Binary_Search lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_704_Binary_Search();
	}
	
	@Test
	void test_case_1() {
		int expected = 4;
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		int target = 9;
		int test = lcp.search(nums, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = -1;
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		int target = 2;
		int test = lcp.search(nums, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 0;
		int[] nums = { 5 };
		int target = 5;
		int test = lcp.search(nums, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		int expected = 1;
		int[] nums = { 1, 2 };
		int target = 2;
		int test = lcp.search(nums, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
