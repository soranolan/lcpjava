package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_121_Best_Time_to_Buy_and_Sell_StockTest {
	
	@Test
	void test_case_1() {
		Lcp_121_Best_Time_to_Buy_and_Sell_Stock lcp = new Lcp_121_Best_Time_to_Buy_and_Sell_Stock();
		
		int expected = 5;
		int[] input = { 7, 1, 5, 3, 6, 4 };
		int test = lcp.maxProfit(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_121_Best_Time_to_Buy_and_Sell_Stock lcp = new Lcp_121_Best_Time_to_Buy_and_Sell_Stock();
		
		int expected = 0;
		int[] input = { 7, 6, 4, 3, 1 };
		int test = lcp.maxProfit(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
