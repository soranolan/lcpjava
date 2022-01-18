package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_205_Isomorphic_StringsTest {
	
	@Test
	void test_case_1() {
		Lcp_205_Isomorphic_Strings lcp = new Lcp_205_Isomorphic_Strings();
		
		String s = "egg";
		String t = "add";
		boolean test = lcp.isIsomorphic(s, t);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		Lcp_205_Isomorphic_Strings lcp = new Lcp_205_Isomorphic_Strings();
		
		String s = "foo";
		String t = "bar";
		boolean test = lcp.isIsomorphic(s, t);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		Lcp_205_Isomorphic_Strings lcp = new Lcp_205_Isomorphic_Strings();
		
		String s = "paper";
		String t = "title";
		boolean test = lcp.isIsomorphic(s, t);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_4() {
		Lcp_205_Isomorphic_Strings lcp = new Lcp_205_Isomorphic_Strings();
		
		String s = "badc";
		String t = "baba";
		boolean test = lcp.isIsomorphic(s, t);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_5() {
		Lcp_205_Isomorphic_Strings lcp = new Lcp_205_Isomorphic_Strings();
		
		String s = "bbbaaaba";
		String t = "aaabbbba";
		boolean test = lcp.isIsomorphic(s, t);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_6() {
		Lcp_205_Isomorphic_Strings lcp = new Lcp_205_Isomorphic_Strings();
		
		String s = "abcdefghijklmnopqrstuvwxyzva";
		String t = "abcdefghijklmnopqrstuvwxyzck";
		boolean test = lcp.isIsomorphic(s, t);
		
		assertThat(test).isFalse();
	}
	
}
