package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

class Lcp_448_Find_All_Numbers_Disappeared_in_an_ArrayTest {
	
	@Test
	void test_case_1() {
		Lcp_448_Find_All_Numbers_Disappeared_in_an_Array lcp = new Lcp_448_Find_All_Numbers_Disappeared_in_an_Array();
		
		Integer[] expect = { 5, 6 };
		int[] input = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> test = lcp.findDisappearedNumbers(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expect));
	}
	
	@Test
	void test_case_2() {
		Lcp_448_Find_All_Numbers_Disappeared_in_an_Array lcp = new Lcp_448_Find_All_Numbers_Disappeared_in_an_Array();
		
		Integer[] expect = { 2 };
		int[] input = { 1, 1 };
		List<Integer> test = lcp.findDisappearedNumbers(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expect));
	}
	
}
