package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Lcp_355_Design_TwitterTest {
	
	@Test
	void test_case_1() {
		List<Integer> expected = null;
		List<Integer> test = null;
		
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		
		expected = Arrays.asList(new Integer[] { 5 });
		test = twitter.getNewsFeed(1);
		assertThat(test).isEqualTo(expected);
		
		twitter.follow(1, 2);
		twitter.postTweet(2, 6);
		
		expected = Arrays.asList(new Integer[] { 6, 5 });
		test = twitter.getNewsFeed(1);
		assertThat(test).isEqualTo(expected);
		
		twitter.unfollow(1, 2);
		
		expected = Arrays.asList(new Integer[] { 5 });
		test = twitter.getNewsFeed(1);
		assertThat(test).isEqualTo(expected);
	}
	
}
