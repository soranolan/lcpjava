package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1299_Replace_Elements_with_Greatest_Element_on_Right_SideTest {
	
	@Test
	void test_case_1() {
		Lcp_1299_Replace_Elements_with_Greatest_Element_on_Right_Side lcp = new Lcp_1299_Replace_Elements_with_Greatest_Element_on_Right_Side();
		
		int[] expect = { 18, 6, 6, 6, 1, -1 };
		int[] input = { 17, 18, 5, 4, 6, 1 };
		int[] test = lcp.replaceElements(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_1299_Replace_Elements_with_Greatest_Element_on_Right_Side lcp = new Lcp_1299_Replace_Elements_with_Greatest_Element_on_Right_Side();
		
		int[] expect = { -1 };
		int[] input = { 400 };
		int[] test = lcp.replaceElements(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
