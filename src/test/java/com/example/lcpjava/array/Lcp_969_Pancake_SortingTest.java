package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class Lcp_969_Pancake_SortingTest {
	
	@Test
	void test_case_1() {
		Lcp_969_Pancake_Sorting lcp = new Lcp_969_Pancake_Sorting();
		
		int[] expected = { 1, 2, 3, 4 };
		int[] input = new int[] { 3, 2, 4, 1 };
		List<Integer> test = lcp.pancakeSort(input);
		
		assertThat(input).isEqualTo(expected);
		assertThat(test).size().isLessThanOrEqualTo(10 * input.length);
	}
	
	@Test
	void test_case_2() {
		Lcp_969_Pancake_Sorting lcp = new Lcp_969_Pancake_Sorting();
		
		int[] expected = { 1, 2, 3 };
		int[] input = new int[] { 1, 2, 3 };
		List<Integer> test = lcp.pancakeSort(input);
		
		assertThat(input).isEqualTo(expected);
		assertThat(test).size().isLessThanOrEqualTo(10 * input.length);
	}
	
}
