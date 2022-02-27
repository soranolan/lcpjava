package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_380_Insert_Delete_GetRandom_O1Test {
	
	@Test
	void test_case_1() {
		RandomizedSet randomizedSet = new RandomizedSet();
		
		int random = -1;
		boolean test = false;
		
		test = randomizedSet.insert(1);
		assertThat(test).isTrue();
		
		test = randomizedSet.remove(2);
		assertThat(test).isFalse();
		
		test = randomizedSet.insert(2);
		assertThat(test).isTrue();
		
		random = randomizedSet.getRandom();
		assertThat(random == 1 || random == 2).isTrue();
		
		test = randomizedSet.remove(1);
		assertThat(test).isTrue();
		
		test = randomizedSet.insert(2);
		assertThat(test).isFalse();
		
		random = randomizedSet.getRandom();
		assertThat(random).isEqualTo(2);
	}
	
}
