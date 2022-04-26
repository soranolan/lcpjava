package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_2080_Range_Frequency_QueriesTest {
	
	@Test
	void test_case_1() {
		int expected = -1;
		int test = -1;
		
		int[] arr = { 12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56 };
		RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(arr);
		
		expected = 1;
		test = rangeFreqQuery.query(1, 2, 4);
		assertThat(test).isEqualTo(expected);
		
		expected = 2;
		test = rangeFreqQuery.query(0, 11, 33);
		assertThat(test).isEqualTo(expected);
	}
	
}
