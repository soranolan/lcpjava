package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_640_Solve_the_EquationTest {
	
	@Test
	void test_case_1() {
		Lcp_640_Solve_the_Equation lcp = new Lcp_640_Solve_the_Equation();
		
		String expected = "x=2";
		String input = "x+5-3+x=6+x-2";
		String test = lcp.solveEquation(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_640_Solve_the_Equation lcp = new Lcp_640_Solve_the_Equation();
		
		String expected = "Infinite solutions";
		String input = "x=x";
		String test = lcp.solveEquation(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_640_Solve_the_Equation lcp = new Lcp_640_Solve_the_Equation();
		
		String expected = "x=0";
		String input = "2x=x";
		String test = lcp.solveEquation(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_640_Solve_the_Equation lcp = new Lcp_640_Solve_the_Equation();
		
		String expected = "x=-1";
		String input = "2x+3x-6x=x+2";
		String test = lcp.solveEquation(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_5() {
		Lcp_640_Solve_the_Equation lcp = new Lcp_640_Solve_the_Equation();
		
		String expected = "x=-20";
		String input = "x-10=10-x+x+2x";
		String test = lcp.solveEquation(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_6() {
		Lcp_640_Solve_the_Equation lcp = new Lcp_640_Solve_the_Equation();
		
		String expected = "Infinite solutions";
		String input = "0x=0";
		String test = lcp.solveEquation(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
