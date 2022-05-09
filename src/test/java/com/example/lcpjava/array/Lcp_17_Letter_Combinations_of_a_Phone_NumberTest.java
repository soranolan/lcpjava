package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Lcp_17_Letter_Combinations_of_a_Phone_NumberTest {
	
	@Test
	void test_case_1() {
		Lcp_17_Letter_Combinations_of_a_Phone_Number lcp = new Lcp_17_Letter_Combinations_of_a_Phone_Number();
		
		List<String> expected = Arrays.stream(new String[] { "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf" }) .toList();
		String digits = "23";
		List<String> test = lcp.letterCombinations(digits);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_17_Letter_Combinations_of_a_Phone_Number lcp = new Lcp_17_Letter_Combinations_of_a_Phone_Number();
		
		List<String> expected = new ArrayList<>();
		String digits = "";
		List<String> test = lcp.letterCombinations(digits);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_17_Letter_Combinations_of_a_Phone_Number lcp = new Lcp_17_Letter_Combinations_of_a_Phone_Number();
		
		List<String> expected = Arrays.stream(new String[] { "a", "b", "c" }).toList();
		String digits = "2";
		List<String> test = lcp.letterCombinations(digits);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
