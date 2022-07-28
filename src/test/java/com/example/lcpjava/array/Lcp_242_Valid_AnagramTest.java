package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_242_Valid_AnagramTest {
	
	private Lcp_242_Valid_Anagram lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_242_Valid_Anagram();
	}
	
	@Test
	void test_case_1() {
		String s = "anagram";
		String t = "nagaram";
		boolean test = lcp.isAnagram(s, t);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		String s = "rat";
		String t = "car";
		boolean test = lcp.isAnagram(s, t);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		String s = "ab";
		String t = "a";
		boolean test = lcp.isAnagram(s, t);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_4() {
		String s = "A B ▲ ▼ ◀ ▶";
		String t = "▲ ▼ ◀ ▶ A B";
		boolean test = lcp.isAnagram(s, t);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_5() {
		String s = "△ ▽ ◁ ▷ A B";
		String t = "▲ ▼ ◀ ▶ A B";
		boolean test = lcp.isAnagram(s, t);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_6() {
		String s = "g̈";
		String t = "g̈";
		boolean test = lcp.isAnagram(s, t);
		
		assertThat(test).isTrue();
	}
	
}
