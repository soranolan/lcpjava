package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1797_Design_Authentication_ManagerTest {
	
	@Test
	void test_case_1() {
		int expected = -1;
		int test = -1;
		
		AuthenticationManager authenticationManager = new AuthenticationManager(5);
		
		authenticationManager.renew("aaa", 1);
		authenticationManager.generate("aaa", 2);
		
		expected = 1;
		test = authenticationManager.countUnexpiredTokens(6);
		assertThat(test).isEqualTo(expected);
		
		authenticationManager.generate("bbb", 7);
		authenticationManager.renew("aaa", 8);
		authenticationManager.renew("bbb", 10);
		
		expected = 0;
		test = authenticationManager.countUnexpiredTokens(15);
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = -1;
		int test = -1;
		
		AuthenticationManager authenticationManager = new AuthenticationManager(13);
		
		authenticationManager.renew("ajvy", 1);
		
		expected = 0;
		test = authenticationManager.countUnexpiredTokens(3);
		assertThat(test).isEqualTo(expected);
		
		expected = 0;
		test = authenticationManager.countUnexpiredTokens(4);
		assertThat(test).isEqualTo(expected);
		
		authenticationManager.generate("fuzxq", 5);
		authenticationManager.generate("izmry", 7);
		authenticationManager.renew("puv", 12);
		authenticationManager.generate("ybiqb", 13);
		authenticationManager.generate("gm", 14);
		
		expected = 4;
		test = authenticationManager.countUnexpiredTokens(15);
		assertThat(test).isEqualTo(expected);
		
		expected = 3;
		test = authenticationManager.countUnexpiredTokens(18);
		assertThat(test).isEqualTo(expected);
		
		expected = 3;
		test = authenticationManager.countUnexpiredTokens(19);
		assertThat(test).isEqualTo(expected);
		
		authenticationManager.renew("ybiqb", 21);
		
		expected = 2;
		test = authenticationManager.countUnexpiredTokens(23);
		assertThat(test).isEqualTo(expected);
		
		expected = 2;
		test = authenticationManager.countUnexpiredTokens(25);
		assertThat(test).isEqualTo(expected);
		
		expected = 2;
		test = authenticationManager.countUnexpiredTokens(26);
		assertThat(test).isEqualTo(expected);
		
		authenticationManager.generate("aqdm", 28);
		
		expected = 2;
		test = authenticationManager.countUnexpiredTokens(29);
		assertThat(test).isEqualTo(expected);
		
		authenticationManager.renew("puv", 30);
	}
	
}
