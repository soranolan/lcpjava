package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_706_Design_HashMapTest {
	
	@Test
	void test_case_1() {
		int expected = -1;
		int test = -1;
		
		MyHashMap myHashMap = new MyHashMap();
		myHashMap.put(1, 1);
		myHashMap.put(2, 2);
		
		expected = 1;
		test = myHashMap.get(1);
		assertThat(test).isEqualTo(expected);
		
		expected = -1;
		test = myHashMap.get(3);
		assertThat(test).isEqualTo(expected);
		
		myHashMap.put(2, 1);
		
		expected = 1;
		test = myHashMap.get(2);
		assertThat(test).isEqualTo(expected);
		
		myHashMap.remove(2);
		
		expected = -1;
		test = myHashMap.get(2);
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = -1;
		int test = -1;
		
		MyHashMap myHashMap = new MyHashMap();
		myHashMap.remove(14);
		
		test = myHashMap.get(4);
		assertThat(test).isEqualTo(expected);
		
		myHashMap.put(7, 3);
		myHashMap.put(11, 1);
		myHashMap.put(12, 1);
		
		expected = 3;
		test = myHashMap.get(7);
		assertThat(test).isEqualTo(expected);
		
		myHashMap.put(1, 19);
		myHashMap.put(0, 3);
		myHashMap.put(1, 8);
		myHashMap.put(2, 6);
	}
	
}
