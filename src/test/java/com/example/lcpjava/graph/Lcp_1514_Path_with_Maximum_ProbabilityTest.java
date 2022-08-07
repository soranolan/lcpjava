package com.example.lcpjava.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1514_Path_with_Maximum_ProbabilityTest {
	
	private Lcp_1514_Path_with_Maximum_Probability lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1514_Path_with_Maximum_Probability();
	}
	
	@Test
	void test_case_1() {
		double expected = 0.25000D;
		int n = 3;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
		double[] succProb = { 0.5, 0.5, 0.2 };
		int start = 0;
		int end = 2;
		double test = lcp.maxProbability(n, edges, succProb, start, end);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		double expected = 0.30000D;
		int n = 3;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
		double[] succProb = { 0.5, 0.5, 0.3 };
		int start = 0;
		int end = 2;
		double test = lcp.maxProbability(n, edges, succProb, start, end);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		double expected = 0.00000D;
		int n = 3;
		int[][] edges = { { 0, 1 } };
		double[] succProb = { 0.5 };
		int start = 0;
		int end = 2;
		double test = lcp.maxProbability(n, edges, succProb, start, end);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
