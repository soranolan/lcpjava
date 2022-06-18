package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_763_Partition_LabelsTest {
	
	private Lcp_763_Partition_Labels lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_763_Partition_Labels();
	}
	
	@Test
	void test_case_1() {
		List<Integer> expected = Arrays.asList(new Integer[] { 9, 7, 8 });
		String s = "ababcbacadefegdehijhklij";
		List<Integer> test = lcp.partitionLabels(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<Integer> expected = Arrays.asList(new Integer[] { 10 });
		String s = "eccbbbbdec";
		List<Integer> test = lcp.partitionLabels(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
