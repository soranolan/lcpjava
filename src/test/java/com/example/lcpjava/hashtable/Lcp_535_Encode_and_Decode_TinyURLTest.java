package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_535_Encode_and_Decode_TinyURLTest {
	
	@Test
	void test_case_1() {
		Lcp_535_Encode_and_Decode_TinyURL lcp = new Lcp_535_Encode_and_Decode_TinyURL();
		
		String longUrl = "https://leetcode.com/problems/design-tinyurl";
		String shortUrl = lcp.encode(longUrl);
		String test = lcp.decode(shortUrl);
		
		assertThat(test).isEqualTo(longUrl);
	}
	
}
