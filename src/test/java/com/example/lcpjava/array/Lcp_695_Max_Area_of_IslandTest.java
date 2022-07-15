package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_695_Max_Area_of_IslandTest {
	
	private Lcp_695_Max_Area_of_Island lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_695_Max_Area_of_Island();
	}
	
	@Test
	void test_case_1() {
		int expected = 6;
		int[][] grid = {
			{ 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
			{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
		};
		int test = lcp.maxAreaOfIsland(grid);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 0;
		int[][] grid = {
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
		};
		int test = lcp.maxAreaOfIsland(grid);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
