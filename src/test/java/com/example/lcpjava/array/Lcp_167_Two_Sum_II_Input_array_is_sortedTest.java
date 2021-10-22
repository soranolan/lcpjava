package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_167_Two_Sum_II_Input_array_is_sortedTest {
	
	@Test
	void test_case_1() {
		Lcp_167_Two_Sum_II_Input_array_is_sorted lcp = new Lcp_167_Two_Sum_II_Input_array_is_sorted();
		
		int[] expect = { 1, 2 };
		int[] input = { 2, 7, 11, 15 };
		int target = 9;
		int[] test = lcp.twoSum(input, target);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_167_Two_Sum_II_Input_array_is_sorted lcp = new Lcp_167_Two_Sum_II_Input_array_is_sorted();
		
		int[] expect = { 1, 3 };
		int[] input = { 2, 3, 4 };
		int target = 6;
		int[] test = lcp.twoSum(input, target);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_167_Two_Sum_II_Input_array_is_sorted lcp = new Lcp_167_Two_Sum_II_Input_array_is_sorted();
		
		int[] expect = { 1, 2 };
		int[] input = { -1, 0 };
		int target = -1;
		int[] test = lcp.twoSum(input, target);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
