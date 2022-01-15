package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_202_Happy_NumberTest {
	
	@Test
	void test_case_1() {
		Lcp_202_Happy_Number lcp = new Lcp_202_Happy_Number();
		
		int input = 19;
		boolean test = lcp.isHappy(input);
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		Lcp_202_Happy_Number lcp = new Lcp_202_Happy_Number();
		
		int input = 2;
		boolean test = lcp.isHappy(input);
		assertThat(test).isFalse();
	}
	
}
