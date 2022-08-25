package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_383_Ransom_NoteTest {
	
	private Lcp_383_Ransom_Note lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_383_Ransom_Note();
	}
	
	@Test
	void test_case_1() {
		String ransomNote = "a";
		String magazine = "b";
		boolean test = lcp.canConstruct(ransomNote, magazine);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_2() {
		String ransomNote = "aa";
		String magazine = "ab";
		boolean test = lcp.canConstruct(ransomNote, magazine);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		String ransomNote = "aa";
		String magazine = "aab";
		boolean test = lcp.canConstruct(ransomNote, magazine);
		
		assertThat(test).isTrue();
	}
	
}
