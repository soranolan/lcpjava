package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Lcp_1424_Diagonal_Traverse_IITest {
	
	@Test
	void test_case_1() {
		Lcp_1424_Diagonal_Traverse_II lcp = new Lcp_1424_Diagonal_Traverse_II();
		
		int[] expected = { 1, 4, 2, 7, 5, 3, 8, 6, 9 };
		List<List<Integer>> nums = Arrays.stream(new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }).map(Arrays::asList).collect(Collectors.toList());
		int[] test = lcp.findDiagonalOrder(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1424_Diagonal_Traverse_II lcp = new Lcp_1424_Diagonal_Traverse_II();
		
		int[] expected = { 1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16 };
		List<List<Integer>> nums = Arrays.stream(new Integer[][] { { 1, 2, 3, 4, 5 }, { 6, 7 }, { 8 }, { 9, 10, 11 }, { 12, 13, 14, 15, 16 } }).map(Arrays::asList).collect(Collectors.toList());
		int[] test = lcp.findDiagonalOrder(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
