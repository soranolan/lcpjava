package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_561_Array_Partition_ITest {
	
	@Test
	void test_case_1() {
		Lcp_561_Array_Partition_I lcp = new Lcp_561_Array_Partition_I();
		
		int expected = 4;
		int[] input = { 1, 4, 3, 2 };
		int test = lcp.arrayPairSum(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_561_Array_Partition_I lcp = new Lcp_561_Array_Partition_I();
		
		int expected = 9;
		int[] input = { 6, 2, 6, 5, 1, 2 };
		int test = lcp.arrayPairSum(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
