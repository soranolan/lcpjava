package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1051_Height_CheckerTest {
	
	@Test
	void test_case_1() {
		Lcp_1051_Height_Checker lcp = new Lcp_1051_Height_Checker();
		
		int expect = 3;
		int[] input = new int[] { 1, 1, 4, 2, 1, 3 };
		int test = lcp.heightChecker(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_1051_Height_Checker lcp = new Lcp_1051_Height_Checker();
		
		int expect = 5;
		int[] input = new int[] { 5, 1, 2, 3, 4 };
		int test = lcp.heightChecker(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_1051_Height_Checker lcp = new Lcp_1051_Height_Checker();
		
		int expect = 0;
		int[] input = new int[] { 1, 2, 3, 4, 5 };
		int test = lcp.heightChecker(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_4() {
		Lcp_1051_Height_Checker lcp = new Lcp_1051_Height_Checker();
		
		int expect = 16;
		int[] input = new int[] { 0, 100, 0, 99, 0, 98, 0, 97, 0, 96, 0, 95, 0, 94, 0, 93, 0, 92, 0, 91, 0, 90 };
		int test = lcp.heightChecker(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
