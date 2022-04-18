package com.example.lcpjava.brainteaser;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_292_Nim_GameTest {
	
	@Test
	void test_case_1() {
		Lcp_292_Nim_Game lcp = new Lcp_292_Nim_Game();
		
		int n = 4;
		boolean test = lcp.canWinNim(n);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_2() {
		Lcp_292_Nim_Game lcp = new Lcp_292_Nim_Game();
		
		int n = 1;
		boolean test = lcp.canWinNim(n);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_3() {
		Lcp_292_Nim_Game lcp = new Lcp_292_Nim_Game();
		
		int n = 2;
		boolean test = lcp.canWinNim(n);
		
		assertThat(test).isTrue();
	}
	
}
