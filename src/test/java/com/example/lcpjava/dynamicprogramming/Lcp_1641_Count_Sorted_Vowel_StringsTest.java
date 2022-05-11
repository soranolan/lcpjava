package com.example.lcpjava.dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1641_Count_Sorted_Vowel_StringsTest {
	
	@Test
	void test_case_1() {
		Lcp_1641_Count_Sorted_Vowel_Strings lcp = new Lcp_1641_Count_Sorted_Vowel_Strings();
		
		int expected = 5;
		int n = 1;
		int test = lcp.countVowelStrings(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1641_Count_Sorted_Vowel_Strings lcp = new Lcp_1641_Count_Sorted_Vowel_Strings();
		
		int expected = 15;
		int n = 2;
		int test = lcp.countVowelStrings(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1641_Count_Sorted_Vowel_Strings lcp = new Lcp_1641_Count_Sorted_Vowel_Strings();
		
		int expected = 66045;
		int n = 33;
		int test = lcp.countVowelStrings(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
