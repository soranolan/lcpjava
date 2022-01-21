package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_387_First_Unique_Character_in_a_StringTest {
	
	@Test
	void test_case_1() {
		Lcp_387_First_Unique_Character_in_a_String lcp = new Lcp_387_First_Unique_Character_in_a_String();
		
		int expected = 0;
		String input = "leetcode";
		int test = lcp.firstUniqChar(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_387_First_Unique_Character_in_a_String lcp = new Lcp_387_First_Unique_Character_in_a_String();
		
		int expected = 2;
		String input = "loveleetcode";
		int test = lcp.firstUniqChar(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_387_First_Unique_Character_in_a_String lcp = new Lcp_387_First_Unique_Character_in_a_String();
		
		int expected = -1;
		String input = "aabb";
		int test = lcp.firstUniqChar(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
