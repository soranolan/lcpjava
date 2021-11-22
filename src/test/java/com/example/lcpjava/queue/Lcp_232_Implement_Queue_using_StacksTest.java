package com.example.lcpjava.queue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_232_Implement_Queue_using_StacksTest {
	
	@Test
	void test_case_1() {
		int expected = -1;
		int test = -1;
		boolean result = false;
		
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);
		myQueue.push(2);
		
		expected = 1;
		test = myQueue.peek();
		assertThat(test).isEqualTo(expected);
		
		expected = 1;
		test = myQueue.pop();
		assertThat(test).isEqualTo(expected);
		
		result = myQueue.empty();
		assertThat(result).isFalse();
	}
	
}
