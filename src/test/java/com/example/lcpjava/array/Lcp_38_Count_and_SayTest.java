package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_38_Count_and_SayTest {
	
	private Lcp_38_Count_and_Say lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_38_Count_and_Say();
	}
	
	@Test
	void test_case_1() {
		String expected = "1";
		int n = 1;
		String test = lcp.countAndSay(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		String expected = "1211";
		int n = 4;
		String test = lcp.countAndSay(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
