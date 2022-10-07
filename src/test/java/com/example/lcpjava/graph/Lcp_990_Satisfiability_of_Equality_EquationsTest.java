package com.example.lcpjava.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_990_Satisfiability_of_Equality_EquationsTest {
	
	private Lcp_990_Satisfiability_of_Equality_Equations lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_990_Satisfiability_of_Equality_Equations();
	}
	
	@Test
	void test_case_1() {
		String[] equations = { "a==b", "b!=a" };
		boolean test = lcp.equationsPossible(equations);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_2() {
		String[] equations = { "b==a", "a==b" };
		boolean test = lcp.equationsPossible(equations);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_3() {
		String[] equations = { "a!=a" };
		boolean test = lcp.equationsPossible(equations);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_4() {
		String[] equations = { "a==b", "b==c", "c==e", "a!=e" };
		boolean test = lcp.equationsPossible(equations);
		
		assertThat(test).isFalse();
	}
	
}
