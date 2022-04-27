package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Lcp_1202_Smallest_String_With_SwapsTest {
	
	@Test
	void test_case_1() {
		Lcp_1202_Smallest_String_With_Swaps lcp = new Lcp_1202_Smallest_String_With_Swaps();
		
		String expected = "bacd";
		String s = "dcab";
		List<List<Integer>> pairs = Arrays
										.stream(new Integer[][] { { 0, 3 }, { 1, 2 } })
										.map(Arrays::stream)
										.map(value -> value.collect(Collectors.toList()))
										.collect(Collectors.toList());
		String test = lcp.smallestStringWithSwaps(s, pairs);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1202_Smallest_String_With_Swaps lcp = new Lcp_1202_Smallest_String_With_Swaps();
		
		String expected = "abcd";
		String s = "dcab";
		List<List<Integer>> pairs = Arrays
										.stream(new Integer[][] { { 0, 3 }, { 1, 2 }, { 0, 2 } })
										.map(Arrays::stream)
										.map(value -> value.collect(Collectors.toList()))
										.collect(Collectors.toList());
		String test = lcp.smallestStringWithSwaps(s, pairs);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
