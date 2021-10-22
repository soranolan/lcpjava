package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Lcp_118_Pascals_TriangleTest {
	
	@Test
	void test_case_1() {
		Lcp_118_Pascals_Triangle lcp = new Lcp_118_Pascals_Triangle();
		
		List<Integer> inner1 = new ArrayList<>();
		inner1.add(1);
		
		List<Integer> inner2 = new ArrayList<>();
		inner2.add(1);
		inner2.add(1);
		
		List<Integer> inner3 = new ArrayList<>();
		inner3.add(1);
		inner3.add(2);
		inner3.add(1);
		
		List<Integer> inner4 = new ArrayList<>();
		inner4.add(1);
		inner4.add(3);
		inner4.add(3);
		inner4.add(1);
		
		List<Integer> inner5 = new ArrayList<>();
		inner5.add(1);
		inner5.add(4);
		inner5.add(6);
		inner5.add(4);
		inner5.add(1);
		
		List<List<Integer>> expect = new ArrayList<>();
		expect.add(inner1);
		expect.add(inner2);
		expect.add(inner3);
		expect.add(inner4);
		expect.add(inner5);
		
		int input = 5;
		List<List<Integer>> test = lcp.generate(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_118_Pascals_Triangle lcp = new Lcp_118_Pascals_Triangle();
		
		List<Integer> inner1 = new ArrayList<>();
		inner1.add(1);
		List<List<Integer>> expect = new ArrayList<>();
		expect.add(inner1);
		
		int input = 1;
		List<List<Integer>> test = lcp.generate(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
