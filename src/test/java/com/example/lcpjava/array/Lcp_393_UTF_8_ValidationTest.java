package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_393_UTF_8_ValidationTest {
	
	private Lcp_393_UTF_8_Validation lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_393_UTF_8_Validation();
	}
	
	@Test
	void test_case_1() {
		int[] data = { 197, 130, 1 };
		boolean test = lcp.validUtf8(data);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		int[] data = { 235, 140, 4 };
		boolean test = lcp.validUtf8(data);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		int[] data = { 228, 189, 160, 229, 165, 189, 13, 10 };
		boolean test = lcp.validUtf8(data);
		
		assertThat(test).isTrue();
	}
	
}
