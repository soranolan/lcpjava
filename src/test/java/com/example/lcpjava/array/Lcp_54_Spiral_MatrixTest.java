package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

class Lcp_54_Spiral_MatrixTest {
	
	@Test
	void test_case_1() {
		Lcp_54_Spiral_Matrix lcp = new Lcp_54_Spiral_Matrix();
		
		Integer[] expect = { 1, 2, 3, 6, 9, 8, 7, 4, 5 };
		int[][] input = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> test = lcp.spiralOrder(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expect));
	}
	
	@Test
	void test_case_2() {
		Lcp_54_Spiral_Matrix lcp = new Lcp_54_Spiral_Matrix();
		
		Integer[] expect = { 1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7 };
		int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		List<Integer> test = lcp.spiralOrder(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expect));
	}
	
	@Test
	void test_case_3() {
		Lcp_54_Spiral_Matrix lcp = new Lcp_54_Spiral_Matrix();
		
		Integer[] expect = { 2, 3 };
		int[][] input = { { 2, 3 } };
		List<Integer> test = lcp.spiralOrder(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expect));
	}
	
	@Test
	void test_case_4() {
		Lcp_54_Spiral_Matrix lcp = new Lcp_54_Spiral_Matrix();
		
		Integer[] expect = { 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10 };
		int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		List<Integer> test = lcp.spiralOrder(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expect));
	}
	
	@Test
	void test_case_5() {
		Lcp_54_Spiral_Matrix lcp = new Lcp_54_Spiral_Matrix();
		
		Integer[] expect = { 1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7 };
		int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		List<Integer> test = lcp.spiralOrder(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expect));
	}
	
}
