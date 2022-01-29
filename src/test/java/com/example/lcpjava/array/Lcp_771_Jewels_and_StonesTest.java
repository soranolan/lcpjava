package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_771_Jewels_and_StonesTest {
	
	@Test
	void test_case_1() {
		Lcp_771_Jewels_and_Stones lcp = new Lcp_771_Jewels_and_Stones();
		
		int expected = 3;
		String jewels = "aA";
		String stones = "aAAbbbb";
		
		int test = lcp.numJewelsInStones(jewels, stones);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_771_Jewels_and_Stones lcp = new Lcp_771_Jewels_and_Stones();
		
		int expected = 0;
		String jewels = "z";
		String stones = "ZZ";
		
		int test = lcp.numJewelsInStones(jewels, stones);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
