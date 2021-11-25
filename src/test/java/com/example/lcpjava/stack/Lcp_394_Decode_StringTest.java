package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_394_Decode_StringTest {
	
	@Test
	void test_case_1() {
		Lcp_394_Decode_String lcp = new Lcp_394_Decode_String();
		
		String expected = "aaabcbc";
		
		String input = "3[a]2[bc]";
		String test = lcp.decodeString(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_394_Decode_String lcp = new Lcp_394_Decode_String();
		
		String expected = "accaccacc";
		
		String input = "3[a2[c]]";
		String test = lcp.decodeString(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_394_Decode_String lcp = new Lcp_394_Decode_String();
		
		String expected = "abcabccdcdcdef";
		
		String input = "2[abc]3[cd]ef";
		String test = lcp.decodeString(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_394_Decode_String lcp = new Lcp_394_Decode_String();
		
		String expected = "abccdcdcdxyz";
		
		String input = "abc3[cd]xyz";
		String test = lcp.decodeString(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_5() {
		Lcp_394_Decode_String lcp = new Lcp_394_Decode_String();
		
		String expected = "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode";
		
		String input = "100[leetcode]";
		String test = lcp.decodeString(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
