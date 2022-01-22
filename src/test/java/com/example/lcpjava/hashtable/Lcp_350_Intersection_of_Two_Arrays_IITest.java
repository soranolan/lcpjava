package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_350_Intersection_of_Two_Arrays_IITest {
	
	@Test
	void test_case_1() {
		Lcp_350_Intersection_of_Two_Arrays_II lcp = new Lcp_350_Intersection_of_Two_Arrays_II();
		
		int[] expected = { 2, 2 };
		int[] input1 = { 1, 2, 2, 1 };
		int[] input2 = { 2, 2 };
		int[] test = lcp.intersect(input1, input2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_350_Intersection_of_Two_Arrays_II lcp = new Lcp_350_Intersection_of_Two_Arrays_II();
		
		int[] expected = { 4, 9 };
		int[] input1 = { 4, 9, 5 };
		int[] input2 = { 9, 4, 9, 8, 4 };
		int[] test = lcp.intersect(input1, input2);
		
		assertThat(test).hasSameSizeAs(expected).containsExactlyInAnyOrder(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_350_Intersection_of_Two_Arrays_II lcp = new Lcp_350_Intersection_of_Two_Arrays_II();
		
		int[] expected = { 1 };
		int[] input1 = { 3, 1, 2 };
		int[] input2 = { 1, 1 };
		int[] test = lcp.intersect(input1, input2);
		
		assertThat(test).hasSameSizeAs(expected).containsExactlyInAnyOrder(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_350_Intersection_of_Two_Arrays_II lcp = new Lcp_350_Intersection_of_Two_Arrays_II();
		
		int[] expected = { 1, 2 };
		int[] input1 = { 1, 2, 2, 1 };
		int[] input2 = { 1, 2 };
		int[] test = lcp.intersect(input1, input2);
		
		assertThat(test).hasSameSizeAs(expected).containsExactlyInAnyOrder(expected);
	}
	
}
