package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1562_Find_Latest_Group_of_Size_MTest {
	
	private Lcp_1562_Find_Latest_Group_of_Size_M lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1562_Find_Latest_Group_of_Size_M();
	}
	
	@Test
	void test_case_1() {
		int expected = 4;
		int[] arr = { 3, 5, 1, 2, 4 };
		int m = 1;
		int test = lcp.findLatestStep(arr, m);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = -1;
		int[] arr = { 3, 1, 5, 4, 2 };
		int m = 2;
		int test = lcp.findLatestStep(arr, m);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
