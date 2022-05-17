package com.example.lcpjava.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1334_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_DistanceTest {
	
	@Test
	void test_case_1() {
		Lcp_1334_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance lcp = new Lcp_1334_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance();
		
		int expected = 3;
		int n = 4;
		int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
		int distanceThreshold = 4;
		int test = lcp.findTheCity(n, edges, distanceThreshold);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1334_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance lcp = new Lcp_1334_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance();
		
		int expected = 0;
		int n = 5;
		int[][] edges = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int distanceThreshold = 2;
		int test = lcp.findTheCity(n, edges, distanceThreshold);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
