package com.example.lcpjava.queue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_200_Number_of_IslandsTest {
	
	@Test
	void test_case_1() {
		Lcp_200_Number_of_Islands lcp = new Lcp_200_Number_of_Islands();
		
		int expected = 1;
		
		char[][] grid = {
			{ '1', '1', '1', '1', '0' },
			{ '1', '1', '0', '1', '0' },
			{ '1', '1', '0', '0', '0' },
			{ '0', '0', '0', '0', '0' }
		};
		int test = -1;
		
		test = lcp.numIslands(grid);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_200_Number_of_Islands lcp = new Lcp_200_Number_of_Islands();
		
		int expected = 3;
		
		char[][] grid = {
				{ '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' }
		};
		int test = -1;
		
		test = lcp.numIslands(grid);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
