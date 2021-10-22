package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_28_Implement_strStrTest {
	
	@Test
	void test_case_1() {
		Lcp_28_Implement_strStr lcp = new Lcp_28_Implement_strStr();
		
		int expect = 2;
		String haystack = "hello";
		String needle = "ll";
		int test = lcp.strStr(haystack, needle);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_28_Implement_strStr lcp = new Lcp_28_Implement_strStr();
		
		int expect = -1;
		String haystack = "aaaaa";
		String needle = "bba";
		int test = lcp.strStr(haystack, needle);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_28_Implement_strStr lcp = new Lcp_28_Implement_strStr();
		
		int expect = 0;
		String haystack = "";
		String needle = "";
		int test = lcp.strStr(haystack, needle);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_4() {
		Lcp_28_Implement_strStr lcp = new Lcp_28_Implement_strStr();
		
		int expect = 4;
		String haystack = "mississippi";
		String needle = "issip";
		int test = lcp.strStr(haystack, needle);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_5() {
		Lcp_28_Implement_strStr lcp = new Lcp_28_Implement_strStr();
		
		int expect = 9;
		String haystack = "mississippi";
		String needle = "pi";
		int test = lcp.strStr(haystack, needle);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
