package com.example.lcpjava.heap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1464_Maximum_Product_of_Two_Elements_in_an_ArrayTest {
	
	@Test
	void test_case_1() {
		Lcp_1464_Maximum_Product_of_Two_Elements_in_an_Array lcp = new Lcp_1464_Maximum_Product_of_Two_Elements_in_an_Array();
		
		int expected = 12;
		int[] input = { 3, 4, 5, 2 };
		int test = lcp.maxProduct(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1464_Maximum_Product_of_Two_Elements_in_an_Array lcp = new Lcp_1464_Maximum_Product_of_Two_Elements_in_an_Array();
		
		int expected = 16;
		int[] input = { 1, 5, 4, 5 };
		int test = lcp.maxProduct(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1464_Maximum_Product_of_Two_Elements_in_an_Array lcp = new Lcp_1464_Maximum_Product_of_Two_Elements_in_an_Array();
		
		int expected = 12;
		int[] input = { 3, 7 };
		int test = lcp.maxProduct(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
