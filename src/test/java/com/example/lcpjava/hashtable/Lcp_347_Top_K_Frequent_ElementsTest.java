package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_347_Top_K_Frequent_ElementsTest {
	
	@Test
	void test_case_1() {
		Lcp_347_Top_K_Frequent_Elements lcp = new Lcp_347_Top_K_Frequent_Elements();
		
		int[] expected = { 1, 2 };
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] test = lcp.topKFrequent(nums, k);
		
		assertThat(test).hasSameSizeAs(expected).containsExactlyInAnyOrder(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_347_Top_K_Frequent_Elements lcp = new Lcp_347_Top_K_Frequent_Elements();
		
		int[] expected = { 1 };
		int[] nums = { 1 };
		int k = 1;
		int[] test = lcp.topKFrequent(nums, k);
		
		assertThat(test).hasSameSizeAs(expected).containsExactlyInAnyOrder(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_347_Top_K_Frequent_Elements lcp = new Lcp_347_Top_K_Frequent_Elements();
		
		int[] expected = { -1 };
		int[] nums = { -1, -1 };
		int k = 1;
		int[] test = lcp.topKFrequent(nums, k);
		
		assertThat(test).hasSameSizeAs(expected).containsExactlyInAnyOrder(expected);
	}
	
}
