package com.example.lcpjava.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/100268/Two-solutions-and-thoughts
 * https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/1110674/Encode-and-Decode-TinyURL-or-Short-and-Easy-w-explanation
 * */
public class Lcp_535_Encode_and_Decode_TinyURL {
	
	public static final String BASE_URL = "http://tinyurl.com/";
	
	public static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public Map<String, String> short2Long = new HashMap<>();
	
	public Map<String, String> long2Short = new HashMap<>();
	
	public String encode(String longUrl) {
		if (long2Short.containsKey(longUrl)) { return long2Short.get(longUrl); }
		
		String url = "";
		
		while (short2Long.containsKey(url)) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				int random = (int) (Math.random() * 62);
				sb.append(SEED.charAt(random));
			}
			url = sb.toString();
		}
		
		String shortUrl = new StringBuilder(BASE_URL).append(url).toString();
		
		short2Long.put(shortUrl, longUrl);
		long2Short.put(longUrl, shortUrl);
		
		return shortUrl;
	}
	
	public String decode(String shortUrl) {
		return short2Long.getOrDefault(shortUrl, BASE_URL);
	}
	
}
