package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_705_Design_HashSetTest {
	
	@Test
	void test_case_1() {
		MyHashSet myHashSet = new MyHashSet();
		
		boolean test = false;
		
		myHashSet.add(1);
		myHashSet.add(2);
		
		test = myHashSet.contains(1);
		assertThat(test).isTrue();
		
		test = myHashSet.contains(3);
		assertThat(test).isFalse();
		
		myHashSet.add(2);
		
		test = myHashSet.contains(2);
		assertThat(test).isTrue();
		
		myHashSet.remove(2);
		
		test = myHashSet.contains(2);
		assertThat(test).isFalse();
	}
	
}
