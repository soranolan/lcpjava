package com.example.lcpjava.trie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_421_Maximum_XOR_of_Two_Numbers_in_an_ArrayTest {
	
	private Lcp_421_Maximum_XOR_of_Two_Numbers_in_an_Array lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_421_Maximum_XOR_of_Two_Numbers_in_an_Array();
	}
	
	@Test
	void test_case_1() {
		// Arrange
		int[] nums = { 3, 10, 5, 25, 2, 8 };
		
		// Act
		int actual = lcp.findMaximumXOR(nums);
		
		// Assert
		assertEquals(28, actual);
	}
	
	@Test
	void test_case_2() {
		// Arrange
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		
		// Act
		int actual = lcp.findMaximumXOR(nums);
		
		// Assert
		assertEquals(127, actual);
	}
	
}
