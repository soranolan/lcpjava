package com.example.lcpjava.queue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_752_Open_the_LockTest {
	
	@Test
	void test_case_1() {
		Lcp_752_Open_the_Lock lcp = new Lcp_752_Open_the_Lock();
		
		int expected = 6;
		int test = -1;
		
		String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
		String target = "0202";
		
		test = lcp.openLock(deadends, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_752_Open_the_Lock lcp = new Lcp_752_Open_the_Lock();
		
		int expected = 1;
		int test = -1;
		
		String[] deadends = { "8888" };
		String target = "0009";
		
		test = lcp.openLock(deadends, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_752_Open_the_Lock lcp = new Lcp_752_Open_the_Lock();
		
		int expected = -1;
		int test = -1;
		
		String[] deadends = { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" };
		String target = "8888";
		
		test = lcp.openLock(deadends, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_752_Open_the_Lock lcp = new Lcp_752_Open_the_Lock();
		
		int expected = -1;
		int test = -1;
		
		String[] deadends = { "0000" };
		String target = "8888";
		
		test = lcp.openLock(deadends, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
