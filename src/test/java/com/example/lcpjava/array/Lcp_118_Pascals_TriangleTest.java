package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_118_Pascals_TriangleTest {
	
	private Lcp_118_Pascals_Triangle lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_118_Pascals_Triangle();
	}
	
	@Test
	void test_case_1() {
		List<List<Integer>> expected = Arrays
											.stream(new Integer[][] { { 1 }, { 1, 1 }, { 1, 2, 1 }, { 1, 3, 3, 1 }, { 1, 4, 6, 4, 1 } })
											.map(Arrays::stream)
											.map(value -> value.collect(Collectors.toList()))
											.collect(Collectors.toList());
		int input = 5;
		List<List<Integer>> test = lcp.generate(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<List<Integer>> expected = Arrays
											.stream(new Integer[][] { { 1 } })
											.map(Arrays::stream)
											.map(value -> value.collect(Collectors.toList()))
											.collect(Collectors.toList());
		
		int input = 1;
		List<List<Integer>> test = lcp.generate(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
