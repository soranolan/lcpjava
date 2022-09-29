package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_658_Find_K_Closest_ElementsTest {
	
	private Lcp_658_Find_K_Closest_Elements lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_658_Find_K_Closest_Elements();
	}
	
	@Test
	void test_case_1() {
		List<Integer> expected = Arrays.asList(new Integer[] { 1, 2, 3, 4 });
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 4;
		int x = 3;
		List<Integer> test = lcp.findClosestElements(arr, k, x);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<Integer> expected = Arrays.asList(new Integer[] { 1, 2, 3, 4 });
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 4;
		int x = -1;
		List<Integer> test = lcp.findClosestElements(arr, k, x);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		List<Integer> expected = Arrays.asList(new Integer[] { 1 });
		int[] arr = { 1, 2 };
		int k = 1;
		int x = 1;
		List<Integer> test = lcp.findClosestElements(arr, k, x);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		List<Integer> expected = Arrays.asList(new Integer[] { -2, -1, 1, 2, 3, 4, 5 });
		int[] arr = { -2, -1, 1, 2, 3, 4, 5 };
		int k = 7;
		int x = 3;
		List<Integer> test = lcp.findClosestElements(arr, k, x);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_5() {
		List<Integer> expected = Arrays.asList(new Integer[] { 5 });
		int[] arr = { 1, 5, 10 };
		int k = 1;
		int x = 4;
		List<Integer> test = lcp.findClosestElements(arr, k, x);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_6() {
		List<Integer> expected = Arrays.asList(new Integer[] { 3, 6, 8, 8, 9 });
		int[] arr = { 0, 1, 2, 2, 2, 3, 6, 8, 8, 9 };
		int k = 5;
		int x = 9;
		List<Integer> test = lcp.findClosestElements(arr, k, x);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
