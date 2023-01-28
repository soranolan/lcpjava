package com.example.lcpjava.design;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_352_Data_Stream_as_Disjoint_IntervalsTest {
	
	private SummaryRanges summaryRanges;
	
	@BeforeEach
	public void beforeEach() {
		summaryRanges = new SummaryRanges();
	}
	
	@Test
	void test_case_1() {
		int[][] test = null;
		int[][] expected = null;
		
		summaryRanges.addNum(1);
		expected = new int[][] { { 1, 1 } };
		test = summaryRanges.getIntervals();
		assertArrayEquals(test, expected);
		
		summaryRanges.addNum(3);
		expected = new int[][] { { 1, 1 }, { 3, 3 } };
		test = summaryRanges.getIntervals();
		assertArrayEquals(test, expected);
		
		summaryRanges.addNum(7);
		expected = new int[][] { { 1, 1 }, { 3, 3 }, { 7, 7 } };
		test = summaryRanges.getIntervals();
		assertArrayEquals(test, expected);
		
		summaryRanges.addNum(2);
		expected = new int[][] { { 1, 3 }, { 7, 7 } };
		test = summaryRanges.getIntervals();
		assertArrayEquals(test, expected);
		
		summaryRanges.addNum(6);
		expected = new int[][] { { 1, 3 }, { 6, 7 } };
		test = summaryRanges.getIntervals();
		assertArrayEquals(test, expected);
	}
	
}
