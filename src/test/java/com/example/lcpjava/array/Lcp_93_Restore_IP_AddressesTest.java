package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_93_Restore_IP_AddressesTest {
	
	private Lcp_93_Restore_IP_Addresses lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_93_Restore_IP_Addresses();
	}
	
	@Test
	void test_case_1() {
		List<String> expected = Arrays.asList(new String[] { "255.255.11.135", "255.255.111.35" });
		String s = "25525511135";
		List<String> test = lcp.restoreIpAddresses(s);
		
		assertThat(test).containsExactlyInAnyOrderElementsOf(expected);
	}
	
	@Test
	void test_case_2() {
		List<String> expected = Arrays.asList(new String[] { "0.0.0.0" });
		String s = "0000";
		List<String> test = lcp.restoreIpAddresses(s);
		
		assertThat(test).containsExactlyInAnyOrderElementsOf(expected);
	}
	
	@Test
	void test_case_3() {
		List<String> expected = Arrays.asList(new String[] { "1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3" });
		String s = "101023";
		List<String> test = lcp.restoreIpAddresses(s);
		
		assertThat(test).containsExactlyInAnyOrderElementsOf(expected);
	}
	
}
