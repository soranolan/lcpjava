package com.example.lcpjava.dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_62_Unique_PathsTest {
	
	@Test
	void test_case_1() {
		Lcp_62_Unique_Paths lcp = new Lcp_62_Unique_Paths();
		
		int expected = 28;
		int m = 3;
		int n = 7;
		int test = lcp.uniquePaths(m, n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_62_Unique_Paths lcp = new Lcp_62_Unique_Paths();
		
		int expected = 3;
		int m = 3;
		int n = 2;
		int test = lcp.uniquePaths(m, n);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
