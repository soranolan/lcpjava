package com.example.lcpjava.trie;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_336_Palindrome_PairsTest {

	private Lcp_336_Palindrome_Pairs lcp;

	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_336_Palindrome_Pairs();
	}

	@Test
	void test_case_1() {
		// Arrange
		String[] words = { "abcd", "dcba", "lls", "s", "sssll" };
		Integer[][] palindrome = new Integer[][] { { 0, 1 }, { 1, 0 }, { 3, 2 }, { 2, 4 } };
		List<List<Integer>> expected = Arrays.stream(palindrome).map(Arrays::asList).collect(Collectors.toList());

		// Act
		List<List<Integer>> actual = lcp.palindromePairs(words);

		// Assert
		assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
	}

	@Test
	void test_case_2() {
		// Arrange
		String[] words = { "bat", "tab", "cat" };
		Integer[][] palindrome = new Integer[][] { { 0, 1 }, { 1, 0 } };
		List<List<Integer>> expected = Arrays.stream(palindrome).map(Arrays::asList).collect(Collectors.toList());

		// Act
		List<List<Integer>> actual = lcp.palindromePairs(words);

		// Assert
		assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
	}

	@Test
	void test_case_3() {
		// Arrange
		String[] words = { "a", "" };
		Integer[][] palindrome = new Integer[][] { { 0, 1 }, { 1, 0 } };
		List<List<Integer>> expected = Arrays.stream(palindrome).map(Arrays::asList).collect(Collectors.toList());

		// Act
		List<List<Integer>> actual = lcp.palindromePairs(words);

		// Assert
		assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
	}

	@Test
	void test_case_4() {
		// Arrange
		String[] words = { "ba", "a", "aaa" };
		Integer[][] palindrome = new Integer[][] { { 1, 0 }, { 1, 2 }, { 2, 1 } };
		List<List<Integer>> expected = Arrays.stream(palindrome).map(Arrays::asList).collect(Collectors.toList());

		// Act
		List<List<Integer>> actual = lcp.palindromePairs(words);

		// Assert
		assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
	}

}
