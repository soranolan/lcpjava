package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_557_Reverse_Words_in_a_String_IIITest {
	
	@Test
	void test_case_1() {
		Lcp_557_Reverse_Words_in_a_String_III lcp = new Lcp_557_Reverse_Words_in_a_String_III();
		
		String expected = "s'teL ekat edoCteeL tsetnoc";
		String input = "Let's take LeetCode contest";
		String test = lcp.reverseWords(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_557_Reverse_Words_in_a_String_III lcp = new Lcp_557_Reverse_Words_in_a_String_III();
		
		String expected = "doG gniD";
		String input = "God Ding";
		String test = lcp.reverseWords(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
