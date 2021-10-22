package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_151_Reverse_Words_in_a_StringTest {
	
	@Test
	void test_case_1() {
		Lcp_151_Reverse_Words_in_a_String lcp = new Lcp_151_Reverse_Words_in_a_String();
		
		String expect = "blue is sky the";
		String input = "the sky is blue";
		String test = lcp.reverseWords(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_151_Reverse_Words_in_a_String lcp = new Lcp_151_Reverse_Words_in_a_String();
		
		String expect = "world hello";
		String input = "  hello world  ";
		String test = lcp.reverseWords(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_151_Reverse_Words_in_a_String lcp = new Lcp_151_Reverse_Words_in_a_String();
		
		String expect = "example good a";
		String input = "a good   example";
		String test = lcp.reverseWords(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_4() {
		Lcp_151_Reverse_Words_in_a_String lcp = new Lcp_151_Reverse_Words_in_a_String();
		
		String expect = "Alice Loves Bob";
		String input = "  Bob    Loves  Alice   ";
		String test = lcp.reverseWords(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_5() {
		Lcp_151_Reverse_Words_in_a_String lcp = new Lcp_151_Reverse_Words_in_a_String();
		
		String expect = "bob like even not does Alice";
		String input = "Alice does not even like bob";
		String test = lcp.reverseWords(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
