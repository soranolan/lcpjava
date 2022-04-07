package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1094_Car_PoolingTest {
	
	@Test
	void test_case_1() {
		Lcp_1094_Car_Pooling lcp = new Lcp_1094_Car_Pooling();
		
		int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
		int capacity = 4;
		boolean test = lcp.carPooling(trips, capacity);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_2() {
		Lcp_1094_Car_Pooling lcp = new Lcp_1094_Car_Pooling();
		
		int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
		int capacity = 5;
		boolean test = lcp.carPooling(trips, capacity);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_3() {
		Lcp_1094_Car_Pooling lcp = new Lcp_1094_Car_Pooling();
		
		int[][] trips = { { 1, 1, 4 }, { 9, 4, 9 }, { 9, 1, 9 }, { 2, 3, 5 }, { 4, 1, 5 }, { 10, 4, 5 } };
		int capacity = 33;
		boolean test = lcp.carPooling(trips, capacity);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_4() {
		Lcp_1094_Car_Pooling lcp = new Lcp_1094_Car_Pooling();
		
		int[][] trips = { { 3, 3, 5 }, { 4, 5, 6 }, { 1, 2, 7 }, { 3, 2, 8 }, { 10, 5, 9 }, { 2, 5, 9 }, { 1, 2, 5 } };
		int capacity = 19;
		boolean test = lcp.carPooling(trips, capacity);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_5() {
		Lcp_1094_Car_Pooling lcp = new Lcp_1094_Car_Pooling();
		
		int[][] trips = { { 6, 6, 7 }, { 5, 1, 5 }, { 1, 4, 7 }, { 6, 3, 7 }, { 1, 1, 3 }, { 3, 1, 7 }, { 8, 4, 6 }, { 10, 2, 9 }, { 8, 6, 7 } };
		int capacity = 33;
		boolean test = lcp.carPooling(trips, capacity);
		
		assertThat(test).isFalse();
	}
	
}
