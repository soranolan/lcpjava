package com.example.lcpjava.queue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_641_Design_Circular_DequeTest {
	
	@Test
	void test_case_1() {
		boolean test = false;
		int result = -1;
		int expected = -1;
		
		MyCircularDeque myCircularDeque = new MyCircularDeque(3);
		
		test = myCircularDeque.insertLast(1);
		assertThat(test).isTrue();
		
		test = myCircularDeque.insertLast(2);
		assertThat(test).isTrue();
		
		test = myCircularDeque.insertFront(3);
		assertThat(test).isTrue();
		
		test = myCircularDeque.insertFront(4);
		assertThat(test).isFalse();
		
		expected = 2;
		result = myCircularDeque.getRear();
		assertThat(result).isEqualTo(expected);
		
		test = myCircularDeque.isFull();
		assertThat(test).isTrue();
		
		test = myCircularDeque.deleteLast();
		assertThat(test).isTrue();
		
		test = myCircularDeque.insertFront(4);
		assertThat(test).isTrue();
		
		expected = 4;
		result = myCircularDeque.getFront();
		assertThat(result).isEqualTo(expected);
	}
	
}
