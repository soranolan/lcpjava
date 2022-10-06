package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_981_Time_Based_Key_Value_StoreTest {
	
	TimeMap timeMap;
	
	@BeforeEach
	void beforeEach() {
		timeMap = new TimeMap();
	}
	
	@Test
	void test_case_1() {
		String expected = "";
		String test = "";
		
		timeMap.set("foo", "bar", 1);
		
		expected = "bar";
		test = timeMap.get("foo", 1);
		assertThat(test).isEqualTo(expected);
		
		expected = "bar";
		test = timeMap.get("foo", 3);
		assertThat(test).isEqualTo(expected);
		
		timeMap.set("foo", "bar2", 4);
		
		expected = "bar2";
		test = timeMap.get("foo", 4);
		assertThat(test).isEqualTo(expected);
		
		expected = "bar2";
		test = timeMap.get("foo", 5);
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		String expected = "";
		String test = "";
		
		timeMap.set("hello", "world", 10);
		
		expected = "world";
		test = timeMap.get("hello", 10);
		assertThat(test).isEqualTo(expected);
		
		expected = "";
		test = timeMap.get("hello", 5);
		assertThat(test).isEqualTo(expected);
		
		timeMap.set("hello", "hubot", 20);
		
		expected = "hubot";
		test = timeMap.get("hello", 20);
		assertThat(test).isEqualTo(expected);
		
		expected = "world";
		test = timeMap.get("hello", 15);
		assertThat(test).isEqualTo(expected);
		
		expected = "hubot";
		test = timeMap.get("hello", 25);
		assertThat(test).isEqualTo(expected);
	}
	
}
