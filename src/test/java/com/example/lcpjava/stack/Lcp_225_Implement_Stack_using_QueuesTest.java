package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_225_Implement_Stack_using_QueuesTest {
	
	@Test
	void test_case_1() {
		int expected = -1;
		int test = -1;
		boolean result = false;
		
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		
		expected = 2;
		test = myStack.top();
		assertThat(test).isEqualTo(expected);
		
		expected = 2;
		test = myStack.pop();
		assertThat(test).isEqualTo(expected);
		
		result = myStack.empty();
		assertThat(result).isFalse();
	}
	
	@Test
	void test_case_2() {
		int expected = -1;
		int test = -1;
		boolean result = false;
		
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		
		expected = 2;
		test = myStack.top();
		assertThat(test).isEqualTo(expected);
		
		myStack.push(3);
		
		expected = 3;
		test = myStack.pop();
		assertThat(test).isEqualTo(expected);
		
		result = myStack.empty();
		assertThat(result).isFalse();
	}
	
}
