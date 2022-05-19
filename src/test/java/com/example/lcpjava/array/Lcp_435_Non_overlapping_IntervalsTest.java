package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_435_Non_overlapping_IntervalsTest {
	
	@Test
	void test_case_1() {
		Lcp_435_Non_overlapping_Intervals lcp = new Lcp_435_Non_overlapping_Intervals();
		
		int expected = 1;
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		int test = lcp.eraseOverlapIntervals(intervals);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_435_Non_overlapping_Intervals lcp = new Lcp_435_Non_overlapping_Intervals();
		
		int expected = 2;
		int[][] intervals = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
		int test = lcp.eraseOverlapIntervals(intervals);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_435_Non_overlapping_Intervals lcp = new Lcp_435_Non_overlapping_Intervals();
		
		int expected = 0;
		int[][] intervals = { { 1, 2 }, { 2, 3 } };
		int test = lcp.eraseOverlapIntervals(intervals);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
