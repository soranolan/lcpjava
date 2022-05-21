package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_322_Coin_ChangeTest {
	
	@Test
	void test_case_1() {
		Lcp_322_Coin_Change lcp = new Lcp_322_Coin_Change();
		
		int expected = 3;
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		int test = lcp.coinChange(coins, amount);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_322_Coin_Change lcp = new Lcp_322_Coin_Change();
		
		int expected = -1;
		int[] coins = { 2 };
		int amount = 3;
		int test = lcp.coinChange(coins, amount);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_322_Coin_Change lcp = new Lcp_322_Coin_Change();
		
		int expected = 0;
		int[] coins = { 1 };
		int amount = 0;
		int test = lcp.coinChange(coins, amount);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_322_Coin_Change lcp = new Lcp_322_Coin_Change();
		
		int expected = 20;
		int[] coins = { 1, 2, 5 };
		int amount = 100;
		int test = lcp.coinChange(coins, amount);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
