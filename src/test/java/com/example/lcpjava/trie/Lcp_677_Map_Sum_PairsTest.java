package com.example.lcpjava.trie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_677_Map_Sum_PairsTest {
	
	private MapSum mapSum;
	
	@BeforeEach
	void beforeEach() {
		mapSum = new MapSum();
	}
	
	@Test
	void test_case_1() {
		int actual = 0;
		
		mapSum.insert("apple", 3);
		
		actual = mapSum.sum("ap");
		assertEquals(3, actual);
		
		mapSum.insert("app", 2);
		
		actual = mapSum.sum("ap");
		assertEquals(5, actual);
	}
	
}
