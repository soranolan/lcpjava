package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_67_Add_BinaryTest {
	
	@Test
	void test_case_1() {
		Lcp_67_Add_Binary lcp = new Lcp_67_Add_Binary();
		
		String expect = "100";
		String inputA = "11";
		String inputB = "1";
		String test = lcp.addBinary(inputA, inputB);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_67_Add_Binary lcp = new Lcp_67_Add_Binary();
		
		String expect = "10101";
		String inputA = "1010";
		String inputB = "1011";
		String test = lcp.addBinary(inputA, inputB);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
