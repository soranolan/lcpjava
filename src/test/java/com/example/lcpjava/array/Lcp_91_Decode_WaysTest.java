package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_91_Decode_WaysTest {
	
	private Lcp_91_Decode_Ways lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_91_Decode_Ways();
	}
	
	@Test
	void test_case_1() {
		int expected = 2;
		String s = "12";
		int test = lcp.numDecodings(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 3;
		String s = "226";
		int test = lcp.numDecodings(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 0;
		String s = "06";
		int test = lcp.numDecodings(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		int expected = 1;
		String s = "2102";
		int test = lcp.numDecodings(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
