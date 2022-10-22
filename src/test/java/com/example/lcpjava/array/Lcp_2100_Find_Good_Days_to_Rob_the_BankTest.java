package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_2100_Find_Good_Days_to_Rob_the_BankTest {
	
	private Lcp_2100_Find_Good_Days_to_Rob_the_Bank lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_2100_Find_Good_Days_to_Rob_the_Bank();
	}
	
	@Test
	void test_case_1() {
		List<Integer> expected = Arrays.asList(new Integer[] { 2, 3 });
		int[] security = { 5, 3, 3, 3, 5, 6, 2 };
		int time = 2;
		List<Integer> test = lcp.goodDaysToRobBank(security, time);
		
		assertThat(test).containsExactlyInAnyOrderElementsOf(expected);
	}
	
	@Test
	void test_case_2() {
		List<Integer> expected = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4 });
		int[] security = { 1, 1, 1, 1, 1 };
		int time = 0;
		List<Integer> test = lcp.goodDaysToRobBank(security, time);
		
		assertThat(test).containsExactlyInAnyOrderElementsOf(expected);
	}
	
	@Test
	void test_case_3() {
		List<Integer> expected = Arrays.asList(new Integer[] {});
		int[] security = { 1, 2, 3, 4, 5, 6 };
		int time = 2;
		List<Integer> test = lcp.goodDaysToRobBank(security, time);
		
		assertThat(test).containsExactlyInAnyOrderElementsOf(expected);
	}
	
	@Test
	void test_case_4() {
		List<Integer> expected = Arrays.asList(new Integer[] {});
		int[] security = { 1, 2, 3, 4 };
		int time = 1;
		List<Integer> test = lcp.goodDaysToRobBank(security, time);
		
		assertThat(test).containsExactlyInAnyOrderElementsOf(expected);
	}
	
	@Test
	void test_case_5() {
		List<Integer> expected = Arrays.asList(new Integer[] {});
		int[] security = { 5, 3, 3, 3, 5, 6, 2 };
		int time = 4;
		List<Integer> test = lcp.goodDaysToRobBank(security, time);
		
		assertThat(test).containsExactlyInAnyOrderElementsOf(expected);
	}
	
}
