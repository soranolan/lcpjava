package com.example.lcpjava.math;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_858_Mirror_ReflectionTest {
	
	private Lcp_858_Mirror_Reflection lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_858_Mirror_Reflection();
	}
	
	@Test
	void test_case_1() {
		int expected = 2;
		int p = 2;
		int q = 1;
		int test = lcp.mirrorReflection(p, q);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 1;
		int p = 3;
		int q = 1;
		int test = lcp.mirrorReflection(p, q);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
