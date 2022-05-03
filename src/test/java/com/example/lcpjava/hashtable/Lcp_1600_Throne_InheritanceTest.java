package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Lcp_1600_Throne_InheritanceTest {
	
	@Test
	void test_case_1() {
		List<String> expected = null;
		List<String> test = null;
		
		ThroneInheritance t = new ThroneInheritance("king");
		
		t.birth("king", "andy");
		t.birth("king", "bob");
		t.birth("king", "catherine");
		t.birth("andy", "matthew");
		t.birth("bob", "alex");
		t.birth("bob", "asha");
		
		expected = Arrays.asList(new String[] { "king", "andy", "matthew", "bob", "alex", "asha", "catherine" });
		test = t.getInheritanceOrder();
		assertThat(test).isEqualTo(expected);
		
		t.death("bob");
		
		expected = Arrays.asList(new String[] { "king", "andy", "matthew", "alex", "asha", "catherine" });
		test = t.getInheritanceOrder();
		assertThat(test).isEqualTo(expected);
	}
	
}
