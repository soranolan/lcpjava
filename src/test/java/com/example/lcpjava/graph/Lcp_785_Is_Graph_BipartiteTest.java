package com.example.lcpjava.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_785_Is_Graph_BipartiteTest {
	
	@Test
	void test_case_1() {
		Lcp_785_Is_Graph_Bipartite lcp = new Lcp_785_Is_Graph_Bipartite();
		
		int[][] input = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
		boolean test = lcp.isBipartite(input);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_2() {
		Lcp_785_Is_Graph_Bipartite lcp = new Lcp_785_Is_Graph_Bipartite();
		
		int[][] input = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		boolean test = lcp.isBipartite(input);
		
		assertThat(test).isTrue();
	}
	
}
