package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_188_Best_Time_to_Buy_and_Sell_Stock_IVTest {
	
	private Lcp_188_Best_Time_to_Buy_and_Sell_Stock_IV lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_188_Best_Time_to_Buy_and_Sell_Stock_IV();
	}
	
	@Test
	void test_case_1() {
		int expected = 2;
		int k = 2;
		int[] prices = { 2, 4, 1 };
		int test = lcp.maxProfit(k, prices);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 7;
		int k = 2;
		int[] prices = { 3, 2, 6, 5, 0, 3 };
		int test = lcp.maxProfit(k, prices);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
