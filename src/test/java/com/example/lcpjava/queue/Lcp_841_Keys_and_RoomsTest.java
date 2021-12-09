package com.example.lcpjava.queue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Lcp_841_Keys_and_RoomsTest {
	
	@Test
	void test_case_1() {
		Lcp_841_Keys_and_Rooms lcp = new Lcp_841_Keys_and_Rooms();
		
		boolean expected = true;
		
		Integer[][] rooms = new Integer[][] { { 1 }, { 2 }, { 3 }, {} };
		List<List<Integer>> input = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
		
		boolean test = lcp.canVisitAllRooms(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_841_Keys_and_Rooms lcp = new Lcp_841_Keys_and_Rooms();
		
		boolean expected = false;
		
		Integer[][] rooms = new Integer[][] { { 1, 3 }, { 3, 0, 1 }, { 2 }, { 0 } };
		List<List<Integer>> input = Arrays.stream(rooms).map(Arrays::asList).collect(Collectors.toList());
		
		boolean test = lcp.canVisitAllRooms(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
