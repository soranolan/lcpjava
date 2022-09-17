package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_2145_Count_the_Hidden_SequencesTest {
	
	private Lcp_2145_Count_the_Hidden_Sequences lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_2145_Count_the_Hidden_Sequences();
	}
	
	@Test
	void test_case_1() {
		int expected = 2;
		int[] differences = { 1, -3, 4 };
		int lower = 1;
		int upper = 6;
		int test = lcp.numberOfArrays(differences, lower, upper);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 4;
		int[] differences = { 3, -4, 5, 1, -2 };
		int lower = -4;
		int upper = 5;
		int test = lcp.numberOfArrays(differences, lower, upper);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 0;
		int[] differences = { 4, -7, 2 };
		int lower = 3;
		int upper = 6;
		int test = lcp.numberOfArrays(differences, lower, upper);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
