package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_724_Find_Pivot_IndexTest {
	
	@Test
	void test_case_1() {
		Lcp_724_Find_Pivot_Index lcp = new Lcp_724_Find_Pivot_Index();
		
		int expect = 3;
		int[] input = new int[] { 1, 7, 3, 6, 5, 6 };
		int test = lcp.pivotIndex(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_724_Find_Pivot_Index lcp = new Lcp_724_Find_Pivot_Index();
		
		int expect = -1;
		int[] input = new int[] { 1, 2, 3 };
		int test = lcp.pivotIndex(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_724_Find_Pivot_Index lcp = new Lcp_724_Find_Pivot_Index();
		
		int expect = 0;
		int[] input = new int[] { 2, 1, -1 };
		int test = lcp.pivotIndex(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_4() {
		Lcp_724_Find_Pivot_Index lcp = new Lcp_724_Find_Pivot_Index();
		
		int expect = -1;
		int[] input = new int[] { -1, -1, -1, -1, -1, -1 };
		int test = lcp.pivotIndex(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
