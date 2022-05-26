package com.example.lcpjava.bitmanipulation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_191_Number_of_1_BitsTest {
	
	private Lcp_191_Number_of_1_Bits lcp;
	
	@BeforeEach
	public void beforeEach() {
		lcp = new Lcp_191_Number_of_1_Bits();
	}
	
	@Test
	void test_case_1() {
		int expected = 3;
		int n = 00000000000000000000000000001011;
		int test = lcp.hammingWeight(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 1;
		int n = 00000000000000000000000010000000;
		int test = lcp.hammingWeight(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 31;
		int n = -3;
		int test = lcp.hammingWeight(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
