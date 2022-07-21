package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1790_Check_if_One_String_Swap_Can_Make_Strings_EqualTest {
	
	private Lcp_1790_Check_if_One_String_Swap_Can_Make_Strings_Equal lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1790_Check_if_One_String_Swap_Can_Make_Strings_Equal();
	}
	
	@Test
	void test_case_1() {
		String s1 = "bank";
		String s2 = "kanb";
		boolean test = lcp.areAlmostEqual(s1, s2);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		String s1 = "attack";
		String s2 = "defend";
		boolean test = lcp.areAlmostEqual(s1, s2);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		String s1 = "kelb";
		String s2 = "kelb";
		boolean test = lcp.areAlmostEqual(s1, s2);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_4() {
		String s1 = "abcd";
		String s2 = "dcba";
		boolean test = lcp.areAlmostEqual(s1, s2);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_5() {
		String s1 = "aa";
		String s2 = "ac";
		boolean test = lcp.areAlmostEqual(s1, s2);
		
		assertThat(test).isFalse();
	}
	
}
