package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1041_Robot_Bounded_In_CircleTest {
	
	@Test
	void test_case_1() {
		Lcp_1041_Robot_Bounded_In_Circle lcp = new Lcp_1041_Robot_Bounded_In_Circle();
		
		String instructions = "GGLLGG";
		boolean test = lcp.isRobotBounded(instructions);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		Lcp_1041_Robot_Bounded_In_Circle lcp = new Lcp_1041_Robot_Bounded_In_Circle();
		
		String instructions = "GG";
		boolean test = lcp.isRobotBounded(instructions);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		Lcp_1041_Robot_Bounded_In_Circle lcp = new Lcp_1041_Robot_Bounded_In_Circle();
		
		String instructions = "GL";
		boolean test = lcp.isRobotBounded(instructions);
		
		assertThat(test).isTrue();
	}
	
}
