package com.example.lcpjava.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_451_Sort_Characters_By_FrequencyTest {
	
	@Test
	void test_case_1() {
		Lcp_451_Sort_Characters_By_Frequency lcp = new Lcp_451_Sort_Characters_By_Frequency();
		
		String expected = "eert";																					// eetr is also valid
		String input = "tree";
		String test = lcp.frequencySort(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_451_Sort_Characters_By_Frequency lcp = new Lcp_451_Sort_Characters_By_Frequency();
		
		String expected = "aaaccc";																					// cccaaa is also valid
		String input = "cccaaa";
		String test = lcp.frequencySort(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_451_Sort_Characters_By_Frequency lcp = new Lcp_451_Sort_Characters_By_Frequency();
		
		String expected = "bbAa";																					// bbaA is also valid
		String input = "Aabb";
		String test = lcp.frequencySort(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
