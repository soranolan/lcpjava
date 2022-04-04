package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_749_Contain_VirusTest {
	
	@Test
	void test_case_1() {
		Lcp_749_Contain_Virus lcp = new Lcp_749_Contain_Virus();
		
		int expected = 10;
		int[][] isInfected = {
			{ 0, 1, 0, 0, 0, 0, 0, 1 },
			{ 0, 1, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }
		};
		int test = lcp.containVirus(isInfected);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_749_Contain_Virus lcp = new Lcp_749_Contain_Virus();
		
		int expected = 4;
		int[][] isInfected = {
			{ 1, 1, 1 },
			{ 1, 0, 1 },
			{ 1, 1, 1 }
		};
		int test = lcp.containVirus(isInfected);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_749_Contain_Virus lcp = new Lcp_749_Contain_Virus();
		
		int expected = 13;
		int[][] isInfected = {
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0 }
		};
		int test = lcp.containVirus(isInfected);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
