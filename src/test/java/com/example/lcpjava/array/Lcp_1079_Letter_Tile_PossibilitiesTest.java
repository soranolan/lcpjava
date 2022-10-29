package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1079_Letter_Tile_PossibilitiesTest {
	
	private Lcp_1079_Letter_Tile_Possibilities lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1079_Letter_Tile_Possibilities();
	}
	
	@Test
	void test_case_1() {
		int expected = 8;
		String tiles = "AAB";
		int test = lcp.numTilePossibilities(tiles);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 188;
		String tiles = "AAABBC";
		int test = lcp.numTilePossibilities(tiles);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 1;
		String tiles = "V";
		int test = lcp.numTilePossibilities(tiles);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
