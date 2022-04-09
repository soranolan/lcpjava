package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Lcp_1222_Queens_That_Can_Attack_the_KingTest {
	
	@Test
	void test_case_1() {
		Lcp_1222_Queens_That_Can_Attack_the_King lcp = new Lcp_1222_Queens_That_Can_Attack_the_King();
		
		Integer[][] output = { { 0, 1 }, { 1, 0 }, { 3, 3 } };
		List<List<Integer>> expected = Arrays
											.stream(output)
											.map(Arrays::stream)
											.map(value -> value.collect(Collectors.toList()))
											.collect(Collectors.toList());
		int[][] queens = { { 0, 1 }, { 1, 0 }, { 4, 0 }, { 0, 4 }, { 3, 3 }, { 2, 4 } };
		int[] king = { 0, 0 };
		List<List<Integer>> test = lcp.queensAttacktheKing(queens, king);
		
		assertThat(test).hasSameSizeAs(expected).containsExactlyInAnyOrderElementsOf(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1222_Queens_That_Can_Attack_the_King lcp = new Lcp_1222_Queens_That_Can_Attack_the_King();
		
		Integer[][] output = { { 2, 2 }, { 3, 4 }, { 4, 4 } };
		List<List<Integer>> expected = Arrays
				.stream(output)
				.map(Arrays::stream)
				.map(value -> value.collect(Collectors.toList()))
				.collect(Collectors.toList());
		int[][] queens = { { 0, 0 }, { 1, 1 }, { 2, 2 }, { 3, 4 }, { 3, 5 }, { 4, 4 }, { 4, 5 } };
		int[] king = { 3, 3 };
		List<List<Integer>> test = lcp.queensAttacktheKing(queens, king);
		
		assertThat(test).hasSameSizeAs(expected).containsExactlyInAnyOrderElementsOf(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1222_Queens_That_Can_Attack_the_King lcp = new Lcp_1222_Queens_That_Can_Attack_the_King();
		
		Integer[][] output = { { 2, 3 }, { 1, 4 }, { 1, 6 }, { 3, 7 }, { 4, 3 }, { 5, 4 }, { 4, 5 } };
		List<List<Integer>> expected = Arrays
				.stream(output)
				.map(Arrays::stream)
				.map(value -> value.collect(Collectors.toList()))
				.collect(Collectors.toList());
		int[][] queens = { { 5, 6 }, { 7, 7 }, { 2, 1 }, { 0, 7 }, { 1, 6 }, { 5, 1 }, { 3, 7 }, { 0, 3 }, { 4, 0 },
				{ 1, 2 }, { 6, 3 }, { 5, 0 }, { 0, 4 }, { 2, 2 }, { 1, 1 }, { 6, 4 }, { 5, 4 }, { 0, 0 }, { 2, 6 },
				{ 4, 5 }, { 5, 2 }, { 1, 4 }, { 7, 5 }, { 2, 3 }, { 0, 5 }, { 4, 2 }, { 1, 0 }, { 2, 7 }, { 0, 1 },
				{ 4, 6 }, { 6, 1 }, { 0, 6 }, { 4, 3 }, { 1, 7 } };
		int[] king = { 3, 4 };
		List<List<Integer>> test = lcp.queensAttacktheKing(queens, king);
		
		assertThat(test).hasSameSizeAs(expected).containsExactlyInAnyOrderElementsOf(expected);
	}
	
}
