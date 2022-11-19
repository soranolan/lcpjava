package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_587_Erect_the_FenceTest {
	
	private Lcp_587_Erect_the_Fence lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_587_Erect_the_Fence();
	}
	
	@Test
	void test_case_1() {
		int[][] expected = { { 1, 1 }, { 2, 0 }, { 3, 3 }, { 2, 4 }, { 4, 2 } };
		int[][] points = { { 1, 1 }, { 2, 2 }, { 2, 0 }, { 2, 4 }, { 3, 3 }, { 4, 2 } };
		int[][] test = lcp.outerTrees(points);
		
		assertThat(Arrays.asList(test)).containsExactlyInAnyOrderElementsOf(Arrays.asList(expected));
	}
	
	@Test
	void test_case_2() {
		int[][] expected = { { 4, 2 }, { 2, 2 }, { 1, 2 } };
		int[][] points = { { 1, 2 }, { 2, 2 }, { 4, 2 } };
		int[][] test = lcp.outerTrees(points);
		
		assertThat(Arrays.asList(test)).containsExactlyInAnyOrderElementsOf(Arrays.asList(expected));
	}
	
}
