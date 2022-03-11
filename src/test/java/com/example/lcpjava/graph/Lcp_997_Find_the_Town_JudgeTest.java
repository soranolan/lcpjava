package com.example.lcpjava.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_997_Find_the_Town_JudgeTest {
	
	@Test
	void test_case_1() {
		Lcp_997_Find_the_Town_Judge lcp = new Lcp_997_Find_the_Town_Judge();
		
		int expected = 2;
		int n = 2;
		int[][] input = { { 1, 2 } };
		int test = lcp.findJudge(n, input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_997_Find_the_Town_Judge lcp = new Lcp_997_Find_the_Town_Judge();
		
		int expected = 3;
		int n = 3;
		int[][] input = { { 1, 3 }, { 2, 3 } };
		int test = lcp.findJudge(n, input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_997_Find_the_Town_Judge lcp = new Lcp_997_Find_the_Town_Judge();
		
		int expected = -1;
		int n = 3;
		int[][] input = { { 1, 3 }, { 2, 3 }, { 3, 1 } };
		int test = lcp.findJudge(n, input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
