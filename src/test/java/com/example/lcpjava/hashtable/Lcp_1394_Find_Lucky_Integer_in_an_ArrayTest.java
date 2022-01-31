package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1394_Find_Lucky_Integer_in_an_ArrayTest {
	
	@Test
	void test_case_1() {
		Lcp_1394_Find_Lucky_Integer_in_an_Array lcp = new Lcp_1394_Find_Lucky_Integer_in_an_Array();
		
		int expected = 2;
		int[] input = new int[] { 2, 2, 3, 4 };
		int test = lcp.findLucky(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1394_Find_Lucky_Integer_in_an_Array lcp = new Lcp_1394_Find_Lucky_Integer_in_an_Array();
		
		int expected = 3;
		int[] input = new int[] { 1, 2, 2, 3, 3, 3 };
		int test = lcp.findLucky(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1394_Find_Lucky_Integer_in_an_Array lcp = new Lcp_1394_Find_Lucky_Integer_in_an_Array();
		
		int expected = -1;
		int[] input = new int[] { 2, 2, 2, 3, 3 };
		int test = lcp.findLucky(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
