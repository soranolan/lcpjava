package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_2260_Minimum_Consecutive_Cards_to_Pick_UpTest {
	
	private Lcp_2260_Minimum_Consecutive_Cards_to_Pick_Up lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_2260_Minimum_Consecutive_Cards_to_Pick_Up();
	}
	
	@Test
	void test_case_1() {
		int expected = 4;
		int[] cards = { 3, 4, 2, 3, 4, 7 };
		int test = lcp.minimumCardPickup(cards);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = -1;
		int[] cards = { 1, 0, 5, 3 };
		int test = lcp.minimumCardPickup(cards);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 3;
		int[] cards = { 95, 11, 8, 65, 5, 86, 30, 27, 30, 73, 15, 91, 30, 7, 37, 26, 55, 76, 60, 43, 36, 85, 47, 96, 6 };
		int test = lcp.minimumCardPickup(cards);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		int expected = 2;
		int[] cards = { 0, 0 };
		int test = lcp.minimumCardPickup(cards);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
