package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_871_Minimum_Number_of_Refueling_StopsTest {
	
	private Lcp_871_Minimum_Number_of_Refueling_Stops lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_871_Minimum_Number_of_Refueling_Stops();
	}
	
	@Test
	void test_case_1() {
		int expected = 0;
		int target = 1;
		int startFuel = 1;
		int[][] stations = {};
		int test = lcp.minRefuelStops(target, startFuel, stations);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = -1;
		int target = 100;
		int startFuel = 1;
		int[][] stations = { { 10, 100 } };
		int test = lcp.minRefuelStops(target, startFuel, stations);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 2;
		int target = 100;
		int startFuel = 10;
		int[][] stations = { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } };
		int test = lcp.minRefuelStops(target, startFuel, stations);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		int expected = 4;
		int target = 1000;
		int startFuel = 299;
		int[][] stations = { { 13, 21 }, { 26, 115 }, { 100, 47 }, { 225, 99 }, { 299, 141 }, { 444, 198 }, { 608, 190 }, { 636, 157 }, { 647, 255 }, { 841, 123 } };
		int test = lcp.minRefuelStops(target, startFuel, stations);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
