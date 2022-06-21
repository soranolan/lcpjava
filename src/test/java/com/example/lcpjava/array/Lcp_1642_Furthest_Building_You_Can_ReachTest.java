package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1642_Furthest_Building_You_Can_ReachTest {
	
	private Lcp_1642_Furthest_Building_You_Can_Reach lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1642_Furthest_Building_You_Can_Reach();
	}
	
	@Test
	void test_case_1() {
		int expected = 4;
		int[] heights = { 4, 2, 7, 6, 9, 14, 12 };
		int bricks = 5;
		int ladders = 1;
		int test = lcp.furthestBuilding(heights, bricks, ladders);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 7;
		int[] heights = { 4, 12, 2, 7, 3, 18, 20, 3, 19 };
		int bricks = 10;
		int ladders = 2;
		int test = lcp.furthestBuilding(heights, bricks, ladders);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 3;
		int[] heights = { 14, 3, 19, 3 };
		int bricks = 17;
		int ladders = 0;
		int test = lcp.furthestBuilding(heights, bricks, ladders);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
