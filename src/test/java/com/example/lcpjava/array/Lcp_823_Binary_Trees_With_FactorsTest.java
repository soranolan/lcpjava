package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_823_Binary_Trees_With_FactorsTest {
	
	private Lcp_823_Binary_Trees_With_Factors lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_823_Binary_Trees_With_Factors();
	}
	
	@Test
	void test_case_1() {
		int expected = 3;
		int[] arr = { 2, 4 };
		int test = lcp.numFactoredBinaryTrees(arr);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 7;
		int[] arr = { 2, 4, 5, 10 };
		int test = lcp.numFactoredBinaryTrees(arr);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
