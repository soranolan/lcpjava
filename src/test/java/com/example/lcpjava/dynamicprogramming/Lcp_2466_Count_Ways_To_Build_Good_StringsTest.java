package com.example.lcpjava.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_2466_Count_Ways_To_Build_Good_StringsTest {
	
	private Lcp_2466_Count_Ways_To_Build_Good_Strings lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_2466_Count_Ways_To_Build_Good_Strings();
	}
	
	@Test
	void test_case_1() {
		int expected = 8;
		int low = 3;
		int high = 3;
		int zero = 1;
		int one = 1;
		int actual = lcp.countGoodStrings(low, high, zero, one);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void test_case_2() {
		int expected = 5;
		int low = 2;
		int high = 3;
		int zero = 1;
		int one = 2;
		int actual = lcp.countGoodStrings(low, high, zero, one);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void test_case_3() {
		int expected = 764262396;
		int low = 200;
		int high = 200;
		int zero = 10;
		int one = 1;
		int actual = lcp.countGoodStrings(low, high, zero, one);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void test_case_4() {
		int expected = 215447031;
		int low = 1;
		int high = 100000;
		int zero = 1;
		int one = 1;
		int actual = lcp.countGoodStrings(low, high, zero, one);
		
		assertEquals(expected, actual);
	}
	
}
