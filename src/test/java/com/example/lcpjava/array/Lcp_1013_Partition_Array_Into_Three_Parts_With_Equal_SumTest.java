package com.example.lcpjava.array;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1013_Partition_Array_Into_Three_Parts_With_Equal_SumTest {
	
	private Lcp_1013_Partition_Array_Into_Three_Parts_With_Equal_Sum lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1013_Partition_Array_Into_Three_Parts_With_Equal_Sum();
	}
	
	@Test
	void test_case_1() {
		int[] arr = { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 };
		boolean test = lcp.canThreePartsEqualSum(arr);
		
		assertTrue(test);
	}
	
	@Test
	void test_case_2() {
		int[] arr = { 0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1 };
		boolean test = lcp.canThreePartsEqualSum(arr);
		
		assertFalse(test);
	}
	
	@Test
	void test_case_3() {
		int[] arr = { 3, 3, 6, 5, -2, 2, 5, 1, -9, 4 };
		boolean test = lcp.canThreePartsEqualSum(arr);
		
		assertTrue(test);
	}
	
	@Test
	void test_case_4() {
		int[] arr = { 18, 12, -18, 18, -19, -1, 10, 10 };
		boolean test = lcp.canThreePartsEqualSum(arr);
		
		assertTrue(test);
	}
	
	@Test
	void test_case_5() {
		int[] arr = { 1, 1, 1, 1 };
		boolean test = lcp.canThreePartsEqualSum(arr);
		
		assertFalse(test);
	}
	
	@Test
	void test_case_6() {
		int[] arr = { 1, -1, 1, -1 };
		boolean test = lcp.canThreePartsEqualSum(arr);
		
		assertFalse(test);
	}
	
	@Test
	void test_case_7() {
		int[] arr = { 0, 0, 0, 0 };
		boolean test = lcp.canThreePartsEqualSum(arr);
		
		assertTrue(test);
	}
	
}
