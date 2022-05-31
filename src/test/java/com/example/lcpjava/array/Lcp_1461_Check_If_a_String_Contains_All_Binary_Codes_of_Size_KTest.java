package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1461_Check_If_a_String_Contains_All_Binary_Codes_of_Size_KTest {
	
	private Lcp_1461_Check_If_a_String_Contains_All_Binary_Codes_of_Size_K lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1461_Check_If_a_String_Contains_All_Binary_Codes_of_Size_K();
	}
	
	@Test
	void test_case_1() {
		String s = "00110110";
		int k = 2;
		boolean test = lcp.hasAllCodes(s, k);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		String s = "0110";
		int k = 1;
		boolean test = lcp.hasAllCodes(s, k);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_3() {
		String s = "0110";
		int k = 2;
		boolean test = lcp.hasAllCodes(s, k);
		
		assertThat(test).isFalse();
	}
	
}
