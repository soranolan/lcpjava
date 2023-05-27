package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_557_Reverse_Words_in_a_String_IIITest {
	
	private Lcp_557_Reverse_Words_in_a_String_III lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_557_Reverse_Words_in_a_String_III();
	}
	
	@Test
	void test_case_1() {
		// Arrange
		String expected = "s'teL ekat edoCteeL tsetnoc";
		String input = "Let's take LeetCode contest";
		
		// Act
		String actual = lcp.reverseWords(input);
		
		// Assert
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		// Arrange
		String expected = "doG gniD";
		String input = "God Ding";
		
		// Act
		String actual = lcp.reverseWords(input);
		
		// Assert
		assertThat(actual).isEqualTo(expected);
	}
	
}
