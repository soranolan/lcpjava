package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Lcp_49_Group_AnagramsTest {
	
	@Test
	void test_case_1() {
		Lcp_49_Group_Anagrams lcp = new Lcp_49_Group_Anagrams();
		
		String[][] rooms = new String[][] { { "bat" }, { "nat", "tan" }, { "ate", "eat", "tea" } };
		List<List<String>> expected = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
		
		String[] input = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> test = lcp.groupAnagrams(input);
		
		assertThat(test).hasSameSizeAs(expected).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_49_Group_Anagrams lcp = new Lcp_49_Group_Anagrams();
		
		String[][] rooms = new String[][] { { "" } };
		List<List<String>> expected = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
		
		String[] input = new String[] { "" };
		List<List<String>> test = lcp.groupAnagrams(input);
		
		assertThat(test).hasSameSizeAs(expected).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_49_Group_Anagrams lcp = new Lcp_49_Group_Anagrams();
		
		String[][] rooms = new String[][] { { "a" } };
		List<List<String>> expected = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
		
		String[] input = new String[] { "a" };
		List<List<String>> test = lcp.groupAnagrams(input);
		
		assertThat(test).hasSameSizeAs(expected).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_49_Group_Anagrams lcp = new Lcp_49_Group_Anagrams();
		
		String[][] rooms = new String[][] { { "c" }, { "ac" } };
		List<List<String>> expected = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
		
		String[] input = new String[] { "ac", "c" };
		List<List<String>> test = lcp.groupAnagrams(input);
		
		assertThat(test).hasSameSizeAs(expected).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expected);
	}
	
	@Test
	void test_case_5() {
		Lcp_49_Group_Anagrams lcp = new Lcp_49_Group_Anagrams();
		
		String[][] rooms = new String[][] { { "d" }, { "ac" } };
		List<List<String>> expected = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
		
		String[] input = new String[] { "ac", "d" };
		List<List<String>> test = lcp.groupAnagrams(input);
		
		assertThat(test).hasSameSizeAs(expected).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expected);
	}
	
	@Test
	void test_case_6() {
		Lcp_49_Group_Anagrams lcp = new Lcp_49_Group_Anagrams();
		
		String[][] rooms = new String[][] { { "max" }, { "buy" }, { "doc" }, { "may" }, { "ill" }, { "duh" }, { "tin" }, { "bar" }, { "pew" }, { "cab" } };
		List<List<String>> expected = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
		
		String[] input = new String[] { "cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc" };
		List<List<String>> test = lcp.groupAnagrams(input);
		
		assertThat(test).hasSameSizeAs(expected).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expected);
	}
	
	@Test
	void test_case_7() {
		Lcp_49_Group_Anagrams lcp = new Lcp_49_Group_Anagrams();
		
		String[][] rooms = new String[][] { { "dgggggggggg" }, { "ddddddddddg" } };
		List<List<String>> expected = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
		
		String[] input = new String[] { "ddddddddddg", "dgggggggggg" };
		List<List<String>> test = lcp.groupAnagrams(input);
		
		assertThat(test).hasSameSizeAs(expected).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expected);
	}
	
	@Test
	void test_case_8() {
		Lcp_49_Group_Anagrams lcp = new Lcp_49_Group_Anagrams();
		
		String[][] rooms = new String[][] { { "bbbbbbbbbbc" }, { "bdddddddddd" } };
		List<List<String>> expected = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
		
		String[] input = new String[] { "bdddddddddd", "bbbbbbbbbbc" };
		List<List<String>> test = lcp.groupAnagrams(input);
		
		assertThat(test).hasSameSizeAs(expected).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expected);
	}
	
}
