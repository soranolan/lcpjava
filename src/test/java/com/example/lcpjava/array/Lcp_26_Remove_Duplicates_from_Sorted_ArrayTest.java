package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_26_Remove_Duplicates_from_Sorted_ArrayTest {
	
	@Test
	void test_case_1() {
		Lcp_26_Remove_Duplicates_from_Sorted_Array lcp = new Lcp_26_Remove_Duplicates_from_Sorted_Array();
		
		int expected = 2;
		int[] input = { 1, 1, 2 };
		int test = lcp.removeDuplicates(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_26_Remove_Duplicates_from_Sorted_Array lcp = new Lcp_26_Remove_Duplicates_from_Sorted_Array();
		
		int expected = 5;
		int[] input = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int test = lcp.removeDuplicates(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
