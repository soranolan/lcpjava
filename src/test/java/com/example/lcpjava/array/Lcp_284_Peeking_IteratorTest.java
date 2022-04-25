package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Lcp_284_Peeking_IteratorTest {
	
	@Test
	void test_case_1() {
		int expected = -1;
		int test = -1;
		
		PeekingIterator peekingIterator = new PeekingIterator(Arrays.asList(new Integer[] { 1, 2, 3 }).iterator());
		
		expected = 1;
		test = peekingIterator.next();
		assertThat(test).isEqualTo(expected);
		
		expected = 2;
		test = peekingIterator.peek();
		assertThat(test).isEqualTo(expected);
		
		expected = 2;
		test = peekingIterator.next();
		assertThat(test).isEqualTo(expected);
		
		expected = 3;
		test = peekingIterator.next();
		assertThat(test).isEqualTo(expected);
		
		boolean hasNext = peekingIterator.hasNext();
		assertThat(hasNext).isFalse();
	}
	
}
