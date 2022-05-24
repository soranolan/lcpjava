package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1386_Cinema_Seat_AllocationTest {
	
	@Test
	void test_case_1() {
		Lcp_1386_Cinema_Seat_Allocation lcp = new Lcp_1386_Cinema_Seat_Allocation();
		
		int expected = 4;
		int n = 3;
		int[][] reservedSeats = { { 1, 2 }, { 1, 3 }, { 1, 8 }, { 2, 6 }, { 3, 1 }, { 3, 10 } };
		int test = lcp.maxNumberOfFamilies(n, reservedSeats);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1386_Cinema_Seat_Allocation lcp = new Lcp_1386_Cinema_Seat_Allocation();
		
		int expected = 2;
		int n = 2;
		int[][] reservedSeats = { { 2, 1 }, { 1, 8 }, { 2, 6 } };
		int test = lcp.maxNumberOfFamilies(n, reservedSeats);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1386_Cinema_Seat_Allocation lcp = new Lcp_1386_Cinema_Seat_Allocation();
		
		int expected = 4;
		int n = 4;
		int[][] reservedSeats = { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } };
		int test = lcp.maxNumberOfFamilies(n, reservedSeats);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
