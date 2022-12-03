package com.example.lcpjava.heap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_451_Sort_Characters_By_FrequencyTest {
	
	private Lcp_451_Sort_Characters_By_Frequency lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_451_Sort_Characters_By_Frequency();
	}
	
	@Test
	void test_case_1() {
		String expected = "eert";																					// eetr is also valid
		String input = "tree";
		String test = lcp.frequencySort(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		String expected = "aaaccc";																					// cccaaa is also valid
		String input = "cccaaa";
		String test = lcp.frequencySort(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		String expected = "bbAa";																					// bbaA is also valid
		String input = "Aabb";
		String test = lcp.frequencySort(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
