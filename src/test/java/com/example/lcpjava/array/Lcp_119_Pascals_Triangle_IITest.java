package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

class Lcp_119_Pascals_Triangle_IITest {
	
	@Test
	void test_case_1() {
		Lcp_119_Pascals_Triangle_II lcp = new Lcp_119_Pascals_Triangle_II();
		
		Integer[] expected = { 1, 3, 3, 1 };
		int input = 3;
		List<Integer> test = lcp.getRow(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expected));
	}
	
	@Test
	void test_case_2() {
		Lcp_119_Pascals_Triangle_II lcp = new Lcp_119_Pascals_Triangle_II();
		
		Integer[] expected = { 1 };
		int input = 0;
		List<Integer> test = lcp.getRow(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expected));
	}
	
	@Test
	void test_case_3() {
		Lcp_119_Pascals_Triangle_II lcp = new Lcp_119_Pascals_Triangle_II();
		
		Integer[] expected = { 1, 1 };
		int input = 1;
		List<Integer> test = lcp.getRow(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expected));
	}
	
}
