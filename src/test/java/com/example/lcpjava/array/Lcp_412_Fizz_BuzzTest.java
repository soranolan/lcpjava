package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

class Lcp_412_Fizz_BuzzTest {
	
	@Test
	void test_case_1() {
		Lcp_412_Fizz_Buzz lcp = new Lcp_412_Fizz_Buzz();
		
		String[] expected = { "1", "2", "Fizz" };
		int input = 3;
		List<String> test = lcp.fizzBuzz(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expected));
	}
	
	@Test
	void test_case_2() {
		Lcp_412_Fizz_Buzz lcp = new Lcp_412_Fizz_Buzz();
		
		String[] expected = { "1", "2", "Fizz", "4", "Buzz" };
		int input = 5;
		List<String> test = lcp.fizzBuzz(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expected));
	}
	
	@Test
	void test_case_3() {
		Lcp_412_Fizz_Buzz lcp = new Lcp_412_Fizz_Buzz();
		
		String[] expected = { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz" };
		int input = 15;
		List<String> test = lcp.fizzBuzz(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expected));
	}
	
}
