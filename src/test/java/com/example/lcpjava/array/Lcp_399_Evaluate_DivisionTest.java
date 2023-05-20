package com.example.lcpjava.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_399_Evaluate_DivisionTest {
	
	private Lcp_399_Evaluate_Division lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_399_Evaluate_Division();
	}
	
	@Test
	void test_case_1() {
		// Arrange
		List<List<String>> equations = Arrays
				.stream(new String[][] { { "a", "b" }, { "b", "c" } })
				.map(Arrays::stream)
				.map(value -> value.collect(Collectors.toList()))
				.collect(Collectors.toList());
		double[] values = { 2.0, 3.0 };
		List<List<String>> queries = Arrays
				.stream(new String[][] { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } })
				.map(Arrays::stream)
				.map(value -> value.collect(Collectors.toList()))
				.collect(Collectors.toList());
		double[] actual = new double[] { 6.00000, 0.50000, -1.00000, 1.00000, -1.00000 };
		
		// Act
		double[] expected = lcp.calcEquation(equations, values, queries);
		
		// Assert
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void test_case_2() {
		// Arrange
		List<List<String>> equations = Arrays
				.stream(new String[][] { { "a", "b" }, { "b", "c" }, { "bc", "cd" } })
				.map(Arrays::stream)
				.map(value -> value.collect(Collectors.toList()))
				.collect(Collectors.toList());
		double[] values = { 1.5, 2.5, 5.0 };
		List<List<String>> queries = Arrays
				.stream(new String[][] { { "a", "c" }, { "c", "b" }, { "bc", "cd" }, { "cd", "bc" } })
				.map(Arrays::stream)
				.map(value -> value.collect(Collectors.toList()))
				.collect(Collectors.toList());
		double[] actual = new double[] { 3.75000, 0.40000, 5.00000, 0.20000 };
		
		// Act
		double[] expected = lcp.calcEquation(equations, values, queries);
		
		// Assert
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void test_case_3() {
		// Arrange
		List<List<String>> equations = Arrays
				.stream(new String[][] { { "a", "b" } })
				.map(Arrays::stream)
				.map(value -> value.collect(Collectors.toList()))
				.collect(Collectors.toList());
		double[] values = { 0.5 };
		List<List<String>> queries = Arrays
				.stream(new String[][] { { "a", "b" }, { "b", "a" }, { "a", "c" }, { "x", "y" } })
				.map(Arrays::stream)
				.map(value -> value.collect(Collectors.toList()))
				.collect(Collectors.toList());
		double[] actual = new double[] { 0.50000, 2.00000, -1.00000, -1.00000 };
		
		// Act
		double[] expected = lcp.calcEquation(equations, values, queries);
		
		// Assert
		assertArrayEquals(expected, actual);
	}
	
}
