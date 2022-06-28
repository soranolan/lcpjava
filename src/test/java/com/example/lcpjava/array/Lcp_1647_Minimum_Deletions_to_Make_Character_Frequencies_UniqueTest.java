package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1647_Minimum_Deletions_to_Make_Character_Frequencies_UniqueTest {
	
	private Lcp_1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique();
	}
	
	@Test
	void test_case_1() {
		int expected = 0;
		String s = "aab";
		int test = lcp.minDeletions(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 2;
		String s = "aaabbbcc";
		int test = lcp.minDeletions(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 2;
		String s = "ceabaacb";
		int test = lcp.minDeletions(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
