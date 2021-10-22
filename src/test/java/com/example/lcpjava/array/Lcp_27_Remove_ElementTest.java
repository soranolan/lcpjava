package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_27_Remove_ElementTest {
	
	@Test
	void test_case_1() {
		Lcp_27_Remove_Element lcp = new Lcp_27_Remove_Element();
		
		int expect = 2;
		int[] input = { 3, 2, 2, 3 };
		int val = 3;
		int test = lcp.removeElement(input, val);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_27_Remove_Element lcp = new Lcp_27_Remove_Element();
		
		int expect = 5;
		int[] input = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		int test = lcp.removeElement(input, val);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_27_Remove_Element lcp = new Lcp_27_Remove_Element();
		
		int expect = 0;
		int[] input = {};
		int val = 0;
		int test = lcp.removeElement(input, val);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_4() {
		Lcp_27_Remove_Element lcp = new Lcp_27_Remove_Element();
		
		int expect = 0;
		int[] input = { 1 };
		int val = 1;
		int test = lcp.removeElement(input, val);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
