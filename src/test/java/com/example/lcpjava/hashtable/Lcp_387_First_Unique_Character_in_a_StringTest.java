package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_387_First_Unique_Character_in_a_StringTest {
	
	private Lcp_387_First_Unique_Character_in_a_String lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_387_First_Unique_Character_in_a_String();
	}
	
	@Test
	void test_case_1() {
		int expected = 0;
		String input = "leetcode";
		int test = lcp.firstUniqChar(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 2;
		String input = "loveleetcode";
		int test = lcp.firstUniqChar(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = -1;
		String input = "aabb";
		int test = lcp.firstUniqChar(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
