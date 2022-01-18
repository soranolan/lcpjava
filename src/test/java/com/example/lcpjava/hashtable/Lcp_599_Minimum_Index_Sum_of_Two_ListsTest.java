package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_599_Minimum_Index_Sum_of_Two_ListsTest {
	
	@Test
	void test_case_1() {
		Lcp_599_Minimum_Index_Sum_of_Two_Lists lcp = new Lcp_599_Minimum_Index_Sum_of_Two_Lists();
		
		String[] expected = { "Shogun" };
		String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
		String[] test = lcp.findRestaurant(list1, list2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_599_Minimum_Index_Sum_of_Two_Lists lcp = new Lcp_599_Minimum_Index_Sum_of_Two_Lists();
		
		String[] expected = { "Shogun" };
		String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] list2 = { "KFC", "Shogun", "Burger King" };
		String[] test = lcp.findRestaurant(list1, list2);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
