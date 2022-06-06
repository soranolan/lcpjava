package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1926_Nearest_Exit_from_Entrance_in_MazeTest {
	
	private Lcp_1926_Nearest_Exit_from_Entrance_in_Maze lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1926_Nearest_Exit_from_Entrance_in_Maze();
	}
	
	@Test
	void test_case_1() {
		int expected = 1;
		char[][] maze = {
			{ '+', '+', '.', '+' },
			{ '.', '.', '.', '+' },
			{ '+', '+', '+', '.' }
		};
		int[] entrance = { 1, 2 };
		int test = lcp.nearestExit(maze, entrance);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 2;
		char[][] maze = {
			{ '+', '+', '+' },
			{ '.', '.', '.' },
			{ '+', '+', '+' }
		};
		int[] entrance = { 1, 0 };
		int test = lcp.nearestExit(maze, entrance);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = -1;
		char[][] maze = {
			{ '.', '+' }
		};
		int[] entrance = { 0, 0 };
		int test = lcp.nearestExit(maze, entrance);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
