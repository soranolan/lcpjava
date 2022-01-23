package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_219_Contains_Duplicate_IITest {
	
	@Test
	void test_case_1() {
		Lcp_219_Contains_Duplicate_II lcp = new Lcp_219_Contains_Duplicate_II();
		
		int[] input = { 1, 2, 3, 1 };
		int k = 3;
		boolean test = lcp.containsNearbyDuplicate(input, k);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		Lcp_219_Contains_Duplicate_II lcp = new Lcp_219_Contains_Duplicate_II();
		
		int[] input = { 1, 0, 1, 1 };
		int k = 1;
		boolean test = lcp.containsNearbyDuplicate(input, k);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_3() {
		Lcp_219_Contains_Duplicate_II lcp = new Lcp_219_Contains_Duplicate_II();
		
		int[] input = { 1, 2, 3, 1, 2, 3 };
		int k = 2;
		boolean test = lcp.containsNearbyDuplicate(input, k);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_4() {
		Lcp_219_Contains_Duplicate_II lcp = new Lcp_219_Contains_Duplicate_II();
		
		int[] input = { 99, 99 };
		int k = 2;
		boolean test = lcp.containsNearbyDuplicate(input, k);
		
		assertThat(test).isTrue();
	}
	
}
