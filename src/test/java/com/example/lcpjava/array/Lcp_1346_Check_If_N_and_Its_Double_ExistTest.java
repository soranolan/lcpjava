package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1346_Check_If_N_and_Its_Double_ExistTest {
	
	@Test
	void test_case_1() {
		Lcp_1346_Check_If_N_and_Its_Double_Exist lcp = new Lcp_1346_Check_If_N_and_Its_Double_Exist();
		
		int[] input = { 10, 2, 5, 3 };
		boolean test = lcp.checkIfExist(input);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		Lcp_1346_Check_If_N_and_Its_Double_Exist lcp = new Lcp_1346_Check_If_N_and_Its_Double_Exist();
		
		int[] input = { 7, 1, 14, 11 };
		boolean test = lcp.checkIfExist(input);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_3() {
		Lcp_1346_Check_If_N_and_Its_Double_Exist lcp = new Lcp_1346_Check_If_N_and_Its_Double_Exist();
		
		int[] input = { 3, 1, 7, 11 };
		boolean test = lcp.checkIfExist(input);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_4() {
		Lcp_1346_Check_If_N_and_Its_Double_Exist lcp = new Lcp_1346_Check_If_N_and_Its_Double_Exist();
		
		int[] input = {};
		boolean test = lcp.checkIfExist(input);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_5() {
		Lcp_1346_Check_If_N_and_Its_Double_Exist lcp = new Lcp_1346_Check_If_N_and_Its_Double_Exist();
		
		int[] input = { 1 };
		boolean test = lcp.checkIfExist(input);
		
		assertThat(test).isFalse();
	}
	
}
