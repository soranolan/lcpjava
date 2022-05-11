package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_926_Flip_String_to_Monotone_IncreasingTest {
	
	@Test
	void test_case_1() {
		Lcp_926_Flip_String_to_Monotone_Increasing lcp = new Lcp_926_Flip_String_to_Monotone_Increasing();
		
		int expected = 1;
		String s = "00110";
		int test = lcp.minFlipsMonoIncr(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_926_Flip_String_to_Monotone_Increasing lcp = new Lcp_926_Flip_String_to_Monotone_Increasing();
		
		int expected = 2;
		String s = "010110";
		int test = lcp.minFlipsMonoIncr(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_926_Flip_String_to_Monotone_Increasing lcp = new Lcp_926_Flip_String_to_Monotone_Increasing();
		
		int expected = 2;
		String s = "00011000";
		int test = lcp.minFlipsMonoIncr(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
