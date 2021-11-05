package com.example.lcpjava.queue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_622_Design_Circular_QueueTest {
	
	@Test
	void test_case_1() {
		boolean test = false;
		int result = -1;
		int expect = -1;
		
		MyCircularQueue myCircularQueue = new MyCircularQueue(3);
		
		test = myCircularQueue.enQueue(1);
		assertThat(test).isTrue();
		
		test = myCircularQueue.enQueue(2);
		assertThat(test).isTrue();
		
		test = myCircularQueue.enQueue(3);
		assertThat(test).isTrue();
		
		test = myCircularQueue.enQueue(4);
		assertThat(test).isFalse();
		
		expect = 3;
		result = myCircularQueue.Rear();
		assertThat(result).isEqualTo(expect);
		
		test = myCircularQueue.isFull();
		assertThat(test).isTrue();
		
		test = myCircularQueue.deQueue();
		assertThat(test).isTrue();
		
		test = myCircularQueue.enQueue(4);
		assertThat(test).isTrue();
		
		expect = 4;
		result = myCircularQueue.Rear();
		assertThat(result).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		boolean test = false;
		
		MyCircularQueue myCircularQueue = new MyCircularQueue(1);
		
		test = myCircularQueue.enQueue(1);
		assertThat(test).isTrue();
		
		test = myCircularQueue.enQueue(2);
		assertThat(test).isFalse();
	}
	
}
