package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_155_Min_StackTest {
	
	@Test
	void test_case_1() {
		int expected = -1;
		int test = -1;
		
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		
		expected = -3;
		test = minStack.getMin();
		assertThat(test).isEqualTo(expected);
		
		minStack.pop();
		
		expected = 0;
		test = minStack.top();
		assertThat(test).isEqualTo(expected);
		
		expected = -2;
		test = minStack.getMin();
		assertThat(test).isEqualTo(expected);
	}
	
}
